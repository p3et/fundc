package com.jambit.fundc.user;

import com.jambit.fundc.common.ResultCode;
import com.jambit.fundc.picture.normalization.NormalizePicture;
import com.jambit.fundc.picture.SavePicture;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import static com.jambit.fundc.common.ResultCode.DATABASE_ERROR;
import static com.jambit.fundc.common.ResultCode.INVALID_PICTURE;
import static com.jambit.fundc.common.ResultCode.SUCCESS;
import static com.jambit.fundc.common.ResultCode.USER_ALREADY_EXISTS;
import static java.util.Optional.of;

@Component
@AllArgsConstructor
public class CreateUserDefault implements CreateUser {

    private final GetUserByName getUserByName;
    private final NormalizePicture normalizePicture;
    private final SavePicture savePicture;
    private final SaveUser saveUser;

    @Override
    public ResultCode apply(final CreateUserParameters parameters) {
        return of(parameters.getName())
                 .map(getUserByName)
                 .map(user -> USER_ALREADY_EXISTS)
                 .orElseGet(() -> of(parameters.getPictureData())
                                    .map(normalizePicture)
                                    .map(savePicture)
                                    .map( pic ->  of(new ImmutablePair<>(parameters.getName(),pic.getId()))
                                                    .map(saveUser)
                                                    .map(b -> SUCCESS)
                                                    .orElse(DATABASE_ERROR))
                                    .orElse(INVALID_PICTURE)
                 );
    }
}
