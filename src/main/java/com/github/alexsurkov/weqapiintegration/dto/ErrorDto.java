package com.github.alexsurkov.weqapiintegration.dto;

import java.time.LocalDateTime;

public record ErrorDto(String message, String code, String path, LocalDateTime timestamp) {
    public ErrorDto(String message, String code, String path) {
        this(message, code, path, LocalDateTime.now());
    }
}
