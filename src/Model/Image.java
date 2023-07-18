package Model;

import PatronObserver.Subject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Image extends Subject {

    BufferedImage bufferedImage;
    BufferedImage originalBufferedImage;

    public Image() {

    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.originalBufferedImage = bufferedImage;
    }

    public void setNewImageSize(int newWidth, int newHeight){
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(this.originalBufferedImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        this.bufferedImage = resizedImage;
    }
}
