package PatronCommand;

import Model.Perspective;

import java.awt.*;

public class Translation extends Operation{
    public void execute(Perspective perspective, Point positionCible){
        perspective.position.move(positionCible.x,positionCible.y);
    }
}
