package ru.sbt.jschool.session5.problem2;

import java.util.List;
import java.util.Map;

public class ListFormatter implements JSONTypeFormatter<List> {

    @Override
    public String format(List list, JSONFormatter formatter, Map<String, Object> ctx) {
        Object[] objects = list.toArray();


        return new JSONFormatterImpl().arrayToString(objects);


    }
}
