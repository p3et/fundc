package com.jambit.fundc.picture.normalization;

import org.springframework.stereotype.Component;

@Component
public class NormalizeDataDefault implements NormalizeData {

    private static final String VALID_PICTURE_PREFIX = "10";

    @Override
    public String apply(String picture) {
        return picture.startsWith(NormalizeDataDefault.VALID_PICTURE_PREFIX) ?
                 picture :
                 null;
    }
}
