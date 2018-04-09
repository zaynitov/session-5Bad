package ru.sbt.jschool.session5.problem2;

import java.util.Map;
import java.util.Set;

public class SetFormatter implements JSONTypeFormatter<Set> {

    @Override
    public String format(Set set, JSONFormatter formatter, Map<String, Object> ctx) {
        Object[] objects = set.toArray();


        return new JSONFormatterImpl().arrayToString(objects);


    }
}



