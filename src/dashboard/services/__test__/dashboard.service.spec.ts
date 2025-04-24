import { Test, TestingModule } from '@nestjs/testing';
import { WinstonLoggerService } from 'src/shared/infrastructure/logger/winston-logger.service';
import { CATEGORY_REPOSITORY, COUPON_REPOSITORY } from 'src/shared/utils/tokens';
import { DashboardService } from '../dashboard.service';
import { DashboardModule } from '../../dashboard.module';
import { Dashboard } from '../../entities/dashboard.entity';
import { CouponService } from 'src/coupon/services/coupon.service';
import { CategoryService } from 'src/category/services/category.service';
import { CACHE_MANAGER } from '@nestjs/cache-manager';
import path from 'node:path';
import { readFile } from 'node:fs/promises';

describe('DashboardController', () => {
  let service: DashboardService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      imports: [DashboardModule],
      providers: [DashboardService, CouponService, CategoryService,
        {
          provide: COUPON_REPOSITORY,
          useValue: {
            find: jest.fn(),
          },
        },
        {
          provide: CATEGORY_REPOSITORY,
          useValue: {
            find: jest.fn(),
          },
        },
        {
          provide: CACHE_MANAGER,
          useValue: {
            get: jest.fn(),
            set: jest.fn(),
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
      ],
    }).compile();

    service = module.get<DashboardService>(DashboardService);
  });

  describe('dashboard', () => {
    it('should return the dashboard', async () => {
      const relativePath = 'test/data/dashboard-ok.json';
      const filePath = path.resolve('.', relativePath);
      const fileContent = await readFile(filePath, 'utf8');     
      const result: Dashboard = JSON.parse(fileContent);

      jest.spyOn(service, 'getDashboard').mockImplementation(async () => result);

      const found = await service.getDashboard(5);     

      expect(found.coupons[0].expiresAt).toBe(result.coupons[0].expiresAt);
      expect(found.categories[0].name).toBe(result.categories[0].name);
    });
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
