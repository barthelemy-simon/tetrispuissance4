public class FormeJ extends Forme {

	public FormeJ(int posX, int posY, int[] remplissage, int rotation) {
		this.posX = posX;
		this.posY = posY;
		this.remplissage = remplissage.clone();
		this.rotation = rotation;
	}

	public FormeJ() {
		this((int)(TetrisPuissance4NonGraphique.LARGEUR/2)+1, 2, remplissageAleatoire(), 0);
	}
	
	public Forme clone() {
		return new FormeJ(this.posX, this.posY, this.remplissage, this.rotation);
	}

	public void rotate() {
		if (rotation == 0) {
			posX -= 1;
			posY -= 1;
		} else if (rotation == 1) {
			posX -= 1;
			posY += 1;
		} else if (rotation == 2) {
			posX += 1;
			posY += 1;
		} else if (rotation == 3) {
			posX += 1;
			posY -= 1;
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
			res[1] = posX - 1;
			res[2] = posX - 2;
			res[3] = posX - 2;
		} else if (rotation == 1) {
			res[0] = posX;
			res[1] = posX;
			res[2] = posX;
			res[3] = posX + 1;
		} else if (rotation == 2) {
			res[0] = posX;
			res[1] = posX + 1;
			res[2] = posX + 2;
			res[3] = posX + 2;
		} else if (rotation == 3) {
			res[0] = posX;
			res[1] = posX;
			res[2] = posX;
			res[3] = posX - 1;
		}
		return res;
	}

	public int[] getPositionsY() {
		int[] res = new int[4];
		if (rotation == 0) {
			res[0] = posY;
			res[1] = posY;
			res[2] = posY;
			res[3] = posY + 1;
		} else if (rotation == 1) {
			res[0] = posY;
			res[1] = posY + 1;
			res[2] = posY + 2;
			res[3] = posY + 2;
		} else if (rotation == 2) {
			res[0] = posY;
			res[1] = posY;
			res[2] = posY;
			res[3] = posY - 1;
		} else if (rotation == 3) {
			res[0] = posY;
			res[1] = posY - 1;
			res[2] = posY - 2;
			res[3] = posY - 2;
		}
		return res;
	}

}
