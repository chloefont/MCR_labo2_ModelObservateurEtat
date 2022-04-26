package ui;

import observables.IObservable;

public interface IClient extends IObservable {
    int getId();
    String getLastName();
    String getFirstName();
    IAccountState getAccountState();
}
