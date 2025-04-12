package com.ecommers.backend.service;

import com.ecommers.backend.dto.GenericResponse;
import com.ecommers.backend.dto.ProductDto;
import com.ecommers.backend.entity.Product;
import org.bson.types.ObjectId;

public interface ProductService {
    GenericResponse findProductByName(String name);

    GenericResponse saveProduct(Product product);

    GenericResponse updateProduct(ProductDto productDto);

    GenericResponse removeProduct(String name);
}
