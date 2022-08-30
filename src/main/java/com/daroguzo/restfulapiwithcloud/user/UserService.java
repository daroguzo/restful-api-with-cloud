package com.daroguzo.restfulapiwithcloud.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("ID[%s] is not found", id)));
    }

    @Transactional
    public User register(UserDto userDto) {
        User newUser = User.builder()
                .name(userDto.getName())
                .joinDate(LocalDateTime.now())
                .build();

        return userRepository.save(newUser);
    }
}
