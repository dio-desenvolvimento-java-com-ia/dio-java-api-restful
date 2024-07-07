package me.dio.diojavaapirestfull;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//* Solução do erro de CORS
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default server url")})
@SpringBootApplication
public class DioJavaApiRestfullApplication {

    public static void main(String[] args) {
        SpringApplication.run(DioJavaApiRestfullApplication.class, args);
    }

}
