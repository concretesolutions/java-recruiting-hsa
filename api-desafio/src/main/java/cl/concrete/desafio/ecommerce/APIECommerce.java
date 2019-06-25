package cl.concrete.desafio.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @author David Nilo
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class APIECommerce {
	
//	@Autowired
//	private CouponsService couponsService;
	
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
	}
	
}
