package com.jambit.fundc.user;

import com.jambit.fundc.picture.Picture;
import lombok.Value;

@Value
public class User {
    private final long id;
    private final String name;
    private final Picture picture;
}
