package com.jambit.fundc.functional.user;


import com.jambit.fundc.functional.MyService;
import com.jambit.fundc.functional.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserFromMyServiceIntegrationTest extends CreateUserIntegrationTestBase {

    @Autowired
    private MyService myService;

    @Override
    protected ResultCode getResultFor(CreateUserParameters parameters) {
        return myService.createUser(parameters);
    }

}
