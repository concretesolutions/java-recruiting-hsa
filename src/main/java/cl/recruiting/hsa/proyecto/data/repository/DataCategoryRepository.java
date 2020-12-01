package cl.recruiting.hsa.proyecto.data.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.recruiting.hsa.proyecto.data.model.DataCategory;

@Repository("dataCategoryRepository")
public interface DataCategoryRepository extends JpaRepository<DataCategory, Long> {

	@Query(value="SELECT * FROM data_category ORDER BY relevance DESC LIMIT 0,5",nativeQuery=true)
	List<DataCategory> top5Categories();	
	
	@Query(value="SELECT * FROM data_category ORDER BY relevance DESC LIMIT 5,100",nativeQuery=true)
	List<DataCategory> categoriesRestantes();
	
	
}
