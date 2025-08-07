package by.koval;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int div = 120;
        List<Ticket> tickets = new JsonFileReader().getTicketsFromJson("src/main/resources/tickets.json");

        List<Ticket> filteredTickets = Calculator.getTicketsFilteredOriginDest(tickets, "VVO", "TLV");
        List<Ticket> minPriceTicketsForEachCarrier = Calculator.getTicketsWithMinTimeOfEachCarrier(filteredTickets);
        Double averagePrice = Calculator.getAveragePrice(filteredTickets);
        Double medianPrice = Calculator.getMedianPrice(filteredTickets);

        for (Ticket ticket : filteredTickets) {
            System.out.println(ticket);
            System.out.println(Calculator.getDuration(ticket).toHours() + " ч " + Calculator.getDuration(ticket).toMinutes() % 60 + " мин");
        }

        System.out.println("-".repeat(div));

        for (Ticket ticket : minPriceTicketsForEachCarrier) {
            System.out.println("У авиаперевозчика \"" + ticket.getCarrier()
                    + "\" минимальное время полета между городами \""
                    + ticket.getOrigin_name() + " - " + ticket.getDestination_name() + "\" составляет "
                    + Calculator.getDuration(ticket).toHours() + " ч "
                    + Calculator.getDuration(ticket).toMinutes() % 60 + " мин");
        }

        System.out.println("-".repeat(div));

        System.out.println("Средняя цена перелета между городами \"" + filteredTickets.getFirst().getOrigin_name()
                + " и " + filteredTickets.getFirst().getDestination_name() + "\" составляет " + averagePrice);
        System.out.println("Медианная цена перелета между городами \"" + filteredTickets.getFirst().getOrigin_name()
                + " и " + filteredTickets.getFirst().getDestination_name() + "\" составляет " + medianPrice);
        System.out.println("Разница между средней и медианной ценой - " + Math.abs(medianPrice - averagePrice));

        System.out.println("-".repeat(div));
    }
}