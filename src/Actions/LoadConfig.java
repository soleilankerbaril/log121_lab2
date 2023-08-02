package Actions;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Model.Image;
import Model.Perspective;

/**
 * LoadConfig implements the Action interface and can be called upon
 * using the execute function
 * LoadConfig is used to open a xml file, treat it and load a
 * previously saved configuration.
 */
public class LoadConfig implements Action {


    File file;
    Image leftPanelImage;
    Image middlePanelImage;
    Image rightPanelImage;
    Perspective middlePanelPerspective;
    Perspective rightPanelPerspective;

    public LoadConfig(File file, Image leftPanelImage, Image middlePanelImage,
                      Image rightPanelImage, Perspective middlePanelPerspective,
                      Perspective rightPanelPerspective) {

        this.file = file;
        this.leftPanelImage = leftPanelImage;
        this.middlePanelImage = middlePanelImage;
        this.rightPanelImage = rightPanelImage;
        this.middlePanelPerspective = middlePanelPerspective;
        this.rightPanelPerspective = rightPanelPerspective;
    }


    @Override
    public void execute() {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            //load image

            Node imageNode = doc.getElementsByTagName("image").item(0);
            Element imageElement = (Element) imageNode;
            String pathImage = imageElement.getAttribute("path");

            File imageFile = new File(pathImage);
            BufferedImage bufferedImage = ImageIO.read(imageFile);

            leftPanelImage.setPath(imageFile.getAbsolutePath());
            middlePanelImage.setPath(imageFile.getAbsolutePath());
            rightPanelImage.setPath(imageFile.getAbsolutePath());

            leftPanelImage.setBufferedImage(bufferedImage);
            middlePanelImage.setBufferedImage(bufferedImage);
            rightPanelImage.setBufferedImage(bufferedImage);

            //load perspectives

            Node perspectiveNode = doc.getElementsByTagName("perspective-centrale").item(0);
            Element perspectiveElement = (Element) perspectiveNode;
            Double zoom = Double.parseDouble(perspectiveElement.getAttribute("zoom"));
            int posX = Integer.parseInt(perspectiveElement.getAttribute("position-x"));
            int posY = Integer.parseInt(perspectiveElement.getAttribute("position-y"));

            middlePanelPerspective.zoom = zoom;
            middlePanelPerspective.position = new Point(posX, posY);

            perspectiveNode = doc.getElementsByTagName("perspective-right").item(0);
            perspectiveElement = (Element) perspectiveNode;
            zoom = Double.parseDouble(perspectiveElement.getAttribute("zoom"));
            posX = Integer.parseInt(perspectiveElement.getAttribute("position-x"));
            posY = Integer.parseInt(perspectiveElement.getAttribute("position-y"));

            rightPanelPerspective.zoom = zoom;
            rightPanelPerspective.position = new Point(posX, posY);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
