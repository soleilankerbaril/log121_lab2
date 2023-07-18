package Views;

import Model.Image;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class MainWindow extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static final String WINDOW_NAME = "Laboratoire 2 : LOG121 - image.io";
	private static final Dimension WINDOW_DIMENSIONS = new Dimension(600, 400);
	
	private Image imageLeft = new Image();
	private Image imageCenter = new Image();
	private Image imageRight = new Image();
	
	private JPanel contentPane = new JPanel(new BorderLayout());
	

	public MainWindow() {
		
		setTitle(WINDOW_NAME);
		setSize(WINDOW_DIMENSIONS);
		// Sets the window to the center of the screen
		setLocationRelativeTo(null);
		// Sets the x buton the event to close and terminate the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(10, 10));

		// Initialises the menu bar
		WindowMenu windowMenu = new WindowMenu(this);
		setJMenuBar(windowMenu);
		
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Rendre la fen�tre visible
		setVisible(true);
		
	}
	
	
	public void setImages(String imagePath) {
		
		imageLeft.setBufferedImage(imagePath);
		imageCenter.setBufferedImage(imagePath);
		imageRight.setBufferedImage(imagePath);
		
		buildPane();
		
	}

	
	public void buildPane() {
				
		// Create a container panel for the three columns
		JPanel containerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		// Create the left panel and add it to the container panel
		gbc.gridx = 0;
		containerPanel.add(imageLeft, gbc);

		// Create the middle panel and add it to the container panel
		gbc.gridx = 1;		
		containerPanel.add(imageCenter, gbc);

		// Create the right panel and add it to the container panel
		gbc.gridx = 2;
		containerPanel.add(imageRight, gbc);

		// Add the container panel to the content pane
		contentPane.removeAll();
		contentPane.add(containerPanel, BorderLayout.CENTER);

		setContentPane(contentPane);
		
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("TEST")) {
			repaint();
		}
	}
	
	public void saveConfig(File file) {
		
	}
	
	public void loadConfig(File file) {
		
	}
	
	public void loadImage(File file) {
		
	}
}
