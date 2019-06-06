package com.jambit.fundc.functional.user;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserByNameDefault implements GetUserByName {

    static final String EXISTING_USER_NAME = "Bob";

    @Override
    public Optional<User> apply(final String name) {
        return name.equals(EXISTING_USER_NAME) ?
               Optional.of(new User(1, EXISTING_USER_NAME, 1)) :
               Optional.empty();
    }
}
