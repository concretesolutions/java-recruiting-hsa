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

	public static void main(String[] args) {
		SpringApplication.run(APIECommerce.class, args);
	}
	
}
