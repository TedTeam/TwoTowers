package tedteam.twotowers.main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

enum Type{elso,masodik}
public class View {

	private Map<Point,Type> roads;
	public MapField field;
	public Graphics graphics;
	public BufferedImage screen;

	public void init(){
		screen = new BufferedImage(400,320,BufferedImage.TYPE_INT_RGB);
		graphics = screen.createGraphics();
		JFrame frame = new JFrame("Two Towers - The Game");
		JPanel pane = new JPanel(new GridBagLayout());
		frame.getContentPane().add(pane);
		GridBagConstraints gbc = new GridBagConstraints();
		pane.setPreferredSize(new Dimension(800,600));
		
		
		JPanel details = new JPanel(new GridLayout(1,6));
		
		details.add(new JLabel("MaxMana"));
		details.add(new JLabel("100"));
		details.add(new JLabel("ActualMana"));
		details.add(new JLabel("20"));
		details.add(new JLabel("DeadEnemies"));
		details.add(new JLabel("xxx"));
		details.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		details.setPreferredSize(new Dimension(800,50));
		
		JPanel elementButtons = new JPanel(new GridLayout(2,1,15,10));
		JButton tower = new JButton("Create Tower");
		JButton blocker = new JButton("Create Blocker");
		elementButtons.add(tower);
		elementButtons.add(blocker);
		elementButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field = new MapField();
		field.add(new JLabel("test"));
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setView(this);
		
		
		
		int x = 0;
		int y = 0;
		//add details
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		pane.add(details,gbc);
		
		y++;
		gbc.gridy = y;
		//gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		pane.add(elementButtons,gbc);
		x++;
		gbc.gridx = x;
		gbc.gridy = y;
		pane.add(field,gbc);
		
		
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("logo.jpg").getImage());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void modifyField(){
		Image img1 = Toolkit.getDefaultToolkit().getImage("logo.jpg");
		graphics.drawImage(img1,10,15,null);
	}
	
}
