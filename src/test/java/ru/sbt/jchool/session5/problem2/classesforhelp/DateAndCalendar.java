package ru.sbt.jchool.session5.problem2.classesforhelp;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Calendar;
import java.util.Date;

public class DateAndCalendar {
    public  Date date = new Date();
    public  Calendar calendar = Calendar.getInstance();

    public Date getDate() {
        return date;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
