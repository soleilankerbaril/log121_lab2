package simulation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;

public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static final String MENU_FILE_TITRE = "Files";
	private static final String MENU_FILE_LOAD_IMAGE = "Load Image";
	private static final String MENU_FILE_LOAD_CONFIG = "Load Configuration";
	private static final String MENU_FILE_SAVE_CONFIG = "Save Configuration";
	private static final String MENU_FILE_EXIT = "Exit program";
	private static final String MENU_HELP_TITLE = "Help";
	private static final String MENU_HELP_ABOUT = "About...";

	public MenuFenetre() {
		ajouterMenuFichier();
		ajouterMenuAide();
	}

	/**
	 * Créer le menu de Fichier
	 */
	private void ajouterMenuFichier() {
		JMenu menuFile = new JMenu(MENU_FILE_TITRE);
		JMenuItem menuLoadImage = new JMenuItem(MENU_FILE_LOAD_IMAGE);
		JMenuItem menuLoadConfig = new JMenuItem(MENU_FILE_LOAD_CONFIG);
		JMenuItem menuSaveConfig = new JMenuItem(MENU_FILE_SAVE_CONFIG);
		JMenuItem menuExit = new JMenuItem(MENU_FILE_EXIT);

		menuLoadImage.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Choose a configuration file to save");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Créer un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Sauvegarder la configue
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
		});

		menuLoadConfig.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Choose a configuration file to load");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Créer un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Loader la config
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
		});

		menuSaveConfig.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Choose a configuration file to save");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Créer un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showSaveDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Sauvegarder la configue
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
			}
		});

		menuExit.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});

		menuFile.add(menuLoadImage);
		menuFile.add(menuLoadConfig);
		menuFile.add(menuSaveConfig);
		menuFile.add(menuExit);

		add(menuFile);

	}


	/**
	 * Créer le menu Aide
	 */
	private void ajouterMenuAide() {
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
