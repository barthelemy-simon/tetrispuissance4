
import javax.swing.JFrame;

public class Jeu extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private TetrisPuissance4Graphique t;
	private JPanelDemarrage d;

	private Joueur joueur1;
	private Joueur joueur2;

	public Jeu() {

		t = null;
		d = new JPanelDemarrage(true, null, null);

		this.add(d);

		this.setSize(568,580);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
	}

	public static void main(String[] args) {
		Jeu j = new Jeu();
		j.setVisible(true);
		j.animer();
	}

	public void run() {
		while (true) {
			if (d != null && d.renvoieNouvellePartie()) {
				
				d.removeAll();
				this.remove(d);
				d = null;
				repaint();
				
				JPanelDemandeJoueur demande = new JPanelDemandeJoueur();
				this.add(demande);
				demande.setBounds(0, 0, getWidth(), getHeight());
				demande.setVisible(true);
				repaint();
				
				while (!demande.isFinie()) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {}
				}
				
				joueur1 = demande.getJoueur1();
				joueur2 = demande.getJoueur2();
				
				demande.removeAll();
				this.remove(demande);
				demande = null;
				repaint();

				t = new TetrisPuissance4Graphique((int)(2*Math.random())+1, joueur1, joueur2);
				t.setVisible(true);
				this.add(t);
				t.requestFocus();
				t.revalidate();

				repaint();

			} else if (d != null && !d.estPremierePartie() &&  d.renvoieContinuer()) {

				d.removeAll();
				this.remove(d);
				d = null;
				repaint();

				t = new TetrisPuissance4Graphique((int)(2*Math.random())+1, joueur1, joueur2);
				t.setVisible(true);
				this.add(t);
				t.requestFocus();
				t.revalidate();

				repaint();

			} else if (t != null && t.renvoieFinPartie()) {

				int score1 = t.getScore1();
				int score2 = t.getScore2();

				if (score1 > score2) this.joueur1.up();
				else if (score2 > score1) this.joueur2.up();

				t.removeAll();
				this.remove(t);
				t = null;
				repaint();

				d = new JPanelDemarrage(false, this.joueur1, this.joueur2);
				d.setVisible(true);
				this.add(d);
				d.revalidate();

				repaint();
			} else if (d != null && d.renvoieQuitter()) {
				System.exit(3);
			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}

	public void animer() {
		Thread t = new Thread(this);
		t.start();
	}
	
}