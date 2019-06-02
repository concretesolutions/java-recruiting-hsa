package com.concrete.challenge.client.base;

import org.springframework.util.MultiValueMap;

public interface ClientOperations<T> {

    /*
     *   GET
     */

    T getObject(final String url);

    T getObjectById(final String url, final String id);

    T getObjectByQueryParams(final String url, final MultiValueMap<String, String> queryParams);

    T[] getObjects(final String url);

    T[] getObjectsByQueryParams(final String url, final MultiValueMap<String, String> queryParams);

}
