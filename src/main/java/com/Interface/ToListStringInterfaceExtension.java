package com.Interface;

import java.util.List;

@FunctionalInterface
public interface ToListStringInterfaceExtension<T> {
    List<String> action(T t);

}
