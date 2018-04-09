package ru.sbt.jschool.session5.problem2;

import java.lang.reflect.Field;
import java.util.*;

public class JSONFormatterImpl implements JSONFormatter {
    private Map<Class, JSONTypeFormatter> types = new HashMap<>();

    public JSONFormatterImpl() {
        types.put(Date.class, new DateFormatter());
        types.put(Calendar.class, new DateFormatter());
        types.put(String.class, new StringFormatter());
        types.put(ArrayList.class, new ListFormatter());
        types.put(LinkedList.class, new ListFormatter());
        types.put(HashSet.class, new SetFormatter());
        types.put(TreeSet.class, new SetFormatter());
        types.put(Short.class, new NumberFormatter());
        types.put(Integer.class, new NumberFormatter());
        types.put(Long.class, new NumberFormatter());
        types.put(Double.class, new NumberFormatter());
        types.put(Float.class, new NumberFormatter());
    }

    @Override
    public String marshall(Object obj) {
        StringBuilder resultString = new StringBuilder("{");

        if (obj == null)
            return "";

        if (obj.getClass().isArray()) {
            return arrayToString((Object[]) obj);
        }

        Map<String, Object> ctx = new HashMap<>();

        if (types.containsKey(obj))
        {  System.out.println("!!!!!!!!!!!");
            return types.get(obj.getClass()).format(obj, this, ctx);}

        Class className = obj.getClass();

        while (className != null) {
            try {
                for (Field field : className.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (value != null) {
                        resultString.append("\"" + field.getName() + "\":");


                        if (value.getClass().isArray()) {
                            resultString.append(arrayToString((Object[]) value));
                            new JSONFormatterImpl()
                        }

                        if (types.containsKey(value.getClass())) {
                            resultString.append(types.get(value.getClass()).format(value, this, ctx));
                            resultString.append(",");

                        }


                    }
                }
                className = className.getSuperclass();

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return resultString.toString();
    }


    @Override
    public <T> boolean addType(Class<T> clazz, JSONTypeFormatter<T> format) {
        return false;
    }


    public String arrayToString(Object[] arrayToString, JSONFormatter jsonFormatter) {
        StringBuilder resultTermString = new StringBuilder("[");


        for (int i = 0; i < arrayToString.length; i++) {
            if (i == (arrayToString.length - 1)) {
                resultTermString.append("\"" +
                        marshall()
                        arrayToString[i].toString()

                        + "\"]");
                break;
            }
            resultTermString.append("\"" + arrayToString[i].toString() + "\",");

        }
        resultTermString.append(",");
        return resultTermString.toString();
    }
}
