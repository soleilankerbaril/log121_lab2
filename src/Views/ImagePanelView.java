package Views;

import Model.Image;
import Model.Perspective;
import PatronObserver.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

public class ImagePanelView extends JPanel implements Observer {
    Image image;
    Perspective perspective;

    public ImagePanelView(Image image, Perspective perspective){
        this.image = image;
        this.perspective = perspective;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

//    public void addNotify() {
//        super.addNotify();
//        addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                int width = getWidth();
//                int height = getHeight();
//                BufferedImage originalBufferedImage = image.getOriginalBufferedImage();
//                double ratio = (double) width/originalBufferedImage.getWidth();
//                int calcHeight = ((int)((ratio) * originalBufferedImage.getHeight()));
//                ratio = (double) height/originalBufferedImage.getHeight();
//                int calcWidth = ((int)((ratio) * originalBufferedImage.getWidth()));
//                image.setNewImageSize(Math.min(width, calcWidth), Math.min(height, calcHeight));
//            }
//        });
//    }

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
