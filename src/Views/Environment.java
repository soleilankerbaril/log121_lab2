package Views;

import javax.swing.*;

public class Environment extends SwingWorker<Object, String> {
	private boolean actif = true;
	private static final int DELAY = 100;
	
	@Override
	protected Object doInBackground() throws Exception {

		while(actif) {
			Thread.sleep(DELAY);
			/**
			 * C'est ici que vous aurez à faire la gestion de la notion de tour.
			 */
			firePropertyChange("TEST", null, "test is running");
		}
		return null;
	}

}