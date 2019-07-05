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
import cl.accenture.concrete.challenge.dto.CategoryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@ApiModel(value = "${categories.api.doc.name}", description = "${categories.api.doc.desc}")
public class CategoryRest {
	// Logger
	private static final Log LOGGER = LogFactory.getLog(CategoryRest.class);

	// External API Interface.
	@Autowired
	private CategoryInterface categoryClient;

	// API Implementations
	// /categories
	@ApiOperation(value = "${categories.api.doc.getCategories.desc}", notes = "${categories.api.doc.getCategories.notes}")
	@GetMapping("${categories.api.url.path}")
	public CategoryDTO getCategories() {
		LOGGER.info("Obtaining Categories.");
		final CategoryDTO categoryTree = this.retrieveData();
		return categoryTree;
	}

	// /categories/top
	@ApiOperation(value = "${categories.api.doc.getTop5Categories.desc}", notes = "${categories.api.doc.getTop5Categories.notes}")
	@GetMapping(produces = { "application/json" }, value = "${categories.api.url.path}/top/")
	public List<CategoryDTO> getTop5Categories() {
		return this.getTopCategories("5");
	}

	// /categories/top/x
	@ApiOperation(value = "${categories.api.doc.getTopCategories.desc}", notes = "${categories.api.doc.getTopCategories.notes}")
	@GetMapping(produces = { "application/json" }, value = "${categories.api.url.path}/top/{total}")
	public List<CategoryDTO> getTopCategories(
			@ApiParam(value = "${categories.api.doc.getTopCategories.param.total.desc}", required = true) @PathVariable String total) {
		// Exception control
		if (!StringUtils.isNumeric(total))
			return new ArrayList<CategoryDTO>();

		LOGGER.info(String.format("Obtaining top %1$s Categories.", total));
		final CategoryDTO categoryTree = this.retrieveData();
		List<CategoryDTO> categoryDTOs = categoryTree.flatten().collect(Collectors.toList());

		Collections.sort(categoryDTOs, Collections.reverseOrder());

		return categoryDTOs.subList(0, Integer.valueOf(total));
	}

	// /categories/notop/
	@ApiOperation(value = "${categories.api.doc.getNoTop5Categories.desc}", notes = "${categories.api.doc.getNoTop5Categories.notes}")
	@GetMapping(produces = { "application/json" }, value = "${categories.api.url.path}/notop/")
	public List<CategoryDTO> getNoTop5Categories() {
		return this.getNoTopCategories("5");
	}

	// /categories/notop/x
	@ApiOperation(value = "${categories.api.doc.getNoTopCategories.desc}", notes = "${categories.api.doc.getNoTopCategories.notes}")
	@GetMapping(produces = { "application/json" }, value = "${categories.api.url.path}/notop/{total}")
	public List<CategoryDTO> getNoTopCategories(
			@ApiParam(value = "${categories.api.doc.getNoTopCategories.param.total.desc}", required = true) @PathVariable String total) {
		// Exception control
		if (!StringUtils.isNumeric(total))
			return new ArrayList<CategoryDTO>();

		// Response Object
		List<CategoryDTO> categoryDTOs;

		LOGGER.info(String.format("Obtaining top %1$s Categories.", total));

		final CategoryDTO categoryTree = this.retrieveData();
		categoryDTOs = categoryTree.flatten().collect(Collectors.toList());

		final List<CategoryDTO> topCategories = getTopCategories(total);
		categoryDTOs.removeIf(x -> topCategories.stream().anyMatch(y -> x.getId() == y.getId()));

		return categoryDTOs;
	}

	// Caching
	// The Caching is implemented through Memoization.
	@Value("${coupons.api.cache.time:0}")
	private String cacheTimeout;
	private Supplier<CategoryDTO> cachedCategories;

	private CategoryDTO retrieveData() {
		LOGGER.info("Reading Category Data.");

		// Cache initialization. Every cacheTimeout milliseconds will drop the cached
		// result.
		if (cachedCategories == null) {
			cachedCategories = Suppliers.memoizeWithExpiration(categoryClient::getCategoyTree,
					Long.valueOf(cacheTimeout), TimeUnit.MILLISECONDS);
		}

		// Return the cached object. Or, go and retrieve again the data,
		// if the cached one already expired.
		return cachedCategories.get();
	}

}
