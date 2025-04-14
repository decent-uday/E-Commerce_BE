package com.ecommers.backend.entity;

import com.ecommers.backend.dto.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Document(collation = "user")
public class User {

    @JsonSerialize(using = ObjectIdSerializer.class)
    @Id
    ObjectId id;

    @NotBlank(message = "Name should not be null!!")
    String name;

    @Email(message = "Give the correct email format!!!")
    String email;

    @NotNull(message = "Specify the role of User")
    String role;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;

}
