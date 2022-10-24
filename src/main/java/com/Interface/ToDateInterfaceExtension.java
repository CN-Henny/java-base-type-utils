package com.Interface;

import java.util.Date;

@FunctionalInterface
public interface ToDateInterfaceExtension<T> {
    Date action(T t);

}

