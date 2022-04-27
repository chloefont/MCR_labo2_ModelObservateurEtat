package flights;

import account.Client;
import ui.IFlight;

import java.util.Arrays;

/**
 * Flights.Flight Object
 *
 * <p>Represents a flight for which clients can buy a ticket</p>
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class Flight implements IFlight {
    // Name of the flight
    private String name;
    // Distance in miles traveled during this flight
    private double distance;
    // Base price of this flight
    private double price;

    // Ticket types available for this flight
    private Ticket[] tickets = {
            new EconomyTicket(this),
            new BusinessTicket(this),
            new FirstClassTicket(this)
    };
    
    /**
     * Creates a new flight
     * @param name name of the flight
     * @param distance distance in miles traveled during this flight
     * @param price base price of this flight
     */
    public Flight(String name, double distance, double price) {
        this.name = name;
        this.distance = distance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + distance + " miles)";
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, tickets.length);
    }
}
