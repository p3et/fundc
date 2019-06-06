package com.jambit.fundc.functional.picture;

import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static com.jambit.fundc.functional.OptionalTestUtils.assertAbsent;
import static com.jambit.fundc.functional.OptionalTestUtils.assertPresent;
import static com.jambit.fundc.functional.picture.SavePicturesDefault.VALID_PICTURE;

@Ignore // Remove for demonstration
@RunWith(Parameterized.class)
public class SavePictureUnitTest {

    @Parameterized.Parameter
    public SavePicture savePicture;

    @Parameterized.Parameters
    public static Collection<SavePicture> data() {
        return Lists.newArrayList(
            new SavePicturesDefault(),
            new SavePicturesSpecial()
        );
    }

    /**
     * Expected to fail for {@link SavePicturesSpecial}
     */
    @Test
    public void whenPictureValidThenPresent() {
        assertPresent(savePicture.apply(VALID_PICTURE));
    }

    @Test
    public void whenPictureInvalidThenAnsent() {
        assertAbsent(savePicture.apply("Foobar"));
    }
}

