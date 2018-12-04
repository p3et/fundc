package com.jambit.fundc.picture;

import com.jambit.fundc.common.ResultCode;
import com.jambit.fundc.picture.normalization.NormalizePicture;
import com.jambit.fundc.user.GetUserByName;
import com.jambit.fundc.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jambit.fundc.common.ResultCode.INVALID_PICTURE;
import static com.jambit.fundc.common.ResultCode.SUCCESS;
import static com.jambit.fundc.common.ResultCode.USER_NOT_FOUND;
import static java.util.Optional.of;

@Component
@AllArgsConstructor
public class UploadPicturesDefault implements UploadPictures {

    private final GetUserByName getUserByName;
    private final NormalizePicture normalizePicture;
    private final SavePicture savePicture;

    @Override
    public ResultCode apply(final UploadPicturesParameters parameters) {
        final ResultCode resultCode;


        final Optional<User> maybeUser = of(parameters.getUserName())
                                     .map(getUserByName);

        if (maybeUser.isPresent()) {
            final Collection<String> picturesRaw = parameters.getPictures();

            final List<Picture> picturesPersisted = picturesRaw
                                       .stream()
                                       .map(normalizePicture)
                                       .filter(Objects::nonNull)
                                       .map(savePicture)
                                       .filter(Objects::nonNull)
                                       .collect(Collectors.toList());

            resultCode = picturesPersisted.size() == picturesRaw.size() ?
                           SUCCESS :
                           INVALID_PICTURE;

        } else {
            resultCode = USER_NOT_FOUND;
        }

        return resultCode;
    }
}
