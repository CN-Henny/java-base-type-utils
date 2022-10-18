package extensions.java.util.Map;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;

import java.util.Map;

@Extension
public class MapExtension {

    public static <K,V> @Self Map<K,V> addaaa(@This Map<K,V> thiz, K key, V value) {
        thiz.put(key, value);
        return thiz; // returns Self for type-safe call chaining
    }
}
