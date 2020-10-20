package cl.desafio.service;

import cl.desafio.domain.CategoryResponse;

import java.util.List;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
public interface CategoryService {

    CategoryResponse getTop5Categories();

    CategoryResponse getOtherCategories();


}
