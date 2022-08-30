package com.daroguzo.restfulapiwithcloud.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUser() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserDto userDto) {
        userService.register(userDto);
    }
}
