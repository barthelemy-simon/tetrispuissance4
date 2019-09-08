
import java.util.Scanner;

public class TetrisPuissance4NonGraphique  {

	//ATTRIBUTS
	private Table t;
	private Deplacement d;
	private Suivants s;
	
	public static final int HAUTEUR = 6;
	public static final int LARGEUR = 7;
	
	
	//CONSTRUCTEUR
	public TetrisPuissance4NonGraphique() {
		t = new Table();
		d = new Deplacement();
		s = new Suivants();
		System.out.println(this.toString());
	}
	
	public void jouer() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!d.formeNull()) {
			System.out.print("Quelle action réaliser?");
			String action = sc.nextLine();
			if (action.equals("g")) {
				d.left();
				System.out.println(this.toString());
			} else if (action.equals("d")) {
				d.right();
				System.out.println(this.toString());
			} else if (action.equals("r")) {
				d.rotate();
				System.out.println(this.toString());
			} else if (action.equals("t")) {
				t.addForme(d.getForme());
				d.newForme(s.firstForme());
				if (t.existeUneHauteurRemplie()) {
					s.changeFormeFin();
				} else {
					s.changeFormes();
				}
				System.out.println(this.toString());
			}
		}
		System.out.println(this.finDePartie());
	}

	public String toString() {
		return "\n\n TOUR EN COURS \n\nZone de déplacement :\n" + d.toString() + "\n\nTable :\n" + t.toString() + "\n\nFigures Suivantes :\n" + s.toString();
	}
	
	public String finDePartie() {
		String res = "La partie est finie!!\n";
		int points1 = t.pointsJoueur1();
		int points2 = t.pointsJoueur2();
		if (points1 > points2) {
			res += "Le joueur 1 gagne!\n" + points1 + " à " + points2;
		} else if (points2 > points1) {
			res += "Le joueur 2 gagne!\n" + points2 + " à " + points1;
		} else {
			res += "Égalité!! Avec " + points1 + " points chacun!";
		}
		return res;
	}
	
	public static void main(String[] args) {
		TetrisPuissance4NonGraphique g = new TetrisPuissance4NonGraphique();
		g.jouer();
	}
}
