package com.tutorial.onetomanyjpa.mapper;

import com.tutorial.onetomanyjpa.dto.ItemDto;
import com.tutorial.onetomanyjpa.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto itemToItemDto(Item item);
    Item itemDtoToItem(ItemDto itemDto);
    List<ItemDto> itemListToItemDtoList(List<Item> items);
    List<Item> itemListDtoToItemList(List<ItemDto> items);
}
