package com.jambit.fundc.functional.picture.normalization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Optional.of;

@Component
@AllArgsConstructor
public class NormalizePictureDefault implements NormalizePicture {

    private final NormalizeDimensions normalizeDimensions;
    private final NormalizeData normalizeData;

    @Override
    public String apply(String picture) {
        return of(picture)
                 .map(normalizeDimensions)
                 .map(normalizeData)
                 .orElse(null);
    }
}
