package com.jambit.fundc.picture.normalization;

import org.springframework.stereotype.Component;

@Component
class NormalizeDimensionsDefault implements NormalizeDimensions {

    @Override
    public String apply(String picture) {
        return picture;
    }
}
