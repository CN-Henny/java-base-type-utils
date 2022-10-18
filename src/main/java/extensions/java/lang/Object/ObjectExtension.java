package extensions.java.lang.Object;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Extension
public class ObjectExtension {

    private static final ObjectMapper mapper = new ObjectMapper();

    //region   判断型


    //endregion

    //region   功能型

    /**
     * 对比两个对象返回不同值的属性map
     *
     * @param source
     * @param target
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @throws
     * @author Henny
     * @cdate 2022/10/18 16:08
     * @version 1.0
     * @mdate 2022/10/18 16:08
     * @since 1.0
     */
    public static Map<String, Object> systemCustomGetModifyContent(@This Object source, Object target) {
        Map<String, Object> modifies = new HashMap<>(16);
         /*
          process null problem, if all null means equal
          if only source is null means all modified
          if only target is null means nothing changed
         */
        if (null == source || null == target) {
            if (null == source && null == target) {
                return modifies;
            } else if (null == target) {
                return modifies;
            } else {
                return mapper.convertValue(target, new TypeReference<Map<String, Object>>() {
                });
            }
        }
        // source and target must be same class type
        if (!Objects.equals(source.getClass().getName(), target.getClass().getName())) {
            throw new ClassCastException("source and target are not same class type");
        }
        Map<String, Object> sourceMap = mapper.convertValue(source, new TypeReference<Map<String, Object>>() {
        });
        Map<String, Object> targetMap = mapper.convertValue(target, new TypeReference<Map<String, Object>>() {
        });
        sourceMap.forEach((k, v) -> {
            Object targetValue = targetMap.get(k);
            if (!Objects.equals(v, targetValue)) {
                modifies.put(k, targetValue);
            }
        });
        return modifies;
    }

    //endregion

    //region   转换型
    //endregion
}
