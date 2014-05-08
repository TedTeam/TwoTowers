package tedteam.twotowers.main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

enum Type{elso,masodik}
public class View {

	private Map<Point,Type> roads;
	public MapField field;
	public Graphics graphics;
	public BufferedImage screen;
	private JButton towerButton;
	private JButton blockerButton;
	private JButton blueStoneButton;
	private JButton blackStoneButton;
	private JButton greenStoneButton;
	private JButton redStoneButton;

	public void init(){
		screen = new BufferedImage(500,320,BufferedImage.TYPE_INT_RGB);
		graphics = screen.createGraphics();
		JFrame frame = new JFrame("Two Towers - The Game");
		JPanel pane = new JPanel(new GridBagLayout());
		frame.getContentPane().add(pane);
		GridBagConstraints gbc = new GridBagConstraints();
		pane.setPreferredSize(new Dimension(800,600));
		
		
		JPanel details = new JPanel(new GridLayout(1,6));
		
		details.add(new JLabel("MaxMana:  ",JLabel.RIGHT));
		details.add(new JLabel("100"));
		details.add(new JLabel("ActualMana:  ",JLabel.RIGHT));
		details.add(new JLabel("20"));
		details.add(new JLabel("DeadEnemies:  ",JLabel.RIGHT));
		details.add(new JLabel("xxx"));
		details.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		details.setPreferredSize(new Dimension(800,30));
		
		JPanel elementButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,50,30));

		towerButton = new JButton("Create Tower");
		towerButton.setPreferredSize(new Dimension(120,30));
		blockerButton = new JButton("Create Blocker");
		blockerButton.setPreferredSize(new Dimension(120,30));
	
		elementButtons.add(towerButton);
		elementButtons.add(blockerButton);
		elementButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		elementButtons.setPreferredSize(new Dimension(150,170));
		
		JPanel stoneButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,50,27));
		stoneButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blueStoneButton = new JButton("Blue Stone");
		blueStoneButton.setPreferredSize(new Dimension(120,30));
		blackStoneButton = new JButton("Black Stone");
		blackStoneButton.setPreferredSize(new Dimension(120,30));
		greenStoneButton = new JButton("Green Stone");
		greenStoneButton.setPreferredSize(new Dimension(120,30));
		redStoneButton = new JButton("Red Stone");
		redStoneButton.setPreferredSize(new Dimension(120,30));
		stoneButtons.add(blueStoneButton);
		stoneButtons.add(blackStoneButton);
		stoneButtons.add(greenStoneButton);
		stoneButtons.add(redStoneButton);
		stoneButtons.setPreferredSize(new Dimension(150,260));
		
		JPanel enemyChoose = new JPanel(new FlowLayout(FlowLayout.LEADING,18,10));
		ButtonGroup radioButtons = new ButtonGroup();
		JRadioButton damageElf = new JRadioButton();
		JRadioButton damageHuman = new JRadioButton();
		JRadioButton damageHobbit = new JRadioButton();
		JRadioButton damageDwarf = new JRadioButton();
		radioButtons.add(damageElf);
		radioButtons.add(damageHuman);
		radioButtons.add(damageHobbit);
		radioButtons.add(damageDwarf);
		enemyChoose.setPreferredSize(new Dimension(150,140));
		enemyChoose.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		enemyChoose.add(damageElf);
		enemyChoose.add(new JLabel("damage Elf"));
		enemyChoose.add(damageHobbit);
		enemyChoose.add(new JLabel("damage Human"));
		enemyChoose.add(damageHuman);
		enemyChoose.add(new JLabel("damage Hobbit"));
		enemyChoose.add(damageDwarf);
		enemyChoose.add(new JLabel("damage Dwarf"));
		field = new MapField();
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
		gbc.gridheight = 3;
		pane.add(field,gbc);
		
		//add stoneButtons panel
		x--;
		y++;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = 1;
		pane.add(stoneButtons,gbc);
		
		//add enemyChoose panel
		y++;
		gbc.gridx = x;
		gbc.gridy = y;
		pane.add(enemyChoose,gbc);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("logo.jpg").getImage());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void modifyField(){
	
		try {
			BufferedImage bg = ImageIO.read(new File("testmap.jpg"));
			BufferedImage image = ImageIO.read(new File("logo.jpg"));
			graphics.drawImage(bg,0,0,null);
			graphics.drawImage(image,10,15,null);
			graphics.drawImage(image,70,-3,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
}
