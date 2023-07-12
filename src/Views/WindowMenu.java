package Views;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class WindowMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static final String MENU_FILE_TITLE = "Files";
	private static final String MENU_FILE_LOAD_IMAGE = "Load Image";
	private static final String MENU_FILE_LOAD_CONFIG = "Load Configuration";
	private static final String MENU_FILE_SAVE_CONFIG = "Save Configuration";
	private static final String MENU_FILE_EXIT = "Exit program";
	private static final String MENU_HELP_TITLE = "Help";
	private static final String MENU_HELP_ABOUT = "About...";

	public WindowMenu() {
		addWindowMenu();
		addHelpWindow();
	}

	/**
	 * Cr�er le menu de Fichier
	 */
	private void addWindowMenu() {
		JMenu menuFile = new JMenu(MENU_FILE_TITLE);
		add(menuFile);


		JMenuItem menuLoadImage = new JMenuItem(MENU_FILE_LOAD_IMAGE);
		menuLoadImage.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Choose a configuration file to save");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Sauvegarder la configue
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
		});
		menuFile.add(menuLoadImage);


		JMenuItem menuLoadConfig = new JMenuItem(MENU_FILE_LOAD_CONFIG);
		menuLoadConfig.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Choose a configuration file to load");
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Loader la config
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
		});
		menuFile.add(menuLoadConfig);


		JMenuItem menuSaveConfig = new JMenuItem(MENU_FILE_SAVE_CONFIG);
		menuSaveConfig.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Choose a configuration file to save");
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showSaveDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Sauvegarder la configue
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
		});
		menuFile.add(menuSaveConfig);


		JMenuItem exitItem = new JMenuItem(MENU_FILE_EXIT, KeyEvent.VK_Q);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		exitItem.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuFile.addSeparator();
		menuFile.add(exitItem);
	}


	/**
	 * Cr�er le menu Aide
	 */
	private void addHelpWindow() {
		JMenu menuAide = new JMenu(MENU_HELP_TITLE);
		JMenuItem menuPropos = new JMenuItem(MENU_HELP_ABOUT);
		menuAide.add(menuPropos);

		menuPropos.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(null,
					"<html>"
							+ "<p>Image Perspective Viewer</p>" + "<br>"
							+ "<p>&copy; &nbsp; 2023 &nbsp; Bissonnette Felix</p>"
							+ "<p>&copy; &nbsp; 2023 &nbsp; Boyer Raimoemoea</p>"
							+ "<p>&copy; &nbsp; 2023 &nbsp; Anker-Baril Soleil</p>" + "<br>"
							+ "<p>&Eacute;cole de technologie sup&eacute;rieure</p></html>");
		});
		add(menuAide);
	}

}