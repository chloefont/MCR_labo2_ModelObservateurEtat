package ui;

import observables.IObservable;

public interface IClient extends IObservable, Comparable<IClient> {
    int getId();
    String getLastName();
    String getFirstName();
    IAccountState getAccountState();
}
