package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido find(Integer id);

    List<Pedido> findAll();
}
