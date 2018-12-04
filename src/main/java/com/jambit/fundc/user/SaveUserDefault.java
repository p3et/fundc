package com.jambit.fundc.user;

import com.jambit.fundc.picture.Picture;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import static com.jambit.fundc.user.GetUserByNameDefault.EXISTING_USER_NAME;

@Component
public class SaveUserDefault implements SaveUser {

    @Override
    public User apply(Pair<String, Long> pair) {
        return pair.getLeft().equals(EXISTING_USER_NAME) ?
                 null :
                 new User(1, pair.getLeft(), pair.getRight());
    }
}
