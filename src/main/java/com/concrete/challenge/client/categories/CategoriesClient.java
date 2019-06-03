package com.concrete.challenge.client.categories;

import com.concrete.challenge.bean.categories.external.CategoryThree;
import com.concrete.challenge.client.base.AbstractClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CategoriesClient
        extends AbstractClient<CategoryThree>
        implements CategoriesRepository {

    @Override
    public void construct() {
        setClazz(CategoryThree.class);
        setArrayClazz(CategoryThree[].class);
        setElementReturn(CategoryThree.builder().build());
        setArrayReturn(new CategoryThree[]{});
    }

    @Override
    @Cacheable("categories")
    public CategoryThree getCategory() {
        return getObject(getContainerConfiguration().getCategoriesUrl());
    }
}
