package com.jambit.fundc.layered.database;

import com.jambit.fundc.layered.model.UserEntity;

public class UserRepository {

    public UserEntity findByName(String name) {
        return null;
    }

    /**
     * Why should this method be exposed to all classes that only nead read access?
     */
    public UserEntity save(UserEntity userEntity) {
        return userEntity;
    }
}
