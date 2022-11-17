package com.Interface;

import java.util.Date;
import java.util.List;

@FunctionalInterface
public interface ToListDateInterfaceExtension<T> {
    List<Date> action(T t);

}
