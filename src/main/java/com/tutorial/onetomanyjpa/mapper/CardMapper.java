package com.tutorial.onetomanyjpa.mapper;

import com.tutorial.onetomanyjpa.dto.CardDto;
import com.tutorial.onetomanyjpa.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardDto cardToCardDto(Card card);
    Card cardDtoToCard(CardDto cardDto);
    List<CardDto> cardListToCardDtoList(List<Card> items);
    List<Card> cardListDtoToCardList(List<CardDto> items);
}
