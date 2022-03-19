package br.com.devtarlley.DenguinhosPetShop.services.exceptions.controller;


import br.com.devtarlley.DenguinhosPetShop.domains.Item;
import br.com.devtarlley.DenguinhosPetShop.dto.ItemDto;
import br.com.devtarlley.DenguinhosPetShop.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/itens")
public class ItemController {


    @Autowired
    private ItemServiceImpl service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        Item object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<Item> list = service.findAll();
        List<ItemDto> listDto = list.stream().map(ItemDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ItemDto objDto, @PathVariable Integer id){
        Item obj = service.fromDto(objDto);
        obj.setId(id);
        service.update(obj);

        return ResponseEntity.noContent().build();
    }
}
