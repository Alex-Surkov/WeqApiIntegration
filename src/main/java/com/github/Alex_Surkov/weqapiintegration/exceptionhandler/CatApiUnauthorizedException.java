package com.github.Alex_Surkov.weqapiintegration.exceptionhandler;

public class CatApiUnauthorizedException extends RuntimeException {
    public CatApiUnauthorizedException(String message, Throwable cause) {
        super(message);
    }
}
