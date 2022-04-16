package com.tutorial.onetomanyjpa.controller;

import com.tutorial.onetomanyjpa.dto.CardDto;
import com.tutorial.onetomanyjpa.entity.Card;
import com.tutorial.onetomanyjpa.mapper.CardMapper;
import com.tutorial.onetomanyjpa.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping
    public ResponseEntity<List<CardDto>> getCards(){
        List<Card> cards = cardService.getCards();
        return new ResponseEntity<>(cardMapper.cardListToCardDtoList(cards), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody final CardDto cardDto){
        Card card = cardService.addCard(cardMapper.cardDtoToCard(cardDto));
        return new ResponseEntity<>(cardMapper.cardToCardDto(card), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCard(@PathVariable final Long id){
        Card card = cardService.getCard(id);
        return new ResponseEntity<>(cardMapper.cardToCardDto(card), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardDto> deleteCard(@PathVariable final Long id){
        Card card = cardService.deleteCard(id);
        return new ResponseEntity<>(cardMapper.cardToCardDto(card), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDto> updateCard(@PathVariable final Long id,
                                              @RequestBody final CardDto cardDto){
        Card card = cardService.updateCard(id,cardMapper.cardDtoToCard(cardDto));
        return new ResponseEntity<>(cardMapper.cardToCardDto(card), HttpStatus.OK);
    }

    @PostMapping("/{cardId}/items/{itemsId}")
    public ResponseEntity<CardDto> addItemToCard(@PathVariable final Long cardId,
                                                 @PathVariable final Long itemsId){
        Card card = cardService.addItemToCard(cardId,itemsId);
        return new ResponseEntity<>(cardMapper.cardToCardDto(card), HttpStatus.OK);
    }

    @DeleteMapping("/{cardId}/items/{itemsId}")
    public ResponseEntity<CardDto> deleteItemFromCard(@PathVariable final Long cardId,
                                                 @PathVariable final Long itemsId){
        Card card = cardService.removeItemFromCard(cardId,itemsId);
        return new ResponseEntity<>(cardMapper.cardToCardDto(card), HttpStatus.OK);
    }
}
