package com.jambit.fundc.functional.user;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

/**
 * Here, we don't use a parameters object but a generic 2-tuple (pair.)
 * Further on, this functionality can be package private.
 */
interface SaveUser extends Function<Pair<String, Long>, User> {
}
