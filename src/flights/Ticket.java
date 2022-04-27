package flights;

import ui.ITicket;
import account.Client;

/**
 * Tickets.Flights.Ticket Object
 *
 * <p>Represents a ticket to a flight that can be bought by a client</p>
 * @see Flight
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public abstract class Ticket implements ITicket {
    // Name of the ticket type
    private final String name;
    // Coefficient by witch the price of the ticket is multiplied
    private final int priceCoefficient;
    // Coefficient by witch the miles of the ticket is multiplied
    private final int milesCoefficient;
    // Flight to which this ticket is associated
    private final Flight flight;

    /**
     * Creates a new ticket
     * @param name name of the ticket type
     * @param priceCoefficient coefficient by which the price of the ticket is multiplied
     * @param milesCoefficient coefficient by which the miles of the ticket is multiplied
     * @param flight flight to which this ticket is associated
     */
    protected Ticket(String name, int priceCoefficient, int milesCoefficient, Flight flight) {
        if (flight == null)
            throw new IllegalArgumentException("Flight must not be null");

        this.name = name;
        this.priceCoefficient = priceCoefficient;
        this.milesCoefficient = milesCoefficient;
        this.flight = flight;
    }

    /**
     * Get the price of the ticket in cash.
     */
    public double getPriceCash() {
        return flight.getPrice() * priceCoefficient;
    }

    /**
     * Get the price of the ticket in miles
     */
    public double getPriceMiles() {
        return flight.getPrice() * milesCoefficient;
    }

    /**
     * Display the ticket information (name and price)
     */
    @Override
    public String toString() {
        return name + " " + getPriceCash() + "$";
    }

    /**
     * Get the flight to which this ticket is associated
     */
    public Flight getFlight() {
        return flight;
    }
}
