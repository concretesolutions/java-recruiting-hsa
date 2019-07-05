package cl.accenture.concrete.challenge.rest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import cl.accenture.concrete.challenge.data.interfaces.CategoryInterface;
import cl.accenture.concrete.challenge.model.Category;

@RestController
public class CategoryRest {
	// Logger
	private static final Log log = LogFactory.getLog(CategoryRest.class);

	// External API Interface.
	@Autowired
	private CategoryInterface categoryClient;

	// API Implementations
	@GetMapping("${categories.api.url.path}")
	public Category getCategories() {
		log.info("Obtaining Categories.");
		Category categoryTree = this.retrieveData();
		return categoryTree;
	}

	@GetMapping("${categories.api.url.path}/top/{total}")
	public List<Category> getTopCategories(@PathVariable String total) {
		//Exception control
		if(!StringUtils.isNumeric(total)) return new ArrayList<Category>();
		
		log.info(String.format("Obtaining top %1$s Categories.", total));
		Category categoryTree = this.retrieveData();
		List<Category> categories = categoryTree.flatten().collect(Collectors.toList());
		
		Collections.sort(categories, Collections.reverseOrder());
		
		return categories.subList(0, Integer.valueOf(total));
	}
	
	@GetMapping("${categories.api.url.path}/notop/{total}")
	public List<Category> getNoTopCategories(@PathVariable String total) {
		//Exception control
		if(!StringUtils.isNumeric(total)) return new ArrayList<Category>();
		
		log.info(String.format("Obtaining top %1$s Categories.", total));
		Category categoryTree = this.retrieveData();
		List<Category> categories = categoryTree.flatten().collect(Collectors.toList());
		List<Category> topCategories = getTopCategories(total);
		
		categories.removeIf(x -> topCategories.stream().anyMatch(y -> x.getId() == y.getId()));
		
		return categories;
	}

	// Caching
	// The Caching is implemented through Memoization.
	@Value("${coupons.api.cache.time:0}")
	private String cacheTimeout;
	private Supplier<Category> cachedCategories;

	private Category retrieveData() {
		log.info("Reading Category Data.");

		// Cache initialization. Every cacheTimeout milliseconds will drop the cached result.
		if (cachedCategories == null) {
			cachedCategories = Suppliers.memoizeWithExpiration(categoryClient::getCategoyTree,
					Long.valueOf(cacheTimeout), TimeUnit.MILLISECONDS);
		}

		// Return the cached object. Or, go and retrieve again the data,
		// if the cached one already expired.
		return cachedCategories.get();
	}

}
