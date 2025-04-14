package com.ecommers.backend.entity;

import com.ecommers.backend.dto.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;

@Setter
@Getter
@Data
@Component
@Document(collection = "Category")
public class Category {

    @JsonSerialize(using = ObjectIdSerializer.class)
    @Id
    ObjectId id;

    String categoryName;

    String categoryDescription;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;

}
