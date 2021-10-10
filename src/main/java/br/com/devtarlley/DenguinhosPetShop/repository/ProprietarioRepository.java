package br.com.devtarlley.DenguinhosPetShop.repository;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario,Integer> {

}
