package Actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Image;

public class LoadImage extends Operation {
	
	
	
	public void execute(File file, Image leftPanelImage, Image middlePanelImage,
						Image rightPanelImage) {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			
			leftPanelImage.setBufferedImage(bufferedImage);
			middlePanelImage.setBufferedImage(bufferedImage);
			rightPanelImage.setBufferedImage(bufferedImage);
			
			leftPanelImage.notify();
			middlePanelImage.notify();
			rightPanelImage.notify();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
