package ru.sbt.jschool.session5.problem2.formatters;

import ru.sbt.jschool.session5.problem2.JSONFormatterImpl;
import ru.sbt.jschool.session5.problem2.JSONTypeFormatter;

import java.util.List;
import java.util.Map;

public class ListFormatter implements JSONTypeFormatter<List> {

    @Override
    public String format(List list, JSONFormatter formatter, Map<String, Integer> ctx) {
        Object[] objects = list.toArray();


        return new JSONFormatterImpl().arrayToString(objects,ctx);


    }
}
