package com.jambit.fundc.functional.picture.normalization;

import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static com.jambit.fundc.functional.OptionalTestUtils.assertAbsent;
import static com.jambit.fundc.functional.OptionalTestUtils.assertPresent;
import static com.jambit.fundc.functional.picture.SavePicturesDefault.VALID_PICTURE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NormalizePictureTest {

    private static final Answer<Optional<String>> ANSWER_PRESENT = i -> Optional.of(i.getArgument(0));
    private static final Answer<Optional<String>> ANSWER_ABSENT = i -> Optional.empty();

    @Test
    public void whenAllStepsSucceedThenNotNull() {
        final NormalizePicture normalizePicture = getNormalizationWithInjectedMocks(ANSWER_PRESENT, ANSWER_PRESENT);

        assertPresent(normalizePicture.apply(VALID_PICTURE));
    }

    private NormalizePicture getNormalizationWithInjectedMocks(
        final Answer<Optional<String>> dimensionNormalizationAnswer,
        final Answer<Optional<String>> dataNormalizationAnswer
    ) {
        final NormalizePictureDimensions normalizePictureDimensions = mock(NormalizePictureDimensions.class);
        when(normalizePictureDimensions.apply(any())).thenAnswer(dimensionNormalizationAnswer);

        final NormalizePictureData normalizePictureData = mock(NormalizePictureData.class);
        when(normalizePictureData.apply(any())).thenAnswer(dataNormalizationAnswer);

        return new NormalizePictureDefault(normalizePictureDimensions, normalizePictureData);
    }

    @Test
    public void whenNormalizeDimensionsFailsThenNull() {
        final NormalizePicture normalizePicture = getNormalizationWithInjectedMocks(ANSWER_ABSENT, ANSWER_PRESENT);

        assertAbsent(normalizePicture.apply(VALID_PICTURE));
    }

    @Test
    public void whenNormalizeDataFailsThenNull() {
        final NormalizePicture normalizePicture = getNormalizationWithInjectedMocks(ANSWER_PRESENT, ANSWER_ABSENT);

        assertAbsent(normalizePicture.apply(VALID_PICTURE));
    }
}
