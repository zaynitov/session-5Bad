package ru.sbt.jschool.session5.problem2;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class JSONHelper {
    Set<Class> classesWeCannSupport = new HashSet();

    public JSONHelper() {
        classesWeCannSupport.add(Array.class);
        classesWeCannSupport.add(Double.class);
        classesWeCannSupport.add(Float.class);
        classesWeCannSupport.add(String.class);
        classesWeCannSupport.add(Long.class);
        classesWeCannSupport.add(Integer.class);
        classesWeCannSupport.add(Short.class);
        classesWeCannSupport.add(Character.class);
        classesWeCannSupport.add(Byte.class);
        classesWeCannSupport.add(Boolean.class);
        classesWeCannSupport.add(Set.class);
        classesWeCannSupport.add(List.class);
        classesWeCannSupport.add(Date.class);
        classesWeCannSupport.add(Calendar.class);
        classesWeCannSupport.add(String.class);
    }

    public void addNewClass(Class clazz) {
        classesWeCannSupport.add(clazz);

    }


    public String toJSON(String fieldName, Object field) {
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

        if (!classesWeCannSupport.contains(field.getClass())) {
            System.out.println("You should add transformToJSON Logic at method addNewClass");
        }
        return null;
        //Here we put new Logic for JSONTransformation for  new Classes
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



}
