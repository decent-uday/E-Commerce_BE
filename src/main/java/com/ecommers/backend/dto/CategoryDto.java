package com.ecommers.backend.dto;

import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;

public class CategoryDto {

    ObjectId id;

    @NotBlank(message = "CategoryName should not be null!!!")
    String categoryName;

    String categoryDescription;
}
