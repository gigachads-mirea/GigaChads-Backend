package ru.gigachads.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * Описание класса
 */
@Configuration
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "Security-management", paramName = "Authorization",
    in = SecuritySchemeIn.HEADER, bearerFormat = "JWT")
@OpenAPIDefinition(info = @Info(title = "GigaChadsServiceAPI",
    description = "Service for managing online games servers", version = "v1"),
    security = {@SecurityRequirement(name = "Security-management")})
public class SwaggerConfig {

}
