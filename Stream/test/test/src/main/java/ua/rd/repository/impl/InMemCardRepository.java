package ua.rd.repository.impl;

import ua.rd.entiry.Card;
import ua.rd.repository.CardRepository;
import ua.rd.util.Predefined;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InMemCardRepository implements CardRepository {
    private List<Card> cards;

    public InMemCardRepository() {
        this.cards = getPredefinedCards();
    }

    @Override
    public List<Card> getAllCards() {
        return cards;
    }

    @Override
    public List<Card> getCardsByUserId(UUID id) {
        return null;
    }

    @Override
    public Card getCardById(UUID id) {
        return null;
    }

    private List<Card> getPredefinedCards() {

        List<Card> cards = Stream.generate(this::createCard)
                .limit(Predefined.DEFAULT_CARD_NUM)
                .collect(Collectors.toList());
        cards.forEach(System.out::println);
        return cards;
    }

    private Card createCard() {
        return new Card(UUID.randomUUID(), Predefined.getRandomUUIDFromList(), "Custom description");
    }
}
