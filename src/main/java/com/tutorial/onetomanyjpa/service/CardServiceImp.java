package com.tutorial.onetomanyjpa.service;

import com.tutorial.onetomanyjpa.entity.Card;
import com.tutorial.onetomanyjpa.entity.Item;
import com.tutorial.onetomanyjpa.exception.CardNotFoundException;
import com.tutorial.onetomanyjpa.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImp implements CardService {
    private final CardRepository cardRepository;
    private final ItemService itemService;

    public CardServiceImp(CardRepository cardRepository, ItemService itemService) {
        this.cardRepository = cardRepository;
        this.itemService = itemService;
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCard(Long id) {
        return cardRepository.findById(id).orElseThrow(
                () -> new CardNotFoundException("cannot found the card with the id: "+id));
    }

    @Override
    public Card updateCard(Long id, Card card) {
        Card cardToUpdate = getCard(id);
        cardToUpdate.setName(card.getName());
        return cardToUpdate;
    }

    @Override
    public Card deleteCard(Long id) {
        Card card = getCard(id);
        cardRepository.delete(card);
        return card;
    }

    @Override
    public Card addItemToCard(Long cardId, Long itemId) {
        Card card = getCard(cardId);
        Item item = itemService.getItem(itemId);
        card.getItems().add(item);
        return card;
    }

    @Override
    public Card removeItemFromCard(Long cardId, Long itemId) {
        Card card = getCard(cardId);
        Item item = itemService.getItem(itemId);

        return card;
    }
}
