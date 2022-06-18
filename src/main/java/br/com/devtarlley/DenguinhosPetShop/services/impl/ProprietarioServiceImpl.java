package br.com.devtarlley.DenguinhosPetShop.services.impl;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.ProprietarioDto;
import br.com.devtarlley.DenguinhosPetShop.mapper.ProprietarioMapper;
import br.com.devtarlley.DenguinhosPetShop.repository.ProprietarioRepository;
import br.com.devtarlley.DenguinhosPetShop.services.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioServiceImpl implements ProprietarioService {
    private final ProprietarioMapper proprietarioMapper;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public ProprietarioServiceImpl(ProprietarioMapper proprietarioMapper) {
        this.proprietarioMapper = proprietarioMapper;
    }

    @Override
    public ResponseEntity<?> find(Integer id){
        Optional<Proprietario> object = proprietarioRepository.findById(id);

        if(object.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Objeto não encontrado! id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(object.orElse(null));
    }

    @Override
    public List<Proprietario> findAll(){
        return proprietarioRepository.findAll();
    }


    @Override
    public Proprietario update(Proprietario obj){
        find(obj.getId());
        return proprietarioRepository.save(obj);
    }

    @Override
    @Transactional
    public ResponseEntity<Integer> salvarProprietario(ProprietarioDto proprietarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proprietarioRepository.saveAndFlush(proprietarioMapper.toEntity(proprietarioDto)).getId());
    }

    @Override
    public void delete(Integer id){
        find(id);
        proprietarioRepository.deleteById(id);
    }
}
