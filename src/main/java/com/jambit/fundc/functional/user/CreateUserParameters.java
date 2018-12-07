package com.jambit.fundc.functional.user;

import lombok.Value;

@Value
public class CreateUserParameters {
    private final String name;
    private final String pictureData;
}
