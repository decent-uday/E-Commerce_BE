package com.ecommers.backend.service;

import com.ecommers.backend.dto.CategoryDto;
import com.ecommers.backend.entity.Category;

public interface CategoryService {

    Category findCategoryByName(String name);

    void saveCategory(CategoryDto Category);

    Category updateCategory(CategoryDto CategoryDto);

    void removeCategory(String name);
}
