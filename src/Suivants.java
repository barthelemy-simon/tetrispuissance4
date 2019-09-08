
import java.awt.*;


public class Suivants {
	
	//ATTRIBUTS
	protected Forme f1;
	protected Forme f2;
	protected Forme f3;
	
	//CONSTRUCTEUR
	public Suivants() {
		f1 = Forme.aleatoire();
		f2 = Forme.aleatoire();
		f3 = Forme.aleatoire();
	}

	public Forme firstForme() {
		return f1;
	}

	public void changeFormes() {
		f1 = f2.clone();
		f2 = f3.clone();
		f3 = Forme.aleatoire();
	}
	
	public  void changeFormeFin() {
		if (f2 == null) {
			f1 = null;
		} else if (f3 == null) {
			f2 = null;
		} else {
			f1 = f2.clone();
			f2 = f3.clone();
			f3 = null;
		}
	}
	
	public String toString() {
		if (f1 == null) {
			return "";
		} else if (f2 == null) {
			return f1.toString();
		} else if (f3 == null) {
			return f1.toString() + "\n\n" + f2.toString();
		} else {
			return f1.toString() + "\n\n" + f2.toString() + "\n\n" + f3.toString();
		}
	}

	public void dessiner(Graphics g, int echelle) {
		if (f1 != null) {
			f1.dessiner(g, 0, echelle);
		} else {
			g.setFont(new Font("Calibri",Font.PLAIN, 15));
			g.setColor(Color.BLACK);
			g.drawString("Aucune autre forme", 10, 20);
			g.drawString("n'apparaîtra : ", 10, 40);
			g.drawString("la partie va se terminer", 10, 60);
		}
		if (f2 != null) {
			f2.dessiner(g, 1, echelle);
		}  else {
			g.setFont(new Font("Calibri",Font.PLAIN, 15));
			g.setColor(Color.BLACK);
			g.drawString("Aucune autre forme", 10, 20 + 4*JPanelSuivants.echelle);
			g.drawString("n'apparaîtra : ", 10, 40 + 4*JPanelSuivants.echelle);
			g.drawString("la partie va se terminer", 10, 60 + 4*JPanelSuivants.echelle);
		}
		if (f3 != null) {
			f3.dessiner(g, 2, echelle);
		} else {
			g.setFont(new Font("Calibri",Font.PLAIN, 15));
			g.setColor(Color.BLACK);
			g.drawString("Aucune autre forme", 10, 20 + 8*JPanelSuivants.echelle);
			g.drawString("n'apparaîtra : ", 10, 40 + 8*JPanelSuivants.echelle);
			g.drawString("la partie va se terminer", 10, 60 + 8*JPanelSuivants.echelle);
		}
	}
	
}
