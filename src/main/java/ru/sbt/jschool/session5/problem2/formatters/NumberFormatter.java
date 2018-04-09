package ru.sbt.jschool.session5.problem2.formatters;

import ru.sbt.jschool.session5.problem2.JSONTypeFormatter;

import java.util.Map;

public class NumberFormatter implements JSONTypeFormatter<Number> {
    @Override
    public String format(Number number, JSONFormatter formatter, Map<String, Integer> ctx) {
        return ( number.toString());

    }
}
