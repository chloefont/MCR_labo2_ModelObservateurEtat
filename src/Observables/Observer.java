package Observables;

import Observables.Observable;
/**
 * Represent an observer object.
 */
public interface Observer {
    /**
     * Indicate to the object that an observable object has changed.
     * @param o the observable object.
     */
    void update(Observable obj);
}
