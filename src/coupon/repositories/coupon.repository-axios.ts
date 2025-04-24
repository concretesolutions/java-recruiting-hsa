import { Inject, Injectable } from '@nestjs/common';
import { Coupon } from "../dto/coupon.dto";
import { HttpClientService } from 'src/shared/infrastructure/http-client/http-client.interface';
import { TYPES } from 'src/shared/utils/types';
import { CouponRepository } from './coupon.repository';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class CouponAxiosRepository implements CouponRepository {
    constructor(
        @Inject(TYPES.HttpClientService)
        private readonly httpClientService: HttpClientService,
        private readonly configService: ConfigService
    ) {}

    async findAll(): Promise<Readonly<Coupon[]>> {
        return await this.httpClientService.get<Readonly<Coupon[]>>({
            url: this.configService.get<Readonly<string>>('API_COUPON'),
        });
    }
}