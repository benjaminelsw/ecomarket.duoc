package ecomarket.duoc.ecomarket.duoc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                  .info(new Info()
                    .title("API 2026 Ecomarket")
                    .version("1.0")
                    .description("Documentacion de API para el sistema Ecomarket"));
    }
}
