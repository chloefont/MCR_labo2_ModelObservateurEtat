package flights;

/**
 * Represent a business class ticket to a flight
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
public class BusinessTicket extends Ticket {
    public BusinessTicket(Flight flight) {
        super("Business", 2, 5, flight);
    }
}
