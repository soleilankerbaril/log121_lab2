package Controller;

import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.io.File;

import Actions.*;
import Model.Image;
import Model.Perspective;
import Views.ImagePanelView;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

/**
 * MainWindowController serves as the controller of the MVC architecture
 * as well as a singleton to reduce the coupling between the implemented classes
 *
 * It implements the MousWheelListener, MousListener and KeyListener,
 * so it may monitor user inputs and relay the information
 * to the correct Subject inherited classes
 */
public class MainWindowController implements MouseWheelListener, MouseListener, KeyListener{

	private static MainWindowController instance = null;
    private Image leftPanelImage;
    private Image middlePanelImage;
    private Image rightPanelImage;
    private Perspective leftPanelPerspective;
    private Perspective middlePanelPerspective;
    private Perspective rightPanelPerspective;
    private ImagePanelView leftPanelView;
    private ImagePanelView middlePanelView;
    private ImagePanelView rightPanelView;

    private OperationPile middleUndoPile;
    private OperationPile rightUndoPile;
    private OperationPile middleRedoPile;
    private OperationPile rightRedoPile;

    private boolean startTranslation = false;
    private Point mousePositionStartTranslation;
    private String startTranslationPerspective;

    /**
     * Constructor is private, so it may only be accessed through
     * getter function per the singleton pattern
     */
    private MainWindowController(){
    }

    /**
     * getInstance returns a new MainWindowController object if it
     * has never been previously created
     * If an instance on MainWindowController already
     * exists the instance shall be returned
     * @return MainWindowController
     */
    public static MainWindowController getInstance(){
        if(instance == null){
            instance = new MainWindowController();
        }
        return  instance;
    }

    /**
     * sets the parameters for the instance of the mainWindowController object
     * @param leftPanelImage
     * @param middlePanelImage
     * @param rightPanelImage
     * @param leftPanelPerspective
     * @param middlePanelPerspective
     * @param rightPanelPerspective
     * @param leftPanelView
     * @param middlePanelView
     * @param rightPanelView
     */
    public void setMainWindow(Image leftPanelImage, Image middlePanelImage, Image rightPanelImage,
                              Perspective leftPanelPerspective, Perspective middlePanelPerspective, Perspective rightPanelPerspective,
                              ImagePanelView leftPanelView, ImagePanelView middlePanelView, ImagePanelView rightPanelView)
    {
        this.leftPanelImage = leftPanelImage;
        this.middlePanelImage = middlePanelImage;
        this.rightPanelImage = rightPanelImage;

        this.leftPanelPerspective = leftPanelPerspective;
        this.middlePanelPerspective = middlePanelPerspective;
        this.rightPanelPerspective = rightPanelPerspective;

        this.leftPanelView = leftPanelView;
        this.middlePanelView = middlePanelView;
        this.rightPanelView = rightPanelView;

        middlePanelView.setFocusable(true);
        rightPanelView.setFocusable(true);

        this.leftPanelPerspective.attach(leftPanelView);
        this.middlePanelPerspective.attach(middlePanelView);
        this.rightPanelPerspective.attach(rightPanelView);

        //Labeling the panels for event handling
        this.leftPanelView.setName("LeftPanel");
        this.middlePanelView.setName("MiddlePanel");
        this.rightPanelView.setName("RightPanel");

        middleUndoPile = new OperationPile();
        rightUndoPile = new OperationPile();
        middleRedoPile = new OperationPile();
        rightRedoPile = new OperationPile();

        //adding scroll wheel listener
        middlePanelView.addMouseWheelListener(this);
        rightPanelView.addMouseWheelListener(this);
        middlePanelView.addMouseListener(this);
        rightPanelView.addMouseListener(this);
        middlePanelView.addKeyListener(this);
        rightPanelView.addKeyListener(this);
    }

    /**
     * loadImage implements the execution for the load image functionality
     * @param file image that is to be loaded
     */
    public void loadImage(File file) {
    	LoadImage loadImage = new LoadImage(file, leftPanelImage, 
    			middlePanelImage, rightPanelImage, leftPanelPerspective, 
    			middlePanelPerspective, rightPanelPerspective);
    	loadImage.execute();
    }

