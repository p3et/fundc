package com.jambit.fundc.layered.service;

import com.jambit.fundc.layered.database.UserRepository;
import com.jambit.fundc.layered.exception.UserAlreadyExistsException;
import com.jambit.fundc.layered.model.UserEntity;
import com.jambit.fundc.layered.model.UserRequest;
import com.jambit.fundc.layered.util.EnityConverter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserRequest request) throws UserAlreadyExistsException {

        if (userRepository.findByName(request.getName()) != null) {
            throw new UserAlreadyExistsException();
        }

        UserEntity entity = EnityConverter.convertUserRequest(request);

        if (entity != null) {
            userRepository.save(entity);
        }
    }
}
