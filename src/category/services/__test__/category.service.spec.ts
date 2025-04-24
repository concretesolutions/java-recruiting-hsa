import { Test, TestingModule } from '@nestjs/testing';
import { CategoryService } from '../category.service';
import { CategoryModule } from '../../category.module';
import { CATEGORY_REPOSITORY } from 'src/shared/utils/tokens';
import { WinstonLoggerService } from 'src/shared/infrastructure/logger/winston-logger.service';
import { TYPES } from 'src/shared/utils/types';
import { ConfigService } from '@nestjs/config';
import { CategoryEntity } from '../../entities/category.entity';

describe('CategoryService', () => {
  let service: CategoryService;

  const mockCategories: CategoryEntity[] = [{
    id: "MOB",
    name: "MOBILE_MARKET",
    subcategories: [
      {
        id: "video-games",
        name: "Video Games",
        relevance: 150,
        subcategories: [
          {
            id: "nintendo",
            name: "Nintendo",
            smallImageUrl: "https://example.com/image.jpg",
            subcategories: [
              {
                id: "switch",
                name: "Switch",
                relevance: 422
              }
            ]
          }
        ]
      },
      {
        id: "toys",
        name: "Toys",
        relevance: 99,
        subcategories: []
      }
    ]
  }];

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      imports: [CategoryModule],
      providers: [CategoryService,
        {
          provide: CATEGORY_REPOSITORY,
          useValue: {
            findAll: jest.fn().mockResolvedValue(mockCategories[0]),
          },
        },
        {
          provide: TYPES.LoggerService,
          useValue: {
            log: jest.fn(),
            error: jest.fn(),
            warn: jest.fn(),
          },
        },
        {
          provide: WinstonLoggerService,
          useValue: {
            log: jest.fn(),
            error: jest.fn(),
            warn: jest.fn(),
          },
        },
        {
          provide: ConfigService,
          useValue: {
            get: jest.fn(),
          }
        }
      ],
    }).compile();

    service = module.get<CategoryService>(CategoryService);
  });

  describe('findTop', () => {
    it('should return top array of categories', async () => {
      const num = 5;
      const result = await service.findTop(num);
      
      // Verify the result has expected structure and data
      expect(result).toBeDefined();
      expect(Array.isArray(result)).toBeTruthy();
      expect(result.length).toBeLessThanOrEqual(num);
      
      // Check sorting by relevance
      if (result.length > 1) {
        for (let i = 0; i < result.length - 1; i++) {
          const currentRelevance = result[i].relevance || 0;
          const nextRelevance = result[i + 1].relevance || 0;
          expect(currentRelevance).toBeGreaterThanOrEqual(nextRelevance);
        }
      }
    });

    it('should handle errors gracefully', async () => {
      jest.spyOn(service['categoryRepository'], 'findAll').mockRejectedValue(new Error('API Error'));
      
      await expect(service.findTop(5)).rejects.toThrow('error requesting top categories');
    });
  });

  describe('findNoTop', () => {
    it('should return non-top array of categories', async () => {
      const num = 1;
      const result = await service.findNoTop(num);
      
      expect(result).toBeDefined();
      if (result) {
        expect(Array.isArray(result)).toBeTruthy();
        
        // Check sorting by relevance
        if (result.length > 1) {
          for (let i = 0; i < result.length - 1; i++) {
            const currentRelevance = result[i].relevance || 0;
            const nextRelevance = result[i + 1].relevance || 0;
            expect(currentRelevance).toBeGreaterThanOrEqual(nextRelevance);
          }
        }
      }
    });

    it('should handle errors gracefully', async () => {
      jest.spyOn(service['categoryRepository'], 'findAll').mockRejectedValue(new Error('API Error'));
      
      await expect(service.findNoTop(5)).rejects.toThrow('error requesting non-top categories');
    });
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
