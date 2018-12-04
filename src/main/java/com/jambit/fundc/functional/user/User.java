package com.jambit.fundc.functional.user;

import lombok.Value;

@Value
public class User {
    private final long id;
    private final String name;
    private final long pictureId;
}
