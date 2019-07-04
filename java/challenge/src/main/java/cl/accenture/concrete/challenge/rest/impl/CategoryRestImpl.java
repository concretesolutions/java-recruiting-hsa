package cl.accenture.concrete.challenge.rest.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.concrete.challenge.data.interfaces.CategoryInterface;
import cl.accenture.concrete.challenge.model.Category;
import cl.accenture.concrete.challenge.rest.CategoryRest;

@RestController
public class CategoryRestImpl implements CategoryRest {
	private static final Log log = LogFactory.getLog(CategoryRestImpl.class);
	
	@Autowired
	private CategoryInterface categoryClient;
	
	@Autowired
    private CacheManager cacheManager;

	@GetMapping("${categories.api.url.path}")
	@Cacheable("${categories.api.cache.name}")
	public Category getCategories() {
		log.info("Obtaining Categories");
		Category cat = categoryClient.getCategoyTree();
		return cat;
	}
	
	@Scheduled(fixedRateString = "${categories.api.cache.time}")
	private void retrieveData() {
		log.info("Clearing Categories Cache");
		cacheManager.getCache("${categories.api.cache.name}").clear();
	}
}
