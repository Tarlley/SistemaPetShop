package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Item;
import br.com.devtarlley.DenguinhosPetShop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    public Item find (Integer id){

        Optional<Item> object = itemRepository.findById(id);
        return object.orElse(null);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }


}
