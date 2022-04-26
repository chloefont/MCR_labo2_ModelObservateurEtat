package ui;

import Flights.Ticket;

public interface IFlight {
    String getName();

    double getDistance();

    double getPrice();

    String toString();

    Ticket[] getTickets();
}
