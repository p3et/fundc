package com.jambit.fundc.functional.picture;

import org.springframework.stereotype.Component;

@Component
public class SavePicturesDefault implements SavePicture {

    public static final String VALID_PICTURE = "101010";

    @Override
    public Picture apply(String picture) {
        return picture.equals(VALID_PICTURE) ?
                 new Picture(1L, picture) :
                 null;
    }
}
