package br.com.devtarlley.DenguinhosPetShop;

import br.com.devtarlley.DenguinhosPetShop.domains.*;
import br.com.devtarlley.DenguinhosPetShop.domains.Enum.EstadoPagamento;
import br.com.devtarlley.DenguinhosPetShop.domains.Enum.Tipo;
import br.com.devtarlley.DenguinhosPetShop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DenguinhosPetShopApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(DenguinhosPetShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {




	}
}
