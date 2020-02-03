package cl.accenture.concrete.feing.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

/**
 * Configuracion especifica para las invocaciones a la api de cupones
 * @author c.leon.palacios
 *
 */
@Configuration
public class CouponsConfiguration {
	
	@Value("${feign.coupons.client.connectTimeout}")
	private int connectTimeout;

	@Value("${feign.coupons.client.readTimeOut}")
	private int readTimeout;

	@Bean
	public Request.Options requestOptions() {
		return new Request.Options(connectTimeout, readTimeout);
	}
}
