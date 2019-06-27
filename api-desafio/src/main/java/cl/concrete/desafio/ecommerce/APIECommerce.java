package cl.concrete.desafio.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.concrete.desafio.ecommerce.webservice.client.model.Category;
import cl.concrete.desafio.ecommerce.webservice.client.model.Coupon;
import cl.concrete.desafio.ecommerce.webservice.client.service.CategoriesServiceImpl;
import cl.concrete.desafio.ecommerce.webservice.client.service.CouponsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author David Nilo
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@RestController
@Api(value = "API E-commerce for Concrete")
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

	@ApiOperation(value = "Returns all categories from https://cs-hsa-api-categories.herokuapp.com/docs")
	@GetMapping("/categories")
	public List<Category> findAllCategories() {
		return this.categoriesService.findAll();
	}
	
	@ApiOperation(value = "Returns Top categories from https://cs-hsa-api-categories.herokuapp.com/docs")
	@GetMapping("/categories/top")
	public List<Category> findTopCategories() {
		return this.categoriesService.findTopCategories();
	}

	@ApiOperation(value = "Returns no Top categories from https://cs-hsa-api-categories.herokuapp.com/docs")
	@GetMapping("/categories/notop")
	public List<Category> findNoTopCategories() {
		return this.categoriesService.findNoTopCategories();
	}
	
	@ApiOperation(value = "Returns all coupons from https://cs-hsa-api-coupons.herokuapp.com/docs")
	@GetMapping("/coupons")
	public List<Coupon> findAllCoupons() {
		return this.couponsService.findAll();
	}

	@ApiOperation(value = "Returns only valid coupons (starting from today) from https://cs-hsa-api-categories.herokuapp.com/docs")
	@GetMapping("/coupons/currents")
	public List<Coupon> findCurrentCoupons() {
		return this.couponsService.findCurrents();
	}

}
