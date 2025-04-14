package com.ecommers.backend.entity;

import com.ecommers.backend.dto.ObjectIdSerializer;
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
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;

@Setter
@Getter
@Data
@Component
@Document(collection = "product")
public class Product {

    @JsonSerialize(using = ObjectIdSerializer.class)
    @Id
    ObjectId id;

    @NotBlank(message = "name should not be null for product!!!")
    @Indexed(name = "name")
    String name;

    String description;

    @NotNull(message = "Price should be mentioned for Product!!")
    Integer price;

    Integer quantityInStock;

    String createdAt;

    @JsonSerialize(using = ObjectIdSerializer.class)
    @NotBlank(message = "Every Product should belong to some Category. Provide categoryId")
    String categoryId;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;

}
