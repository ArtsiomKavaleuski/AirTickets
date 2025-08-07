package by.koval;

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class JsonFileReader {
    public Set<Ticket> getTicketsFromJson (String fileName) {
        Set<Ticket> tickets = new HashSet<Ticket>();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new CustomDateTimeAdapter())
                .registerTypeAdapter(LocalTime.class, new CustomDateTimeAdapter())
                .create();

        try (FileReader reader = new FileReader(fileName)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
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
