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
	private Controller controller;
	
	

	public Graphics graphics;
	public BufferedImage screen;
	private JButton towerButton;
	private JButton blockerButton;
	private JButton blueStoneButton;
	private JButton blackStoneButton;
	private JButton greenStoneButton;
	private JButton redStoneButton;
	private ButtonGroup radioButtons;
	private JRadioButton damageElf;
	private JRadioButton damageHuman;
	private JRadioButton damageHobbit;
	private JRadioButton damageDwarf;

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
		/*CreateTowerController ctc = new CreateTowerController();
		ctc.setView(this);*/
		towerButton.addActionListener(new CreateTowerController());
		blockerButton = new JButton("Create Blocker");
		blockerButton.setPreferredSize(new Dimension(120,30));
		blockerButton.addActionListener(new CreateBlockerController());
	
		elementButtons.add(towerButton);
		elementButtons.add(blockerButton);
		elementButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		elementButtons.setPreferredSize(new Dimension(150,170));
		
		JPanel stoneButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,50,27));
		stoneButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blueStoneButton = new JButton("Blue Stone");
		blueStoneButton.setPreferredSize(new Dimension(120,30));
		blueStoneButton.addActionListener(new BlueStoneController());
		blackStoneButton = new JButton("Black Stone");
		blackStoneButton.setPreferredSize(new Dimension(120,30));
		blackStoneButton.addActionListener(new BlackStoneController());
		greenStoneButton = new JButton("Green Stone");
		greenStoneButton.setPreferredSize(new Dimension(120,30));
		greenStoneButton.addActionListener(new GreenStoneController());
		redStoneButton = new JButton("Red Stone");
		redStoneButton.setPreferredSize(new Dimension(120,30));
		redStoneButton.addActionListener(new RedStoneController());
		stoneButtons.add(blueStoneButton);
		stoneButtons.add(blackStoneButton);
		stoneButtons.add(greenStoneButton);
		stoneButtons.add(redStoneButton);
		stoneButtons.setPreferredSize(new Dimension(150,260));
		
		JPanel enemyChoose = new JPanel(new FlowLayout(FlowLayout.LEADING,18,10));
		radioButtons = new ButtonGroup();
		damageElf = new JRadioButton();
		damageElf.addActionListener(new ElfRedStoneController());
		damageHuman = new JRadioButton();
		damageHuman.addActionListener(new HumanRedStoneController());
		damageHobbit = new JRadioButton();
		damageHobbit.addActionListener(new HobbitRedStoneController());
		damageDwarf = new JRadioButton();
		damageDwarf.addActionListener(new DwarfRedStoneController());
		radioButtons.add(damageElf);
		radioButtons.add(damageHuman);
		radioButtons.add(damageHobbit);
		radioButtons.add(damageDwarf);
		enableAllRadioButtons(false);
		
		enemyChoose.setPreferredSize(new Dimension(150,140));
		enemyChoose.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		enemyChoose.add(damageElf);
		enemyChoose.add(new JLabel("damage Elf"));
		enemyChoose.add(damageHuman);
		enemyChoose.add(new JLabel("damage Human"));
		enemyChoose.add(damageHobbit);
		enemyChoose.add(new JLabel("damage Hobbit"));
		enemyChoose.add(damageDwarf);
		enemyChoose.add(new JLabel("damage Dwarf"));
		field = new MapField();
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setView(this);
		field.addMouseListener(controller);
		
		int x = 0;
		int y = 0;
		
		//details panel hozzadasa a frame-hez
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		pane.add(details,gbc);
		
		y++;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		pane.add(elementButtons,gbc);
		
		x++;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = 3;
		pane.add(field,gbc);
		
		//stoneButtons panel hozzadasa
		x--;
		y++;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = 1;
		pane.add(stoneButtons,gbc);
		
		//enemyChoose panel hozzadasa
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
	
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Osszes gomb aktivalasa, amelyik nem aktiv
	 */
	public void enableAllButtons(){
		if(towerButton.isEnabled() == false) towerButton.setEnabled(true);
		if(blockerButton.isEnabled() == false) blockerButton.setEnabled(true);
		if(blueStoneButton.isEnabled() == false) blueStoneButton.setEnabled(true);
		if(blackStoneButton.isEnabled() == false) blackStoneButton.setEnabled(true);
		if(redStoneButton.isEnabled() == false) redStoneButton.setEnabled(true);
		if(greenStoneButton.isEnabled() == false) greenStoneButton.setEnabled(true);
		enableAllRadioButtons(false);
	}
	
	public void enableAllRadioButtons(boolean enable){
		damageElf.setSelected(enable);
		damageElf.setEnabled(enable);
		damageHuman.setEnabled(enable);
		damageHobbit.setEnabled(enable);
		damageDwarf.setEnabled(enable);
		if(enable == false)radioButtons.clearSelection();
	}
	
	



	public void drawIcon(int x, int y) {
		BufferedImage image;
		try {
			BufferedImage bg = ImageIO.read(new File("testmap.jpg"));
			graphics.drawImage(bg,0,0,null);
			image = ImageIO.read(new File("logo.jpg"));
			graphics.drawImage(image,x,y,null);
			field.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
