
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelEtat extends JPanel {

	private static final long serialVersionUID = 1L;
	private int joueur;
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	public JPanelEtat(int joueur, Joueur joueur1, Joueur joueur2) {
		this.joueur = joueur;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
	public void changeJoueur() {
		if (joueur == 1) joueur =2;
		else joueur = 1;
	}
	
	public Joueur getJoueur() {
		if (joueur == 1) {
			return joueur1;
		} else {
			return joueur2;
		}
	}
	
	public void paint(Graphics g) {
		setSize(7*JPanelSuivants.echelle+4, 5*JPanelDeplacement.echelle+4+6*JPanelTable.echelle+4-12*JPanelSuivants.echelle);
		g.setFont(new Font("Calibri",Font.BOLD,20));

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(238,254,221));
		g.fillRect(2, 2, getWidth()-4, getHeight()-4);
		
		g.setColor(Color.BLACK);
		g.drawString("Tour de " + getJoueur().getNom(), 10, 50);
		g.drawString(joueur1.getNom() + " \t\t\t\t\t " + joueur2.getNom(), 10, 125);
		
		g.setColor(new Color(150, 150, 0));
		g.fillRect(25, 150, 40, 40);
		g.setColor(new Color(200, 200, 0));
		g.fillRect(25+2, 150+2, 40-4, 40-4);
		g.setColor(new Color(250, 250, 0));
		g.fillRect(25+4, 150+4, 40-8, 40-8);
		
		g.setColor(new Color(150, 0, 0));
		g.fillRect(130, 150, 40, 40);
		g.setColor(new Color(200, 0, 0));
		g.fillRect(130+2, 150+2, 40-4, 40-4);
		g.setColor(new Color(250, 0, 0));
		g.fillRect(130+4, 150+4, 40-8, 40-8);
	}
}
