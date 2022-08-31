package com.daroguzo.restfulapiwithcloud.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        User newUser = userService.register(userDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> reviseName(@PathVariable Long id, @RequestBody UserDto userDto) {
        User newUser = userService.reviseName(id, userDto.getName());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
