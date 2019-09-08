
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class JPanelDeplacement extends JPanel {

	private static final long serialVersionUID = 1L;
	private Deplacement d;
	public static int echelle;

	public JPanelDeplacement() {
		d = new Deplacement();
		echelle = 50;
	}
	
	public void paint(Graphics g) {
		setSize(7*echelle+4, 5*echelle+4);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(238,254,221));
		g.fillRect(2, 2, getWidth()-4, getHeight()-4);
		
		d.dessiner(g, echelle);
	}

	public void left() {
		d.left();
	}

	public void right() {
		d.right();
	}

	public void rotate() {
		d.rotate();
	}

	public Forme getForme() {
		return d.getForme();
	}

	public void newForme(Forme firstForme) {
		d.newForme(firstForme);
	}

	public boolean formeNull() {
		return d.formeNull();
	}
}
