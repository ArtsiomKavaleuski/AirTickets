package by.koval;

import com.google.gson.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFileReader {
    public List<Ticket> getTicketsFromJson() {
        List<Ticket> tickets = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new CustomDateTimeAdapter())
                .registerTypeAdapter(LocalTime.class, new CustomDateTimeAdapter())
                .create();

        try (InputStream inputStream = JsonFileReader.class.getResourceAsStream("/tickets.json");) {
            if (inputStream == null) {
                throw new RuntimeException("JSON файл не найден");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            JsonObject jsonObject = gson.fromJson(content, JsonObject.class);
            JsonElement ticketsElement = jsonObject.get("tickets");
            for (JsonElement ticketElement : ticketsElement.getAsJsonArray()) {
                tickets.add(gson.fromJson(ticketElement, Ticket.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
