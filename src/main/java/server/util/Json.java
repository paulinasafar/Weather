package server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class Json {

    private static ObjectMapper myMapper = defaultObjectMapper();

    private static ObjectMapper defaultObjectMapper(){
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    public static JsonNode parse(String jsonSource) throws IOException {

            return myMapper.readTree(jsonSource);

    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return myMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object o) {
        return myMapper.valueToTree(o);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateJson(node, true);
    }

    public static String generateJson(Object o, boolean pretty) throws JsonProcessingException {
        ObjectWriter writer = myMapper.writer();
        if(pretty) {
            writer = writer.with(SerializationFeature.INDENT_OUTPUT);
        }
        return writer.writeValueAsString(o);
    }




}
