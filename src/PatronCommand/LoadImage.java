package PatronCommand;

import java.io.File;

import Views.MainWindow;

public class LoadImage extends Operation{
	
	private MainWindow window;
	
	public LoadImage(MainWindow window) {
		this.window = window;		
	}

	public void execute(File file){
		window.setImages(file.getAbsolutePath());
    }
	
	
}
