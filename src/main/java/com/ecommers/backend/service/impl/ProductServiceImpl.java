package com.ecommers.backend.service.impl;

import com.ecommers.backend.dto.GenericResponse;
import com.ecommers.backend.dto.ProductDto;
import com.ecommers.backend.entity.Product;
import com.ecommers.backend.repository.ProductRepository;
import com.ecommers.backend.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public GenericResponse findProductByName(String name) {
        Product product = productRepository.getByName(name);
        GenericResponse genericResponse = new GenericResponse();
        if (product != null) {
            genericResponse.setData(product);
            genericResponse.setStatus(HttpStatus.OK.toString());
        }
        else {
            genericResponse.setStatus(HttpStatus.NOT_FOUND.toString());
            genericResponse.setMessage("Cannot find the Product with name " + name);
        }
        return genericResponse;
    }

    public GenericResponse saveProduct(Product product) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            productRepository.save(product);
            genericResponse.setMessage("Product Created with name " + product.getName());
            return genericResponse;
        } catch (Exception ex) {
            genericResponse.setMessage("Couldn't save product!!!");
            genericResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.toString());
            log.info("Exception in saveProduct : " + ex.getMessage());
            ex.printStackTrace();
        }
        return genericResponse;
    }

    public GenericResponse updateProduct(ProductDto productDto) {
        GenericResponse genericResponse = new GenericResponse();
        if (productRepository.existsById(productDto.getId())) {
            ObjectMapper objectMapper = new ObjectMapper();
            Product product = objectMapper.convertValue(productDto, Product.class);
            productRepository.save(product);
            genericResponse.setStatus(HttpStatus.OK.toString());
            genericResponse.setMessage("Product is Updated Successfully");
        } else {
            genericResponse.setStatus(HttpStatus.NOT_FOUND.toString());
            genericResponse.setMessage("No product found");
        }
        return genericResponse;
    }

    public GenericResponse removeProduct(String name) {
        GenericResponse genericResponse = new GenericResponse();
        Product product = productRepository.getByName(name);
        if (product != null) {
            productRepository.delete(product);
            genericResponse.setMessage("Deleted the Product with name " + name);
            genericResponse.setStatus(HttpStatus.OK.toString());
        } else {
            genericResponse.setMessage("Cannot delete the product!!");
            genericResponse.setStatus(HttpStatus.NOT_FOUND.toString());
        }
        return genericResponse;
    }
}
