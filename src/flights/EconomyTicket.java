package flights;

/**
 * Represent a economy class ticket to a flight
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
class EconomyTicket extends Ticket {
    EconomyTicket(Flight flight) {
        super("Economy", 1, 1, flight);
    }
}
