package ru.sbt.jschool.session5.problem2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NIzhikov
 */
public class JSONFormatterImpl implements JSONFormatter {
    private Map<Class, JSONTypeFormatter> types = new HashMap<>();

    @Override public String marshall(Object obj) {
        if (obj == null)
            return "";

        Map<String, Object> ctx = new HashMap<>();

        if (!types.containsKey(obj))
            return types.get(Object.class).format(obj, this, ctx);

        return types.get(obj.getClass()).format(obj, this, ctx);
    }

    @Override public <T> boolean addType(Class<T> clazz, JSONTypeFormatter<T> format) {
        return false;
    }
}
