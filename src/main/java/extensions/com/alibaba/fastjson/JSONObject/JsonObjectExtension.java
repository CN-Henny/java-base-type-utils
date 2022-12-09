package extensions.com.alibaba.fastjson.JSONObject;

import com.alibaba.fastjson.JSONObject;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

@Extension
public class JsonObjectExtension {

    public static JSONObject customGetValue(@This JSONObject source, JSONObject errorBack) {
        return source == null ? errorBack : source;
    }

    public static JSONObject customGetValue(@This JSONObject source) {
        return source == null ? new JSONObject() : source;
    }
}
