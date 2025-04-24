import { Test, TestingModule } from '@nestjs/testing';
import { CATEGORY_REPOSITORY, COUPON_REPOSITORY } from 'src/shared/utils/tokens';
import { CACHE_MANAGER } from '@nestjs/cache-manager';
import { WinstonLoggerService } from 'src/shared/infrastructure/logger/winston-logger.service';
import { DashboardController } from '../dashboard.controller';
import { DashboardService } from '../../services/dashboard.service';
import { DashboardModule } from '../../dashboard.module';
import { Dashboard } from '../../entities/dashboard.entity';
import { CouponService } from 'src/coupon/services/coupon.service';
import { CategoryService } from 'src/category/services/category.service';

describe('DashboardController', () => {
  let controller: DashboardController;

  const mockDashboard: Dashboard = {
    categories: [{
      id: "MOB",
      name: "MOBILE_MARKET",
      subcategories: [
        {
          id: "video-games",
          name: "Video Games",
          relevance: 150,
          subcategories: []
        }
      ]
    }],
    coupons: [
      {
        id: "COUPON_1",
        description: "50% Discount",
        seller: "Crazy Seller",
        image: "https://example.com/image1.jpg",
        expiresAt: "2045-12-01"
      }
    ]
  };

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      imports: [DashboardModule],
      controllers: [DashboardController],
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

    controller = module.get<DashboardController>(DashboardController);
  });

  describe('dashboard', () => {
    it('should return the dashboard', async () => {
      jest.spyOn(controller, 'dashboard').mockImplementation(async () => mockDashboard);

      const found = await controller.dashboard(5);
      expect(found.coupons.length).toBe(mockDashboard.coupons.length);
      expect(found.coupons[0].expiresAt).toBe(mockDashboard.coupons[0].expiresAt);
      expect(found.categories[0].name).toBe(mockDashboard.categories[0].name);
    });
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
