package br.com.devtarlley.DenguinhosPetShop.services.impl;

import br.com.devtarlley.DenguinhosPetShop.domains.*;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetDto;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetNewDto;
import br.com.devtarlley.DenguinhosPetShop.repository.*;
import br.com.devtarlley.DenguinhosPetShop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EspecieRepository especieRepository;

    @Override
    public Pet find(Integer id) {

        Optional<Pet> object = petRepository.findById(id);

        if(object.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pet não encontrado. Id: " + id);
        }
        return object.orElse(null);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet fromDto(PetDto objDto) {
        return new Pet(objDto.getId(), objDto.getNome(), objDto.getNascimento());
    }

    @Override
    public Pet fromDto(PetNewDto objDto) {
     //   Especie especie = especieRepository.getById(objDto.getEspecie());

        Pet pet = new Pet(objDto.getId(), objDto.getNome(), objDto.getNascimento());
        Cidade cidade = cidadeRepository.getById(objDto.getCidadeId());
        Endereco endereco = new Endereco(null, objDto.getLogradouro(),
                objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(),
                objDto.getCep(), cidade);

        enderecoRepository.saveAll(List.of(endereco));

        pet.setEnderecoEntrega(endereco);
      //  pet.setEspecie_pet(especie);
        return pet;
    }


    @Override
    public Pet update(Pet obj) {
        Pet newObj = find(obj.getId());
        updateData(newObj, obj);
        return petRepository.save(newObj);
    }

    @Override
    public Pet insert(Pet obj) {
        obj.setId(null);
        obj = petRepository.save(obj);
//            enderecoRepository.save(obj.getEnderecoEntrega());

    return obj;
    }

    @Override
    public void updateData(Pet newObj, Pet obj) {

        newObj.setNome(obj.getNome());
        newObj.setNascimento(obj.getNascimento());
    }

    @Override
    public void delete(Integer id){
        find(id);
     petRepository.deleteById(id);
    }

}
