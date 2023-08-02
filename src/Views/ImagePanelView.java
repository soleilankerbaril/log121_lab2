package Views;

import Model.Image;
import Model.Perspective;
import PatronObserver.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

/**
 * ImagePanelView inherits from JPanel from the java swing libraries
 * as well as implements the observer interface.
 * ImagePanelView acts as the View in the MVC architecture
 */
public class ImagePanelView extends JPanel implements Observer {
    Image image;
    Perspective perspective;

    public ImagePanelView(Image image, Perspective perspective){
        this.image = image;
        this.perspective = perspective;
    }

    /**
     * @return the image used by this view
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets a new image to be used by this view
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the perspective that is used by this view
     */
    public Perspective getPerspective() {
        return perspective;
    }

    /**
     * Sets a new perspective to be used by this view
     * @param perspective
     */
    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

    /**
     * receives the graphical component used by this view JFrame
     * and paints the image with its modified image and perspective
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
    	
    	if(this.image.getOriginalBufferedImage() != null) {
    		
	        int width = (int)(this.perspective.zoom * this.image.getOriginalBufferedImage().getWidth());
	        int height = (int)(this.perspective.zoom * this.image.getOriginalBufferedImage().getHeight());
	        
	        this.image.setNewImageSize(width, height);        
	        g.drawImage(this.image.getBufferedImage(), this.perspective.position.x, this.perspective.position.y, this);
	        
    	}
    }

    @Override
    public void update() {
        paintComponent(this.getGraphics());
    }
}
