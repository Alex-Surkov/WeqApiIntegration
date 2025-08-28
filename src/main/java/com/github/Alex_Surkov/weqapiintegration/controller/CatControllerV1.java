package com.github.Alex_Surkov.weqapiintegration.controller;

import com.github.Alex_Surkov.weqapiintegration.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cats")
public class CatControllerV1 {

    private final CatService catService;

    @GetMapping
    public ResponseEntity<?> getCats() {
        return ResponseEntity.ok(catService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCatById(@PathVariable long id) {
        return ResponseEntity.ok(catService.getCatById(id));
    }

}
