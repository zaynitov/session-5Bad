package ru.sbt.jchool.session5.problem2;

import org.junit.Test;
import ru.sbt.jchool.session5.problem2.classesforhelp.Account;
import ru.sbt.jchool.session5.problem2.classesforhelp.Currency;
import ru.sbt.jchool.session5.problem2.classesforhelp.DateAndCalendar;
import ru.sbt.jchool.session5.problem2.classesforhelp.SubA;
import ru.sbt.jschool.session5.problem2.Main;
import ru.sbt.jschool.session5.problem2.ObjectToJsonExViaJacksonToCheck;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestObjectToJson {


    @Test
    public void testAccount() {
        String[] myStringArray = {"a", "b", "c"};
        List<String> skills = new ArrayList<>();
        {
            skills.add("java");
            skills.add("python");
        }
        Date date = new Date();
        Account er = new Account(2, 3, 4, Currency.EUR, 34, myStringArray, skills);
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(er), new Main().toJSON(er));
    }

    @Test
    public void testWithInheritance() {

        Set subSet = new HashSet<String>();
        subSet.add("aSD");
        subSet.add("OSIDPOAIUFINSAFKL");

        SubA subA = new SubA();
        subA.setSubSet(subSet);
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(subA), new Main().toJSON(subA));


    }

    @Test
    public void testWithDateAndCalendar() {



        DateAndCalendar dateAndCalendar = new DateAndCalendar();
        dateAndCalendar.calendar.setTime(dateAndCalendar.date);

        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(dateAndCalendar), new Main().toJSON(dateAndCalendar));


    }


}