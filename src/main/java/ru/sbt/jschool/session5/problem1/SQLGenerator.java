package ru.sbt.jschool.session5.problem1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 */
public class SQLGenerator {
    public <T> String insert(Class<T> clazz) {
      return null;
    }

    public <T> String update(Class<T> clazz) {
        return null;
    }

    public <T> String delete(Class<T> clazz) {
        return null;
    }

    public <T> String select(Class<T> clazz) {

        StringBuilder result = new StringBuilder("");
        result.append("SELECT ");



        Field[] asd = HashMap.class.getFields();
        for (Field field : asd) {
            Class fieldType = field.getType();
            System.out.println("Имя: " + field.getName());
            System.out.println("Тип: " + fieldType.getName());
        }









        Field[] publicFields = clazz.getFields();

        for (Field publicField : publicFields) {

        }

        for (int i = 0; i < publicFields.length; i++) {

            if (i == (publicFields.length - 1)) {
                result.append(publicFields[i] + " ");
                break;
            }
            result.append(publicFields[i] + ", ");
        }

        result.append("FROM ");


        for (Field f : publicFields) {
            Column column = f.getAnnotation(Column.class);
            if (column != null) {
                result.append(column);
            }

        }

        result.append(" WHERE ");

        for (Field f : publicFields) {
            PrimaryKey primaryKey = f.getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                result.append(primaryKey + " = ?");
                result.append(" AND ");
            }

        }


        return result.toString();
    }
}
