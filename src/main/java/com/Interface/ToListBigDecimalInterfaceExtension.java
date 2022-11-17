package com.Interface;

import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface ToListBigDecimalInterfaceExtension<T> {
    List<BigDecimal> action(T t);

}
