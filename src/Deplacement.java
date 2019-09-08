
import java.awt.Graphics;


public class Deplacement {
	
	//ATTRIBUTS
	private Forme f;
	
	//CONSTRUCTEUR
	public Deplacement() {
		f = Forme.aleatoire();
	}

	public void newForme(Forme f) {
		if (f == null) {
			this.f = null;
		} else {
			this.f = f.clone();
		}
	}
	
	public void left() {
		f.left();
	}

	public void right() {
		f.right();
	}

	public void rotate() {
		f.rotate();
	}

	public Forme getForme() {
		return f;
	}
	
	public boolean formeNull() {
		return f == null;
	}
	
	public String toString() {
		if (f == null) {
			return "";
		} else {
			return f.toString();
		}
	}

	public void dessiner(Graphics g, int echelle) {
		if (f!=null) {
			f.dessiner(g, 0, echelle);
		}
	}
}
