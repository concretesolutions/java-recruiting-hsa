package cl.concrete.desafio.main;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import cl.concrete.desafio.utils.ResourceTransformer;
import cl.concrete.desafio.webservice.client.model.Category;
import cl.concrete.desafio.webservice.client.model.CategoryDto;
import cl.concrete.desafio.webservice.client.model.Coupon;
import cl.concrete.desafio.webservice.client.model.CouponDto;
import cl.concrete.desafio.webservice.client.rest.CategoriesClientInterface;
import cl.concrete.desafio.webservice.client.rest.CouponsClientInterface;
import feign.Feign;


/**
 * 
 * @author David Nilo
 *
 */
@SpringBootApplication
@EnableFeignClients
public class APIECommerce {
	
	@Autowired
	private CouponsClientInterface couponsClient;
	
	
	public static void main(String[] args) {
		SpringApplication.run(APIECommerce.class, args);
//		CouponsClientInterface client = Feign.builder()
//				.decoder(new GsonDecoder())
//				.target(CouponsClientInterface.class, "https://cs-hsa-api-coupons.herokuapp.com/coupons");
//		
//		try {
//			List<Coupon> coupons = ResourceTransformer.transformDtosToCoupon(client.findAll());
//			for(Coupon coupon:coupons) {
//				System.out.println(coupon.getExpiresAt());
//			}
//		} catch (ParseException e) {
//			// Logger
//		}
		
		//APIECommerce api = new APIECommerce();
		//api.asd();
	}
	
	public void getCoupons() {
		try {
			List<Coupon> coupons = ResourceTransformer.transformDtosToCoupon(this.couponsClient.findAll());
			for(Coupon coupon:coupons) {
				System.out.println(coupon.getExpiresAt());
			}
		} catch (ParseException e) {
			// logger
		}
	}
	
}
