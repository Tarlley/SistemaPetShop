package br.com.devtarlley.DenguinhosPetShop.repository;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

}
