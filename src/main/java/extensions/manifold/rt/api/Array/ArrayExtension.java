package extensions.manifold.rt.api.Array;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Extension
public class ArrayExtension {

    public static List<@Self(true) Object> toaaaList(@This Object array) {
        if (!array.getClass().getComponentType().isPrimitive()) {
            return Arrays.asList((Object[])((Object[])array));
        } else {
            int len = Array.getLength(array);
            List<Object> list = new ArrayList(len);

            for(int i = 0; i < len; ++i) {
                list.add(Array.get(array, i));
            }

            return list;
        }
    }
}
