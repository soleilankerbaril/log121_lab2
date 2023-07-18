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
        super.paintComponent(g);
        int width = this.perspective.zoom * this.image.getBufferedImage().getWidth() / 100;
        int height = this.perspective.zoom * this.image.getBufferedImage().getHeight() / 100;
        this.image.setNewImageSize(width, height);
        g.drawImage(this.image.getBufferedImage(), this.perspective.position.x, this.perspective.position.y, null);
    }

    @Override
    public void update() {
        paintComponent(this.getGraphics());
    }
}
