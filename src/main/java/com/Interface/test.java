package com.Interface;


        import java.util.Objects;
        import java.util.function.Predicate;

@FunctionalInterface
public interface test<T,R> {
    R apply(T t);
}
