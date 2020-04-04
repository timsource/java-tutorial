package com.timsource;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Function;

@FunctionalInterface
public interface ExceptionWrapperFunction<T, R, E extends Throwable> {
    static <T, R, E extends Throwable> Function<T, R> unchecked(ExceptionWrapperFunction<T, R, E> function) {
        return param -> {
        try {
            return function.apply(param);
        }
        catch (Throwable e) {
            if(e instanceof IOException) {
                throw new UncheckedIOException((IOException) e);
            }
            throw new RuntimeException(e);
        }
        };
    }

    R apply(T t) throws E;
}
