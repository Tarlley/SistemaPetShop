package br.com.devtarlley.DenguinhosPetShop.repository;

import br.com.devtarlley.DenguinhosPetShop.domains.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie,Integer> {

}
