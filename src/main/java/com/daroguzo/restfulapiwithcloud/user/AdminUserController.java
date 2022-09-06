package com.daroguzo.restfulapiwithcloud.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminUserController {
    private final UserService userService;

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUser() {
        return userService.findAllUsingFilter();
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable Long id) {
        return userService.findByIdUsingFilter(id);
    }
}
