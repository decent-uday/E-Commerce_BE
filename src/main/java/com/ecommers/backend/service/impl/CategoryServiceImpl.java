package com.ecommers.backend.service.impl;

import com.ecommers.backend.dto.CategoryDto;
import com.ecommers.backend.dto.GenericResponse;
import com.ecommers.backend.entity.Category;
import com.ecommers.backend.repository.CategoryRepository;
import com.ecommers.backend.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public GenericResponse findCategoryByName(String name) {
        Category category = categoryRepository.getByCategoryName(name);
        GenericResponse genericResponse = new GenericResponse();
        if (category != null) {
            genericResponse.setData(category);
            genericResponse.setStatus(HttpStatus.OK.toString());
        }
        else {
            genericResponse.setStatus(HttpStatus.NOT_FOUND.toString());
            genericResponse.setMessage("Cannot find the category with name " + name);
        }
        return genericResponse;
    }

    public GenericResponse saveCategory(Category category) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            categoryRepository.save(category);
            genericResponse.setMessage("Category Created with name " + category.getCategoryName());
            genericResponse.setStatus(HttpStatus.CREATED.toString());
            return genericResponse;
        } catch (Exception ex) {
            genericResponse.setMessage("Couldn't save product!!!");
            genericResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.toString());
            log.info("Exception in saveCategory : " + ex.getMessage());
            ex.printStackTrace();
        }
        return genericResponse;

    }

    public GenericResponse updateCategory(CategoryDto categoryDto) {
        GenericResponse genericResponse = new GenericResponse();
        if(categoryDto.getId() == null) {
            genericResponse.setMessage("Please make sure that category id is present!!!");
            genericResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.toString());
            return genericResponse;
        }
        if (categoryRepository.existsById(categoryDto.getId())) {
            ObjectMapper objectMapper = new ObjectMapper();
            Category category = objectMapper.convertValue(categoryDto, Category.class);
            categoryRepository.save(category);
            genericResponse.setStatus(HttpStatus.OK.toString());
            genericResponse.setMessage("Category is Updated Successfully");
        } else {
            genericResponse.setStatus(HttpStatus.NOT_FOUND.toString());
            genericResponse.setMessage("No category found");
        }
        return genericResponse;
    }

    public GenericResponse removeCategory(String name) {
        GenericResponse genericResponse = new GenericResponse();
        Category category = categoryRepository.getByCategoryName(name);
        if (category != null) {
            categoryRepository.delete(category);
            genericResponse.setMessage("Deleted the Product with name " + name);
            genericResponse.setStatus(HttpStatus.OK.toString());
        } else {
            genericResponse.setMessage("Cannot delete the product!!");
            genericResponse.setStatus(HttpStatus.NOT_FOUND.toString());
        }
        return genericResponse;
    }
}
