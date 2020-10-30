package myWorkDir.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;
import java.util.Random;


public class DataUtils {

    protected static Configuration createJsonPathConfiguration() {
        return new Configuration.ConfigurationBuilder()
                .jsonProvider(new GsonJsonProvider())
                .mappingProvider(new GsonMappingProvider())
                .build();
    }


    public static String getValueFromJsonAsString(String json, String jsonPath) {
        Gson gsonObject = new Gson();
        ReadContext ctx = JsonPath.parse(json, createJsonPathConfiguration());
        boolean error = false;
            try {
                JsonElement jsonElement = gsonObject.toJsonTree(ctx.read(jsonPath));
                return jsonElement.getAsString();
            } catch (PathNotFoundException e) {
                error = true;
        }
        if (error)
            throw new RuntimeException("В json не найдено значение по заданному jsonpath");
        return null;
    }

    public static JsonArray getValueFromJsonAsJsonArray(String json, String jsonPath) {
        Gson gsonObject = new Gson();
        ReadContext ctx = JsonPath.parse(json, createJsonPathConfiguration());
        boolean error = false;
        try {
            JsonElement jsonElement = gsonObject.toJsonTree(ctx.read(jsonPath));
            return jsonElement.getAsJsonArray();
        } catch (PathNotFoundException e) {
            error = true;
        }
        if (error)
            throw new RuntimeException("В json не найдено значение по заданному jsonpath");
        return null;
    }

}