    /**
     * loadConfig implements the execution for the load configuration functionality
     * @param file .xml file that contains the parameters of an application state
     */
    public void loadConfig(File file) {
    	LoadConfig loadConfig = new LoadConfig(file, 
    						leftPanelImage, middlePanelImage, rightPanelImage,
    						middlePanelPerspective, rightPanelPerspective);
    	loadConfig.execute();
        middleUndoPile.clearActions();
        rightUndoPile.clearActions();
        middleRedoPile.clearActions();
        rightRedoPile.clearActions();
    }

    /**
     * loadConfig implements the execution for the load configuration functionality
     * @param path where you want to save the .xml file containing the parameters of
     *             the current application state
     */
    public void saveConfig(String path) {
    	SaveConfig saveConfig = new SaveConfig(path, 
    						leftPanelImage, middlePanelPerspective, rightPanelPerspective);
    	saveConfig.execute();
    }
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		//Getting the scroll direction
		int notches = e.getWheelRotation();
		
		String componentName = e.getComponent().getName();
		if(componentName.equals("MiddlePanel")) {
            Zoom zoom = new Zoom(middlePanelPerspective,notches);
            zoom.execute();
            SaveAction(middleUndoPile,middleRedoPile,zoom);
		}
		else if(componentName.equals("RightPanel")) {
            Zoom zoom = new Zoom(rightPanelPerspective,notches);
            zoom.execute();
            SaveAction(rightUndoPile,rightRedoPile,zoom);
		}
	}

    /**
     * Saves a executed action to the correct undo and redo piles
     * for an operation sequence
     * @param undo
     * @param redo
     * @param operation
     */
    private void SaveAction(OperationPile undo, OperationPile redo, Operation operation){
        undo.addOperation(operation);
        redo.clearActions();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == '-'){
            String componentName = e.getComponent().getName();
            if(componentName.equals("MiddlePanel")) {
                new Undo(middleUndoPile,middleRedoPile).execute();
            }
            else if(componentName.equals("RightPanel")) {
                new Undo(rightUndoPile,rightRedoPile).execute();
            }
        }
        if(e.getKeyChar() == '+'){
            String componentName = e.getComponent().getName();
            if(componentName.equals("MiddlePanel")) {
                new Redo(middleUndoPile,middleRedoPile).execute();
            }
            else if(componentName.equals("RightPanel")) {
                new Redo(rightUndoPile,rightRedoPile).execute();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 90){
            String componentName = e.getComponent().getName();
            if(componentName.equals("MiddlePanel")) {
                new Undo(middleUndoPile,middleRedoPile).execute();
            }
            else if(componentName.equals("RightPanel")) {
                new Undo(rightUndoPile,rightRedoPile).execute();
            }
        }
        if(e.getKeyCode() == 89){
            String componentName = e.getComponent().getName();
            if(componentName.equals("MiddlePanel")) {
                new Redo(middleUndoPile,middleRedoPile).execute();
            }
            else if(componentName.equals("RightPanel")) {
                new Redo(rightUndoPile,rightRedoPile).execute();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        String componentName = e.getComponent().getName();
        startTranslation = true;
        mousePositionStartTranslation = e.getLocationOnScreen();
        startTranslationPerspective = componentName;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(startTranslation){
            Point distance = new Point(e.getLocationOnScreen().x - mousePositionStartTranslation.x, e.getLocationOnScreen().y - mousePositionStartTranslation.y);
            if(startTranslationPerspective.equals("MiddlePanel")) {
                Translation translation = new Translation(middlePanelPerspective,distance);
                translation.execute();
                SaveAction(middleUndoPile,middleRedoPile,translation);
            }
            else if(startTranslationPerspective.equals("RightPanel")) {
                Translation translation = new Translation(rightPanelPerspective,distance);
                translation.execute();
                SaveAction(rightUndoPile,rightRedoPile,translation);
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String componentName = e.getComponent().getName();
        if(componentName.equals("MiddlePanel")) {
            middlePanelView.grabFocus();
        }
        else if(componentName.equals("RightPanel")) {
            rightPanelView.grabFocus();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
