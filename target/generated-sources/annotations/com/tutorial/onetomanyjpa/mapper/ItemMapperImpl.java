package com.tutorial.onetomanyjpa.mapper;

import com.tutorial.onetomanyjpa.dto.ItemDto;
import com.tutorial.onetomanyjpa.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-16T22:01:20+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDto itemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setId( item.getId() );
        itemDto.setSerialNumber( item.getSerialNumber() );

        return itemDto;
    }

    @Override
    public Item itemDtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( itemDto.getId() );
        item.setSerialNumber( itemDto.getSerialNumber() );

        return item;
    }

    @Override
    public List<ItemDto> itemListToItemDtoList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( items.size() );
        for ( Item item : items ) {
            list.add( itemToItemDto( item ) );
        }

        return list;
    }

    @Override
    public List<Item> itemListDtoToItemList(List<ItemDto> items) {
        if ( items == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( items.size() );
        for ( ItemDto itemDto : items ) {
            list.add( itemDtoToItem( itemDto ) );
        }

        return list;
    }
}
