package com.jambit.fundc.picture;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static com.jambit.fundc.picture.SavePicturesDefault.VALID_PICTURE_DATA;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(Parameterized.class)
public class SavePictureUnitTest {

    @Parameterized.Parameters
    public static Collection<SavePicture> data() {
        return Lists.newArrayList(
            new SavePicturesDefault(),
            new SavePicturesSpecial()
        );
    }

    @Parameterized.Parameter
    public SavePicture savePicture;

    @Test
    public void whenPictureValidThenNotNull() {
        assertNotNull(savePicture.apply(VALID_PICTURE_DATA));
    }

    @Test
    public void whenPictureInvalidThenNull() {
        assertNull(savePicture.apply("Foobar"));
    }
}

