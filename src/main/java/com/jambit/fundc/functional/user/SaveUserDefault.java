package com.jambit.fundc.functional.user;

import com.jambit.fundc.functional.picture.Picture;
import org.javatuples.Pair;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class SaveUserDefault implements SaveUser {

    @Override
    public Optional<User> apply(final Pair<CreateUserParameters, Picture> pair) {
        final CreateUserParameters parameters = pair.getValue0();
        final Picture picture = pair.getValue1();

        return Optional.of(new User(1, parameters.getName(), picture.getId()));
    }
}
