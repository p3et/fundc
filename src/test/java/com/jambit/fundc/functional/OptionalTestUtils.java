package com.jambit.fundc.functional;

import org.junit.Assert;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class OptionalTestUtils {

    public static <T> void assertPresent(final Optional<T> optional) {
        Assert.assertTrue(optional.isPresent());
    }

    public static <T> void assertAbsent(final Optional<T> optional) {
        Assert.assertFalse(optional.isPresent());
    }
}
