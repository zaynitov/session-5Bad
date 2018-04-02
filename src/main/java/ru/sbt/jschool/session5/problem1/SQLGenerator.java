package ru.sbt.jschool.session5.problem1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class SQLGenerator {
    private List<String> columnNames = new ArrayList<>();
    private List<String> primaryKeysNames = new ArrayList<>();
    private String tableName;
    private List<String> totalFieldsNames = new ArrayList<>();


    public <T> String insert(Class<T> clazz) {
        if (primaryKeysNames.size()==0) {
            initAllNames(clazz);
        }

        StringBuilder result = new StringBuilder("INSERT INTO " + tableName + "(");
        for (String totalFieldsName : totalFieldsNames) {

            result.append(totalFieldsName + ", ");

        }
        result.delete(result.length() - 2, result.length()); //to remove last ", "
        result.append(") VALUES (");
        for (int i = 0; i < totalFieldsNames.size(); i++) {
            result.append("?, ");
        }
        result.delete(result.length() - 2, result.length()); //to remove last ", "
        result.append(")");


        return result.toString();
    }

    public <T> String update(Class<T> clazz) {

        if (primaryKeysNames.size()==0) {
            initAllNames(clazz);
        }
        StringBuilder result = new StringBuilder("UPDATE " + tableName + " SET ");

        for (String columnName : columnNames) {
            result.append(columnName + " = ?, ");
        }
        result.delete(result.length() - 2, result.length()); //to remove last ", "

        result.append(" WHERE ");
        for (String primaryKeysName : primaryKeysNames) {
            result.append(primaryKeysName + " = ? AND ");
        }
        result.delete(result.length() - 5, result.length()); //to remove last " AND "

        return result.toString();
    }


    public <T> String delete(Class<T> clazz)
    {
        if (primaryKeysNames.size()==0) {
            initAllNames(clazz);
        }

        StringBuilder result = new StringBuilder("DELETE FROM " + tableName + " WHERE ");
        for (String primaryKeysName : primaryKeysNames) {
            result.append(primaryKeysName + " = ? AND ");
        }
        result.delete(result.length() - 5, result.length()); //to remove last " AND "

        return result.toString();
    }


    public <T> String select(Class<T> clazz) {
        if (primaryKeysNames.size()==0) {
            initAllNames(clazz);
        }
        StringBuilder result = new StringBuilder("SELECT ");

        for (String columnName : columnNames) {
            result.append(columnName + ", ");
        }
        result.delete(result.length() - 2, result.length()); //to remove last ", "
        result.append(" FROM " + tableName + " WHERE ");

        for (String primaryKeysName : primaryKeysNames) {
            result.append(primaryKeysName + " = ? AND ");
        }
        result.delete(result.length() - 5, result.length()); //to remove last " AND "

        return result.toString();
    }


    public <T> void initAllNames(Class<T> clazz) {
        Field[] publicFields = clazz.getDeclaredFields();
        for (int i = 0; i < publicFields.length; i++) {

            Column column = publicFields[i].getAnnotation(Column.class);
            if (column != null) {
                if (column.name().equals("")) {
                    columnNames.add(publicFields[i].getName().toLowerCase());
                } else {
                    columnNames.add(column.name().toLowerCase());
                }
                totalFieldsNames.add(columnNames.get(columnNames.size() - 1));
                continue;
            }

            PrimaryKey primaryKey = publicFields[i].getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                if (primaryKey.name().equals("")) {
                    primaryKeysNames.add(publicFields[i].getName().toLowerCase());

                } else {
                    primaryKeysNames.add(column.name().toLowerCase());
                }
                totalFieldsNames.add(primaryKeysNames.get(primaryKeysNames.size() - 1));
            }
        }

        Table table = clazz.getAnnotation(Table.class);
        tableName = table.name();


    }


}

