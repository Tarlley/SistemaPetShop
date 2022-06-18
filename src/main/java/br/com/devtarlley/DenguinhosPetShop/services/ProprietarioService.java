package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.ProprietarioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProprietarioService {
    ResponseEntity<?> find(Integer id);

    List<Proprietario> findAll();

    Proprietario update(Proprietario obj);

    ResponseEntity<Integer> salvarProprietario(ProprietarioDto proprietarioDto);

    void delete(Integer id);
}
