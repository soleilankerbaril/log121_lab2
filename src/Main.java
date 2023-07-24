import Controller.MainWindowController;
import Model.Image;
import Model.Perspective;
import Views.Environment;
import Views.ImagePanelView;
import Views.MainWindow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Image leftPanelImage = new Image();
        Image middlePanelImage = new Image();
        Image rightPanelImage = new Image();

        /*leftPanelImage.setBufferedImage(bufferedImage);
        middlePanelImage.setBufferedImage(bufferedImage);
        rightPanelImage.setBufferedImage(bufferedImage);*/

        Perspective leftPanelPerspective = new Perspective();
        Perspective middlePanelPerspective = new Perspective();
        Perspective rightPanelPerspective = new Perspective();

        ImagePanelView leftPanelView = new ImagePanelView(leftPanelImage, leftPanelPerspective);
        ImagePanelView middlePanelView = new ImagePanelView(middlePanelImage, middlePanelPerspective);
        ImagePanelView rightPanelView = new ImagePanelView(rightPanelImage, rightPanelPerspective);


        Environment environment = new Environment();

        MainWindowController mainWindowController = new MainWindowController(leftPanelImage, middlePanelImage, rightPanelImage,
                leftPanelPerspective, middlePanelPerspective, rightPanelPerspective,
                leftPanelView, middlePanelView, rightPanelView);
        
        MainWindow mainWindow = new MainWindow(leftPanelView, middlePanelView, rightPanelView, mainWindowController);
        
        environment.addPropertyChangeListener(mainWindow);
        environment.execute();
    }
}