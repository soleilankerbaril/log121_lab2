package Actions;

import Model.Perspective;

import java.awt.*;

public class Translation extends Operation{

    Point positionCible;
    public Translation(Perspective perspective, Point positionCible){
        this.perspective = perspective;
        this.positionCible = positionCible;
    }
    public void executeAction(){
        perspective.position.translate(positionCible.x,positionCible.y);
        perspective.notifyObservers();
    }
}
