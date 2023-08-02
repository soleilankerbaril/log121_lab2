package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import PatronObserver.Subject;

/**
 * Image is subject of the Observer design pattern
 * as well as a model to the MVC architecture
 *
 * It contains the information regarding a bufferedImage
 * state and its original image path
 */
public class Image{

    BufferedImage bufferedImage;
    BufferedImage originalBufferedImage;
    String imagePath;

    /**
     * Sets the path of the image to display
     * @param imagePath
     */
    public void setPath(String imagePath) {
    	this.imagePath = imagePath;
    }

    /**
     * @return the path that contains the current displayed image
     */
    public String getPath() {
    	return imagePath;
    }

    /**
     * @return the currently altered bufferedImage
     */
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    /**
     * @return the original unaltered bufferedImage
     */
    public BufferedImage getOriginalBufferedImage() {
        return originalBufferedImage;
    }

    /**
     * Sets the current bufferedImage with a new image
     * @param bufferedImage
     */
    public void setBufferedImage(BufferedImage bufferedImage) {
    	
        this.bufferedImage = bufferedImage;
        
        // copying image
        //https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
        ColorModel cm = bufferedImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        this.originalBufferedImage = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        
    }

    /**
     * Sets the images new size and resizes the resolution of the bufferedImage
     * from the originalBufferedImage as to not lose clarity from
     * repeated alteration to the current bufferedImage
     * @param newWidth
     * @param newHeight
     */
    public void setNewImageSize(int newWidth, int newHeight){
    	
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        this.bufferedImage = resizedImage;
        
        g2d.drawImage(this.originalBufferedImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        
    }
}
