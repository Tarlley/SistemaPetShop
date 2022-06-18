package br.com.devtarlley.DenguinhosPetShop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DenguinhosPetShopApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(DenguinhosPetShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
