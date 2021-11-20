package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.dto.PetDto;
import br.com.devtarlley.DenguinhosPetShop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet find(Integer id){

        Optional<Pet> object = petRepository.findById(id);
        return object.orElse(null);
    }

    public List<Pet> findAll(){
        return petRepository.findAll();
    }

    public Pet fromDto(PetDto objDto){
        return new Pet(objDto.getId(),objDto.getNome(),objDto.getNascimento(),null,null);
    }

    public Pet update(Pet obj){
        find(obj.getId());
        return petRepository.save(obj);
    }
}
