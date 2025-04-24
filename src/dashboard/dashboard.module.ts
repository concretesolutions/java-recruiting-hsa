import { Module } from '@nestjs/common';
import { CouponModule } from 'src/coupon/coupon.module';
import { CategoryModule } from 'src/category/category.module';
import { DashboardController } from './controllers/dashboard.controller';
import { DashboardService } from './services/dashboard.service';

@Module({
  imports: [CouponModule, CategoryModule],
  controllers: [DashboardController],
  providers: [DashboardService]
})
export class DashboardModule { }