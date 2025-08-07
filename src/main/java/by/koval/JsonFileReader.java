package by.koval;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonFileReader {
    public List<Ticket> getTicketsFromJson (String fileName) {
        List<Ticket> tickets = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new CustomDateTimeAdapter())
                .registerTypeAdapter(LocalTime.class, new CustomDateTimeAdapter())
                .create();
        boolean fileFound = false;

        while (!fileFound) {
            try (FileReader reader = new FileReader(fileName)) {
                fileFound = true;
                JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
                JsonElement ticketsElement = jsonObject.get("tickets");
                for (JsonElement ticketElement : ticketsElement.getAsJsonArray()) {
                    tickets.add(gson.fromJson(ticketElement, Ticket.class));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл tickets.json не найден: " + fileName
                        + ". Убедитесь, что файл находится в папке resources и нажмите Enter или укажите путь к файлу вручную: ");
                String input = new Scanner(System.in).nextLine();
                if (new File(input).exists()) {
                    fileName = input;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return tickets;

    }
}
