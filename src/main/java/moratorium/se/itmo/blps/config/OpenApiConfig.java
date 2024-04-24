package moratorium.se.itmo.blps.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "ЛР №1 БЛПС",
                description = "Лабораторная работа №1 курса БЛПС ", version = "1.0.0",
                contact = @Contact(
                        name = "Киушкин Артем",
                        email = "kiushkin.artem.work@gmail.com"
                )
        )
)
@Configuration
public class OpenApiConfig {
}