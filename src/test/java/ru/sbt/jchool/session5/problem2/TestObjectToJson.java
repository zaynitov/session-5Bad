package ru.sbt.jchool.session5.problem2;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import ru.sbt.jchool.session5.problem2.classesforhelp.*;
import ru.sbt.jschool.session5.problem2.JSONFormatterImpl;
import ru.sbt.jschool.session5.problem2.ObjectToJsonExViaJacksonToCheck;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestObjectToJson {


    @Test
    public void testAccount() throws JsonProcessingException {
        String[] myStringArray = {"a", "b", "c"};
        List<String> skills = new ArrayList<>();
        {
            skills.add("java");
            skills.add("python");
        }
        Date date = new Date();
        Account er = new Account(2, 3, 4, 34, myStringArray, skills);
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(er), new JSONFormatterImpl().marshall(er));
    }

    @Test
    public void testWithInheritance() throws JsonProcessingException {

        Set subSet = new HashSet<String>();
        subSet.add("aSD");
        subSet.add("OSIDPOAIUFINSAFKL");

        SubA subA = new SubA();
        subA.setSubSet(subSet);
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(subA), new JSONFormatterImpl().marshall(subA));


    }

    @Test
    public void testWithDateAndCalendar() throws JsonProcessingException {


        DateAndCalendar dateAndCalendar = new DateAndCalendar();
        dateAndCalendar.calendar.setTime(dateAndCalendar.date);

        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(dateAndCalendar), new JSONFormatterImpl().marshall(dateAndCalendar));


    }

    @Test
    public void testEmptyObject() {

        assertEquals("{}", new JSONFormatterImpl().marshall(null));

    }

    @Test
    public void testArray() throws JsonProcessingException {

        String[] arrayString = {"sdf", "SE"};
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(arrayString), new JSONFormatterImpl().marshall(arrayString));

    }

    @Test
    public void testString() throws JsonProcessingException {

        String as = "ASD";
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(as), new JSONFormatterImpl().marshall(as));

    }

    @Test
    public void testDate() throws JsonProcessingException {

        Date date = new Date();
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(date), new JSONFormatterImpl().marshall(date));

    }

}
