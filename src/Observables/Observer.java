package Observables;

import Observables.Observable;

public interface Observer {
    void update(Observable obj, Object arg);
}
