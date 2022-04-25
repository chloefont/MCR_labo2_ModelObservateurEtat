package Flights;

import Flights.Flight;
import Flights.Ticket;

public class FirstClassTicket extends Ticket {

    public FirstClassTicket(Flight flight) {
        super("FirstClass", 5, 30, flight);
    }
}
