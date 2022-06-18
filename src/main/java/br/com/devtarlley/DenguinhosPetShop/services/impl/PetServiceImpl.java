package br.com.devtarlley.DenguinhosPetShop.services.impl;

import br.com.devtarlley.DenguinhosPetShop.domains.*;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetDto;
import br.com.devtarlley.DenguinhosPetShop.mapper.PetMapper;
import br.com.devtarlley.DenguinhosPetShop.repository.*;
import br.com.devtarlley.DenguinhosPetShop.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetMapper petMapper;
    private final PetRepository petRepository;

    private final CidadeRepository cidadeRepository;

    private final EnderecoRepository enderecoRepository;

    private final EspecieRepository especieRepository;

    public PetServiceImpl(PetMapper petMapper, PetRepository petRepository, CidadeRepository cidadeRepository, EnderecoRepository enderecoRepository, EspecieRepository especieRepository) {
        this.petMapper = petMapper;
        this.petRepository = petRepository;
        this.cidadeRepository = cidadeRepository;
        this.enderecoRepository = enderecoRepository;
        this.especieRepository = especieRepository;
    }

    @Override
    public ResponseEntity<?> find(Integer id) {

        Optional<Pet> object = petRepository.findById(id);

        if(object.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado. Id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(object.orElse(null));
    }

    @Override
    public ResponseEntity<List<Pet>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(petRepository.findAll());
    }

    @Transactional
    @Override
    public ResponseEntity<?> salvarPet(PetDto petDto) {
        Pet pet;
        try{
          pet = petRepository.saveAndFlush(petMapper.toEntity(petDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível salvar o Pet");
        }
//            enderecoRepository.save(obj.getEnderecoEntrega());

    return ResponseEntity.status(HttpStatus.OK).body(pet.getId());
    }

    @Override
    public void delete(Integer id){
        find(id);
     petRepository.deleteById(id);
    }

}
