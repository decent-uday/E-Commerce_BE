package com.ecommers.backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Data
public class CategoryDto {

    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    ObjectId id;

    @NotBlank(message = "CategoryName should not be null!!!")
    String categoryName;

    String categoryDescription;
}
