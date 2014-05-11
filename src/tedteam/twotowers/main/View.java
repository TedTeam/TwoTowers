package tedteam.twotowers.main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//enum Type{elso,masodik}
public class View {

	
	
	private ArrayList<Point> roads;
	//az a jpanel, amire rajzolunk
	private MapField field;
	private Controller controller;
	
	
	//ezen keresztul rajzolunk a kepre
	private Graphics graphics;
	//erre a kepre rajzolunk
	private BufferedImage screen;
	//torony letrehozas gomb es a tobbi..
	private JButton towerButton;
	private JButton blockerButton;
	private JButton blueStoneButton;
	private JButton blackStoneButton;
	private JButton greenStoneButton;
	private JButton redStoneButton;
	//radio gombokat csoportba foglalo objektum
	private ButtonGroup radioButtons;
	//radio gombok a sebzesek kivalasztasahoz
	private JRadioButton damageElf;
	private JRadioButton damageHuman;
	private JRadioButton damageHobbit;
	private JRadioButton damageDwarf;
	
	//details panel cimkei
	private JLabel maxMana;
	private JLabel actualMana;
	private JLabel enemies;
	
	private JTextField notification;
	private BufferedImage image;
	private BufferedImage background;
	private BufferedImage road;
	private BufferedImage hobbit;
	private BufferedImage elf;
	private BufferedImage human;
	private BufferedImage dwarf;
	private BufferedImage blocker;
	private BufferedImage tower;
	private BufferedImage blue;
	private BufferedImage green;
	private BufferedImage black;
	private BufferedImage red;
	private BufferedImage fog;
	/**
	 * Inicializacio, mint frame felepitese
	 */
	
	
	public void init(){
		try {
			image = ImageIO.read(new File("logo.jpg"));
			background = ImageIO.read(new File("map.jpg"));
			road = ImageIO.read(new File("road.jpg"));
			hobbit = ImageIO.read(new File("hobbit.png"));
			human = ImageIO.read(new File("human.png"));
			elf = ImageIO.read(new File("elf.png"));
			dwarf = ImageIO.read(new File("dwarf.png"));
			blocker = ImageIO.read(new File("blocker.png"));
			tower = ImageIO.read(new File("tower.png"));
			blue = ImageIO.read(new File("blue.png"));
			green = ImageIO.read(new File("green.png"));
			black = ImageIO.read(new File("black.png"));
			red = ImageIO.read(new File("red.png"));
			fog = ImageIO.read(new File("fog.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//elementek meretei
		Point buttonSize = new Point(120,30);
		Point windowSize = new Point(800,600);
		int leftSideWidth = 140;
		int rightSideWidth = 660;
		
		
		//kep letrehozasa
		screen = new BufferedImage(660,540,BufferedImage.TYPE_INT_RGB);
		graphics = screen.createGraphics();
		
		
		JFrame frame = new JFrame("Two Towers - The Game");
		JPanel pane = new JPanel(new GridBagLayout());
		frame.getContentPane().add(pane);
		//ezzel helyezhetunk el elemeket a fopanelre,a pane-re
		GridBagConstraints gbc = new GridBagConstraints();
		//ekkora az egesz ablak merete is:800x600
		pane.setPreferredSize(new Dimension(windowSize.x,windowSize.y));
		//felso informacioknak a panel
		JPanel details = new JPanel(new GridLayout(1,6));
		
		//felso panel feltoltese
		details.add(new JLabel("MaxMana:  ",JLabel.RIGHT));
		maxMana = new JLabel();
		details.add(maxMana);
		details.add(new JLabel("ActualMana:  ",JLabel.RIGHT));
		actualMana = new JLabel();
		details.add(actualMana);
		details.add(new JLabel("DeadEnemies:  ",JLabel.RIGHT));
		enemies = new JLabel();
		details.add(enemies);
		//fekete keret beallitasa
		details.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//meret 800x30
		details.setPreferredSize(new Dimension(windowSize.x,30));
		
		//tower es blocker letrehozando gombok panelje, az 50 es 30 padding ertek
		JPanel elementButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,50,30));
		towerButton = new JButton("Create Tower");
		towerButton.setPreferredSize(new Dimension(buttonSize.x,buttonSize.y));
		towerButton.addActionListener(new CreateTowerController());
		blockerButton = new JButton("Create Blocker");
		blockerButton.setPreferredSize(new Dimension(buttonSize.x,buttonSize.y));
		blockerButton.addActionListener(new CreateBlockerController());
	
		elementButtons.add(towerButton);
		elementButtons.add(blockerButton);
		elementButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		elementButtons.setPreferredSize(new Dimension(leftSideWidth,170));
		
		//kovek letrehozasanak gombjai
		JPanel stoneButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,50,27));
		stoneButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blueStoneButton = new JButton("Blue Stone");
		blueStoneButton.setPreferredSize(new Dimension(buttonSize.x,buttonSize.y));
		blueStoneButton.addActionListener(new BlueStoneController());
		blackStoneButton = new JButton("Black Stone");
		blackStoneButton.setPreferredSize(new Dimension(buttonSize.x,buttonSize.y));
		blackStoneButton.addActionListener(new BlackStoneController());
		greenStoneButton = new JButton("Green Stone");
		greenStoneButton.setPreferredSize(new Dimension(buttonSize.x,buttonSize.y));
		greenStoneButton.addActionListener(new GreenStoneController());
		redStoneButton = new JButton("Red Stone");
		redStoneButton.setPreferredSize(new Dimension(buttonSize.x,buttonSize.y));
		redStoneButton.addActionListener(new RedStoneController());
		stoneButtons.add(blueStoneButton);
		stoneButtons.add(blackStoneButton);
		stoneButtons.add(greenStoneButton);
		stoneButtons.add(redStoneButton);
		stoneButtons.setPreferredSize(new Dimension(leftSideWidth,260));
		
