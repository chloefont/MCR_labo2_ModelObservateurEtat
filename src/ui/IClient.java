package ui;

import Observables.IObservable;

public interface IClient extends IObservable {
    int getId();
    String getLastName();
    String getFirstName();
    IAccountState getAccountState();
}
