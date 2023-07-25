package Actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Image;

public class LoadImage implements Action {

	File file;
	Image leftPanelImage;
	Image middlePanelImage;
	Image rightPanelImage;

	public LoadImage(File file, Image leftPanelImage, Image middlePanelImage,
					 Image rightPanelImage){
		this.file = file;
		this.leftPanelImage = leftPanelImage;
		this.middlePanelImage = middlePanelImage;
		this.rightPanelImage = rightPanelImage;
	}

	@Override
	public void execute() {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			
			leftPanelImage.setBufferedImage(bufferedImage);
			middlePanelImage.setBufferedImage(bufferedImage);
			rightPanelImage.setBufferedImage(bufferedImage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
