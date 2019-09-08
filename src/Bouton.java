
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;
	private boolean pressed;
	private boolean actif;
	
	public Bouton(String s, boolean actif) {
		super(s);
		pressed = false;
		this.actif = actif;
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(50,86,68));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (!actif) {
			g.setColor(Color.GRAY);
			g.fillRect(5, 3, this.getWidth()-8, this.getHeight()-8);
			g.setColor(new Color(10,46,28));
			g.drawString(this.getText(), this.getWidth()/2 - 3*this.getText().length(), this.getHeight()/2);
		} else if (!pressed) {
			g.setColor(new Color(89,142,123));
			g.fillRect(5, 3, this.getWidth()-8, this.getHeight()-8);
			g.setColor(new Color(10,46,28));
			g.drawString(this.getText(), this.getWidth()/2 - 3*this.getText().length(), this.getHeight()/2);
		} else {
			g.setColor(new Color(30,66,48));
			g.fillRect(3, 5, this.getWidth()-8, this.getHeight()-8);
			g.setColor(new Color(10,46,28));
			g.drawString(this.getText(), this.getWidth()/2 - 3*this.getText().length()-2, this.getHeight()/2+2);
		}
		

	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		pressed = true;
	}

	public void mouseReleased(MouseEvent e) {
		pressed = false;
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
}
