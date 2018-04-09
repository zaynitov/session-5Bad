package ru.sbt.jschool.session5.problem2;
import java.util.Map;

public class StringFormatter implements JSONTypeFormatter<String> {

    @Override
    public String format(String s, JSONFormatter formatter, Map<String, Object> ctx) {
        return ("\"" + s.toString() + "\"");
    }
}
