package Actions;

import java.io.File;

import Model.Image;
import Model.Perspective;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * SaveConfig implements the Action interface and can be called upon
 * using the execute function
 * SaveConfig will convert all the current state of the
 * application and save it to a .xml format
 */
public class SaveConfig implements Action{
	
	String path;
	Image leftPanelImage;
	Image middlePanelImage;
	Image rightPanelImage;
	Perspective middlePanelPerspective;
	Perspective rightPanelPerspective;
	
	public SaveConfig(String path, Image leftPanelImage, 
			Perspective middlePanelPerspective, Perspective rightPanelPerspective){
		
		this.path = path;
		this.leftPanelImage = leftPanelImage;
		this.middlePanelPerspective = middlePanelPerspective;
		this.rightPanelPerspective = rightPanelPerspective;
	}


	@Override
	public void execute() {
		
		try {
			
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("configuration");
	         doc.appendChild(rootElement);

	         // image element
	         
	         Element imageElement = doc.createElement("image");
	         rootElement.appendChild(imageElement);

	         Attr attr = doc.createAttribute("path");
	         attr.setValue(leftPanelImage.getPath());
	         imageElement.setAttributeNode(attr);
	         
	         // perspective centrale element
	         
	         Element perspeCentraleElement = doc.createElement("perspective-centrale");
	         rootElement.appendChild(perspeCentraleElement);

	         attr = doc.createAttribute("zoom");
	         attr.setValue(Double.toString(middlePanelPerspective.zoom));
	         perspeCentraleElement.setAttributeNode(attr);
	         attr = doc.createAttribute("position-x");
	         attr.setValue(Integer.toString(middlePanelPerspective.position.x));
	         perspeCentraleElement.setAttributeNode(attr);
	         attr = doc.createAttribute("position-y");
	         attr.setValue(Integer.toString(middlePanelPerspective.position.y));
	         perspeCentraleElement.setAttributeNode(attr);
	         
	         // perspective droite element
	         
	         Element perspeRightElement = doc.createElement("perspective-right");
	         rootElement.appendChild(perspeRightElement);

	         attr = doc.createAttribute("zoom");
	         attr.setValue(Double.toString(rightPanelPerspective.zoom));
	         perspeRightElement.setAttributeNode(attr);
	         attr = doc.createAttribute("position-x");
	         attr.setValue(Integer.toString(rightPanelPerspective.position.x));
	         perspeRightElement.setAttributeNode(attr);
	         attr = doc.createAttribute("position-y");
	         attr.setValue(Integer.toString(rightPanelPerspective.position.y));
	         perspeRightElement.setAttributeNode(attr);

	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File(path));
	         transformer.transform(source, result);
	         
		}
		
		catch (Exception e) {
	         e.printStackTrace();
	    }
		
	}

}
