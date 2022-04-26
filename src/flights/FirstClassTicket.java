package flights;

/**
 * Represent a first class ticket to a flight
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
class FirstClassTicket extends Ticket {

    FirstClassTicket(Flight flight) {
        super("FirstClass", 5, 30, flight);
    }
}
