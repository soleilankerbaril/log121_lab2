package Controller;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;

import Actions.LoadImage;
import Actions.Zoom;
import Model.Image;
import Model.Perspective;
import Views.ImagePanelView;

public class MainWindowController implements MouseWheelListener{
	
    private Image leftPanelImage;
    private Image middlePanelImage;
    private Image rightPanelImage;
    private Perspective leftPanelPerspective;
    private Perspective middlePanelPerspective;
    private Perspective rightPanelPerspective;
    private ImagePanelView leftPanelView;
    private ImagePanelView middlePanelView;
    private ImagePanelView rightPanelView;
    
    public MainWindowController(Image leftPanelImage, Image middlePanelImage, Image rightPanelImage,
                                Perspective leftPanelPerspective, Perspective middlePanelPerspective, Perspective rightPanelPerspective,
                                ImagePanelView leftPanelView, ImagePanelView middlePanelView, ImagePanelView rightPanelView){
    	
        this.leftPanelImage = leftPanelImage;
        this.middlePanelImage = middlePanelImage;
        this.rightPanelImage = rightPanelImage;
        
        this.leftPanelPerspective = leftPanelPerspective;
        this.middlePanelPerspective = middlePanelPerspective;
        this.rightPanelPerspective = rightPanelPerspective;
        
        this.leftPanelView = leftPanelView;
        this.middlePanelView = middlePanelView;
        this.rightPanelView = rightPanelView;

        this.leftPanelPerspective.attach(leftPanelView);
        this.middlePanelPerspective.attach(middlePanelView);
        this.rightPanelPerspective.attach(rightPanelView);
        
        this.leftPanelImage.attach(leftPanelView);
        this.middlePanelImage.attach(middlePanelView);
        this.rightPanelImage.attach(rightPanelView);
        
        //Labeling the panels for event handling
        this.leftPanelView.setName("LeftPanel");
        this.middlePanelView.setName("MiddlePanel");
        this.rightPanelView.setName("RightPanel");
        
        //adding scroll wheel listener
        middlePanelView.addMouseWheelListener(this);
        rightPanelView.addMouseWheelListener(this);
        
    }
    
    public void loadImage(File file) {
    	LoadImage loadImage = new LoadImage();
    	loadImage.execute(file, leftPanelImage, middlePanelImage, rightPanelImage);
    }

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		//Getting the scroll direction
		int notches = e.getWheelRotation();
		Zoom zoom = new Zoom();
		
		String componentName = e.getComponent().getName();
		if(componentName.equals("MiddlePanel")) {
			zoom.execute(middlePanelPerspective, notches);
		}
		else if(componentName.equals("RightPanel")) {
			zoom.execute(rightPanelPerspective, notches);
		}
	}
    
}
