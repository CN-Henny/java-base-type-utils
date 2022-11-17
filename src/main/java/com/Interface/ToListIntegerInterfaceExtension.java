package com.Interface;

import java.util.List;

@FunctionalInterface
public interface ToListIntegerInterfaceExtension<T> {
    List<Integer> action(T t);

}
