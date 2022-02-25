package br.com.devtarlley.DenguinhosPetShop.services;

import br.com.devtarlley.DenguinhosPetShop.domains.Item;
import br.com.devtarlley.DenguinhosPetShop.dto.ItemDto;
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

    public Item fromDto(ItemDto objDto){
        return new Item(objDto.getId(),objDto.getNome(),objDto.getPreco());
    }

    public Item update(Item obj){
        Item newObj =  find(obj.getId());
        updateData(newObj,obj);
        return itemRepository.save(newObj);
    }

    private void updateData(Item newObj, Item obj) {

        newObj.setNome(obj.getNome());
        newObj.setPreco(obj.getPreco());
    }
}
