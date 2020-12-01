package cl.recruiting.hsa.proyecto.legacy.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recruiting.hsa.proyecto.legacy.client.CategoryFeignClient;
import cl.recruiting.hsa.proyecto.legacy.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryFeignClient categoryFeignClient;
	
	@Override
	public Category getAllCategories() {
		Category category = null;
		try {
			category = categoryFeignClient.getAllCategories();
		}catch(Exception e) {
			LOG.error("Error en el servicio de categorias : ",e);
		}
		return category;
	}
	
	

}
