package com.jambit.fundc.user;

import lombok.Value;

@Value
public class CreateUserParameters {
    private final String name;
    private final String pictureData;
}
