package com.jambit.fundc.functional.picture.normalization;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class NormalizeDimensionsDefault implements NormalizePictureDimensions {

    @Override
    public Optional<String> apply(final String picture) {
        return Optional.ofNullable(picture);
    }
}
