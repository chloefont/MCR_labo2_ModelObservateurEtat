package ui;

import Flights.Flight;

public interface ITicket {
    double getPriceMiles();
    double getPriceCash();
    String toString();
    Flight getFlight();
}
