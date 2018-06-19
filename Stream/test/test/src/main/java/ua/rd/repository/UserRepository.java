package ua.rd.repository;

import ua.rd.entiry.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(UUID id);
}
