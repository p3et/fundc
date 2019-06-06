package com.jambit.fundc.functional.picture;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SavePicturesDefault implements SavePicture {

    public static final String VALID_PICTURE = "101010";

    @Override
    public Optional<Picture> apply(final String picture) {
        return picture.equals(VALID_PICTURE) ?
               Optional.of(new Picture(1L, picture)) :
               Optional.empty();
    }
}
