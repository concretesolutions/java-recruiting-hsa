package com.desafio;

import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Categories;
import com.desafio.entidades.SubcategoryLv2;
import com.desafio.entidades.SubcategoryLv3;
import com.desafio.entidades.SubcategoryLv4;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepositorie categorieRepositorie;

    public CategorieServiceImpl(CategorieRepositorie categorieRepositorie) {
        this.categorieRepositorie = categorieRepositorie;
    }

    
	
	public CategorieThree getCategorieTop5() {

        
        CategorieThree top5Categorie = new CategorieThree();
        try {

            
            top5Categorie = this.categorieRepositorie.getListCategorie();
            
            //ordena subcategorias nivel 2
            top5Categorie.getSubcategories().stream()
			.forEach(x -> x.setSubcategories(orderCategorie2Relevance(x.getSubcategories())));
        				
        } catch (IOException io) {
            throw new NullPointerException();
        }
        catch(NullPointerException en)
        {
        	System.out.println(en.getStackTrace());
        	System.out.println(en.getMessage());
        }
        catch(Exception e)
        {
        	System.out.println(e.getStackTrace());
        }
        return top5Categorie;
    }

    @SuppressWarnings("unlikely-arg-type")
	public CategorieThree getCategorieOthers() {

        CategorieThree listAllCategorie = new CategorieThree();

        try { 
        	listAllCategorie = this.categorieRepositorie.getListCategorie();
        	 CategorieThree top5Categorie =  getCategorieTop5();
           
        	 for(Categories cat : top5Categorie.getSubcategories())
        	 {
        		 for(SubcategoryLv2 lv2 : cat.getSubcategories())
        		 {
        				 listAllCategorie.getSubcategories().stream().forEach(x -> x.getSubcategories().removeIf(y-> y.getId().equals(lv2.getId())));
        		 }
        			 
        	 }
           
        } catch (IOException io) {
            throw new NullPointerException();
        }
        
        return listAllCategorie;
    }
    
    private List<SubcategoryLv2> orderCategorie2Relevance(List<SubcategoryLv2> list)
    {
    	List<SubcategoryLv2> result = new ArrayList<SubcategoryLv2>();
    	try {
    		result = list.stream().sorted(Comparator.comparingInt(SubcategoryLv2::getRelevance)).collect(Collectors.toList());
    			result = result.stream().filter(x-> x.getRelevance() != 0).limit(5).collect(Collectors.toList());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    	
    }
    
   
   
}
