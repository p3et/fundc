package com.jambit.fundc;

import com.jambit.fundc.common.ResultCode;
import com.jambit.fundc.picture.UploadPictures;
import com.jambit.fundc.picture.UploadPicturesParameters;
import com.jambit.fundc.user.CreateUser;
import com.jambit.fundc.user.CreateUserParameters;
import org.springframework.stereotype.Service;

import static com.jambit.fundc.common.ResultCode.UNKNOWN_ERROR;
import static java.util.Optional.of;

/**
 * Only this class shall be exposed to the public!
 */
@Service
public class MyService {

    private final UploadPictures uploadPictures;
    private final CreateUser createUser;

    public MyService(UploadPictures uploadPictures, CreateUser createUser) {
        this.uploadPictures = uploadPictures;
        this.createUser = createUser;
    }

    public ResultCode createUser(CreateUserParameters parameters) {
        return of(parameters)
                 .map(createUser)
                 .orElse(UNKNOWN_ERROR);
    }

    public ResultCode uploadPicures(UploadPicturesParameters parameters) {
        return of(parameters)
                 .map(uploadPictures)
                 .orElse(UNKNOWN_ERROR);
    }
}
