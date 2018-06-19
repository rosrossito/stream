package ua.rd;

import ua.rd.entiry.Card;
import ua.rd.repository.impl.InMemCardRepository;
import ua.rd.repository.impl.InMemUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("------");
        InMemCardRepository inMemCardRepository = new InMemCardRepository();
        InMemUserRepository inMemUserRepository = new InMemUserRepository();

    }
}
