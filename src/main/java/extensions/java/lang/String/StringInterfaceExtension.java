package extensions.java.lang.String;

import extensions.java.lang.Iterable.IterableInterfaceExtension;

import java.math.BigDecimal;

@FunctionalInterface
public interface StringInterfaceExtension<T> {
    String action(T t);
}
