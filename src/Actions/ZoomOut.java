package Actions;

import Model.Perspective;

public class ZoomOut extends Operation{
    public void execute(Perspective perspective, int zoomPercentage){
        perspective.zoom += zoomPercentage;
    }
}
