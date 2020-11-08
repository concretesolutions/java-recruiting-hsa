package com.accenture.test.matias.util;

import java.io.InputStream;
import java.util.Objects;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtils {

    /**
     * Method that json file and parse it into a java Object given as
     * parameter..
     * 
     * @param <S> class type.
     * @param filename filename
     * @param template template.
     * @return json.
     */
    public static <S> S readJson(String filename, Class<S> template) {

        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {

            String result = IOUtils.toString(Objects.requireNonNull(inputStream), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(result, template);
        } catch (Exception ex) {
            log.error("Error getting object from json file", ex);
            return null;
        }
    }

}
