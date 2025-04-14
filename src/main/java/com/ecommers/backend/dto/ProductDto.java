package com.ecommers.backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Setter
@Getter
@Data
public class ProductDto {

    @JsonSerialize(using = ObjectIdSerializer.class)
    @Id
    ObjectId id;

    @NotBlank(message = "Name of the product should not be null")
    String name;

    String description;

    @NotNull(message = "Define the price of product!!!")
    Integer price;

    Integer quantityInStock;

    String createdAt;

    @JsonSerialize(using = ObjectIdSerializer.class)
    ObjectId categoryId;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;

}
