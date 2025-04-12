package com.ecommers.backend.service.impl;

import com.ecommers.backend.dto.CategoryDto;
import com.ecommers.backend.entity.Category;
import com.ecommers.backend.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    public Category findCategoryByName(String name) {
        return null;
    }

    public void saveCategory(CategoryDto Category) {

    }

    public Category updateCategory(CategoryDto CategoryDto) {
        return null;
    }

    public void removeCategory(String name) {

    }
}
