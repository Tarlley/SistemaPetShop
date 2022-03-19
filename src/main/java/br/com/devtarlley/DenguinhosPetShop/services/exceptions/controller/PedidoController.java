package br.com.devtarlley.DenguinhosPetShop.services.exceptions.controller;


import br.com.devtarlley.DenguinhosPetShop.domains.Pedido;
import br.com.devtarlley.DenguinhosPetShop.services.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {


    @Autowired
    private PedidoServiceImpl service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        Pedido object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<Pedido> object = service.findAll();
        return ResponseEntity.ok().body(object);
    }
}
