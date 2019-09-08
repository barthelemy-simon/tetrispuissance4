
import java.awt.Color;
import java.awt.Graphics;

public class FormeO extends Forme {

	public FormeO(int posX, int posY, int[] remplissage, int rotation) {
		this.posX = posX;
		this.posY = posY;
		this.remplissage = remplissage.clone();
		this.rotation = rotation;
	}

	public FormeO() {
		this((int)(TetrisPuissance4NonGraphique.LARGEUR/2)-1, 2, remplissageAleatoire(), 0);
	}
	
	public Forme clone() {
		return new FormeO(this.posX, this.posY, this.remplissage, this.rotation);
	}

	public void rotate() {
		if (rotation == 0) {
			posX += 1;
		} else if (rotation == 1) {
			posY -= 1;
		} else if (rotation == 2) {
			posX -= 1;
		} else if (rotation == 3) {
			posY += 1;
			rotation = -1;
		}
		rotation++;
		int minX = minPosX();
		int maxX = maxPosX();

		if (minX < 0) {
			posX -= minX;
		}

		if (maxX > TetrisPuissance4NonGraphique.LARGEUR - 1) {
			posX -= (maxX - TetrisPuissance4NonGraphique.LARGEUR + 1);
		}

	}

	public int[] getPositionsX() {
		int[] res = new int[4];
		if (rotation == 0) {
			res[0] = posX;
			res[1] = posX + 1;
			res[2] = posX + 1;
			res[3] = posX;
		} else if (rotation == 1) {
			res[0] = posX;
			res[1] = posX;
			res[2] = posX - 1;
			res[3] = posX - 1;
		} else if (rotation == 2) {
			res[0] = posX;
			res[1] = posX - 1;
			res[2] = posX - 1;
			res[3] = posX;
		} else if (rotation == 3) {
			res[0] = posX;
			res[1] = posX;
			res[2] = posX + 1;
			res[3] = posX + 1;
		}
		return res;
	}

	public int[] getPositionsY() {
		int[] res = new int[4];
		if (rotation == 0) {
			res[0] = posY;
			res[1] = posY;
			res[2] = posY - 1;
			res[3] = posY - 1;
		} else if (rotation == 1) {
			res[0] = posY;
			res[1] = posY - 1;
			res[2] = posY - 1;
			res[3] = posY;
		} else if (rotation == 2) {
			res[0] = posY;
			res[1] = posY;
			res[2] = posY + 1;
			res[3] = posY + 1;
		} else if (rotation == 3) {
			res[0] = posY;
			res[1] = posY + 1;
			res[2] = posY + 1;
			res[3] = posY;
		}
		return res;
	}
	
	public void dessiner(Graphics g, int i, int echelle) {
		int[] posiX = getPositionsX();
		int[] posiY = getPositionsY();
		for (int j=0;j<4;j++) {
			int x = posiX[j];
			int y = posiY[j] - 4*i -3;
			if (getJoueur(j) == 1) {
				g.setColor(new Color(150, 150, 0));
				g.fillRect(x*echelle+2, (- y)*echelle+2, echelle, echelle);
				g.setColor(new Color(200, 200, 0));
				g.fillRect(x*echelle+4, (- y)*echelle+4, echelle-4, echelle-4);
				g.setColor(new Color(250, 250, 0));
				g.fillRect(x*echelle+6, (- y)*echelle+6, echelle-8, echelle-8);
			} else {
				g.setColor(new Color(150, 0, 0));
				g.fillRect(x*echelle+2, (- y)*echelle+2, echelle, echelle);
				g.setColor(new Color(200, 0, 0));
				g.fillRect(x*echelle+4, (- y)*echelle+4, echelle-4, echelle-4);
				g.setColor(new Color(250, 0, 0));
				g.fillRect(x*echelle+6, (- y)*echelle+6, echelle-8, echelle-8);
			}
		}
	}

}
