package com.Interface;


import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface LambdaIterableInterfaceExtension<T> {
    boolean action(T t);
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> action(t) && other.test(t);
    }
}
