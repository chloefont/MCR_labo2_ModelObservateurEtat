package ui;

import flights.Ticket;

/**
 * Represent a ticket to a flight that can be bought by a client
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
public interface IFlight {

    String getName();
    double getDistance();
    double getPrice();
    String toString();
    Ticket[] getTickets();
}
