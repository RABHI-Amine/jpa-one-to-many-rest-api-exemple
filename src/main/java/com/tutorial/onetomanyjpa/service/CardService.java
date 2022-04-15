package com.tutorial.onetomanyjpa.service;


import com.tutorial.onetomanyjpa.entity.Card;
import com.tutorial.onetomanyjpa.entity.Item;

import java.util.List;

public interface CardService {
    Card addCard(Card card);
    List<Card> getCards();
    Card getCard(Long id);
    Card updateCard(Long id,Card card);
    Card deleteCard(Long id);
    Card addItemToCard(Long cardId,Long itemId);
    Card removeItemFromCard(Long cardId,Long itemId);
}
