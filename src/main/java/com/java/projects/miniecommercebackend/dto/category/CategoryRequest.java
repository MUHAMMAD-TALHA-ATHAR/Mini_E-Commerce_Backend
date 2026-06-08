package com.java.projects.miniecommercebackend.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryRequest {

    @NotBlank(message = "Category name is required")
    @Size(max = 100, message = "Category name cannot exceed {max} characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed {max} characters")
    private String description;

    private String imageUrl;


}
