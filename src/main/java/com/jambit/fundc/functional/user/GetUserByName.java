package com.jambit.fundc.functional.user;

import java.util.Optional;
import java.util.function.Function;

public interface GetUserByName extends Function<String, Optional<User>> {

}
