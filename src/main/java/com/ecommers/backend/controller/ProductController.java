package com.ecommers.backend.controller;

import com.ecommers.backend.dto.GenericResponse;
import com.ecommers.backend.entity.Product;
import com.ecommers.backend.repository.ProductRepository;
import com.ecommers.backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/v1/services/product")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add-product")
    ResponseEntity<GenericResponse> saveProduct(@Valid @RequestBody Product product) {
        GenericResponse genericResponse = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }
}
