package com.ecommers.backend.controller;

import com.ecommers.backend.dto.GenericResponse;
import com.ecommers.backend.dto.ProductDto;
import com.ecommers.backend.entity.Product;
import com.ecommers.backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/v1/services/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add-product")
    ResponseEntity<GenericResponse> saveProduct(@Valid @RequestBody Product product) {
        GenericResponse genericResponse = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping("/{name}")
    ResponseEntity<GenericResponse> retrieveProduct(@PathVariable("name") String name) {
        GenericResponse genericResponse = productService.findProductByName(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @PutMapping("/update-product")
    ResponseEntity<GenericResponse> updateProduct(@Valid @RequestBody ProductDto product) {
        GenericResponse genericResponse = productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @DeleteMapping("/remove/{name}")
    ResponseEntity<GenericResponse> deleteProduct(@PathVariable("name") String name) {
        GenericResponse genericResponse = productService.removeProduct(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }
}
