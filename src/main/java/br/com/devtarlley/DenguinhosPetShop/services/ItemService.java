package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Item;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.ItemDto;

import java.util.List;

public interface ItemService {
    Item find(Integer id);

    List<Item> findAll();

    Item fromDto(ItemDto objDto);

    Item update(Item obj);

    void updateData(Item newObj, Item obj);
}
