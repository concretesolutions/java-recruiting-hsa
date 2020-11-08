package com.accenture.test.matias.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.accenture.test.matias.exception.ServiceUnavailableException;
import com.accenture.test.matias.model.Category;
import com.accenture.test.matias.util.Constants;

/**
 * Fallback class for the methods of the Categories Client.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Component
public class CategoryClientFallback implements CategoryClient {

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Category> getCategories() {

        throw new ServiceUnavailableException(Constants.API_CATEGORY_ERROR, Constants.GENERIC_SOLUTION,
                Constants.SERVICE_CODE_CATEGORY);
    }

}
