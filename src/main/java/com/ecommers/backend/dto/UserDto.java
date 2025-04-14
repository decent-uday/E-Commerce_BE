package com.ecommers.backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@Data
public class UserDto {

    @JsonSerialize(using = ObjectIdSerializer.class)
    ObjectId id;

    @NotBlank(message = "User Name should not be null")
    String name;

    String email;

    @NotEmpty(message = "User-Role should be mentioned!!!")
    String role;

    @CreatedDate
    Date dateCreated;

    @LastModifiedDate
    Date dateUpdated;
}
