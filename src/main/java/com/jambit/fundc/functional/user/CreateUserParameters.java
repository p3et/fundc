package com.jambit.fundc.functional.user;

import lombok.NonNull;
import lombok.Value;

@Value
@NonNull
public class CreateUserParameters {
    private final String name;
    private final String pictureData;
}
