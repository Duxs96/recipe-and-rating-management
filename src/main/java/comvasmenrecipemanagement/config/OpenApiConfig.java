package comvasmenrecipemanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Configurador de swagger",
        version = "1.0.0",
        description = "Descripción, Perro!"
    )
)
public class OpenApiConfig {

}
