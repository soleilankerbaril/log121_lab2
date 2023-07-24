package Model;

import Actions.Memento;

import PatronObserver.Subject;

import java.awt.*;

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

    public Perspective clone(){
        return new Perspective(zoom, position.x, position.y);
    }

    public void setPerspectiveFromMemento(Memento memento){
        zoom = memento.perspective.zoom;
        position.setLocation(memento.perspective.position);
        notifyObservers();
    }

    public Memento createMemento(){
        return new Memento(clone());
    }
}
