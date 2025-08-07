package by.koval;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Ticket {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private LocalDate departure_date;
    private LocalTime departure_time;
    private LocalDate arrival_date;
    private LocalTime arrival_time;
    private String carrier;
    private Integer stops;
    private Integer price;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
    }

    public LocalTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalTime departure_time) {
        this.departure_time = departure_time;
    }

    public LocalDate getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(LocalDate arrival_date) {
        this.arrival_date = arrival_date;
    }

    public LocalTime getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(LocalTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;
        return Objects.equals(getOrigin(), ticket.getOrigin()) && Objects.equals(getOrigin_name(), ticket.getOrigin_name()) && Objects.equals(getDestination(), ticket.getDestination()) && Objects.equals(getDestination_name(), ticket.getDestination_name()) && Objects.equals(getDeparture_date(), ticket.getDeparture_date()) && Objects.equals(getDeparture_time(), ticket.getDeparture_time()) && Objects.equals(getArrival_date(), ticket.getArrival_date()) && Objects.equals(getArrival_time(), ticket.getArrival_time()) && Objects.equals(getCarrier(), ticket.getCarrier()) && Objects.equals(getStops(), ticket.getStops()) && Objects.equals(getPrice(), ticket.getPrice());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getOrigin());
        result = 31 * result + Objects.hashCode(getOrigin_name());
        result = 31 * result + Objects.hashCode(getDestination());
        result = 31 * result + Objects.hashCode(getDestination_name());
        result = 31 * result + Objects.hashCode(getDeparture_date());
        result = 31 * result + Objects.hashCode(getDeparture_time());
        result = 31 * result + Objects.hashCode(getArrival_date());
        result = 31 * result + Objects.hashCode(getArrival_time());
        result = 31 * result + Objects.hashCode(getCarrier());
        result = 31 * result + Objects.hashCode(getStops());
        result = 31 * result + Objects.hashCode(getPrice());
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "origin='" + origin + '\'' +
                ", origin_name='" + origin_name + '\'' +
                ", destination='" + destination + '\'' +
                ", destination_name='" + destination_name + '\'' +
                ", departure_date=" + departure_date +
                ", departure_time=" + departure_time +
                ", arrival_date=" + arrival_date +
                ", arrival_time=" + arrival_time +
                ", carrier='" + carrier + '\'' +
                ", stops=" + stops +
                ", price=" + price +
                '}';
    }
}
