package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.repository.CategoriaRepository;
import br.com.devtarlley.DenguinhosPetShop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public Pet find(Integer id){

        Optional<Pet> object = repository.findById(id);
        return object.orElse(null);
    }

    public List<Pet> findAll(){
        List<Pet> object = repository.findAll();
        return object;
    }
}
