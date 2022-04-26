package observables;

/**
 * Represent an observer object.
 */
public interface Observer {
    /**
     * Indicate to the object that an observable object has changed.
     * @param obj the observable object.
     */
    void update(Observable obj);
}
