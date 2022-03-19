package br.com.devtarlley.DenguinhosPetShop.services.impl;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.dto.ProprietarioDto;
import br.com.devtarlley.DenguinhosPetShop.dto.ProprietarioNewDto;
import br.com.devtarlley.DenguinhosPetShop.repository.ProprietarioRepository;
import br.com.devtarlley.DenguinhosPetShop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioServiceImpl {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Proprietario find(Integer id){

        Optional<Proprietario> object = proprietarioRepository.findById(id);

        if(object.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado! id: " + id);
        }
        return object.orElse(null);
    }

    public List<Proprietario> findAll(){
        return proprietarioRepository.findAll();
    }


    public Proprietario update(Proprietario obj){
        find(obj.getId());
        return proprietarioRepository.save(obj);
    }

    public Proprietario insert(Proprietario obj) {
        obj.setId(null);
        return proprietarioRepository.save(obj);
    }

    public Proprietario fromDto(ProprietarioDto objDto){
        return new Proprietario(objDto.getId(), objDto.getNome(), objDto.getEmail());
    }

    public Proprietario fromDto(ProprietarioNewDto objDto){

        return new Proprietario(objDto.getId(),objDto.getCPF(),objDto.getNome(), objDto.getEmail());
    }

    public void delete(Integer id){
        find(id);
        proprietarioRepository.deleteById(id);
    }
}
