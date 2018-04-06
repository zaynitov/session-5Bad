package ru.sbt.jschool.session5.problem2;


import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    public String toJSON(Object someObject) {


        StringBuilder resultString = new StringBuilder("{");
        Class className = someObject.getClass();

        if (className.isArray()||className == Double.class || className == Float.class || className == Long.class ||
                className == Integer.class || className == Short.class || className == Character.class ||
                className == Byte.class || className == Boolean.class || className == Set.class || className == List.class ||
                className == Date.class || className == Calendar.class || className == String.class) {
            resultString.append(toJSONObj("", someObject));

            resultString.delete(0,4);       //delete smth what we don't need to make the same as Jackson
            return resultString.delete(resultString.length()-1,resultString.length()).toString();
        } else {
            while (className != null) {
                try {
                    for (Field field : className.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object value = field.get(someObject);
                        if (value != null) {
                            resultString.append(toJSONObj(field.getName(), value));
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


    public String toJSONObj(String fieldName, Object field) {
        StringBuilder resultTermString = new StringBuilder();

        if ((field instanceof List)) {
            Object[] objects = ((List) field).toArray();
            return arrayToString(fieldName, objects).toString();

        }
        if ((field instanceof Set)) {
            Object[] objects = ((Set) field).toArray();
            return arrayToString(fieldName, objects);


        }
        if (field.getClass().isArray()) {
            return arrayToString(fieldName, (Object[]) field);
        }
        if ((field instanceof Date)) {
            resultTermString.append("\"" + fieldName + "\":");
            resultTermString.append("\"" + new SimpleDateFormat("dd.MM.yyyy").format(field) + "\"" + ",");
            return resultTermString.toString();


        }
        if ((field instanceof Calendar)) {
            Date date = ((Calendar) field).getTime();
            resultTermString.append("\"" + fieldName + "\":");
            resultTermString.append("\"" + new SimpleDateFormat("dd.MM.yyyy").format(date) + "\"" + ",");
            return resultTermString.toString();
        }


        Class type = field.getClass();
        //	isPrimitiveWrapper(Class<?> type) from Apache.smth.* doesn't work(don't know why(i used dependencies)) So:
        if (type == Double.class || type == Float.class || type == Long.class ||
                type == Integer.class || type == Short.class || type == Character.class ||
                type == Byte.class || type == Boolean.class) {
            return ("\"" + fieldName + "\":" + field.toString() + ",");
        }
        if (type == String.class) return ("\"" + fieldName + "\":" + "\"" + field.toString() + "\"" + ",");


        return newClasstoJSON(fieldName, field); //Here we put new Logic for formatting new Classes

    }

    public String arrayToString(String fieldName, Object[] arrayToString) {
        StringBuilder resultTermString = new StringBuilder();


        resultTermString.append("\"" + fieldName + "\"" + ":[");

        for (int i = 0; i < arrayToString.length; i++) {
            if (i == (arrayToString.length - 1)) {
                resultTermString.append("\"" + arrayToString[i].toString() + "\"]");
                break;
            }
            resultTermString.append("\"" + arrayToString[i].toString() + "\",");

        }
        resultTermString.append(",");
        return resultTermString.toString();
    }

    public String newClasstoJSON(String fieldName, Object field) {
//TODO
        return "";
    }

}
