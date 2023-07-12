package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends JPanel {
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(String imagePath) {
        try {
            File file = new File(imagePath);
            this.bufferedImage = ImageIO.read(file);
            this.originalBufferedImage = this.bufferedImage;
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void setNewImageSize(int newWidth, int newHeight){
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(this.originalBufferedImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        this.bufferedImage = resizedImage;
    }

    public void addNotify() {
        super.addNotify();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();
                double ratio = (double) width/originalBufferedImage.getWidth();
                int calcHeight = ((int)((ratio) * originalBufferedImage.getHeight()));
                ratio = (double) height/originalBufferedImage.getHeight();
                int calcWidth = ((int)((ratio) * originalBufferedImage.getWidth()));
                setNewImageSize(Math.min(width, calcWidth), Math.min(height, calcHeight));
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - this.bufferedImage.getWidth()) / 2;  // Center horizontally
        int y = (getHeight() - this.bufferedImage.getHeight()) / 2;  // Center vertically
        g.drawImage(this.bufferedImage, x, y, null);
    }

    BufferedImage bufferedImage;

    BufferedImage originalBufferedImage;

    public Image() {

    }
}
