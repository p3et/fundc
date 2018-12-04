package com.jambit.fundc.user;

import com.jambit.fundc.picture.Picture;
import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

public interface SaveUser extends Function<Pair<UserParameters, Picture>, User> {
}
