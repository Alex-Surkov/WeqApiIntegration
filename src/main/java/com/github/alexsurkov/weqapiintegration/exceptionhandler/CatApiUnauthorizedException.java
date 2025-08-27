package com.github.alexsurkov.weqapiintegration.exceptionhandler;

public class CatApiUnauthorizedException extends RuntimeException {
    public CatApiUnauthorizedException(String message, Throwable cause) {
        super(message);
    }
}
