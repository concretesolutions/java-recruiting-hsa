import { Test, TestingModule } from '@nestjs/testing';
import { CategoryController } from '../category.controller';
import { CategoryService } from '../../services/category.service';
import { CATEGORY_REPOSITORY } from 'src/shared/utils/tokens';
import { WinstonLoggerService } from 'src/shared/infrastructure/logger/winston-logger.service';
import { TYPES } from 'src/shared/utils/types';
import { ConfigService } from '@nestjs/config';
import { CategoryEntity } from '../../entities/category.entity';

describe('CategoryController', () => {
  let controller: CategoryController;
  let service: CategoryService;

  const mockCategory: CategoryEntity = {
    id: '1',
    name: 'Test Category',
    subcategories: []
  };

  const mockCategoryService = {
    findOne: jest.fn().mockResolvedValue(mockCategory),
    create: jest.fn().mockResolvedValue(mockCategory),
    update: jest.fn().mockResolvedValue(mockCategory),
    remove: jest.fn().mockResolvedValue(mockCategory),
  };

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [CategoryController],
      providers: [
        {
          provide: CategoryService,
          useValue: mockCategoryService,
        },
        {
          provide: CATEGORY_REPOSITORY,
          useValue: {},
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
          },
        },
      ],
    }).compile();

    controller = module.get<CategoryController>(CategoryController);
    service = module.get<CategoryService>(CategoryService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });

  describe('findOne', () => {
    it('should find one category', async () => {
      const categoryId = '1';
      const result = await controller.findOne(categoryId);

      expect(result).toBe(mockCategory);
      expect(service.findOne).toHaveBeenCalledWith(+categoryId);
    });
  });

  describe('create', () => {
    it('should create a category', async () => {
      const createDto = { name: 'New Category' };
      const result = await controller.create(createDto);

      expect(result).toBe(mockCategory);
      expect(service.create).toHaveBeenCalledWith(createDto);
    });
  });

  describe('update', () => {
    it('should update a category', async () => {
      const categoryId = '1';
      const updateDto = { name: 'Updated Category' };
      const result = await controller.update(categoryId, updateDto);

      expect(result).toBe(mockCategory);
      expect(service.update).toHaveBeenCalledWith(+categoryId, updateDto);
    });
  });

  describe('remove', () => {
    it('should remove a category', async () => {
      const categoryId = '1';
      const result = await controller.remove(categoryId);

      expect(result).toBe(mockCategory);
      expect(service.remove).toHaveBeenCalledWith(+categoryId);
    });
  });
});
