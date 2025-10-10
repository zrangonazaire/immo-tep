package com.gestimo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Immotep API", version = "1.0", description = "API for Immotep application", contact = @Contact(name = "Support Team", email = "support@immotep.com")))
@EnableAsync
@EnableScheduling
public class GestimoBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestimoBackendApplication.class, args);
    }

    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Application started successfully!");
        };
    }
}