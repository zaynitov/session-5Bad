package ru.sbt.jschool.session5.problem2;

import java.util.Map;

public class NumberFormatter implements JSONTypeFormatter<Number> {
    @Override
    public String format(Number number, JSONFormatter formatter, Map<String, Object> ctx) {
        return ( number.toString());
    }
}
