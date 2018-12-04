package com.jambit.fundc.user;


import com.jambit.fundc.MyService;
import com.jambit.fundc.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserFromMyServiceIntegrationTest extends CreateUserIntegrationTestBase {

    @Autowired
    private MyService myService;

    @Override
    protected ResultCode getResultFor(CreateUserParameters parameters) {
        return myService.createUser(parameters);
    }

}
