package extensions.java.lang.Iterable;


@FunctionalInterface
public interface IterableInterfaceExtension<T> {
     boolean action(T t);

    default void say(Object ceshi) {

    }
    //void toLambda(StringInterfaceExtension<? super T> after);

}
