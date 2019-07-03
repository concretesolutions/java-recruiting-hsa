package cl.accenture.concrete.challenge.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.concrete.challenge.interfaces.CategoryInterface;
import cl.accenture.concrete.challenge.model.Category;

@RestController
public class CategoryController {
	private static final Log log = LogFactory.getLog(CouponController.class);

	@Autowired
	private CategoryInterface categoryClient;

	@GetMapping("/categories")
	public Category getCategories() {
		log.info("Obtaining Categories");
		Category cat = categoryClient.getCategoyTree();
		return cat;
	}
}
