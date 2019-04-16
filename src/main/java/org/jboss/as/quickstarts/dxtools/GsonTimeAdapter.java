package org.jboss.as.quickstarts.dxtools;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GsonTimeAdapter implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime> {

    private final DateTimeFormatter timeFormater;

    public GsonTimeAdapter() {
        timeFormater = DateTimeFormatter.ofPattern("H:mm");
    }
    @Override
    public synchronized JsonElement serialize(LocalTime time, Type type, JsonSerializationContext jsonSerializationContext){
        return new JsonPrimitive(timeFormater.format(time));
    }
    @Override public synchronized LocalTime deserialize(JsonElement jsonElement,Type type,JsonDeserializationContext jsonDeserializationContext) {
        try {
            return LocalTime.parse(jsonElement.getAsString(), timeFormater);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }

}
