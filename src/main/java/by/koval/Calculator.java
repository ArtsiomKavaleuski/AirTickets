package by.koval;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    public static List<Ticket> getTicketsFilteredOriginDest(List<Ticket> tickets, String origin, String destination) {
        return tickets.stream()
                .filter(t -> t.getOrigin().equals(origin) && t.getDestination().equals(destination))
                .toList();
    }

    public static List<Ticket> getTicketsWithMinTimeOfEachCarrier(List<Ticket> tickets) {
        List<Ticket> minTimeTickets = new ArrayList<>();
        List<String> carriers = tickets.stream().map(Ticket::getCarrier).distinct().toList();
        for (String carrier : carriers) {
            minTimeTickets.add(tickets.stream()
                    .filter(t -> t.getCarrier().equals(carrier))
                    .min(Comparator.comparing(Calculator::getDuration)).orElse(null));
        }
        return minTimeTickets;
    }

    public static Double getAveragePrice(List<Ticket> tickets) {
        return (double) tickets.stream()
                .map(Ticket::getPrice)
                .mapToInt(Integer::intValue)
                .sum() / tickets.size();
    }

    public static Double getMedianPrice(List<Ticket> tickets) {
        List<Integer> prices = tickets.stream()
                .map(Ticket::getPrice)
                .sorted()
                .toList();
        int size = prices.size();
        if (size % 2 == 0) {
            return (prices.get(size / 2 - 1) + prices.get(size / 2)) / 2.0;
        } else {
            return (double) prices.get(size / 2);
        }
    }

    public static Duration getDuration(Ticket ticket) {
        return Duration.between(LocalDateTime.of(ticket.getDeparture_date(), ticket.getDeparture_time()), LocalDateTime.of(ticket.getArrival_date(), ticket.getArrival_time()));
    }
}
