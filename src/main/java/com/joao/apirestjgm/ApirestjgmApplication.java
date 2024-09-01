package com.joao.apirestjgm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API REST JGM", version = "1",
		description = "API RESTful para cadastro de clientes."))
@EnableScheduling
public class ApirestjgmApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApirestjgmApplication.class, args);
	}

}
