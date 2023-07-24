package Actions;

import Model.Perspective;

public class Zoom extends Operation{
	
	private static final double ZOOM_INCREMENT = 0.05;
	private static final double ZOOM_MAX = 2;
	private static final double ZOOM_MIN = 0.2;
	
    public void execute(Perspective perspective, int nbNotch){
        
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
    
    public void Undo(){
    }

    public void Redo(){
        
    }
    
}
