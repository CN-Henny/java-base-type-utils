package extensions.com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSONArray;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.ArrayList;
import java.util.List;

@Extension
public class JsonArrayExtension {
    public static  JSONArray customGetValue(@This JSONArray source, JSONArray errorBack) {
        return source == null ? errorBack : source;
    }

    public static JSONArray customGetValue(@This JSONArray source) {
        return source == null ? new JSONArray() : source;
    }
}
