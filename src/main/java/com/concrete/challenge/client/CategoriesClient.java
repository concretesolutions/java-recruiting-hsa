package com.concrete.challenge.client;

import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.client.base.AbstractClient;
import org.springframework.stereotype.Component;

@Component
public class CategoriesClient extends AbstractClient<Category> {

    @Override
    public void construct() {
        setClazz(Category.class);
        setArrayClazz(Category[].class);
        setElementReturn(null);
        setArrayReturn(new Category[]{});
    }


}
