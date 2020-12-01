package cl.recruiting.hsa.proyecto.data.service;

import java.util.List;

import cl.recruiting.hsa.proyecto.data.model.DataCategory;


public interface DataCategoryService {

	
	List<DataCategory> top5Categories();
	
	List<DataCategory> categoriesRestantes();
	
	
}
