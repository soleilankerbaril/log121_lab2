package Actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Image;
import Model.Perspective;

public class LoadImage implements Action {

	File file;
	Image leftPanelImage;
	Image middlePanelImage;
	Image rightPanelImage;
	Perspective leftPanelPerspective;
	Perspective middlePanelPerspective;
	Perspective rightPanelPerspective;

	public LoadImage(File file, Image leftPanelImage, Image middlePanelImage,
					 Image rightPanelImage, Perspective leftPanelPerspective,
					 Perspective middlePanelPerspective, Perspective rightPanelPerspective){
		
		this.file = file;
		this.leftPanelImage = leftPanelImage;
		this.middlePanelImage = middlePanelImage;
		this.rightPanelImage = rightPanelImage;
		this.leftPanelPerspective = leftPanelPerspective;
		this.middlePanelPerspective = middlePanelPerspective;
		this.rightPanelPerspective = rightPanelPerspective;
	}

	@Override
	public void execute() {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			
			leftPanelImage.setPath(file.getAbsolutePath());
			middlePanelImage.setPath(file.getAbsolutePath());
			rightPanelImage.setPath(file.getAbsolutePath());
			
			leftPanelImage.setBufferedImage(bufferedImage);
			middlePanelImage.setBufferedImage(bufferedImage);
			rightPanelImage.setBufferedImage(bufferedImage);
			
			middlePanelPerspective.zoom = 1;
			middlePanelPerspective.position.x = 0;
			middlePanelPerspective.position.y = 0;
			rightPanelPerspective.zoom = 1;
			rightPanelPerspective.position.x = 0;
			rightPanelPerspective.position.y = 0;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
