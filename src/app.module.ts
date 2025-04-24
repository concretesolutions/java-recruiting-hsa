import { MiddlewareConsumer, Module, NestModule } from '@nestjs/common';
import { CategoryModule } from './category/category.module';
import { CouponModule } from './coupon/coupon.module';
import { APP_FILTER } from '@nestjs/core';
import { HttpExceptionFilter } from './shared/infrastructure/http-exception.filter';
import { HttpModule } from '@nestjs/axios';
import { DashboardModule } from './dashboard/dashboard.module';
import { LoggerMiddleware } from './middleware/logger.middleware';
import { SharedModule } from './shared/shared.module';

@Module({
  imports: [
    SharedModule,
    DashboardModule,
    CouponModule,
    CategoryModule,
    HttpModule,
  ],
  providers: [
    {
      provide: APP_FILTER,
      useClass: HttpExceptionFilter,
    },
  ],
})

export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer) {
    consumer
      .apply(LoggerMiddleware)
      .forRoutes('*');
  }
}