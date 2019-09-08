
import java.awt.*;
import javax.swing.*;

public class JPanelSuivants extends JPanel {

	private static final long serialVersionUID = 1L;
	private Suivants s;
	public static int echelle;

	public JPanelSuivants() {
		s = new Suivants();
		echelle = 30;
	}
	
	public void paint(Graphics g) {
		setSize(7*echelle+4, 12*echelle);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(238,254,221));
		g.fillRect(2, 2, getWidth()-4, 4*echelle-4);
		g.fillRect(2, 4*echelle+2, getWidth()-4, 4*echelle-4);
		g.fillRect(2, 8*echelle+2, getWidth()-4, 4*echelle-4);
		s.dessiner(g,echelle);
	}
	
	public static void main(String[] args) {
		JPanelSuivants p = new JPanelSuivants();
		JFrame f = new JFrame();
		f.add(p);
		f.setSize(210,382);
		f.setVisible(true);
	}

	public Forme firstForme() {
		return s.firstForme();
	}

	public void changeFormes() {
		s.changeFormes();
	}


	public void changeFormeFin() {
		s.changeFormeFin();
	}
	
}
