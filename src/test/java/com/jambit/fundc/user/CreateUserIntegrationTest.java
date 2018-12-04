package com.jambit.fundc.user;


import com.jambit.fundc.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CreateUserIntegrationTest extends CreateUserIntegrationTestBase {

    @Autowired
    private CreateUser createUser;

    @Override
    protected ResultCode getResultFor(CreateUserParameters parameters) {
        return createUser.apply(parameters);
    }
}
