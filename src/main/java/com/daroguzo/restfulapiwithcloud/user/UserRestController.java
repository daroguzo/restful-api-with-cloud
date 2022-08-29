package com.daroguzo.restfulapiwithcloud.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserRepository userRepository;


}
