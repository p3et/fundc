package com.jambit.fundc.functional.picture;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SavePicturesSpecial implements SavePicture {

    @Override
    public Optional<Picture> apply(final String picture) {
        return Optional.empty();
    }
}
