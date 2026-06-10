package org.example.dronelog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // TODO: deixar a documentação compatível com o tema da API.
        return new OpenAPI()
                .info(new Info()
                        .title(" Dronelog API")
                        .version("1.0")
                        .description(" API para gerenciamento de operações com drones em campo. Deve Permite cadastrar, " +
                                "listar, atualizar e deletar drones, alem de registrar os voos realizados " +
                                "por cada drone."));
    }
}
