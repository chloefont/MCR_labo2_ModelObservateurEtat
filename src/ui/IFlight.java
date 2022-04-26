package ui;

import flights.Ticket;

/**
 * Represent a ticket to a flight that can be bought by a client
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
public interface IFlight {
    /**
     * Get the name of the flight
     * @return the name of the flight
     */
    String getName();

    /**
     * Get the distance of the flight
     * @return the distance of the flight
     */
    double getDistance();

    /**
     * Get the price of the flight
     * @return the price of the flight
     */
    double getPrice();

    String toString();

    /**
     * Get the type of tickets available for this flight
     * @return the type of tickets available for this flight
     */
    Ticket[] getTickets();
}