		JPanel enemyChoose = new JPanel(new FlowLayout(FlowLayout.LEADING,12,10));
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
		
		enemyChoose.setPreferredSize(new Dimension(leftSideWidth,140));
		enemyChoose.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		enemyChoose.add(damageElf);
		enemyChoose.add(new JLabel("damage Elf"));
		enemyChoose.add(damageHuman);
		enemyChoose.add(new JLabel("damage Human"));
		enemyChoose.add(damageHobbit);
		enemyChoose.add(new JLabel("damage Hobbit"));
		enemyChoose.add(damageDwarf);
		enemyChoose.add(new JLabel("damage Dwarf"));
		
		JPanel map = new JPanel(new FlowLayout(FlowLayout.LEADING,0,0));
		field = new MapField();
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setView(this);
		field.addMouseListener(controller);
		field.setPreferredSize(new Dimension(rightSideWidth,540));
		map.add(field);
		notification = new JTextField();
		notification.setPreferredSize(new Dimension(rightSideWidth,30));
		notification.setEditable(false);
		Font textFieldFont=new Font(notification.getFont().getName(),
				Font.BOLD,notification.getFont().getSize()+3);
		notification.setFont(textFieldFont);  
		notification.setText("Nincs ertesites!");
		notification.setHorizontalAlignment(JTextField.CENTER);
		map.add(notification);
		map.setPreferredSize(new Dimension(rightSideWidth,570));
		//text.add(notification);
		//x es y a fopanelen levo alpanelek indexei. A GridBagLayout-ot tudjuk indexelni vele
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
		pane.add(map,gbc);
		
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
		
		
		//egesz ablakra vonatkozo beallitasok
		frame.setSize(windowSize.x,windowSize.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("logo.jpg").getImage());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		
		roads = controller.getRoads();
	}
	
	
	
	public BufferedImage getScreen() {
		return screen;
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
	
	


	
	
	
	public void drawField(){
		graphics.drawImage(background,0,0,null);
		for(Point p:roads){
			graphics.drawImage(road,p.x,p.y,null);
		}
		
	
	}



	public void repaint() {
		field.repaint();
	}



	public void drawHobbit(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(hobbit, point.x, point.y, null);
	}
	
	public void drawHuman(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(human, point.x, point.y, null);
	}
	
	public void drawElf(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(elf, point.x, point.y, null);
	}
	
	public void drawDwarf(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(dwarf, point.x, point.y, null);
	}
	
	public void drawBlocker(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(blocker, point.x, point.y, null);
	}
	
	public void drawTower(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(tower, point.x, point.y, null);
	}
	
	public void drawHits(ArrayList<Hit> hits) {
		Graphics2D g2 = (Graphics2D) graphics;
		for(Hit act: hits) {
			Line2D line = new Line2D.Double(act.getFrom().getX(), act.getFrom().getY(),
					act.getTo().getX(), act.getTo().getY());
			g2.setColor(Color.red);
			g2.draw(line);
		}
	}

	public void drawBlueStone(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(blue, point.x, point.y, null);
	}	
	
	public void drawGreenStone(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(green, point.x, point.y, null);
	}	
	
	public void drawRedStone(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(red, point.x, point.y, null);
	}	

	public void drawBlackStone(Point point) {
		// TODO Auto-generated method stub
		graphics.drawImage(black, point.x, point.y, null);
	}
	
	public void drawFog(Point point) {
		graphics.drawImage(fog, point.x, point.y, null);
	}
	
	public void refreshDetails(int maxmana,int actualmana,int dead,int max, String noti){
		Integer temp = maxmana;
		maxMana.setText(temp.toString());
		temp = actualmana;
		actualMana.setText(temp.toString());
		temp = dead;
		Integer temp2 = max;
		enemies.setText(temp.toString()+"/"+temp2.toString());
		notification.setText(noti);
	}




}

