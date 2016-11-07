package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Logo extends JPanel {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ImageIcon imagen;
	/**
	 * Create the panel.
	 */
	public Logo(String nombre) {
		super();
		initialize();
		imagen=new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconWidth(),imagen.getIconHeight());

	}
	private void initialize() {
		this.setSize(200,300);
		this.setLayout(new GridBagLayout());
		
	}
	protected void paintComponent (Graphics g)
	{
		Dimension d=getSize();
		g.drawImage(imagen.getImage(),0,0,d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}

}
