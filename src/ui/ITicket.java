package ui;

import flights.Flight;

/**
 * Represent a ticket to a flight that can be bought by a client
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
public interface ITicket {
    double getPriceMiles();
    double getPriceCash();
    String toString();
    Flight getFlight();
}
