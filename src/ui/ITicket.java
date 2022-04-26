package ui;

import flights.Flight;

public interface ITicket {
    double getPriceMiles();
    double getPriceCash();
    String toString();
    Flight getFlight();
}
