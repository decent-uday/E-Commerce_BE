package com.ecommers.backend.service;

import com.ecommers.backend.dto.CategoryDto;
import com.ecommers.backend.dto.GenericResponse;
import com.ecommers.backend.entity.Category;

public interface CategoryService {

    GenericResponse findCategoryByName(String name);

    GenericResponse saveCategory(Category Category);

    GenericResponse updateCategory(CategoryDto CategoryDto);

    GenericResponse removeCategory(String name);
}
