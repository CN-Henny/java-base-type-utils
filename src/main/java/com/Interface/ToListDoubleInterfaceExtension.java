package com.Interface;

import java.util.List;

@FunctionalInterface
public interface ToListDoubleInterfaceExtension<T> {
    List<Double> action(T t);

}
