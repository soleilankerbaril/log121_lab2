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
        //gets default image for the setup
        BufferedImage bufferedImage = new BufferedImage(10,10,BufferedImage.TYPE_INT_ARGB);
        try {
            File file = new File("src/resources/one_piece.jpg");
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }


        Image leftPanelImage = new Image();
        Image middlePanelImage = new Image();
        Image rightPanelImage = new Image();

        leftPanelImage.setBufferedImage(bufferedImage);
        middlePanelImage.setBufferedImage(bufferedImage);
        rightPanelImage.setBufferedImage(bufferedImage);

        Perspective leftPanelPerspective = new Perspective();
        Perspective middlePanelPerspective = new Perspective();
        Perspective rightPanelPerspective = new Perspective();

        ImagePanelView leftPanelView = new ImagePanelView(leftPanelImage, leftPanelPerspective);
        ImagePanelView middlePanelView = new ImagePanelView(middlePanelImage, middlePanelPerspective);
        ImagePanelView rightPanelView = new ImagePanelView(rightPanelImage, rightPanelPerspective);

        Environment environment = new Environment();

        MainWindow mainWindow = new MainWindow(leftPanelView, middlePanelView, rightPanelView);
        MainWindowController mainWindowController = new MainWindowController(leftPanelImage, middlePanelImage, rightPanelImage,
                                                            leftPanelPerspective, middlePanelPerspective, rightPanelPerspective,
                                                            leftPanelView, middlePanelView, rightPanelView);


        environment.addPropertyChangeListener(mainWindow);
        environment.execute();
    }
}