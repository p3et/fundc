package com.jambit.fundc.functional;

import com.jambit.fundc.functional.common.ResultCode;
import com.jambit.fundc.functional.picture.UploadPictures;
import com.jambit.fundc.functional.picture.UploadPicturesParameters;
import com.jambit.fundc.functional.user.CreateUser;
import com.jambit.fundc.functional.user.CreateUserParameters;
import org.springframework.stereotype.Service;

import static java.util.Optional.of;

/**
 * Only this class shall be exposed to the public!
 */
@Service
public class MyService {

    private final UploadPictures uploadPictures;
    private final CreateUser createUser;

    public MyService(final UploadPictures uploadPictures, final CreateUser createUser) {
        this.uploadPictures = uploadPictures;
        this.createUser = createUser;
    }

    public ResultCode createUser(final CreateUserParameters parameters) {
        return of(parameters)
                 .map(createUser)
                 .orElse(ResultCode.UNKNOWN_ERROR);
    }

    public ResultCode uploadPicures(final UploadPicturesParameters parameters) {
        return of(parameters)
                 .map(uploadPictures)
                 .orElse(ResultCode.UNKNOWN_ERROR);
    }
}
