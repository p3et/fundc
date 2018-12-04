package com.jambit.fundc.functional.user;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import static com.jambit.fundc.functional.user.GetUserByNameDefault.EXISTING_USER_NAME;

@Component
class SaveUserDefault implements SaveUser {

    @Override
    public User apply(Pair<String, Long> pair) {
        return pair.getLeft().equals(EXISTING_USER_NAME) ?
                 null :
                 new User(1, pair.getLeft(), pair.getRight());
    }
}
