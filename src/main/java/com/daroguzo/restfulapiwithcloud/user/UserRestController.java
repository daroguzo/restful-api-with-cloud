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

    @GetMapping("/v1/users")
    public List<User> retrieveAllUserV1() {
        return userService.findAll();
    }

    @GetMapping("/v1/users/{id}")
    public User retrieveUserV1(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/v1/users")
    public ResponseEntity<User> createUserV1(@RequestBody @Valid UserDto userDto) {
        User newUser = userService.register(userDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/v1/users/{id}")
    public ResponseEntity<User> reviseNameV1(@PathVariable Long id, @RequestBody UserDto userDto) {
        User newUser = userService.reviseName(id, userDto.getName());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/v1/users/{id}")
    public void deleteUserV1(@PathVariable Long id) {
        userService.delete(id);
    }
}
