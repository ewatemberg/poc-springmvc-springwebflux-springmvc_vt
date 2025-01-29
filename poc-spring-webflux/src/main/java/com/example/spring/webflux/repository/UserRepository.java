package com.example.spring.webflux.repository;

import com.example.spring.webflux.domain.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Long> {

    Mono<User> findByEmail(String email);
}