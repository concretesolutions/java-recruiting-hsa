package com.concrete.challenge.endpoints;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import com.concrete.challenge.apis.CategoryApi;
import com.concrete.challenge.apis.CouponApi;
import com.concrete.challenge.models.CategoryResponse;
import com.concrete.challenge.models.CouponResponse;
import com.concrete.challenge.models.CustomCategory;
import com.concrete.challenge.models.Subcategory_;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Endpoints Challenge", description = "Endpoints para obtener resultados de Cupones y Categorias")
@EnableFeignClients
@RestController
public class EndpointController {
	
	@Autowired
	CouponApi ca;
	
	@Autowired
	CategoryApi catApi;
	
	@RequestMapping("/")
    public String home(){
        return "Mapping for /";
    }
    
	@ApiOperation(value = "Test de conexión")
    @RequestMapping(method = RequestMethod.GET, value = "/challenge/healthcheck", produces = "application/json")
    public String healthCheck() {
        return "\"healthy\"";
    }
    
	@ApiOperation(value = "Obtiene todos los cupones disponibles", response = CouponResponse.class)
    @Cacheable("coupons")
    @RequestMapping(method = RequestMethod.GET, value = "/challenge/coupons", produces = "application/json")
    public List<CouponResponse> getAllCoupons() {
    	List<CouponResponse> cupones = null;
		try {
			cupones = ca.getCoupons();
		}catch(RestClientException e){
			e.printStackTrace();
		}
        return cupones;
    }
    
	@ApiOperation(value = "Obtiene todos los cupones no expirados a la fecha", response = CouponResponse.class)
    @Cacheable("not-expired")
    @RequestMapping(method = RequestMethod.GET, value = "/challenge/coupons/not-expired", produces = "application/json")
    public List<CouponResponse> getCouponsNotExpired() {
    	ArrayList<CouponResponse> temp = new ArrayList<CouponResponse>();
    	Date today = new Date();
		try {
			List<CouponResponse> cupones = ca.getCoupons();
			for(int i=0; i<cupones.size();i++) {
				String sDate1=cupones.get(i).getExpiresAt();  
			    Date couponExpiredDate = null;
				try {
					couponExpiredDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
					if(couponExpiredDate.compareTo(today) > 0) {
						temp.add(cupones.get(i));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}catch(RestClientException e){
			e.printStackTrace();
		}
        return temp;
    }
    
	@ApiOperation(value = "Obtiene todas las categorias disponibles", response = CategoryResponse.class)
    @Cacheable("categories")
    @RequestMapping(method = RequestMethod.GET, value = "/challenge/categories", produces = "application/json")
    public CategoryResponse getAllCategories() {
    	CategoryResponse categories = null;
		try {
			categories = catApi.getCategories();
		}catch(RestClientException e){
			e.printStackTrace();
		}
        return categories;
    }
    
	@ApiOperation(value = "Obtiene el top 5 de categorias disponibles", response = CustomCategory.class)
    @Cacheable("top-five")
    @RequestMapping(method = RequestMethod.GET, value = "/challenge/categories/top-five", produces = "application/json")
    public ArrayList<CustomCategory> getCategoriesTopFive() {
    	ArrayList<Subcategory_> temp = new ArrayList<Subcategory_>();
		try {
			ArrayList<Subcategory_> subcategories = catApi.getCategories().getSubcategories().get(0).getSubcategories();
			temp = bubbleSort(subcategories);
		}catch(RestClientException e){
			e.printStackTrace();
		}
		
        return topFive(temp);
    }
    
	@ApiOperation(value = "Obtiene la cantidad de categorias restantes luego de obtener las top 5", response = CustomCategory.class)
    @Cacheable("rest-top-five")
    @RequestMapping(method = RequestMethod.GET, value = "/challenge/categories/rest-top-five", produces = "application/json")
    public ArrayList<CustomCategory> getCategoriesRest() {
    	ArrayList<Subcategory_> temp = new ArrayList<Subcategory_>();
		try {
			ArrayList<Subcategory_> subcategories = catApi.getCategories().getSubcategories().get(0).getSubcategories();
			temp = bubbleSort(subcategories);
		}catch(RestClientException e){
			e.printStackTrace();
		}
		
        return restOfTheCategories(temp);
    }
    
    private ArrayList<Subcategory_> bubbleSort(ArrayList<Subcategory_> list)
    {
    	Subcategory_ temp = null;
        
        for(int i=0; i < list.size(); i++){  
            for(int j=1; j < (list.size()-i); j++){ 
                if(list.get(j).getRelevance() != null && list.get(j-1).getRelevance() != null){
	                if(list.get(j-1).getRelevance() < list.get(j).getRelevance()){  
	                        temp = list.get(j-1);
	                        list.set( j-1, list.get(j));
	                        list.set( j, temp);
	                }  
                }
                if(list.get(j-1).getRelevance() == null) {
                	temp = list.get(j-1);
                    list.set( j-1, list.get(j));
                    list.set( j, temp);
                }
            }  
        }
        
        return list;
    }
    
    private ArrayList<CustomCategory> topFive(ArrayList<Subcategory_> list){
    	
    	ArrayList<CustomCategory> customCategories = new ArrayList<CustomCategory>();
    	for(int i=0; i<list.size()-1;i++) {
    		CustomCategory custom = new CustomCategory();
    		custom.setName(list.get(i).getName());
    		custom.setRelevance(list.get(i).getRelevance());
    		custom.setIconImageUrl(list.get(i).getIconImageUrl());
    		if(list.get(i).getSubcategories().size() != 0) {
    			custom.setSmallImageUrl(list.get(i).getSubcategories().get(0).getSmallImageUrl());
    		}
    		customCategories.add(custom);
    	}
    	
    	if(customCategories.size()>5) {
        	ArrayList<CustomCategory> firstElements = new ArrayList<CustomCategory>(customCategories.subList(0, 5));
        	return firstElements;
        }
    	return customCategories;
    }
    
    private ArrayList<CustomCategory> restOfTheCategories(ArrayList<Subcategory_> list){
    	
    	ArrayList<CustomCategory> customCategories = new ArrayList<CustomCategory>();
    	for(int i=0; i<list.size();i++) {
    		CustomCategory custom = new CustomCategory();
    		custom.setName(list.get(i).getName());
    		custom.setRelevance(list.get(i).getRelevance());
    		custom.setIconImageUrl(list.get(i).getIconImageUrl());
    		if(list.get(i).getSubcategories().size() != 0) {
    			custom.setSmallImageUrl(list.get(i).getSubcategories().get(0).getSmallImageUrl());
    		}
    		customCategories.add(custom);
    	}
    	
    	if(customCategories.size()>5) {
        	ArrayList<CustomCategory> lastElements = new ArrayList<CustomCategory>(customCategories.subList(5, customCategories.size()));
        	return lastElements;
        }
    	return customCategories;
    }
    
}
