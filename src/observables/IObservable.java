package observables;

/**
 * Represents an observable object.
 * @version 1.0
 * @author Luca Coduri
 * @author Chloé Fontaine
 */
public interface IObservable {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
