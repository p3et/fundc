package com.jambit.fundc.functional.picture;

import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
@NonNull
public class UploadPicturesParameters {
    private final String userName;
    private final Collection<String> pictures;
}
