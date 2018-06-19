package ua.rd.repository.impl;

import ua.rd.entiry.User;
import ua.rd.repository.UserRepository;
import ua.rd.util.Predefined;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemUserRepository implements UserRepository {
    private List<User> users;

    public InMemUserRepository() {
        this.users = getPredefinedUsers();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    private List<User> getPredefinedUsers() {
//        List<UUID> list = Predefined.getUUIDs();
//        List<User> users = new ArrayList<>();

//        List<User> users = Stream.generate(this::createUserWithId(
//                .foreach();
//                ))

//        for (UUID id : list) {
//            users.add(createUserWithId(id));
//        }

        return Predefined.getUUIDs().stream()
                .map(this::createUserWithId)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private User createUserWithId(UUID id) {
        return new User(id, "name", "surname");
    }
}
