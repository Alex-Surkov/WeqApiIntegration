package com.github.alexsurkov.weqapiintegration.dto;

public record CatDto(Long id,
                     String name,
                     String breed,
                     Integer age) {
}
