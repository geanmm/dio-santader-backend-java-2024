package edu.alura.lab_animes_spring.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {

  @Bean
  OpenAPI customOpenAPI() {
    return new OpenAPI()
        // .components(new Components()
        // .addSecuritySchemes("bearer-key", new SecurityScheme()
        // .type(SecurityScheme.Type.HTTP)
        // .scheme("bearer")
        // .bearerFormat("JWT")))
        .info(new Info()
            .title("Animes Api")
            .description(
                "API REST com funcionalidades de CRUD em um site de Animes.")
            .contact(new Contact()
                .name("Gean Moura"))
            .license(new License()
                .name("Apache 2.0")
                .url("http://springdoc.org")));
  }
}
