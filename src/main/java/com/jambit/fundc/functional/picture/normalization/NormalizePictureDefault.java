package com.jambit.fundc.functional.picture.normalization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class NormalizePictureDefault implements NormalizePicture {

    private final NormalizePictureDimensions normalizePictureDimensions;
    private final NormalizePictureData normalizePictureData;

    @Override
    public Optional<String> apply(final String picture) {
        return Optional.of(picture)
                       .map(normalizePictureDimensions)
                       .filter(Optional::isPresent)
                       .map(Optional::get)
                       .map(normalizePictureData)
                       .filter(Optional::isPresent)
                       .map(Optional::get);
    }
}
