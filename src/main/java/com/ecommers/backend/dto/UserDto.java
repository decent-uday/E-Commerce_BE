package com.ecommers.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

public class UserDto {
    ObjectId id;

    @NotBlank(message = "User Namew should not be null")
    String name;

    String email;

    @NotEmpty(message = "User-Role should be mentioned!!!")
    String role;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;
}
