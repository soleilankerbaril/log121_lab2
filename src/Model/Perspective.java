package Model;

import Actions.Memento;

import java.awt.*;

public class Perspective {
    public int zoom;
    public Point position;

    public Perspective(){
        zoom = 100;
        position = new Point(0,0);
    }

    public Perspective(int zoom,int positionX,int positionY){
        this.zoom = zoom;
        this.position = new Point(positionX,positionY);
    }

    public Perspective clone(){
        return new Perspective(zoom, position.x, position.y);
    }

    public void setPerspectiveFromMemento(Memento memento){
        zoom = memento.perspective.zoom;
        position.setLocation(memento.perspective.position);
    }
}
