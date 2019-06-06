package com.jambit.fundc.functional.picture;

import com.jambit.fundc.functional.common.ResultCode;
import com.jambit.fundc.functional.picture.normalization.NormalizePicture;
import com.jambit.fundc.functional.user.GetUserByName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jambit.fundc.functional.common.ResultCode.DATABASE_ERROR;
import static com.jambit.fundc.functional.common.ResultCode.INVALID_PICTURE;
import static com.jambit.fundc.functional.common.ResultCode.SUCCESS;
import static com.jambit.fundc.functional.common.ResultCode.USER_NOT_FOUND;

@Component
@AllArgsConstructor
public class UploadPicturesDefault implements UploadPictures {

    private final GetUserByName getUserByName;
    private final NormalizePicture normalizePicture;
    private final SavePicture savePicture;

    @Override
    public ResultCode apply(final UploadPicturesParameters parameters) {
        return Optional.ofNullable(parameters.getUserName())
                       .map(getUserByName)
                       .map(user -> normalizePictures(parameters))
                       .orElse(USER_NOT_FOUND);
    }

    private ResultCode normalizePictures(final UploadPicturesParameters parameters) {
        final Collection<String> rawPictures = parameters.getPictures();

        final Collection<String> normalizedPictures = rawPictures.stream()
                                                                 .map(normalizePicture)
                                                                 .filter(Optional::isPresent)
                                                                 .map(Optional::get)
                                                                 .collect(Collectors.toList());

        return normalizedPictures.size() == rawPictures.size()
               ? uploadPictures(normalizedPictures)
               : INVALID_PICTURE;
    }

    private ResultCode uploadPictures(final Collection<String> normalizedPictures) {
        final long uploadCount = normalizedPictures.stream()
                                                   .map(savePicture)
                                                   .filter(Optional::isPresent)
                                                   .count();

        return uploadCount == normalizedPictures.size()
               ? SUCCESS
               : DATABASE_ERROR;
    }

}
