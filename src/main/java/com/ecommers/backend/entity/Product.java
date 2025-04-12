package com.ecommers.backend.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Document(collection = "product")
public class Product {

    @Id
    ObjectId id;

    String name;

    String description;

    Integer price;

    Integer quantityInStock;

    String createdAt;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;

}
