package cl.talavera.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class ApiApplication {
	private static final Logger log = LoggerFactory.getLogger(ApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

@Component
class ApplicationRunner implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		//use this to run functional test!!
		System.out.println("Welcome!!!");
	}
}




