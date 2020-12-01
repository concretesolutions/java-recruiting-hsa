package cl.recruiting.hsa.proyecto.legacy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recruiting.hsa.proyecto.legacy.client.CouponFeignClient;
import cl.recruiting.hsa.proyecto.legacy.model.Coupon;

@Service
public class CouponServiceImpl implements CouponService {

	private static final Logger LOG = LoggerFactory.getLogger(CouponServiceImpl.class);
			
	@Autowired
	private CouponFeignClient couponFeignClient;
	

	@Override
	public List<Coupon> getAllCoupons() {
		List<Coupon> listCoupons = null;
		try {
			listCoupons = couponFeignClient.getAllCoupons();
		}catch(Exception e) {
			LOG.error("Error en el servicio de categorias : ",e);
		}
		return listCoupons;
	}
	


	
	
}
