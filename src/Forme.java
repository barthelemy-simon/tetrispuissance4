
import java.awt.Color;
import java.awt.Graphics;

public abstract class Forme {
	
	protected int posX;
	protected int posY;
	protected int rotation;
	protected int[] remplissage;
	
	public void left() {
		if (minPosX() > 0) {
			posX--;

		}
	}
	
	public void right() {
		if (maxPosX() < TetrisPuissance4NonGraphique.LARGEUR-1) {
			posX++;
		}
	}

	public static Forme aleatoire() {
		int alea = (int)(Math.random()*7);
		switch (alea) {
		case 0:
			return new FormeI();
		case 1:
			return new FormeJ();
		case 2:
			return new FormeL();
		case 3:
			return new FormeO();
		case 4:
			return new FormeS();
		case 5:
			return new FormeT();
		case 6:
			return new FormeZ();
		default:
			return null;
		}
	}
	
	public static int[] remplissageAleatoire() {
		int alea = (int)(Math.random()*6);
		if (alea == 0) {
			return new int[] {1,1,2,2};
		} else if (alea == 1) {
			return new int[] {2,2,1,1};
		} else if (alea == 2) {
			return new int[] {2,1,2,1};
		} else if (alea == 3) {
			return new int[] {1,2,1,2};
		} else if (alea == 4) {
			return new int[] {1,2,2,1};
		} else {
			return new int[] {2,1,1,2};
		}
	}
	
	public abstract Forme clone();

	public abstract void rotate();

	public abstract int[] getPositionsX();
	public abstract int[] getPositionsY();	
	
	public void dessiner(Graphics g, int i, int echelle) {
		int[] posiX = getPositionsX();
		int[] posiY = getPositionsY();
		for (int j=0;j<4;j++) {
			int x = posiX[j];
			int y = posiY[j] - 4*i - 4;
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
	
	public int getJoueur(int i) {
		return remplissage[i];
	}
		
	public int minPosX() {
		int[] positionsSurX = getPositionsX();
		int min = positionsSurX[0];
		for (int i = 1; i < 4; i++) {
			int aTester = positionsSurX[i];
			if (aTester < min) {
				min = aTester;
			}
		}
		return min;
	}

	public int maxPosX() {
		int[] positionsSurX = getPositionsX();
		int max = positionsSurX[0];
		for (int i = 1; i < 4; i++) {
			int aTester = positionsSurX[i];
			if (aTester > max) {
				max = aTester;
			}
		}
		return max;
	}

	public int getPosY() {
		return posY;
	}

	public int[][] toGrid() {
		int[][] grille = new int[4][TetrisPuissance4NonGraphique.LARGEUR];
		int[] positionsX = this.getPositionsX();
		int[] positionsY = this.getPositionsY();
		for (int i=0;i<4;i++) {
			grille[3-positionsY[i]][positionsX[i]] = remplissage[i];
		}
		return grille;
	}
	
	public String toString() {
		int[][] grille = this.toGrid();
		String res = "";
		for (int i=0;i<4;i++) {
			for (int j=0;j<TetrisPuissance4NonGraphique.LARGEUR;j++) {
				res += grille[i][j] + " ";
			}
			res += '\n';
		}
		return res;
	}
}
