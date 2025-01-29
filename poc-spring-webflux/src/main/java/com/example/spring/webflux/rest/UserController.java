package com.example.spring.webflux.rest;

import com.example.spring.webflux.domain.User;
import com.example.spring.webflux.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUserByEmail(@PathVariable("email") String email) {
        return userRepository.findByEmail(email);
    }
}
