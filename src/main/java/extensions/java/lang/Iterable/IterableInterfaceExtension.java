package extensions.java.lang.Iterable;


import java.math.BigDecimal;

@FunctionalInterface
public interface IterableInterfaceExtension<T> {
    boolean action(T t);

    default void say(Object ceshi) {

    }

}
