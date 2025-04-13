package com.ecommers.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@Data
public class CategoryDto {

    ObjectId id;

    @NotBlank(message = "CategoryName should not be null!!!")
    String categoryName;

    String categoryDescription;
}
