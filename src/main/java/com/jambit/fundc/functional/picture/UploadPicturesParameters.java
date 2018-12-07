package com.jambit.fundc.functional.picture;

import lombok.Value;

import java.util.Collection;

@Value
public class UploadPicturesParameters {
    private final String userName;
    private final Collection<String> pictures;
}
