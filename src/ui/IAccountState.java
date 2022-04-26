package ui;

import java.awt.Color;

public interface IAccountState {
    double getBalance();
    double getMiles();
    String getStatus();
    String getLastAction();
    Color getStatusColor();
    void deposit(double amount);
    boolean bookCash(ITicket t);
    boolean bookMiles(ITicket t);
}
