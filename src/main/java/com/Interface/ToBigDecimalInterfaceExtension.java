package com.Interface;

import java.math.BigDecimal;

@FunctionalInterface
public interface ToBigDecimalInterfaceExtension<T> {
    BigDecimal action(T t);

}
