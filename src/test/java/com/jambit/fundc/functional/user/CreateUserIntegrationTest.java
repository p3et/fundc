package com.jambit.fundc.functional.user;

import com.jambit.fundc.functional.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserIntegrationTest extends CreateUserIntegrationTestBase {

    @Autowired
    private CreateUser createUser;

    @Override
    protected ResultCode getResultFor(final CreateUserParameters parameters) {
        return createUser.apply(parameters);
    }
}
