package Model;

import Actions.Memento;

import PatronObserver.Subject;

import java.awt.*;

/**
 * Perspective inherites the Subject class of the observer design pattern
 * as well as represents a model of the MVC architecture
 */
public class Perspective extends Subject {
	
    public double zoom;
    public Point position;

    public Perspective(){
        zoom = 1;
        position = new Point(0,0);
    }

    public Perspective(double zoom, int positionX,  int positionY){
        this.zoom = zoom;
        this.position = new Point(positionX,positionY);
    }

    protected Perspective clone(){
        return new Perspective(zoom, position.x, position.y);
    }

    /**
     * sets the perspective of a Perspective object from a state saved in a momento object
     * @param memento
     */
    public void setPerspectiveFromMemento(Memento memento){
        zoom = memento.perspective.zoom;
        position.setLocation(memento.perspective.position);
        notifyObservers();
    }

    /**
     * @return created momento
     */
    public Memento createMemento(){
        return new Memento(clone());
    }
}
