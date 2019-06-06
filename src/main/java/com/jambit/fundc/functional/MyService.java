package com.jambit.fundc.functional;

import com.jambit.fundc.functional.common.ResultCode;
import com.jambit.fundc.functional.picture.UploadPictures;
import com.jambit.fundc.functional.picture.UploadPicturesParameters;
import com.jambit.fundc.functional.user.CreateUser;
import com.jambit.fundc.functional.user.CreateUserParameters;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Only this class shall be exposed to the public!
 */
@Service
@AllArgsConstructor
public class MyService {

    private final CreateUser createUser;
    private final UploadPictures uploadPictures;

    public ResultCode createUser(final CreateUserParameters parameters) {
        return Optional.ofNullable(parameters)
                       .map(createUser)
                       .orElse(ResultCode.EMPTY_PARAMETERS);
    }

    public ResultCode uploadPicures(final UploadPicturesParameters parameters) {
        return Optional.ofNullable(parameters)
                       .map(uploadPictures)
                       .orElse(ResultCode.EMPTY_PARAMETERS);
    }
}
