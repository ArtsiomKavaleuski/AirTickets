package by.koval;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Ticket> tickets = new JsonFileReader().getTicketsFromJson("src/main/resources/tickets.json");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}