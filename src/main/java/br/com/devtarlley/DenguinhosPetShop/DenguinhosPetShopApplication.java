package br.com.devtarlley.DenguinhosPetShop;

import br.com.devtarlley.DenguinhosPetShop.domains.*;
import br.com.devtarlley.DenguinhosPetShop.domains.Enum.Tipo;
import br.com.devtarlley.DenguinhosPetShop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
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

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DenguinhosPetShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Especie esp1 =  new Especie(null,"Cachorro");
		Especie esp2 = new Especie(null,"Gato");


		Estado est1 = new Estado(null,"São Paulo");
		Estado est2 = new Estado(null,"Minas Gerais");

		Cidade cid1 = new Cidade(null,"Belo horizonte",est2);
		Cidade cid2 = new Cidade(null,"São Paulo",est1);

		Endereco end1 = new Endereco(null,"rua 1","123321","Casa","Bairro B","30300-300",cid2);
		Endereco end2 = new Endereco(null,"rua 5","30","Apartamento","Bairro Grande","50050-555",cid1);

		Pet pet1 = new Pet(null,"doghinho",sdf.parse("01/01/2010"),esp1,end1);
		Pet pet2 = new Pet(null,"Gatinho",sdf.parse("10/10/2020"),esp2,end2);

		Raca rac1 = new Raca(null,"pincher",esp1);
		Raca rac2 = new Raca(null,"persa",esp2);

		Categoria cat1 = new Categoria(null,"Ração");
		Categoria cat2 = new Categoria(null,"Serviços");
		Categoria cat3 = new Categoria(null,"Medicamento");

		Item item1 = new Item(null,"Ração 1kg",15.00, Tipo.PRODUTO,cat1);
		Item item2 = new Item(null,"Dipirona",7.45,Tipo.PRODUTO,cat3);
		Item item3 = new Item(null,"Banho e tosa cão pequeno",25.00,Tipo.SERVICO,cat2);

		est1.getCidades().addAll(List.of(cid2));
		est2.getCidades().addAll(List.of(cid1));

		cid1.getEnderecos().addAll(List.of(end2));
		cid2.getEnderecos().addAll(List.of(end1));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2));

		end1.getPets().addAll(List.of(pet1));
		end2.getPets().addAll(List.of(pet2));

		esp1.getRacas().addAll(List.of(rac1));
		esp2.getRacas().addAll(List.of(rac2));

		esp1.getPets().addAll(List.of(pet1));
		esp2.getPets().addAll(List.of(pet2));

		Proprietario prop1 = new Proprietario(null,"0123456789-10","Wendel Tarlley","wendel@wendel.com");
		Proprietario prop2 = new Proprietario(null,"0198765432-10","Samanta Rocha","samanta@samanta.com");

		prop1.setTelefones(Collections.singleton("31999999999"));
		prop2.getTelefones().addAll(Arrays.asList("31988888888","31977777777"));
		prop1.getPets().addAll(List.of(pet1));
		prop2.getPets().addAll(List.of(pet2));

		pet1.getProprietarios().addAll(List.of(prop1));
		pet2.getProprietarios().addAll(List.of(prop2));





		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		petRepository.saveAll(Arrays.asList(pet1,pet2));
		especieRepository.saveAll(Arrays.asList(esp1,esp2));
		racaRepository.saveAll(Arrays.asList(rac1,rac2));
		proprietarioRepository.saveAll(Arrays.asList(prop1,prop2));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		itemRepository.saveAll(Arrays.asList(item1,item2,item3));

	}
}
