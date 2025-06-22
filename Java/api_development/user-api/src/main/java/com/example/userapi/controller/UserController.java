package main.java.com.example.userapi.controller;

import main.java.com.example.userapi.model.User;
import main.java.com.example.userapi.service.UserService;
import org.springframework.beans.factory.annotation.AutoWired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userSerivce;

    @GetMapping
    public List<User> getAllUsers() {
        return userSerivce.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userSerivce.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}