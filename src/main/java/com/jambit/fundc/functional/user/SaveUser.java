package com.jambit.fundc.functional.user;

import com.jambit.fundc.functional.picture.Picture;
import org.javatuples.Pair;

import java.util.Optional;
import java.util.function.Function;

/**
 * Here, we don't use a parameters object but a generic 2-tuple (pair.)
 * Further on, this functionality can be package private.
 */
interface SaveUser extends Function<Pair<CreateUserParameters, Picture>, Optional<User>> {
}
