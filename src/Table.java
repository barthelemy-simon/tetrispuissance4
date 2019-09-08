
import java.awt.Color;
import java.awt.Graphics;


public class Table {
	
	protected int[][] grille;
	
	public Table(int hauteur, int largeur) {
		grille = new int[hauteur][largeur];
	}
	
	public Table() {
		this(TetrisPuissance4NonGraphique.HAUTEUR, TetrisPuissance4NonGraphique.LARGEUR);
	}
	
	public Table(Table t) {
		this.grille = t.grille.clone();
	}

	public void addForme(Forme forme) {
		int[] positionsX = forme.getPositionsX();
		int[] positionsY = forme.getPositionsY();
		int posY = forme.getPosY();
		int max = hauteurRemplie(positionsX[0]) - (positionsY[0] - posY-1);
		for (int i=1;i<4;i++) {
			int m = hauteurRemplie(positionsX[i]) - (positionsY[i] - posY-1);
			if (m > max) {
				max = m;
			}
		}
		
		for (int i=0; i<4; i++) {
			if ((max + (positionsY[i] - posY)) < grille.length) {
				grille[max + (positionsY[i] - posY)][positionsX[i]] = forme.getJoueur(i);
			}
		}
	}

	private int hauteurRemplie(int i) {
		int j=grille.length-1;
		while (j >= 0 && grille[j][i] == 0) {
			j--;
		}
		return j;
		
	}
	
	public String toString() {
		String res = "";
		for (int i=grille.length-1;i>=0;i--) {
			for (int j=0;j<grille[0].length;j++) {
				res += grille[i][j] + " ";
			}
			res += '\n';
		}
		return res;
	}
	
	public boolean existeUneHauteurRemplie() {
		for (int i=0;i<grille[0].length;i++) {
			if (hauteurRemplie(i) >= grille.length-1) {
				return true;
			}
		}
		return false;
	}
	
	public int pointsJoueur1() {
		int res = 0;
		int[][] listeLignes = this.listeDesLignes();
		int[][] listeColonnes = this.listeDesColonnes();
		int[][] listeDiagA = this.listeDesDiagonalesA();
		int[][] listeDiagB = this.listeDesDiagonalesB();

		for (int i=0;i<listeLignes.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeLignes[0].length;j++) {
				if (souvenir1 == 1 && souvenir2 == 1 && souvenir3 == 1 && listeLignes[i][j] == 1) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeLignes[i][j];
			}
		}
		
