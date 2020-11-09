package com.accenture.test.matias.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.accenture.test.matias.exception.ServiceUnavailableException;
import com.accenture.test.matias.model.Category;
import com.accenture.test.matias.util.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * Fallback class for the methods of the Categories Client.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Slf4j
@Component
public class CategoryClientFallback implements CategoryClient {

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Category> getCategories() {

        log.error("Fallback: Error al conseguir las categorias desde la API.");
        throw new ServiceUnavailableException(Constants.API_CATEGORY_ERROR, Constants.GENERIC_SOLUTION,
                Constants.SERVICE_CODE_CATEGORY);
    }

}
