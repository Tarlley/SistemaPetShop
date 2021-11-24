package br.com.devtarlley.DenguinhosPetShop.resources;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.dto.ProprietarioDto;
import br.com.devtarlley.DenguinhosPetShop.services.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/proprietarios")
public class ProprietarioResource {

     @Autowired
     private ProprietarioService service;

     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
     public ResponseEntity<?> find(@PathVariable Integer id){

         Proprietario object = service.find(id);
         return ResponseEntity.ok().body(object);
     }

     @RequestMapping(method = RequestMethod.GET)
     public ResponseEntity<?> findAll(){
         List<Proprietario> list = service.findAll();
         List<ProprietarioDto> listDto = list.stream().map(ProprietarioDto::new)
                 .collect(Collectors.toList());
             return ResponseEntity.ok().body(listDto);

     }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ProprietarioDto objDto, @PathVariable Integer id){
        Proprietario obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }
}
