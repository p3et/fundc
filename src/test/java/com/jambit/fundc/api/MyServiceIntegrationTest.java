package com.jambit.fundc.api;


import com.jambit.fundc.common.ResultCode;
import com.jambit.fundc.picture.NormalizePicture;
import com.jambit.fundc.user.UserParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jambit.fundc.common.ResultCode.SUCCESS;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyConfiguration.class })
public class MyServiceIntegrationTest {

    @Autowired
    private MyService myService;

    @Test
    public void test() {
        final UserParameters parameters = new UserParameters("Alice", NormalizePicture.VALID_PICTURE_DATA);
        final ResultCode resultCode = myService.createUser(parameters);
        assertEquals(SUCCESS, resultCode);
    }

}
