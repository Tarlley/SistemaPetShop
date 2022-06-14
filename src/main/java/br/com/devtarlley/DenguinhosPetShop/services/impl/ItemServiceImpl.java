package br.com.devtarlley.DenguinhosPetShop.services.impl;

import br.com.devtarlley.DenguinhosPetShop.domains.Item;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.ItemDto;
import br.com.devtarlley.DenguinhosPetShop.repository.ItemRepository;
import br.com.devtarlley.DenguinhosPetShop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item find (Integer id){

        Optional<Item> object = itemRepository.findById(id);
        return object.orElse(null);
    }

    @Override
    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    @Override
    public Item fromDto(ItemDto objDto){
        return new Item(objDto.getId(),objDto.getNome(),objDto.getPreco());
    }

    @Override
    public Item update(Item obj){
        Item newObj =  find(obj.getId());
        updateData(newObj,obj);
        return itemRepository.save(newObj);
    }

    @Override
    public void updateData(Item newObj, Item obj) {

        newObj.setNome(obj.getNome());
        newObj.setPreco(obj.getPreco());
    }
}
