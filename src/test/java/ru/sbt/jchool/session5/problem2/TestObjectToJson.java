package ru.sbt.jchool.session5.problem2;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import ru.sbt.jchool.session5.problem2.classesforhelp.*;
import ru.sbt.jschool.session5.problem2.JSONFormatterImpl;
import ru.sbt.jschool.session5.problem2.ObjectToJsonExViaJacksonToCheck;
import ru.sbt.jschool.session5.problem2.data.Animal;
import ru.sbt.jschool.session5.problem2.data.Cat;
import ru.sbt.jschool.session5.problem2.data.Dog;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestObjectToJson {


    @Test
    public void testCat() throws JsonProcessingException {
        Cat catNAMe = new Cat("CatNAMe");
 catNAMe.setAge(23);
        assertEquals("{\n" +
                "  \"age\" : 23,\n" +
                "  \"name\" : \"CatNAMe\"\n" +
                "}", new JSONFormatterImpl().marshall(catNAMe));


        System.out.println( new JSONFormatterImpl().marshall(catNAMe));


        System.out.println("\n");



    }


    @Test
    public void testDog() throws JsonProcessingException {
        Dog dogName = new Dog("DogName");
        dogName.setBread("sd");
        assertEquals("{\n" +
                "  \"bread\" : \"sd\",\n" +
                "  \"name\" : \"DogName\"\n" +
                "}", new JSONFormatterImpl().marshall(dogName));
        System.out.println(new JSONFormatterImpl().marshall(dogName));
        System.out.println("\n");


    }





        @Test
    public void testAccount(){
        String[] myStringArray = {"a", "b", "c"};
        List<String> skills = new ArrayList<>();
        {
            skills.add("java");
            skills.add("python");
        }
        Date date = new Date();
        Account er = new Account(2, 3, 4, 34, myStringArray, skills);
        assertEquals("{\n" +
                "  \"clientID\" : 2,\n" +
                "  \"accountID\" : 3,\n" +
                "  \"bankID\" : 4,\n" +
                "  \"balance\" : 34.0,\n" +
                "  \"array\" : [\n" +
                "    \"a\",\n" +
                "    \"b\",\n" +
                "    \"c\"\n" +
                "  ]\n" +
                "  \"skills\" : [\n" +
                "    \"java\",\n" +
                "    \"python\"\n" +
                "  ]\n" +
                "}", new JSONFormatterImpl().marshall(er));
            System.out.println( new JSONFormatterImpl().marshall(er));
            System.out.println("\n");
        }



    @Test
    public void testWithDateAndCalendar() throws JsonProcessingException {


        DateAndCalendar dateAndCalendar = new DateAndCalendar();
        dateAndCalendar.calendar.setTime(dateAndCalendar.date);

        assertEquals("{\n" +
                        "  \"date\" : \"10.04.2018\",\n" +
                        "  \"calendar\" : \"10.04.2018\"\n" +
                        "}",
                new JSONFormatterImpl().marshall(dateAndCalendar));
        System.out.println( new JSONFormatterImpl().marshall(dateAndCalendar));
        System.out.println("\n");


    }


    @Test
    public void testString() throws JsonProcessingException {

        String as = "ASD";
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(as), new JSONFormatterImpl().marshall(as));
        System.out.println( new JSONFormatterImpl().marshall(as));
        System.out.println("\n");


    }

    @Test
    public void testDate() throws JsonProcessingException {

        Date date = new Date();
        assertEquals(new ObjectToJsonExViaJacksonToCheck().objToJson(date), new JSONFormatterImpl().marshall(date));
        System.out.println( new JSONFormatterImpl().marshall(date));
        System.out.println("\n");

    }



}
