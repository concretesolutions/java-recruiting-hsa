package com.desafio;

import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;
import com.desafio.entidades.SubcategoryLv2;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepositorie categorieRepositorie;

    public CategorieServiceImpl(CategorieRepositorie categorieRepositorie) {
        this.categorieRepositorie = categorieRepositorie;
    }

    public List<CategorieThree> getCategorieTop5() {

        List<CategorieThree> listAllCategorie = new ArrayList<CategorieThree>();
        try {

            listAllCategorie = this.categorieRepositorie.getListCategorie().stream().map(result -> {
                result.getSubcategories().setSubcategories(orderRelevance(result.getSubcategories().getSubcategories().stream().limit(5).collect(Collectors.toList())));
                return new CategorieThree(result.getSubcategories());
            })
                    .collect(Collectors.toList());
        } catch (IOException io) {
            throw new NullPointerException();
        }
        return listAllCategorie;
    }

    public List<CategorieThree> getCategorieOthers() {

        List<CategorieThree> listAllCategorie = new ArrayList<CategorieThree>();
        List<CategorieThree> listTop5Categorie = new ArrayList<CategorieThree>();

        try {

            listAllCategorie = this.categorieRepositorie.getListCategorie();
            listAllCategorie.remove(getCategorieTop5());

        } catch (IOException io) {
            throw new NullPointerException();
        }
        return listAllCategorie;
    }

    private List<SubcategoryLv2> orderRelevance(List<SubcategoryLv2> subCategorieLv2) {
        SubcategoryLv2 result = new SubcategoryLv2();
        return subCategorieLv2.stream().sorted(Comparator.comparingInt(SubcategoryLv2::getRelevance)).collect(Collectors.toList());

    }
}
