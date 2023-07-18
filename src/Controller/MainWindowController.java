package Controller;

import Model.Image;
import Model.Perspective;
import Views.ImagePanelView;

public class MainWindowController {
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
    }
}
