package Views;

import Model.Image;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainWindow extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static final String WINDOW_NAME = "Laboratoire 2 : LOG121 - image.io";
	private static final Dimension WINDOW_DIMENSIONS = new Dimension(600, 400);

	public MainWindow() {
		setTitle(WINDOW_NAME);
		setSize(WINDOW_DIMENSIONS);
		// Sets the window to the center of the screen
		setLocationRelativeTo(null);
		// Sets the x buton the event to close and terminate the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(10, 10));

		// Initialises the menu bar
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
		Image image1 = new Model.Image();
		image1.setBufferedImage("src/resources/one_piece.jpg");
		containerPanel.add(image1, gbc);


		// Create the middle panel and add it to the container panel
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		Image image2 = new Model.Image();
		image2.setBufferedImage("src/resources/one_piece.jpg");
		containerPanel.add(image2, gbc);


		// Create the right panel and add it to the container panel
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		Image image3 = new Model.Image();
		image3.setBufferedImage("src/resources/one_piece.jpg");
		containerPanel.add(image3, gbc);


		// Add the container panel to the content pane
		contentPane.add(containerPanel, BorderLayout.CENTER);
		// Faire en sorte que le X de la fenêtre ferme la fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Rendre la fenêtre visible
		setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("TEST")) {
			repaint();
		}
	}
}
