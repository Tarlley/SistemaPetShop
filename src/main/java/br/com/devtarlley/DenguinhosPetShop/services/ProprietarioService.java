package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.dto.ProprietarioDto;
import br.com.devtarlley.DenguinhosPetShop.dto.ProprietarioNewDto;

import java.util.List;

public interface ProprietarioService {
    Proprietario find(Integer id);

    List<Proprietario> findAll();

    Proprietario update(Proprietario obj);

    Proprietario insert(Proprietario obj);

    Proprietario fromDto(ProprietarioDto objDto);

    Proprietario fromDto(ProprietarioNewDto objDto);

    void delete(Integer id);
}
