package by.koval;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomDateTimeAdapter implements JsonDeserializer<Object> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("[H:mm][HH:mm]");

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (type == LocalDate.class) {
            return LocalDate.parse(jsonElement.getAsString(), DATE_FORMATTER);
        }
        if (type == LocalTime.class) {
            return LocalTime.parse(jsonElement.getAsString(), TIME_FORMATTER);
        }
        return null;
    }
}
