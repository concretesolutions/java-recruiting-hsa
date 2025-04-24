import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { CouponService } from '../services/coupon.service';
import { CreateCouponDto } from '../dto/create-coupon.dto';
import { UpdateCouponDto } from '../dto/update-coupon.dto';
import { CouponEntity } from '../entities/coupon.entity';
import { ApiExcludeEndpoint, ApiTags } from '@nestjs/swagger';

@ApiTags('coupon')
@Controller('coupon')
export class CouponController {
  constructor(private readonly couponService: CouponService) {}

  @Get('notexpired')
  public async findNotExpired(): Promise<Readonly<CouponEntity[]>>  {
    return await this.couponService.findNotExpired();
  }







  @Post()
  @ApiExcludeEndpoint()
  create(@Body() createCouponDto: CreateCouponDto) {
    return this.couponService.create(createCouponDto);
  }

  @Get(':id')
  @ApiExcludeEndpoint()
  findOne(@Param('id') id: string) {
    return this.couponService.findOne(+id);
  }

  @Patch(':id')
  @ApiExcludeEndpoint()
  update(@Param('id') id: string, @Body() updateCouponDto: UpdateCouponDto) {
    return this.couponService.update(+id, updateCouponDto);
  }

  @Delete(':id')
  @ApiExcludeEndpoint()
  remove(@Param('id') id: string) {
    return this.couponService.remove(+id);
  }
}
