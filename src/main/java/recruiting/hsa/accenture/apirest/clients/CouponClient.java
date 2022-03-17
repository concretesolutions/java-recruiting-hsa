package recruiting.hsa.accenture.apirest.clients;

import feign.RequestLine;

public interface CouponClient {
	
	@RequestLine("GET /coupons")
	public String getCoupons();

}
