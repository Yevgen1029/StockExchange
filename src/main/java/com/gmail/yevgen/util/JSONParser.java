package com.gmail.yevgen.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class JSONParser<T> {
    public T getObject(Class<T> tClass, String urlString) {
        ObjectMapper mapper = new ObjectMapper();
//        Companies companies = null;
        T t = null;
        try {
            System.out.println(urlString);
            URL url = new URL(urlString);
            t = mapper.readValue(url, tClass);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
}
