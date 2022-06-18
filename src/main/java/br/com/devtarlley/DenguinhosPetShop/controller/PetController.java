package br.com.devtarlley.DenguinhosPetShop.controller;

import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetDto;
import br.com.devtarlley.DenguinhosPetShop.services.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/pets")
@Api(value = "API REST Pet")
@CrossOrigin(origins = "*")
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um Pet pelo id informado pelo usuario")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return service.find(id);
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de Pet ")
    public ResponseEntity<?> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ApiOperation(value = "Salva um novo Pet")
    public ResponseEntity<Void> salvarPet(@Valid @RequestBody PetDto petDto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(service.salvarPet(petDto).getBody()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Deleta um Pet pelo Id informado")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
