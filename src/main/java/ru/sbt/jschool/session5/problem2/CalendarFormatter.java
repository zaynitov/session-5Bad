package ru.sbt.jschool.session5.problem2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class CalendarFormatter implements JSONTypeFormatter<Calendar> {
    @Override
    public String format(Calendar calendar, JSONFormatter formatter, Map<String, Object> ctx) {
        return ("\"" + new SimpleDateFormat("dd.MM.yyyy").format(calendar) + "\"" + ",");
    }
}
