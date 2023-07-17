package PatronCommand;

import Model.Perspective;

import java.awt.*;

public class ZoomIn extends Operation{
    public void execute(Perspective perspective, int zoomPercentage){
        perspective.zoom -= zoomPercentage;
    }
}
