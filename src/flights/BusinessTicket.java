package flights;

public class BusinessTicket extends Ticket {
    public BusinessTicket(Flight flight) {
        super("Business", 2, 5, flight);
    }
}
