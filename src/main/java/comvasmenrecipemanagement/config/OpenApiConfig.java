package comvasmenrecipemanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "VIRTUAL MASTER CHEF ILIS",
        version = "1.0.0",
        description = "SISTEMA DE REGISTRO DE RECETAS Y VALORACIONES"
    )
)
public class OpenApiConfig {

}
