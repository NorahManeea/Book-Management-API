package com.example.BookManagementAPI.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Book Management API")
                        .description("The Book Management API is a RESTful web service built using Spring Boot to manage a collection of books. It provides endpoints for performing CRUD (Create, Read, Update, Delete) operations on books.")
                );
    }
}
