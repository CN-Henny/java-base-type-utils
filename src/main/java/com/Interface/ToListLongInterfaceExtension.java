package com.Interface;

import java.util.List;

@FunctionalInterface
public interface ToListLongInterfaceExtension<T> {
    List<Long> action(T t);

}
