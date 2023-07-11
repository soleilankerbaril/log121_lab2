package Views;

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
		MainPanel mainPanel1 = new MainPanel();
		mainPanel1.setLayout(new BoxLayout(mainPanel1, BoxLayout.Y_AXIS));
		mainPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//mainPanel1.add(new JLabel("Left Column"));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(mainPanel1, gbc);

		// Create the middle panel and add it to the container panel
		MainPanel mainPanel2 = new MainPanel();
		mainPanel2.setLayout(new BoxLayout(mainPanel2, BoxLayout.Y_AXIS));
		mainPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//mainPanel2.add(new JLabel("Middle Column"));

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(mainPanel2, gbc);

		// Create the right panel and add it to the container panel
		MainPanel mainPanel3 = new MainPanel();
		mainPanel3.setLayout(new BoxLayout(mainPanel3, BoxLayout.Y_AXIS));
		mainPanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//mainPanel3.add(new JLabel("Right Column"));

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		containerPanel.add(mainPanel3, gbc);

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
			System.out.println(evt.getNewValue());
		}
	}
}
