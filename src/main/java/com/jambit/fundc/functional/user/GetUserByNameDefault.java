package com.jambit.fundc.functional.user;

import org.springframework.stereotype.Component;

@Component
public class GetUserByNameDefault implements GetUserByName {

    public static final String EXISTING_USER_NAME = "Bob";

    @Override
    public User apply(String name) {
        return name.equals(EXISTING_USER_NAME) ?
                 new User(1, EXISTING_USER_NAME, 1) :
                 null;
    }
}
