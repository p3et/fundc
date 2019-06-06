package com.jambit.fundc.functional.user;

import com.jambit.fundc.functional.common.ResultCode;
import com.jambit.fundc.functional.picture.SavePicture;
import com.jambit.fundc.functional.picture.normalization.NormalizePicture;
import lombok.AllArgsConstructor;
import org.javatuples.Pair;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.jambit.fundc.functional.common.ResultCode.DATABASE_ERROR;
import static com.jambit.fundc.functional.common.ResultCode.INVALID_PICTURE;
import static com.jambit.fundc.functional.common.ResultCode.SUCCESS;
import static com.jambit.fundc.functional.common.ResultCode.USER_ALREADY_EXISTS;

@Component
@AllArgsConstructor
public class CreateUserDefault implements CreateUser {

    private final GetUserByName getUserByName;
    private final NormalizePicture normalizePicture;
    private final SavePicture savePicture;
    private final SaveUser saveUser;

    @Override
    public ResultCode apply(final CreateUserParameters parameters) {
        return Optional.of(parameters.getName())
                       .map(getUserByName)
                       .filter(Optional::isPresent)
                       .map(user -> USER_ALREADY_EXISTS)
                       .orElseGet(() -> normalizePicture(parameters));
    }

    private ResultCode normalizePicture(final CreateUserParameters parameters) {
        return Optional.of(parameters.getPictureData())
                       .map(normalizePicture)
                       .filter(Optional::isPresent)
                       .map(Optional::get)
                       .map(normalizedPicture -> savePictureAndUser(parameters, normalizedPicture))
                       .orElse(INVALID_PICTURE);
    }

    private ResultCode savePictureAndUser(final CreateUserParameters parameters, final String normalizedPicture) {
        return Optional.of(normalizedPicture)
                       .map(savePicture)
                       .filter(Optional::isPresent)
                       .map(Optional::get)
                       .map(picture -> new Pair<>(parameters, picture))
                       .map(saveUser)
                       .filter(o -> o.isPresent())
                       .map(o -> SUCCESS)
                       .orElse(DATABASE_ERROR);
    }
}
