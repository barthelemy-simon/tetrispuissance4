
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class JPanelFin extends JPanel {

	private static final long serialVersionUID = 1L;
	public JPanelTable t;
	private Joueur j1;
	private Joueur j2;
	
	public JPanelFin(JPanelTable t, Joueur j1, Joueur j2) {
		this.t = t;
		this.j1 = j1;
		this.j2 = j2;
	}
	
	public int gagnant() {
		int points1 = t.pointsJoueur1();
		int points2 = t.pointsJoueur2();
		if (points1 > points2) {
			return 1;
		} else if (points2 > points1) {
			return 2;
		} else {
			return 0;
		}
	}
	
	public int perdant() {
		int points1 = t.pointsJoueur1();
		int points2 = t.pointsJoueur2();
		if (points1 > points2) {
			return 2;
		} else if (points2 > points1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int pointsGagnant() {
		int points1 = t.pointsJoueur1();
		int points2 = t.pointsJoueur2();
		if (points1 > points2) {
			return points1;
		} else if (points2 > points1) {
			return points2;
		} else {
			return points1;
		}
	}
	
	public int pointsPerdant() {
		int points1 = t.pointsJoueur1();
		int points2 = t.pointsJoueur2();
		if (points1 > points2) {
			return points2;
		} else if (points2 > points1) {
			return points1;
		} else {
			return points1;
		}
	}
	
	public void paint(Graphics g) {
		setSize(7*JPanelDeplacement.echelle+4, 5*JPanelDeplacement.echelle+4);
		g.setFont(new Font("Calibri",Font.BOLD,30));
	     
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(238,254,221));
		g.fillRect(2, 2, getWidth()-4, getHeight()-4);
		
		g.setColor(Color.BLACK);
		
		if (this.gagnant()==1) {
			g.drawString(j1.getNom() + " gagne\n" + pointsGagnant() + " à " + pointsPerdant(), 15, 50);
		} else if (this.gagnant()==2) {
			g.drawString(j2.getNom() + " gagne\n" + pointsGagnant() + " à " + pointsPerdant(), 15, 50);
		} else {
			g.setColor(Color.GRAY);
			g.drawString("Égalité\n" + pointsGagnant() + " partout", 15, 50);
		}
	}
}
