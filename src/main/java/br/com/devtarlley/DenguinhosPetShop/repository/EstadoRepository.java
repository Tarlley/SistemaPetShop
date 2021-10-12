package br.com.devtarlley.DenguinhosPetShop.repository;

import br.com.devtarlley.DenguinhosPetShop.domains.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {

}
