package Views;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Variables temporaires de la demonstration:
	private Point position = new Point(0,0);
	private Point speed = new Point(1,1);
	private int size = 32;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// On ajoute à la position le delta x et y de la vitesse
		position.translate(speed.x, speed.y);
		g.fillRect(position.x, position.y, size, size);
	}

}