package com.tutorial.onetomanyjpa.mapper;

import com.tutorial.onetomanyjpa.dto.CardDto;
import com.tutorial.onetomanyjpa.entity.Card;
import com.tutorial.onetomanyjpa.entity.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-16T22:01:20+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CardMapperImpl implements CardMapper {

    @Override
    public CardDto cardToCardDto(Card card) {
        if ( card == null ) {
            return null;
        }

        CardDto cardDto = new CardDto();

        cardDto.setId( card.getId() );
        cardDto.setName( card.getName() );
        Collection<Item> collection = card.getItems();
        if ( collection != null ) {
            cardDto.setItems( new ArrayList<Item>( collection ) );
        }

        return cardDto;
    }

    @Override
    public Card cardDtoToCard(CardDto cardDto) {
        if ( cardDto == null ) {
            return null;
        }

        Card card = new Card();

        card.setId( cardDto.getId() );
        card.setName( cardDto.getName() );
        List<Item> list = cardDto.getItems();
        if ( list != null ) {
            card.setItems( new ArrayList<Item>( list ) );
        }

        return card;
    }

    @Override
    public List<CardDto> cardListToCardDtoList(List<Card> items) {
        if ( items == null ) {
            return null;
        }

        List<CardDto> list = new ArrayList<CardDto>( items.size() );
        for ( Card card : items ) {
            list.add( cardToCardDto( card ) );
        }

        return list;
    }

    @Override
    public List<Card> cardListDtoToCardList(List<CardDto> items) {
        if ( items == null ) {
            return null;
        }

        List<Card> list = new ArrayList<Card>( items.size() );
        for ( CardDto cardDto : items ) {
            list.add( cardDtoToCard( cardDto ) );
        }

        return list;
    }
}
