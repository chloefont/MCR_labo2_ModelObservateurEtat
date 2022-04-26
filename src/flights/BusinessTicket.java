package flights;

/**
 * Represent a business class ticket to a flight
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
class BusinessTicket extends Ticket {
    BusinessTicket(Flight flight) {
        super("Business", 2, 5, flight);
    }
}
