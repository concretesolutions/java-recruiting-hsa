import { Inject, Injectable, InternalServerErrorException } from '@nestjs/common';
import { CategoryService } from 'src/category/services/category.service';
import { CouponService } from 'src/coupon/services/coupon.service';
import { Dashboard } from '../entities/dashboard.entity';
import { CategoryEntity } from 'src/category/entities/category.entity';
import { CouponEntity } from 'src/coupon/entities/coupon.entity';
import { LoggerService } from 'src/shared/infrastructure/logger/logger.service';
import { TYPES } from 'src/shared/utils/types';

@Injectable()
export class DashboardService {
  constructor(
    private readonly couponService: CouponService,
    private readonly categoryService: CategoryService,
    @Inject(TYPES.LoggerService) private readonly logger: LoggerService
  ) { }

  async getDashboard(num: Readonly<number>): Promise<Readonly<Dashboard>> {
    try {
      const categories: CategoryEntity[] = await this.categoryService.findTop(num);
      const coupons: CouponEntity[] = await this.couponService.findNotExpired();

      return {
        categories,
        coupons,
      };
    }
    catch (error) {
      this.logger.error('error requesting dashboard');
      throw new InternalServerErrorException('error requesting dashboard');
    }   
  }
}
