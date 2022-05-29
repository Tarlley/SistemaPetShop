package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetDto;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetNewDto;

import java.util.List;

public interface PetService {
    Pet find(Integer id);

    List<Pet> findAll();

    Pet fromDto(PetDto objDto);

    Pet fromDto(PetNewDto objDto);

    Pet update(Pet obj);

    Pet insert(Pet obj);

    void updateData(Pet newObj, Pet obj);

    void delete(Integer id);
}
