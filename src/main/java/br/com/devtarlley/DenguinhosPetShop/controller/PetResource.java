package br.com.devtarlley.DenguinhosPetShop.controller;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.dto.PetDto;
import br.com.devtarlley.DenguinhosPetShop.dto.PetNewDto;
import br.com.devtarlley.DenguinhosPetShop.services.PetService;
import br.com.devtarlley.DenguinhosPetShop.services.impl.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pets")
public class PetResource {

    @Autowired
    private PetService service;

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<PetDto>> findAll(){

        List<Pet> list = service.findAll();
        List<PetDto> listDto = list.stream().map(PetDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody PetNewDto objDto){
        Pet obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody PetNewDto objDto, @PathVariable Integer id){
        Pet obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
