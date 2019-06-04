package com.desafio;

import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Categories;
import com.desafio.entidades.SubcategoryLv2;
import com.desafio.entidades.SubcategoryLv3;
import com.desafio.entidades.SubcategoryLv4;

import org.springframework.stereotype.Service;

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
            
            //ordena subcategorias nivel 4
            top5Categorie.getSubcategories().stream()
			.forEach(x -> x.getSubcategories().stream()
						   .forEach(lv3 -> lv3.getSubcategorie().stream()
								   			  .forEach(lv4 -> lv4.setSubcategories(orderCategorie4Relevance(lv4.getSubcategories())))));
            
            //ordena subcategorias nivel 3
            top5Categorie.getSubcategories().stream()
			.forEach(x -> x.getSubcategories().stream().forEach(lv3 -> lv3.setSubcategorie(orderCategorie3Relevance(lv3.getSubcategorie()))));
        				
                        
            //ordena subcategorias nivel 2
            top5Categorie.getSubcategories().stream()
			.forEach(x -> x.setSubcategories(orderCategorie2Relevance(x.getSubcategories())));
        				
        } catch (IOException io) {
            throw new NullPointerException();
        }
        return top5Categorie;
    }

    public CategorieThree getCategorieOthers() {

        CategorieThree listAllCategorie = new CategorieThree();
        CategorieThree listTop5Categorie = new CategorieThree();

        try {

            listAllCategorie = this.categorieRepositorie.getListCategorie();
            listAllCategorie.getSubcategories().remove(getCategorieTop5().getSubcategories());

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
    		if(result.stream().count() > 5)
    			result = result.stream().filter(x-> x.getRelevance() != 0).limit(5).collect(Collectors.toList());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    	
    }
    
    private List<SubcategoryLv3> orderCategorie3Relevance(List<SubcategoryLv3> list)
    {
    	List<SubcategoryLv3> result = new ArrayList<SubcategoryLv3>();
    	try {
    		result = list.stream().sorted(Comparator.comparingInt(SubcategoryLv3::getRelevance)).collect(Collectors.toList());
    		if(result.stream().count() > 5)
    			result = result.stream().filter(x-> x.getRelevance() != 0).limit(5).collect(Collectors.toList());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    	
    }
    
    private List<SubcategoryLv4> orderCategorie4Relevance(List<SubcategoryLv4> list)
    {
    	List<SubcategoryLv4> result = new ArrayList<SubcategoryLv4>();
    	try {
    		result = list.stream().sorted(Comparator.comparingInt(SubcategoryLv4::getRelevance)).collect(Collectors.toList());
    		if(result.stream().count() > 5)
    			result = result.stream().filter(x-> x.getRelevance() != 0).limit(5).collect(Collectors.toList());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    	
    }


}
