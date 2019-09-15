
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelDemandeJoueur extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel texteJ1;
	private JLabel texteJ2;
	private JTextField j1;
	private JTextField j2;
	private Bouton valider;
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	private boolean finie;
	
	public JPanelDemandeJoueur() {
		finie = false;
		
		joueur1 = null;
		joueur2 = null;
		
		texteJ1 = new JLabel("Name of player 1 :");
		texteJ2 = new JLabel("Name of player 2 :");
		
		j1 = new JTextField("Pierre",6);
		j2 = new JTextField("Paul",6);
		
		valider = new Bouton("Accept", true);
		
		this.setLayout(null);
		
		texteJ1.setBounds(40,150,200,30);
		texteJ2.setBounds(300, 150, 200, 30);
		j1.setBounds(40, 200, 200, 30);
		j2.setBounds(300, 200, 200, 30);
		valider.setBounds(350,300,200,40);
		
		this.add(texteJ1);
		this.add(texteJ2);
		this.add(j1);
		this.add(j2);
		this.add(valider);
		
		valider.addActionListener(this);

		this.setSize(410, 150);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == valider) {
			joueur1 = new Joueur(j1.getText());
			joueur2 = new Joueur(j2.getText());
			finie = true;
		}
	}
	
	public Joueur getJoueur1() {
		return joueur1;
	}
	
	public Joueur getJoueur2() {
		return joueur2;
	}
	
	public boolean isFinie() {
		return finie;
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(238,254,221));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.BLACK);	
		
		paintComponents(g);
		}
}
