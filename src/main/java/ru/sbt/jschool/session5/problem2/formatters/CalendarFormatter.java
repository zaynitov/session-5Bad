package ru.sbt.jschool.session5.problem2.formatters;

import ru.sbt.jschool.session5.problem2.JSONTypeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class CalendarFormatter implements JSONTypeFormatter<Calendar> {
    @Override
    public String format(Calendar calendar, JSONFormatter formatter, Map<String, Integer> ctx) {
        return  ("\"" + new SimpleDateFormat("dd.MM.yyyy").
                format(calendar.getTime()) + "\"");
    }
}
