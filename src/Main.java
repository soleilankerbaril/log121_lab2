import Controller.MainWindowController;
import Model.Image;
import Model.Perspective;
import Views.Environment;
import Views.ImagePanelView;
import Views.MainWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Environment environment = new Environment();
        
        MainWindow mainWindow = new MainWindow();
        
        environment.addPropertyChangeListener(mainWindow);
        environment.execute();
    }
}