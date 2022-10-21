package extensions.java.lang.Iterable;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Iterator;
import java.util.List;

@Extension
public class IterableExtension {
    public static <T> T customSelect(@This Iterable<T> thiz) {
        return null;
    }

    public static <T> void toLambda(@This Iterable<T> source, IterableInterfaceExtension<? super T> after){
        for (T element: source) {
            if(!after.action(element)){

            }
        }
    }
}
