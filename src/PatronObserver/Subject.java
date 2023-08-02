package PatronObserver;

import java.util.ArrayList;

/**
 * Subject parent class of the observer pattern
 */
public class Subject {
    ArrayList<Observer> observers;

    public Subject() {
        observers = new ArrayList<Observer>();
    }

    /**
     * Adds an observer to a list of observer that are
     * to be updated upon the subject being modified
     * @param o Observer
     */
    public void attach(Observer o){
        observers.add(o);
    }

    /**
     * removes an observer from the list of observer that are
     * to be updated upon the subject being modified
     * @param o Observer
     */
    public  void dettach(Observer o){
        observers.remove(o);
    }

    /**
     * iterates through the observer list and calls their respected update functions
     */
    public void notifyObservers(){
        for(Observer o: observers) {
            o.update();
        }
    }
}
