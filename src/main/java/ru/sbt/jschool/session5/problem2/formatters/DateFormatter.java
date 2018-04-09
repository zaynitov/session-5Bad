package ru.sbt.jschool.session5.problem2.formatters;

import ru.sbt.jschool.session5.problem2.JSONTypeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DateFormatter implements JSONTypeFormatter<Date> {
    @Override
    public String format(Date date, JSONFormatter formatter, Map<String, Integer> ctx) {
        return  "\"" + new SimpleDateFormat("dd.MM.yyyy").format(date)
                + "\"";

    }
}
