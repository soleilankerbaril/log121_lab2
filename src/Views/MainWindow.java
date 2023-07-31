package Views;

import javax.swing.*;

import Controller.MainWindowController;
import Model.Image;
import Model.Perspective;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainWindow extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static final String WINDOW_NAME = "Laboratoire 2 : LOG121 - image.io";
	private static final Dimension WINDOW_DIMENSIONS = new Dimension(600, 400);

	public MainWindow() {

		Model.Image leftPanelImage = new Model.Image();
		Model.Image middlePanelImage = new Model.Image();
		Model.Image rightPanelImage = new Image();


		Perspective leftPanelPerspective = new Perspective();
		Perspective middlePanelPerspective = new Perspective();
		Perspective rightPanelPerspective = new Perspective();

		ImagePanelView leftPanelView = new ImagePanelView(leftPanelImage, leftPanelPerspective);
		ImagePanelView middlePanelView = new ImagePanelView(middlePanelImage, middlePanelPerspective);
		ImagePanelView rightPanelView = new ImagePanelView(rightPanelImage, rightPanelPerspective);

		MainWindowController.getInstance().setMainWindow(leftPanelImage, middlePanelImage, rightPanelImage,
		                                leftPanelPerspective, middlePanelPerspective, rightPanelPerspective,
		                                leftPanelView, middlePanelView, rightPanelView);

		setTitle(WINDOW_NAME);
		setSize(WINDOW_DIMENSIONS);
		
		// Sets the window to the center of the screen
		setLocationRelativeTo(null);
		
		// Sets the x button the event to close and terminate the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(10, 10));

		// Initialize the menu bar
		WindowMenu windowMenu = new WindowMenu();
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
		containerPanel.add(leftPanelView, gbc);


		// Create the middle panel and add it to the container panel
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(middlePanelView, gbc);


		// Create the right panel and add it to the container panel
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(rightPanelView, gbc);


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
