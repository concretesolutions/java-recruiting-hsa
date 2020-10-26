package cl.mobile.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BffMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffMobileApplication.class, args);
	}

}
