
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JPanelDemarrage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Bouton nouvellePartie;
	private Bouton continuer;
	private Bouton quitter;
	
	private boolean premierePartie;
	private boolean nouvPartie;
	private boolean cont;
	private boolean quit;
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	public JPanelDemarrage(boolean premierePartie, Joueur joueur1, Joueur joueur2) {
		this.premierePartie = premierePartie;
		this.nouvPartie = false;
		this.cont = false;
		this.quit = false;
		
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		
		this.setLayout(null);
		
		nouvellePartie = new Bouton("New Game", true);
		continuer = new Bouton("Continue", !premierePartie);
		quitter = new Bouton("Exit", true);
		
		this.add(nouvellePartie);
		this.add(continuer);
		this.add(quitter);
		
		nouvellePartie.addActionListener(this);
		continuer.addActionListener(this);
		quitter.addActionListener(this);
		
		nouvellePartie.setBounds(175, 200, 200, 50);
		continuer.setBounds(175, 275, 200, 50);
		quitter.setBounds(175, 350, 200, 50);
						
		this.setVisible(true);
		this.setSize(568,558);
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(238,254,221));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Calibri", Font.BOLD, 20));
		if (premierePartie) {
			g.drawString("NEW GAME", 220, 60);
		} else {
			g.drawString("SCORE", 240, 60);
			g.drawString(joueur1.getNom() + " : " + getScore1() + " | " + getScore2() + " : " + joueur2.getNom(), 180, 90);
		}
		
		this.paintComponents(g);
	}
	
	public boolean estPremierePartie() {
		return premierePartie;
	}

	public boolean renvoieNouvellePartie() {
		return nouvPartie;
	}

	public boolean renvoieContinuer() {
		return cont;
	}
	
	public boolean renvoieQuitter() {
		return quit;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nouvellePartie) {
			nouvPartie = true;
		} else if (e.getSource() == continuer) {
			cont = true;
		} else if (e.getSource() == quitter) {
			quit = true;
		}
	}

	public int getScore1() {
		return this.joueur1.getScore();
	}

	public int getScore2() {
		return this.joueur2.getScore();
	}

}