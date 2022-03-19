package br.com.devtarlley.DenguinhosPetShop.services.impl;

import br.com.devtarlley.DenguinhosPetShop.domains.*;
import br.com.devtarlley.DenguinhosPetShop.dto.PetDto;
import br.com.devtarlley.DenguinhosPetShop.dto.PetNewDto;
import br.com.devtarlley.DenguinhosPetShop.repository.*;
import br.com.devtarlley.DenguinhosPetShop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceimpl {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EspecieRepository especieRepository;

    public Pet find(Integer id) {

        Optional<Pet> object = petRepository.findById(id);

        if(object.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado! id: " + id);
        }
        return object.orElse(null);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet fromDto(PetDto objDto) {
        return new Pet(objDto.getId(), objDto.getNome(), objDto.getNascimento());
    }

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


    public Pet update(Pet obj) {
        Pet newObj = find(obj.getId());
        updateData(newObj, obj);
        return petRepository.save(newObj);
    }

    public Pet insert(Pet obj) {
        obj.setId(null);
        obj = petRepository.save(obj);
//            enderecoRepository.save(obj.getEnderecoEntrega());

    return obj;
    }

    private void updateData(Pet newObj, Pet obj) {

        newObj.setNome(obj.getNome());
        newObj.setNascimento(obj.getNascimento());
    }


    public void delete(Integer id){
        find(id);
     petRepository.deleteById(id);
    }

}
