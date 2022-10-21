package extensions.java.math.BigDecimal;

import extensions.java.lang.Iterable.IterableInterfaceExtension;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalInterfaceExtension<T> {
    BigDecimal action(T t);
}
