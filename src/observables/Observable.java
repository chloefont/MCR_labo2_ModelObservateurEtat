package observables;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of an observable object.
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
public abstract class Observable implements IObservable{
    // List of observers
    private List<Observer> observers = new ArrayList<>();
    /**
     * Attaches an observer to the observable object.
     * @param o the observer to attach.
     */
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     * Detaches an observer from the observable object.
     * @param o the observer to detach.
     */
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifies all the observers of the observable object.
     */
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(this);
        }
    }
}
