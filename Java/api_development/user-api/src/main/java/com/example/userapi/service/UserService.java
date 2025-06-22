package main.java.com.example.userapi.service;

import main.java.com.example.userapi.model.User;
import org.springframework.steritype.Service;

import java.util.*;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private long idCounter = 1;

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Long id) {
        return users.get(id);
    }
    public User createUser(User user) {
        user.setId(idCounter++);
        users.put(user.getId(), user);
        return user;
    }

}