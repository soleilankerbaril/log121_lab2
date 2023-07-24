package Actions;

import Model.Perspective;

public class Zoom extends Operation{
	
	private static final double ZOOM_INCREMENT = 0.05;
	private static final double ZOOM_MAX = 2;
	private static final double ZOOM_MIN = 0.2;

    private int nbNotch;

    public Zoom(Perspective perspective, int nbNotch){
        this.perspective = perspective;
        this.nbNotch = nbNotch;
    }

    @Override
    protected void executeAction(){
    	double zoom =  perspective.zoom + (nbNotch * ZOOM_INCREMENT);
        if(zoom >= ZOOM_MAX) {
        	zoom = 2;
        }
        
        if(zoom <= ZOOM_MIN) {
        	zoom = 0.2;
        }
        
        perspective.zoom = zoom;     
        perspective.notifyObservers();
    }
}
