package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Proprietario find(Integer id){

        Optional<Proprietario> object = proprietarioRepository.findById(id);

        return object.orElse(null);
    }

    public List<Proprietario> findAll(){
        return proprietarioRepository.findAll();
    }
}
