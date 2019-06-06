package com.jambit.fundc.layered;

import com.jambit.fundc.layered.exception.UserAlreadyExistsException;
import com.jambit.fundc.layered.model.UserRequest;
import com.jambit.fundc.layered.service.UserService;
import com.jambit.fundc.layered.util.ValidationHelper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApplicationController {

    private final UserService userService;

    public String createUser(final UserRequest request) {

        final boolean valid = ValidationHelper.validateUserRequest(request);

        if (valid) {
            try {
                userService.createUser(request);

                return "success";
            } catch (final UserAlreadyExistsException e) {
                return "user already exists";
            }
        } else {
            return "invalid parameters";
        }
    }
}
