package cl.recruiting.hsa.proyecto.data.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recruiting.hsa.proyecto.data.model.DataCoupon;
import cl.recruiting.hsa.proyecto.data.repository.DataCouponRepository;
import cl.recruiting.hsa.proyecto.legacy.model.Coupon;
import cl.recruiting.hsa.proyecto.legacy.service.CouponService;

@Service("dataCouponService")
public class DataCouponServiceImpl implements DataCouponService {

	@Autowired
	private CouponService couponService;
	
	@Autowired
	private DataCouponRepository dataCouponRepository;
	
	
	@Autowired
	public List<DataCoupon> cuponesVigentes(){
		this.actualizaCoupon();
		return dataCouponRepository.cuponesVigentes();
	}
	
	
	private void actualizaCoupon() {
		List<Coupon> listCoupons = couponService.getAllCoupons();
		if(listCoupons!=null) {
			for(Coupon coupon:listCoupons) {
				LocalDate localDate = LocalDate.parse(coupon.getExpiresAt());
				Timestamp timestamp = Timestamp.valueOf(localDate.atStartOfDay());
				dataCouponRepository.save(new DataCoupon(coupon.getId(), coupon.getDescription(), coupon.getSeller(), coupon.getImage(), timestamp));
			}
		}
	}

	
}