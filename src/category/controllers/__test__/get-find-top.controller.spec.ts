import { Test, TestingModule } from '@nestjs/testing';
import { GetFindTopController } from '../get-find-top.controller';
import { CategoryService } from '../../services/category.service';
import { CategoryModule } from '../../category.module';
import { CATEGORY_REPOSITORY } from 'src/shared/utils/tokens';
import { WinstonLoggerService } from 'src/shared/infrastructure/logger/winston-logger.service';
import { TYPES } from 'src/shared/utils/types';
import { ConfigService } from '@nestjs/config';
import { CategoryEntity } from '../../entities/category.entity';
import path from 'node:path';
import { readFile } from 'node:fs/promises';

describe('GetFindTopController', () => {
  let controller: GetFindTopController;
  let service: CategoryService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      // Use imports that provide necessary dependencies for GetFindTopController if different
      // For simplicity, assuming CategoryModule provides CategoryService correctly
      imports: [CategoryModule],
      controllers: [GetFindTopController],
      providers: [
        CategoryService,
        {
          provide: CATEGORY_REPOSITORY,
          useValue: {
            find: jest.fn(), // Mock repository methods used by CategoryService.findTop
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
          provide: TYPES.HttpClientService,
          useValue: {
            get: jest.fn(),
            set: jest.fn(),
          },
        },
        {
          provide: ConfigService,
          useValue: {
            get: jest.fn(),
            set: jest.fn(),
          }
        }
      ],
    })
    // Override the actual service methods if needed, or provide mocks directly
    .overrideProvider(CategoryService)
    .useValue({
      findTop: jest.fn(),
      // Add other methods if CategoryService is complex and needs more mocking
    })
    .compile();

    controller = module.get<GetFindTopController>(GetFindTopController);
    service = module.get<CategoryService>(CategoryService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });

  describe('findTop', () => {
    it('should return top array of categories', async () => {
      const relativePath = 'test/data/categories-ok.json';
      const filePath = path.resolve('.', relativePath);
      const fileContent = await readFile(filePath, 'utf8');
      const result: CategoryEntity[] = JSON.parse(fileContent);

      // Mock the service method directly
      jest.spyOn(service, 'findTop').mockResolvedValue(result);

      const limit = 5;
      const found = await controller.findTop(limit);
      expect(service.findTop).toHaveBeenCalledWith(limit);
      expect(found).toEqual(result); // Use Jest's deep equality check
    });
  });
});
