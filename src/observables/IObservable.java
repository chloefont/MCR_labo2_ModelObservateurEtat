package Observables;

public interface IObservable {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
