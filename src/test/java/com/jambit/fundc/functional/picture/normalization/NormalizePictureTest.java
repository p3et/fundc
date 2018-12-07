package com.jambit.fundc.functional.picture.normalization;

import org.junit.Test;
import org.mockito.stubbing.Answer;

import static com.jambit.fundc.functional.picture.SavePicturesDefault.VALID_PICTURE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NormalizePictureTest {

    @Test
    public void whenAllStepsSucceedThenNotNull() {
        final NormalizePicture normalizePicture = injectMocksAndGetNormalization(
          i -> i.getArgument(0), i -> i.getArgument(0));

        assertNotNull(normalizePicture.apply(VALID_PICTURE));
    }

    @Test
    public void whenNormalizeDimensionsFailsThenNull() {
        final NormalizePicture normalizePicture =
          injectMocksAndGetNormalization(i -> null, i -> i.getArgument(0));

        assertNull(normalizePicture.apply(VALID_PICTURE));
    }

    @Test
    public void whenNormalizeDataFailsThenNull() {
        final NormalizePicture normalizePicture =
          injectMocksAndGetNormalization(i -> i.getArgument(0), i -> null);

        assertNull(normalizePicture.apply(VALID_PICTURE));
    }

    private NormalizePicture injectMocksAndGetNormalization(
      final Answer<String> dimensionNormalizationAnswer,
      final Answer<String> dataNormalizationAnswer
    ) {

        final NormalizeDimensions normalizeDimensions = mock(NormalizeDimensions.class);
        final NormalizeData normalizeData = mock(NormalizeData.class);

        when(normalizeDimensions.apply(any())).thenAnswer(dimensionNormalizationAnswer);
        when(normalizeData.apply(any())).thenAnswer(dataNormalizationAnswer);

        return new NormalizePictureDefault(normalizeDimensions, normalizeData);
    }
}
