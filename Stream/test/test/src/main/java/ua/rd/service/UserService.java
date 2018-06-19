package ua.rd.service;

import ua.rd.entiry.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsersWithoutCards();

    List<User> getAllUsersWithCards();

    User getUserWithoutCards(UUID id);

    User getUserWithCards(UUID id);
}
