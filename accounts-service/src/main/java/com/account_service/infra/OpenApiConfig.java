package com.account_service.infra;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Christian Silva",
                        email = "chrislcontrol@hotmail.com",
                        url = "https://github.com/chrislcontrol"
                ),
                description = "Api docs",
                title = "Accounts Microservice",
                version = "1.0",
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Localhost",
                        url = "http://localhost:8080"
                ),
        }
)
public class OpenApiConfig {
}