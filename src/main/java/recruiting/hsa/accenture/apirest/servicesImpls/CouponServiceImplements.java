package recruiting.hsa.accenture.apirest.servicesImpls;

import org.springframework.stereotype.Service;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import recruiting.hsa.accenture.apirest.clients.CouponClient;

@Service
public class CouponServiceImplements implements CouponClient {

	@Override
	public String getCoupons() {
		CouponClient coupon = Feign.builder()
				  .client(new OkHttpClient())
				  .logger(new Slf4jLogger(CouponClient.class))
				  .target(CouponClient.class, "https://cs-hsa-api-coupons-rest.herokuapp.com/");
		return coupon.getCoupons();
	}

}
