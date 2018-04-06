package ru.sbt.jschool.session5.problem2;


import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    public String toJSON(Object someObject) {


        StringBuilder resultString = new StringBuilder("{");
        Class className = someObject.getClass();
        JSONHelper jsonHelper = new JSONHelper();

        if (jsonHelper.classesWeCannSupport.contains(className)||className.isArray()) {
            resultString.append(jsonHelper.toJSON("", someObject));

            resultString.delete(0,4);       //delete smth what we don't need to make the same as Jackson
            return resultString.delete(resultString.length()-1,resultString.length()).toString();
        } else {
            while (className != null) {
                try {
                    for (Field field : className.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object value = field.get(someObject);
                        if (value != null) {
                            resultString.append(jsonHelper.toJSON(field.getName(), value));
                        }
                    }
                    className = className.getSuperclass();

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        if (resultString.toString().endsWith(",")) {
            resultString.replace(resultString.length() - 1, resultString.length(), "}");
        } else {
            resultString.append("}");
        }
        return resultString.toString();
    }

}
