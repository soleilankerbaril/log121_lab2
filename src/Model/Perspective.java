package Model;

import java.awt.*;

public class Perspective {
    Image image;
    public int zoom;
    public Point position;

    public Perspective(Image image){
        zoom = 100;
        position = new Point(0,0);
        this.image = image;
    }

    public Perspective(Image image,int zoom,int positionX,int positionY){
        this.zoom = zoom;
        this.position = new Point(positionX,positionY);
        this.image = image;
    }

    public Perspective clone(){
        return new Perspective(image,zoom, position.x, position.y);
    }
}
