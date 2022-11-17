package com.Interface;


@FunctionalInterface
public interface LambdaGetValueInterface<T,R> {
    R apply(T t);
}
