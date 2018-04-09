package ru.sbt.jschool.session5.problem2;

import ru.sbt.jschool.session5.problem2.formatters.JSONFormatter;

import java.util.Map;

public interface JSONTypeFormatter<T> {
    String format(T t, JSONFormatter formatter, Map<String, Integer> ctx);
}
