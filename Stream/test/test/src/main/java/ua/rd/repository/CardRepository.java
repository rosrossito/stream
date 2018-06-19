package ua.rd.repository;

import ua.rd.entiry.Card;

import java.util.List;
import java.util.UUID;

public interface CardRepository {
    List<Card> getAllCards();

    List<Card> getCardsByUserId(UUID id);

    Card getCardById(UUID id);
}
