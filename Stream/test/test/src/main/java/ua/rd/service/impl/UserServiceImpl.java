package ua.rd.service.impl;

import ua.rd.entiry.Card;
import ua.rd.entiry.User;
import ua.rd.repository.CardRepository;
import ua.rd.repository.UserRepository;
import ua.rd.repository.impl.InMemCardRepository;
import ua.rd.repository.impl.InMemUserRepository;
import ua.rd.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private CardRepository cardRepository;

    public UserServiceImpl() {
        this.userRepository = new InMemUserRepository();
        this.cardRepository = new InMemCardRepository();
    }

    @Override
    public List<User> getAllUsersWithoutCards() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> getAllUsersWithCards() {
        return null;
    }

    @Override
    public User getUserWithoutCards(UUID id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserWithCards(UUID id) {
        return null;
    }

    private User setCardsForUser(User user) {
        List<Card> userCards = cardRepository.getCardsByUserId(user.getId());
        user.setCards(userCards);
        return user;
    }
}
