package br.com.desnecesauron.javaunittestscourse.person.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Person API").version("1.0.0").description(
                                                    "Person API implemented with Spring Boot RESTful service and " +
                                                            "documented using springdoc-openapi and OpenAPI 3.0.3.")
                                            .termsOfService("https://swagger.io/terms/")
                                            .license(new License().name("Apache 2.0")));

    }

}
