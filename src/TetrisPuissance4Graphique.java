
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;


public class TetrisPuissance4Graphique extends JPanel implements KeyListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	private JPanelDeplacement d;
	private JPanelSuivants s;
	private JPanelTable t;
	private JPanelEtat e;
	
	private JPanelFin f;
	
	private boolean partieFinie;
	private boolean partiePreFinie;
	private boolean debutPartie;
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	public TetrisPuissance4Graphique(int joueur, Joueur joueur1, Joueur joueur2) {	
		
		partieFinie = false;
		debutPartie = true;
		partiePreFinie = false;
		
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		
		d = new JPanelDeplacement();
		s = new JPanelSuivants();
		t = new JPanelTable();
		e = new JPanelEtat(joueur, joueur1, joueur2);
		
		d.setBounds(0,0,7*JPanelDeplacement.echelle+4, 5*JPanelDeplacement.echelle+4);		
		this.add(d);
		
		s.setBounds(7*JPanelDeplacement.echelle+4, 0, 7*JPanelSuivants.echelle+4, 12*JPanelSuivants.echelle+4);
		this.add(s);
		
		t.setBounds(0, 5*JPanelDeplacement.echelle+4, 7*JPanelTable.echelle+4, 6*JPanelTable.echelle+4);
		this.add(t);
		
		e.setBounds(7*JPanelDeplacement.echelle+4, 12*JPanelSuivants.echelle, 7*JPanelSuivants.echelle+4, 5*JPanelDeplacement.echelle+4+6*JPanelTable.echelle+4-12*JPanelSuivants.echelle+4);
		this.add(e);
		
		
		this.setLayout(null);
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.setVisible(true);
		this.setSize(7*JPanelDeplacement.echelle+4 + 7*JPanelSuivants.echelle+4, 5*JPanelDeplacement.echelle + 4 + 6*JPanelTable.echelle+4 +22);
		this.setFocusable(true);
	}

	public void keyPressed(KeyEvent e) {
		if (this.debutPartie) {
			debutPartie = false;
			repaint();
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur2 && e.getKeyCode() == KeyEvent.VK_LEFT) {
			d.left();
			repaint();
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur2 && e.getKeyCode() == KeyEvent.VK_RIGHT) {
			d.right();
			repaint();
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur2 && e.getKeyCode() == KeyEvent.VK_UP) {
			d.rotate();
			repaint();
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur2 && e.getKeyCode() ==  KeyEvent.VK_DOWN) {
			this.e.changeJoueur();
			t.addForme(d.getForme());
			d.newForme(s.firstForme());
			if (t.existeUneHauteurRemplie()) {
				s.changeFormeFin();
			} else {
				s.changeFormes();
			}
			repaint();
			
			if (d.getForme() == null) {
				partiePreFinie = true;
				this.e.changeJoueur();
				
				d.removeAll();
				this.remove(d);
				d = null;
				f = new JPanelFin(t, joueur1, joueur2);
				f.setBounds(0,0,7*JPanelDeplacement.echelle+4, 5*JPanelDeplacement.echelle+4);		
				this.add(f);
				
				repaint();
				
			}
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur1 && e.getKeyCode() == KeyEvent.VK_Q) {
			d.left();
			repaint();
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur1 && e.getKeyCode() == KeyEvent.VK_D) {
			d.right();
			repaint();
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur1 && e.getKeyCode() == KeyEvent.VK_Z) {
			d.rotate();
			repaint();
		} else if (!this.partiePreFinie && this.e.getJoueur() == this.joueur1 && e.getKeyCode() ==  KeyEvent.VK_S) {
			this.e.changeJoueur();
			t.addForme(d.getForme());
			d.newForme(s.firstForme());
			if (t.existeUneHauteurRemplie()) {
				s.changeFormeFin();
			} else {
				s.changeFormes();
			}
			repaint();
			
			if (d.getForme() == null) {
				partiePreFinie = true;
				this.e.changeJoueur();
				
				d.removeAll();
				this.remove(d);
				d = null;
				f = new JPanelFin(t, joueur1, joueur2);
				f.setBounds(0,0,7*JPanelDeplacement.echelle+4, 5*JPanelDeplacement.echelle+4);		
				this.add(f);
				
				repaint();
			}
		} else if (this.partiePreFinie) {
			partieFinie = true;
		}
	}
	
	public void paint(Graphics g) {
		paintComponents(g);
		if (debutPartie) {
			g.setColor(new Color(25,25,25,200));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(new Color(175,175,175));
			g.setFont(new Font("Calibri", Font.BOLD, 20));
			g.drawString("La partie va commencer.", 170, 100);
			g.drawString("Le premier à jouer est le joueur " + e.getJoueur().getNom() + ".", 100, 200);
			g.setFont(new Font("Calibri", Font.PLAIN, 16));
			g.drawString(joueur1.getNom() + " est en jaune.", 40, 300);
			g.drawString("Il joue avec les touches ZQSD.", 40, 350);
			g.drawString(joueur2.getNom() + " est en rouge.", 295, 300);
			g.drawString("Il joue avec les flèches.", 295, 350);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			g.setFont(new Font("Calibri", Font.BOLD, 20));
			g.drawString("PRESSEZ N'IMPORTE QUELLE TOUCHE", 100, 430);
			g.drawString("POUR CONTINUER", 200, 460);
			
		}
	}
	
	public void keyReleased(KeyEvent e) {}

	public boolean renvoieFinPartie() {
		return partieFinie;
	}

	public int getScore1() {
		return t.pointsJoueur1();
	}

	public int getScore2() {
		return t.pointsJoueur2();
	}

	public void mouseClicked(MouseEvent e) {
		if (debutPartie) {
			debutPartie = false;
			repaint();
		} else if (partiePreFinie) {
			partieFinie = true;
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
	public void keyTyped(KeyEvent e) {}

}
