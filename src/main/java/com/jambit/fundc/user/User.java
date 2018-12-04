package com.jambit.fundc.user;

import lombok.Value;

@Value
public class User {
    private final long id;
    private final String name;
    private final long pictureId;
}
