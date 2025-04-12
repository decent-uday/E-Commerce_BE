package com.ecommers.backend.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Category")
public class Category {

    @Id
    ObjectId id;

    String categoryName;

    String categoryDescription;
}
