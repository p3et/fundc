package com.jambit.fundc.functional.user;

import com.jambit.fundc.functional.MyConfiguration;
import com.jambit.fundc.functional.common.ResultCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jambit.fundc.functional.common.ResultCode.INVALID_PICTURE;
import static com.jambit.fundc.functional.common.ResultCode.SUCCESS;
import static com.jambit.fundc.functional.common.ResultCode.USER_ALREADY_EXISTS;
import static com.jambit.fundc.functional.picture.SavePicturesDefault.VALID_PICTURE;
import static com.jambit.fundc.functional.user.GetUserByNameDefault.EXISTING_USER_NAME;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfiguration.class})
public abstract class CreateUserIntegrationTestBase {

    @Test
    public void whenUserNotExistsAndValidPictureThenSuccess() {
        whenUserAndPictureThenExpect("foo", VALID_PICTURE, SUCCESS);
    }

    private void whenUserAndPictureThenExpect(final String userName, final String pictureData, final ResultCode expected) {
        final CreateUserParameters parameters = new CreateUserParameters(userName, pictureData);
        final ResultCode resultCode = getResultFor(parameters);
        assertEquals(expected, resultCode);
    }

    protected abstract ResultCode getResultFor(CreateUserParameters parameters);

    @Test
    public void whenUserNotExistsAndInvalidPictureThenInvalidPicture() {
        whenUserAndPictureThenExpect("foo", "bar", INVALID_PICTURE);
    }

    @Test
    public void whenUserExistsThenUserAlreadyExists() {
        whenUserAndPictureThenExpect(EXISTING_USER_NAME, VALID_PICTURE, USER_ALREADY_EXISTS);
    }
}
