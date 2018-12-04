package com.jambit.fundc.picture.normalization;

import org.springframework.stereotype.Component;

@Component
public class NormalizeDimensionsDefault implements NormalizeDimensions {

    @Override
    public String apply(String picture) {
        return picture;
    }
}
