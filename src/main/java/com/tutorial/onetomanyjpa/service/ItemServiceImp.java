package com.tutorial.onetomanyjpa.service;

import com.tutorial.onetomanyjpa.entity.Item;
import com.tutorial.onetomanyjpa.exception.ItemNotFoundException;
import com.tutorial.onetomanyjpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item add(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("could not find an item with id: "+ id)
        );
    }

    @Override
    public Item deleteItem(Long id) {
        Item item = getItem(id);
        itemRepository.delete(item);
        return item;
    }

    public Item updateItem(Long id,Item item){
        Item itemToUpdate = getItem(id);
        itemToUpdate.setSerialNumber(item.getSerialNumber());
        return itemToUpdate;
    }


}
