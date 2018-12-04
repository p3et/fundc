package com.jambit.fundc.user;

import com.jambit.fundc.common.ResultCode;
import com.jambit.fundc.picture.NormalizePicture;
import com.jambit.fundc.picture.SavePicure;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static com.jambit.fundc.common.ResultCode.DATABASE_ERROR;
import static com.jambit.fundc.common.ResultCode.INVALID_IMAGE_DATA;
import static com.jambit.fundc.common.ResultCode.SUCCESS;
import static com.jambit.fundc.common.ResultCode.USER_ALREADY_EXISTS;
import static java.util.Optional.of;

@Component
@AllArgsConstructor
public class CreateUser implements Function<UserParameters, ResultCode> {

    private final GetUserByName getUserByName;
    private final NormalizePicture normalizePicture;
    private final SavePicure savePicure;
    private final SaveUser saveUser;

    @Override
    public ResultCode apply(final UserParameters parameters) {
        return of(parameters.getName())
                 .map(getUserByName)
                 .map(user -> USER_ALREADY_EXISTS)
                 .orElseGet(() -> of(parameters.getPictureData())
                                    .map(normalizePicture)
                                    .map(savePicure)
                                    .map( pic ->  of(new ImmutablePair<>(parameters,pic))
                                                    .map(saveUser)
                                                    .map(b -> SUCCESS)
                                                    .orElse(DATABASE_ERROR))
                                    .orElse(INVALID_IMAGE_DATA)
                 );
    }
}
