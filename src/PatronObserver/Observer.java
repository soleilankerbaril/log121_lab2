package PatronObserver;

/**
 * Observer interface of the observer pattern
 */
public interface Observer {
    /**
     * generic function to be called through inheritance
     * to update the state of the views
     */
    public void update();
}
