package ui;

import Observables.IObservable;
import Observables.Observable;

public interface IClient extends IObservable {
    int getId();
    String getLastName();
    String getFirstName();
    IAccountState getAccountState();
}
