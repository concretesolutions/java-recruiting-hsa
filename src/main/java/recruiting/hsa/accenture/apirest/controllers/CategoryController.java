package recruiting.hsa.accenture.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recruiting.hsa.accenture.apirest.pojos.CategoryPojo;
import recruiting.hsa.accenture.apirest.servicesImpls.CategoryServiceImplements;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImplements service;
	private List<String> excludeCategories = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("MOB");
			add("ROOT");
		}
	};

	@GetMapping(value = "")
	public ResponseEntity<Object> getAllCategories(@RequestParam(name = "top", required = false) Integer top,
			@RequestParam(name = "justTop", required = false, defaultValue = "false") Boolean justTop) {

		try {
			if (justTop && top == null) {
				return new ResponseEntity<Object>(new HashMap<String, Object>() {
					private static final long serialVersionUID = 1L;

					{
						put("message", "Para recibir sólo los top, se debe indicar un valor para top");
					}
				}, HttpStatus.BAD_REQUEST);
			}
			JSONObject auxResponse = new JSONObject(service.getCategories());
			List<CategoryPojo> categories = flateenCategoryResponse(auxResponse);
			Object response = categories;
			if (top != null) {
				categories.sort((c1, c2) -> {
					return (c2.getRelevance().intValue() - c1.getRelevance().intValue());
				});
				List<CategoryPojo> topList = categories.subList(0, Math.min(top, categories.size()));
				response = topList;
				if (!justTop) {
					response = new HashMap<String, Object>() {
						private static final long serialVersionUID = 1L;
						{
							put("topList", topList);
							put("complementList",
									categories.subList(Math.min(top, categories.size()), categories.size()));
						}
					};
				}
			}
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private List<CategoryPojo> flateenCategoryResponse(JSONObject categoryResponse) {
		List<CategoryPojo> auxResponse = new ArrayList<CategoryPojo>();
		CategoryPojo auxCategory = new CategoryPojo((JSONObject) categoryResponse);

		if (!excludeCategories.contains(auxCategory.getId())) {
			auxResponse.add(auxCategory);
		}
		try {
			for (Object categoryPojo : categoryResponse.getJSONArray("subcategories")) {
				auxResponse.addAll(flateenCategoryResponse((JSONObject) categoryPojo));
			}
		} catch (JSONException e) {
		}

		return auxResponse;
	}
}
