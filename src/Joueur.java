

public class Joueur {

	//ATTRIBUTS
	private String nom;
	private int score;
	
	//CONSTRUCTEUR
	public Joueur(String nom) {
		this.nom = nom;
		score = 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getScore() {
		return score;
	}
	
	public void up() {
		score++;
	}
	
}
