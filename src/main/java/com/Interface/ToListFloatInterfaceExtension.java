package com.Interface;

import java.util.List;

@FunctionalInterface
public interface ToListFloatInterfaceExtension<T> {
    List<Float> action(T t);

}
