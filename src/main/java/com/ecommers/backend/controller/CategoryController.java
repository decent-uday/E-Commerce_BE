package com.ecommers.backend.controller;

import com.ecommers.backend.dto.GenericResponse;
import com.ecommers.backend.dto.CategoryDto;
import com.ecommers.backend.entity.Category;
import com.ecommers.backend.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/v1/services/category")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add-category")
    ResponseEntity<GenericResponse> saveCategory(@Valid @RequestBody Category Category) {
        GenericResponse genericResponse = categoryService.saveCategory(Category);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @PostMapping("/{name}")
    ResponseEntity<GenericResponse> retrieveCategory(@PathVariable("name") String name) {
        GenericResponse genericResponse = categoryService.findCategoryByName(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @PostMapping("/update-category")
    ResponseEntity<GenericResponse> updateCategory(@Valid @RequestBody CategoryDto Category) {
        GenericResponse genericResponse = categoryService.updateCategory(Category);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @PostMapping("/remove/{name}")
    ResponseEntity<GenericResponse> deleteCategory(@PathVariable("name") String name) {
        GenericResponse genericResponse = categoryService.removeCategory(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }
}
