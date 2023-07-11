package Model;

public class Perspective {
    Image image;
    int zoom;
    int translationX;
    int translationY;

    public Perspective(Image image){
        zoom = 0;
        translationX = 0;
        translationY = 0;
        this.image = image;
    }

    public Perspective(Image image,int zoom,int translationX,int translationY){
        this.zoom = zoom;
        this.translationX = translationX;
        this.translationY = translationY;
        this.image = image;
    }

    public Perspective clone(){
        return new Perspective(image,zoom,translationX,translationY);
    }
}
