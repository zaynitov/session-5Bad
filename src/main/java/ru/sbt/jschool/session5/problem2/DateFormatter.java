package ru.sbt.jschool.session5.problem2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DateFormatter implements JSONTypeFormatter<Date> {
    @Override
    public String format(Date date, JSONFormatter formatter, Map<String, Object> ctx) {
        StringBuilder resultTermString = new StringBuilder();
        resultTermString.append("\"" + new SimpleDateFormat("dd.MM.yyyy").format(date) + "\"" + ",");
        return resultTermString.toString();
    }
}
