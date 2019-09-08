
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private Table t;
	public static int echelle;
	
	public JPanelTable() {
		t = new Table();
		echelle = 50;
	}
	
	public JPanelTable(JPanelTable j) {
		this.t = j.t.clone();
	}
	
	public void paint(Graphics g) {
		setSize(7*echelle+4, 6*echelle+4);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(238,254,221));
		g.fillRect(2, 2, getWidth()-4, getHeight()-4);
		
		g.setColor(Color.GRAY);
		for (int i=1;i<7;i++) {
			g.drawLine(i*echelle+2, 2, i*echelle+2, 6*echelle+2);
		}
		for (int i=1;i<6;i++) {
			g.drawLine(2, i*echelle+2, 7*echelle+2, i*echelle+2);
		}
		
		t.dessiner(g, echelle);
	}

	public void addForme(Forme forme) {
		t.addForme(forme);
	}

	public boolean existeUneHauteurRemplie() {
		return t.existeUneHauteurRemplie();
	}

	public int pointsJoueur1() {
		return t.pointsJoueur1();
	}
	
	public int pointsJoueur2() {
		return t.pointsJoueur2();
	}
	
	public JPanelTable clone() {
		return new JPanelTable(this);
	}
	
}
