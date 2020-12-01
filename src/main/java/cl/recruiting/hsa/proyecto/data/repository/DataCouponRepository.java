package cl.recruiting.hsa.proyecto.data.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.recruiting.hsa.proyecto.data.model.DataCoupon;

@Repository("dataCouponRepository")
public interface DataCouponRepository extends JpaRepository<DataCoupon, Long> {
	
	@Query(value="SELECT * FROM proyecto.data_coupon where expires_at <= NOW()",nativeQuery=true)
	List<DataCoupon> cuponesVigentes();
	
	}