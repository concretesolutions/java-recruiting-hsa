package cl.recruiting.hsa.proyecto.data.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.recruiting.hsa.proyecto.data.model.DataCategory;
import cl.recruiting.hsa.proyecto.data.repository.DataCategoryRepository;
import cl.recruiting.hsa.proyecto.legacy.model.Category;
import cl.recruiting.hsa.proyecto.legacy.model.SubcategoryPrimerNivel;
import cl.recruiting.hsa.proyecto.legacy.service.CategoryService;



@Service("dataCategoryService")
public class DataCategoryServiceImpl implements DataCategoryService {

	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DataCategoryRepository dataCategoryRepository;
	
	@Autowired
	public List<DataCategory> top5Categories(){
		this.actualizaDatosCategoria();
		return dataCategoryRepository.top5Categories();
	}
	
	@Autowired
	public List<DataCategory> categoriesRestantes(){
		this.actualizaDatosCategoria();
		return dataCategoryRepository.categoriesRestantes();
	}
	
	
	
	
	private void actualizaDatosCategoria() {
		Gson gson = new Gson();
		Category category = categoryService.getAllCategories();
		if(category!=null) {
			List<SubcategoryPrimerNivel> listPrimerNivel = category.getSubcategories().get(0).getSubcategories();
			for(SubcategoryPrimerNivel primerNivel:listPrimerNivel) {
				dataCategoryRepository.save(new DataCategory(primerNivel.getId(),primerNivel.getName(),primerNivel.getRelevance(),gson.toJson(primerNivel)));
			}
		}
	}
	
	

}
