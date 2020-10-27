package com.accenture.challenge.api.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.challenge.api.exceptions.CouponServiceException;
import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.models.Coupon;
import com.accenture.challenge.api.proxy.ICouponsService;
import com.accenture.challenge.api.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CouponsService implements ICouponsService{
	
	/**
	 * Obtiene un listado de cupones desde una API externa
	 * @return
	 * @throws CouponServiceException
	 */
	private List<Coupon> getCoupons() throws CouponServiceException, CustomNotFoundException{
		
		
		List<Coupon> coupons = new ArrayList<>(); 
		RestTemplate restTemplate = new RestTemplate();			
		
		try {
		
			ResponseEntity<Coupon[]> response = restTemplate.exchange("https://cs-hsa-api-coupons.herokuapp.com/coupons", HttpMethod.GET, null, Coupon[].class);
			
			if (response.getStatusCode().equals(HttpStatus.OK)) {

				for (Coupon coupon : response.getBody()) {
					coupons.add(coupon);	
				}

			} else {
				
				log.error("HttpStatus Error: CouponsService:getCoupons(), error : " + response.getStatusCode().toString());
				if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
					throw new CustomNotFoundException(HttpStatus.NOT_FOUND.toString());
				}
			}
			
			
			
		} catch (Exception ex) {
			log.error("Service error: CategoriesService:getCategories(), error : " + ex.getMessage());
			throw new CouponServiceException("Error : " + ex.getMessage(), ex);
		}
		
		
		
		return coupons;
	
	}
	
	/**
	 * Obtiene los cupones expirados (expired = true) o los no expirados (expired = false)
	 * @param expired
	 * @return
	 * @throws CouponServiceException 
	 * @throws CustomNotFoundException 
	 */
	public List<Coupon> getCoupons(boolean expired) throws CouponServiceException, CustomNotFoundException{
		
			List<Coupon> coupons = new ArrayList<>();
		
			for (Coupon coupon : this.getCoupons()) {
				
				   Date expireDate = Utils.getDateFromString(coupon.getExpiresAt());
				   
				   if (expireDate != null && Utils.isExpireDate(expireDate).equals(expired)) {
					   
					   coupons.add(coupon);
				   }
				
			}
			
			return coupons;
	}

}
