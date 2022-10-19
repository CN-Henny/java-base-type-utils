package extensions.java.util.List;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;

import java.util.List;

@Extension
public class ListExtension {

    public static @Self List<Object> customAdd(@This List<Object> source, Object key) {
        source.add(key);
        return source;
    }
}
