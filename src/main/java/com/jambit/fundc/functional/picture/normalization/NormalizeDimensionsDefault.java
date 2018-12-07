package com.jambit.fundc.functional.picture.normalization;

import org.springframework.stereotype.Component;

@Component
class NormalizeDimensionsDefault implements NormalizeDimensions {

    @Override
    public String apply(String picture) {
        return picture;
    }
}
