package ru.sbt.jschool.session5.problem2.formatters;

import ru.sbt.jschool.session5.problem2.JSONFormatterImpl;
import ru.sbt.jschool.session5.problem2.JSONTypeFormatter;

import java.util.Map;
import java.util.Set;

public class SetFormatter implements JSONTypeFormatter<Set> {

    @Override
    public String format(Set set, JSONFormatter formatter, Map<String, Integer> ctx) {
        Object[] objects = set.toArray();


        return new JSONFormatterImpl().arrayToString(objects,ctx);


    }
}



