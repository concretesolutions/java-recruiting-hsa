package com.example.demo.controller.handler;


import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.DomainException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.NotImplementedException;
import com.example.demo.properties.PropertiesFeign;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.ServiceUnavailableException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {


    private final PropertiesFeign propertiesFeign;


    @Autowired
    public CustomErrorDecoder(PropertiesFeign propertiesFeign){
        this.propertiesFeign=propertiesFeign;
    }

    @Override
    public Exception decode(String methodKey, Response response) {

        String reader = null;
        try {
            reader = extractErrorMessage(readFromReader(response.body().asReader(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            throw new DomainException(propertiesFeign.getGenericError());
        }

        switch (response.status()){
            case 400 :
                return new BadRequestException(reader);
            case 404:
                return new NotFoundException(reader);
            case 500:
                 return  new NotImplementedException(reader);
            default:
                return new ServiceUnavailableException(propertiesFeign.getGenericError());
        }

    }

    private  String readFromReader(Reader reader) {

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            return bufferedReader.lines()
                    .collect(Collectors.joining());
        }
        catch (IOException e) {
            throw new  DomainException(propertiesFeign.getGenericError());
        }

    }

    private String extractErrorMessage(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            if (jsonNode.has(propertiesFeign.getMessage())) {
                String message = jsonNode.get(propertiesFeign.getMessage()).asText();
                if (message != null && message.startsWith("{") && message.endsWith("}")) {
                    JsonNode internalMessageNode = objectMapper.readTree(message);
                    if (internalMessageNode.has(propertiesFeign.getMessage())) {
                        return internalMessageNode.get(propertiesFeign.getMessage()).asText();
                    }
                } else {
                    return message;
                }
            }
        } catch (Exception e) {
                log.error(" error en método extractErrorMessage {}",e.getMessage());
        }

        return null;
    }
}

