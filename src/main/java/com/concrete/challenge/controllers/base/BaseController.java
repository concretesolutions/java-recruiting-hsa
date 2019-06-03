package com.concrete.challenge.controllers.base;

import org.springframework.http.HttpHeaders;

public interface BaseController {

    default HttpHeaders getResponseHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        responseHeaders.set("Access-Control-Allow-Credentials", "true");
        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        responseHeaders.set("Access-Control-Max-Age", "1209600");
        return responseHeaders;
    }
}