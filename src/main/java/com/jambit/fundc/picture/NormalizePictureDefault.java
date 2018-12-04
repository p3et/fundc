package com.jambit.fundc.picture;

import org.springframework.stereotype.Component;

@Component
public class NormalizePictureDefault implements NormalizePicture {

    private static final String VALID_PICTURE_PREFIX = "10";

    @Override
    public String apply(String s) {
        return s.startsWith(VALID_PICTURE_PREFIX) ? s : null;
    }
}
