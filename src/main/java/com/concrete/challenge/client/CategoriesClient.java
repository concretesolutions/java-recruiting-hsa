package com.concrete.challenge.client;

import com.concrete.challenge.bean.categories.external.CategoryThree;
import com.concrete.challenge.client.base.AbstractClient;
import org.springframework.stereotype.Component;

@Component
public class CategoriesClient extends AbstractClient<CategoryThree> {

    @Override
    public void construct() {
        setClazz(CategoryThree.class);
        setArrayClazz(CategoryThree[].class);
        setElementReturn(CategoryThree.builder().build());
        setArrayReturn(new CategoryThree[]{});
    }

    public CategoryThree getCategory() {
        return getObject(getClientConfiguration().getCategoriesUrl());
    }
}
