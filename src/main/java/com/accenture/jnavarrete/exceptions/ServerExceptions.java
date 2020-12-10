package com.accenture.jnavarrete.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerExceptions extends RuntimeException {
    private static final Logger LOG = LoggerFactory.getLogger(ServerExceptions.class);

    public ServerExceptions(Exception e) {
        super(e.getMessage());
        LOG.error(e.getMessage(), e);
    }
}
