package com.jambit.fundc.picture;

import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static com.jambit.fundc.picture.SavePicturesDefault.VALID_PICTURE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@Ignore // Remove for demonstration
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

    /**
     * Expected to fail for {@link SavePicturesSpecial}
     */
    @Test
    public void whenPictureValidThenNotNull() {
        assertNotNull(savePicture.apply(VALID_PICTURE));
    }

    @Test
    public void whenPictureInvalidThenNull() {
        assertNull(savePicture.apply("Foobar"));
    }
}

