package tedteam.twotowers.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MapField extends JPanel{

	View view;
	
	public void setView(View v){
		this.view = v;
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(view.screen,0,0,null);
		System.out.println("repainted");
		
	}
}
