package Actions;

import Model.Perspective;

import java.awt.*;

/**
 * Translation inherits from the Operation class permitting it to have a saved
 * momento state as well as have its action called through executeAction
 * Translation wil receive the new coordinates and set the image to its new position.
 */
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
