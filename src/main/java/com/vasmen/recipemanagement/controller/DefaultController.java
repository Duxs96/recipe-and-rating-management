package com.vasmen.recipemanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.io.IOException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
@Tag(name="Redirigir a Swagger por defecto")
public class DefaultController {

    @GetMapping()
    public void redirectToSwagger(HttpServletResponse response) throws IOException, java.io.IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }
}
