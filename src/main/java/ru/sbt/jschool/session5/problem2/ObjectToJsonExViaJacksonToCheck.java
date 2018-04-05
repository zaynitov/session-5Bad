package ru.sbt.jschool.session5.problem2;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ObjectToJsonExViaJacksonToCheck {

    public String objToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr=null;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        mapper.setDateFormat(df);
        try {
            jsonStr = mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;

    }

}
