package cl.accenture.concrete.challenge.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.concrete.challenge.interfaces.CouponInterface;
import cl.accenture.concrete.challenge.model.Coupon;

@RestController
public class CouponController {
	private static final Log log = LogFactory.getLog(CouponController.class);

	@Autowired
	private CouponInterface couponClient;

	@GetMapping("/coupons")
	public List<Coupon> getCoupons() {
		log.info("Obtaining Coupons");
		return couponClient.getCoupons();
	}

}
