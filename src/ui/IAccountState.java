package ui;

import java.awt.Color;

public interface IAccountState {
    double getBalance();
    double getMiles();
    String getStatus();
    String getLastAction();
    Color getStatusColor();
}
