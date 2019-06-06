package com.jambit.fundc.functional.picture.normalization;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class NormalizeDataDefault implements NormalizePictureData {

    private static final String VALID_PICTURE_PREFIX = "10";

    @Override
    public Optional<String> apply(final String picture) {
        return picture.startsWith(NormalizeDataDefault.VALID_PICTURE_PREFIX) ?
               Optional.of(picture) :
               Optional.empty();
    }
}