		for (int i=0;i<listeColonnes.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeColonnes[0].length;j++) {
				if (souvenir1 == 1 && souvenir2 == 1 && souvenir3 == 1 && listeColonnes[i][j] == 1) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeColonnes[i][j];
			}
		}
		
		for (int i=0;i<listeDiagA.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeDiagA[0].length;j++) {
				if (souvenir1 == 1 && souvenir2 == 1 && souvenir3 == 1 && listeDiagA[i][j] == 1) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeDiagA[i][j];
			}
		}
		
		for (int i=0;i<listeDiagB.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeDiagB[0].length;j++) {
				if (souvenir1 == 1 && souvenir2 == 1 && souvenir3 == 1 && listeDiagB[i][j] == 1) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeDiagB[i][j];
			}
		}
		
		return res;
	}
	
	public int pointsJoueur2() {
		int res = 0;
		int[][] listeLignes = this.listeDesLignes();
		int[][] listeColonnes = this.listeDesColonnes();
		int[][] listeDiagA = this.listeDesDiagonalesA();
		int[][] listeDiagB = this.listeDesDiagonalesB();

		for (int i=0;i<listeLignes.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeLignes[0].length;j++) {
				if (souvenir1 == 2 && souvenir2 == 2 && souvenir3 == 2 && listeLignes[i][j] == 2) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeLignes[i][j];
			}
		}
		
		for (int i=0;i<listeColonnes.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeColonnes[0].length;j++) {
				if (souvenir1 == 2 && souvenir2 == 2 && souvenir3 == 2 && listeColonnes[i][j] == 2) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeColonnes[i][j];
			}
		}
		
		for (int i=0;i<listeDiagA.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeDiagA[0].length;j++) {
				if (souvenir1 == 2 && souvenir2 == 2 && souvenir3 == 2 && listeDiagA[i][j] == 2) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeDiagA[i][j];
			}
		}
		
		for (int i=0;i<listeDiagB.length;i++) {
			int souvenir1 = 0;
			int souvenir2 = 0;
			int souvenir3 = 0;
			for (int j=0;j<listeDiagB[0].length;j++) {
				if (souvenir1 == 2 && souvenir2 == 2 && souvenir3 == 2 && listeDiagB[i][j] == 2) {
					res++;
				}
				souvenir3 = souvenir2;
				souvenir2 = souvenir1;
				souvenir1 = listeDiagB[i][j];
			}
		}
		
		return res;
	}
	
	private int[][] listeDesColonnes() {
		int[][] res = new int[grille[0].length][grille.length];
		for (int i=0; i<res.length; i++) {
			for (int j=0; j<res[0].length; j++) {
				res[i][j] = this.grille[j][i];
			}
		}
		return res;
	}

	private int[][] listeDesLignes() {
		return grille.clone();
	}
	
	private int[][] listeDesDiagonalesB() {
		int longueur = grille.length + grille[0].length - 1;
		int[][] res = new int[longueur][grille[0].length];
		int compteur = 0;
		for (int i=0;i<grille.length;i++) {
			for (int j=0; j<=i; j++) {
				res[i][j] = grille[j][i-j];
			}
			compteur++;

		}
		
		for (int i=1; i<grille[0].length; i++) {
			for (int j=grille[0].length-1; j >= i; j--) {
				res[compteur+i-1][j] = grille[i-j+grille.length-1][j];
			}
		}
		return res;
	}

	private int[][] listeDesDiagonalesA() {
		int longueur = grille.length + grille[0].length - 1;
		int[][] res = new int[longueur][grille[0].length];
		int compteur = 0;
		for (int i=0;i<grille.length;i++) {
			for (int j = grille.length - 1; j>=grille.length-1-i; j--) {
				res[i][grille.length - 1 - j] = grille[j][i+j-(grille.length-1)];
			}
			compteur++;
		}
		
		for (int i=grille.length-1; i>=0; i--) {
			for (int j=grille[0].length-1;j>(grille.length-1)-i;j--) {
				res[compteur][grille[0].length-1-j] = grille[i+j-(grille[0].length-1)][j];
			}
			compteur++;
		}
		
		return res;
	}

	public void dessiner(Graphics g, int echelle) {
		for (int i=grille.length-1;i>=0;i--) {
			for (int j=0;j<grille[0].length;j++) {
				if (grille[i][j] == 1) {
					g.setColor(new Color(150, 150, 0));
					g.fillRect(j*echelle+2, (TetrisPuissance4NonGraphique.HAUTEUR - i - 1)*echelle+2, echelle, echelle);
					g.setColor(new Color(200, 200, 0));
					g.fillRect(j*echelle+4, (TetrisPuissance4NonGraphique.HAUTEUR - i - 1)*echelle+4, echelle-4, echelle-4);
					g.setColor(new Color(250, 250, 0));
					g.fillRect(j*echelle+6, (TetrisPuissance4NonGraphique.HAUTEUR - i - 1)*echelle+6, echelle-8, echelle-8);
				} else if (grille[i][j] == 2) {
					g.setColor(new Color(150, 0, 0));
					g.fillRect(j*echelle+2, (TetrisPuissance4NonGraphique.HAUTEUR - i - 1)*echelle+2, echelle, echelle);
					g.setColor(new Color(200, 0, 0));
					g.fillRect(j*echelle+4, (TetrisPuissance4NonGraphique.HAUTEUR - i - 1)*echelle+4, echelle-4, echelle-4);
					g.setColor(new Color(250, 0, 0));
					g.fillRect(j*echelle+6, (TetrisPuissance4NonGraphique.HAUTEUR - i - 1)*echelle+6, echelle-8, echelle-8);
				}
			}
		}
	}
	
	public Table clone() {
		return new Table(this);
	}
}
