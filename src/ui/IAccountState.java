package ui;

import java.awt.Color;

/**
 * Represent an account
 */
public interface IAccountState {
    double getBalance();
    double getMiles();
    String getStatus();
    String getLastAction();
    Color getStatusColor();
    void deposit(double amount);
    void bookCash(ITicket t);
    void bookMiles(ITicket t);
}
