package com.uaga.checklist.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Checklist Alfandegário UAGA")
                        .description("Documentação da API para o checklist 8/18 alfandegário, com suporte para registro de inspeções, observações e evidências.")
                        .version("1.0")
                        .license(new License().name("UNLICENSED").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório do Projeto")
                        .url("https://github.com/seu-usuario/seu-repositorio")); // Atualize com o seu repositório
    }
}
