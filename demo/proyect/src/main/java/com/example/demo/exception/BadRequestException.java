package com.example.demo.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String str) {

        super(str);
    }

    @Override
    public String toString() {
        return  getMessage();
    }
}
