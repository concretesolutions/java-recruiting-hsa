import { CategoryEntity } from "src/category/entities/category.entity";
import { CouponEntity } from "src/coupon/entities/coupon.entity";

export class Dashboard {    
   readonly categories: CategoryEntity[]
   readonly coupons: CouponEntity[]
}