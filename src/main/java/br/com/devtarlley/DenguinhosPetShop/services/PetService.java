package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PetService {
    ResponseEntity<?> find(Integer id);

    ResponseEntity<List<Pet>> findAll();

    ResponseEntity<?> salvarPet(PetDto petDto);

    void delete(Integer id);
}
