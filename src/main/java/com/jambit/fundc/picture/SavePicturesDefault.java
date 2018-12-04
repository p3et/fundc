package com.jambit.fundc.picture;

import org.springframework.stereotype.Component;

@Component
public class SavePicturesDefault implements SavePicture {
    public static final String VALID_PICTURE_DATA = "101010";

    @Override
    public Picture apply(String picture) {
        return picture.equals(VALID_PICTURE_DATA) ?
                 new Picture(1, picture) :
                 null;
    }
}
