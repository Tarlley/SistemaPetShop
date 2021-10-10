package br.com.devtarlley.DenguinhosPetShop;

import br.com.devtarlley.DenguinhosPetShop.domains.Especie;
import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.domains.Raca;
import br.com.devtarlley.DenguinhosPetShop.repository.EspecieRepository;
import br.com.devtarlley.DenguinhosPetShop.repository.PetRepository;
import br.com.devtarlley.DenguinhosPetShop.repository.ProprietarioRepository;
import br.com.devtarlley.DenguinhosPetShop.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DenguinhosPetShopApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private EspecieRepository especieRepository;

	@Autowired
	private RacaRepository racaRepository;

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(DenguinhosPetShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Especie esp1 =  new Especie(null,"Cachorro");
		Especie esp2 = new Especie(null,"Gato");

		Pet pet1 = new Pet(null,"doghinho",sdf.parse("01/01/2010"),esp1);
		Pet pet2 = new Pet(null,"Gatinho",sdf.parse("10/10/2020"),esp2);

		Raca rac1 = new Raca(null,"pincher",esp1);
		Raca rac2 = new Raca(null,"persa",esp2);

		esp1.getRacas().addAll(List.of(rac1));
		esp2.getRacas().addAll(List.of(rac2));

		esp1.getPets().addAll(List.of(pet1));
		esp2.getPets().addAll(List.of(pet2));

		Proprietario prop1 = new Proprietario(null,"0123456789-10","Wendel Tarlley","wendel@wendel.com");
		Proprietario prop2 = new Proprietario(null,"0198765432-10","Samanta Rocha","samanta@samanta.com");

		prop1.getPets().addAll(List.of(pet1));
		prop2.getPets().addAll(List.of(pet2));

		pet1.getProprietarios().addAll(List.of(prop1));
		pet2.getProprietarios().addAll(List.of(prop2));


		petRepository.saveAll(Arrays.asList(pet1,pet2));
		especieRepository.saveAll(Arrays.asList(esp1,esp2));
		racaRepository.saveAll(Arrays.asList(rac1,rac2));
		proprietarioRepository.saveAll(Arrays.asList(prop1,prop2));
	}
}
