package com.tutorial.onetomanyjpa;

import com.tutorial.onetomanyjpa.entity.Card;
import com.tutorial.onetomanyjpa.entity.Item;
import com.tutorial.onetomanyjpa.service.CardService;
import com.tutorial.onetomanyjpa.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@RequiredArgsConstructor
@SpringBootApplication
public class OneToManyJpaApplication implements CommandLineRunner {

    private final CardService cardService;
    private final ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Item item1 = itemService.add(new Item(null,"0001"));
        Item item2 = itemService.add(new Item(null,"0002"));
        Item item3 = itemService.add(new Item(null,"0003"));
        Item item4 = itemService.add(new Item(null,"0004"));

        Card card1 = cardService.addCard(new Card(null,"card-1",null));
        Card card2 = cardService.addCard(new Card(null,"card-2",null));

        cardService.addItemToCard(card1.getId(),item2.getId());
        cardService.addItemToCard(card1.getId(),item1.getId());
        cardService.addItemToCard(card1.getId(),item3.getId());
    }
}
