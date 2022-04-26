package flights;

/**
 * Represent a economy class ticket to a flight
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
public class EconomyTicket extends Ticket {
    public EconomyTicket(Flight flight) {
        super("Economy", 1, 1, flight);
    }
}
