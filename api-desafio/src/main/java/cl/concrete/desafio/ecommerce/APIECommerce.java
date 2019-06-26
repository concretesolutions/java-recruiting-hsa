package cl.concrete.desafio.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.concrete.desafio.ecommerce.webservice.client.model.Category;
import cl.concrete.desafio.ecommerce.webservice.client.model.Coupon;
import cl.concrete.desafio.ecommerce.webservice.client.service.CategoriesServiceImpl;
import cl.concrete.desafio.ecommerce.webservice.client.service.CouponsServiceImpl;

/**
 * 
 * @author David Nilo
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@RestController
public class APIECommerce extends SpringBootServletInitializer {

	@Autowired
	private CategoriesServiceImpl categoriesService;
	@Autowired
	private CouponsServiceImpl couponsService;

	public static void main(String[] args) {
		SpringApplication.run(APIECommerce.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(APIECommerce.class);
	}

	@RequestMapping("/categories")
	public List<Category> findAllCategories() {
		return this.categoriesService.findAll();
	}

	@RequestMapping("/coupons")
	public List<Coupon> findAllCoupons() {
		return this.couponsService.findAll();
	}
	
	@RequestMapping("/coupons/currents")
	public List<Coupon> findCurrentCoupons() {
		return this.couponsService.findCurrents();
	}

}
