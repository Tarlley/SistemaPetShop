package br.com.devtarlley.DenguinhosPetShop.services.impl;

import br.com.devtarlley.DenguinhosPetShop.domains.Pedido;
import br.com.devtarlley.DenguinhosPetShop.repository.PedidoRepository;
import br.com.devtarlley.DenguinhosPetShop.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl  implements PedidoService {


    @Autowired
    private PedidoRepository PedidoRepository;

    @Override
    public Pedido find (Integer id){

        Optional<Pedido> object = PedidoRepository.findById(id);
        return object.orElse(null);
    }

    @Override
    public List<Pedido> findAll(){
        return PedidoRepository.findAll();
    }


}
