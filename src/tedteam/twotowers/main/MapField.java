package tedteam.twotowers.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * Egy JPanel leszarmazott osztaly, melyre rajzolunk a jatek soran.
 */
public class MapField extends JPanel{

	View view;
	
	public void setView(View v){
		this.view = v;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(view.getScreen(),0,0,null);
		
	}
}
