package com.duoc.suscripciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StreamflowServicioSuscripcionesApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamflowServicioSuscripcionesApplication.class, args);
	}
}