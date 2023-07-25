package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import PatronObserver.Subject;

public class Image{

    BufferedImage bufferedImage;
    BufferedImage originalBufferedImage;

    public Image() {

    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    
    public BufferedImage getOriginalBufferedImage() {
        return originalBufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
    	
        this.bufferedImage = bufferedImage;
        
        // copying image
        //https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
        ColorModel cm = bufferedImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        this.originalBufferedImage = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        
    }

    public void setNewImageSize(int newWidth, int newHeight){
    	
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        this.bufferedImage = resizedImage;
        
        g2d.drawImage(this.originalBufferedImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        
    }
}
