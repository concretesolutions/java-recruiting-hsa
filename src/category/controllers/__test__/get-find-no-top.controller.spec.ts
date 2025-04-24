import { Test, TestingModule } from '@nestjs/testing';
import { GetFindNoTopController } from '../get-find-no-top.controller'; // Changed import
import { CategoryService } from '../../services/category.service';
import { CategoryModule } from '../../category.module';
import { CATEGORY_REPOSITORY } from 'src/shared/utils/tokens';
import { WinstonLoggerService } from 'src/shared/infrastructure/logger/winston-logger.service';
import { TYPES } from 'src/shared/utils/types';
import { ConfigService } from '@nestjs/config';
import { CategoryEntity } from '../../entities/category.entity';
import path from 'node:path';
import { readFile } from 'node:fs/promises';

describe('GetFindNoTopController', () => { // Changed description
  let controller: GetFindNoTopController; // Changed type
  let service: CategoryService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      imports: [CategoryModule],
      controllers: [GetFindNoTopController], // Changed controller
      providers: [
        CategoryService,
        {
          provide: CATEGORY_REPOSITORY,
          useValue: {
            find: jest.fn(), // Mock repository methods used by CategoryService.findNoTop
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
    .overrideProvider(CategoryService)
    .useValue({
      findNoTop: jest.fn(), // Changed method to mock
    })
    .compile();

    controller = module.get<GetFindNoTopController>(GetFindNoTopController); // Changed type
    service = module.get<CategoryService>(CategoryService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });

  describe('findNoTop', () => { // Changed describe block
    it('should return non-top array of categories', async () => { // Changed description
      const relativePath = 'test/data/categories-ok.json'; // Assuming same data file for simplicity
      const filePath = path.resolve('.', relativePath);
      const fileContent = await readFile(filePath, 'utf8');
      const result: CategoryEntity[] = JSON.parse(fileContent);

      // Mock the service method directly
      jest.spyOn(service, 'findNoTop').mockResolvedValue(result); // Changed method to spy on

      const from = 5; // Changed parameter name
      const found = await controller.findNoTop(from); // Changed method call and parameter
      expect(service.findNoTop).toHaveBeenCalledWith(from); // Changed assertion
      expect(found).toEqual(result);
    });
  });
});
