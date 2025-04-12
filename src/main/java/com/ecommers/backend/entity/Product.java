package com.ecommers.backend.entity;

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

    @Id
    ObjectId id;

    @Indexed(name = "name")
    String name;

    String description;

    Integer price;

    Integer quantityInStock;

    String createdAt;

    ObjectId categoryId;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;

}
