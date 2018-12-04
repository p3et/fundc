package com.jambit.fundc.picture;

import lombok.Value;

@Value
public class Picture {
    private final long id;
    private final String name;
    private final String data;
}
