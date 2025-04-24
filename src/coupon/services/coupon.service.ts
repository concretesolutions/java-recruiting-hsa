import { Inject, Injectable, InternalServerErrorException } from '@nestjs/common';
import { CreateCouponDto } from '../dto/create-coupon.dto';
import { UpdateCouponDto } from '../dto/update-coupon.dto';
import { CouponRepository } from '../repositories/coupon.repository';
import { CouponEntity } from '../entities/coupon.entity';
import { COUPON_REPOSITORY } from 'src/shared/utils/tokens';
import { CACHE_MANAGER, Cache } from '@nestjs/cache-manager';
import { LoggerService } from 'src/shared/infrastructure/logger/logger.service';
import { TYPES } from 'src/shared/utils/types';
import { Coupon } from '../dto/coupon.dto';

@Injectable()
export class CouponService {
  constructor(
    @Inject(COUPON_REPOSITORY) private readonly couponRepository: CouponRepository,    
    @Inject(CACHE_MANAGER) private readonly cacheManager: Cache,    
    @Inject(TYPES.LoggerService) private readonly logger: LoggerService
  ) { }

  async findNotExpired(): Promise<CouponEntity[]> {
    const today : Readonly<Date> = new Date();
    today.setHours(0, 0, 0, 0);

    const cachedCoupons : CouponEntity[] = await this.cacheManager.get(TYPES.CouponsFiltered);
    if (cachedCoupons) {
      return cachedCoupons;
    }

    let coupons: Readonly<Coupon[]>;
    try {
      coupons = await this.couponRepository.findAll();
    } catch (error) {
      this.logger.error('error requesting coupons');
      throw new InternalServerErrorException('error requesting coupons');
    }
    
    const couponsFiltered : CouponEntity[] = coupons.filter(coupon => today < new Date(coupon.expiresAt));
    await this.cacheManager.set(TYPES.CouponsFiltered, couponsFiltered);
    return couponsFiltered;
}




create(createCouponDto: CreateCouponDto) {
  return 'This action adds a new coupon';
}

findOne(id: number) {
  return `This action returns a #${id} coupon`;
}

update(id: number, updateCouponDto: UpdateCouponDto) {
  return `This action updates a #${id} coupon`;
}

remove(id: number) {
  return `This action removes a #${id} coupon`;
}
}
