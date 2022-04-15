package com.tutorial.onetomanyjpa.service;

import com.tutorial.onetomanyjpa.entity.Item;

import java.util.List;

public interface ItemService {
     Item add(Item item);
     List<Item> getItems();
     Item getItem(Long id);
     Item deleteItem(Long id);
}
