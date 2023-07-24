package Views;

import javax.swing.*;

import Controller.MainWindowController;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainWindow extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static final String WINDOW_NAME = "Laboratoire 2 : LOG121 - image.io";
	private static final Dimension WINDOW_DIMENSIONS = new Dimension(600, 400);
	private MainWindowController controller;

	public MainWindow(ImagePanelView leftPanel, ImagePanelView middlePanel, 
					ImagePanelView rightPanel, MainWindowController controller) {
		
		this.controller = controller;
		
		setTitle(WINDOW_NAME);
		setSize(WINDOW_DIMENSIONS);
		
		// Sets the window to the center of the screen
		setLocationRelativeTo(null);
		
		// Sets the x button the event to close and terminate the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(10, 10));

		// Initialize the menu bar
		WindowMenu windowMenu = new WindowMenu(controller);
		setJMenuBar(windowMenu);

		// Create the content pane to contain the panels
		JPanel contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);

		// Create a container panel for the three columns
		JPanel containerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();


		/**
		 * The following code implements the 3 used panels.
		 * They need to be updated so that they implement
		 * the panels that are developed as the views of the MVC structure.
		 * TODO - change panels for the needed views
		 */

		// Create the left panel and add it to the container panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(leftPanel, gbc);


		// Create the middle panel and add it to the container panel
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(middlePanel, gbc);


		// Create the right panel and add it to the container panel
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(rightPanel, gbc);


		// Add the container panel to the content pane
		contentPane.add(containerPanel, BorderLayout.CENTER);
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Rendre la fen�tre visible
		setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("TEST")) {
			repaint();
		}
	}
}
