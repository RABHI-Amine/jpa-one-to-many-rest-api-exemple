package com.tutorial.onetomanyjpa.controller;

import com.tutorial.onetomanyjpa.dto.ItemDto;
import com.tutorial.onetomanyjpa.entity.Item;
import com.tutorial.onetomanyjpa.mapper.ItemMapper;
import com.tutorial.onetomanyjpa.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody final ItemDto itemDto){
        Item item = itemService.add(itemMapper.itemDtoToItem(itemDto));
        return new ResponseEntity<ItemDto>(itemMapper.itemToItemDto(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems(){
        List<Item> items = itemService.getItems();
        return new ResponseEntity<>(itemMapper.itemListToItemDtoList(items),HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable final long id){
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(itemMapper.itemToItemDto(item),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable final long id){
        Item item = itemService.deleteItem(id);
        return new ResponseEntity<>(itemMapper.itemToItemDto(item),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ItemDto>  editItem(@PathVariable final long id,
                                             @RequestBody final ItemDto itemDto
                                             ){
        Item item = itemService.updateItem(id,itemMapper.itemDtoToItem(itemDto));
        return new ResponseEntity<>(itemMapper.itemToItemDto(item),HttpStatus.OK);
    }

}
