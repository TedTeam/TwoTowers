package tedteam.twotowers.main;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Controller implements ActionListener, MouseListener,EnemyVisitor,ElementVisitor {

	enum Creation{none,tower,blocker,elfRedStone,humanRedStone,hobbitRedStone,dwarfRedStone,blueStone,greenStone,blackStone}
	protected static View view;
	protected static Creation creationState = Creation.none;
	private User user;
	private Converter converter;
	private GameField gameField;
	private GameState gameState;
	
	private Notification notification = new Notification();
	
	public void setUser(User user) {
		this.user = user;
	}
	public void setView(View view2) {
		view = view2;
	}
	
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}
	public void setConverter(Converter converter) {
		this.converter = converter;
	}
	@Override
	public void actionPerformed(ActionEvent clicked) {
		//System.out.println(clicked.getActionCommand());
		JButton button = (JButton)clicked.getSource();
		view.enableAllButtons();
		button.setEnabled(false);
		//view.field.repaint();
		
	}
	@Override
	public void mouseClicked(MouseEvent clicked) {
		//System.out.println("X: "+clicked.getX()+" Y: "+clicked.getY());
		
		Cell cell = converter.getCell(new Point(clicked.getX(),clicked.getY()));
		//Point p = converter.getCoords(cell);
		
		//System.out.println("point:"+p);
		//view.drawIcon(p.x,p.y);
		
		System.out.println(cell);
		switch(creationState){
		case none:break;
		case tower: {
			if(user.createTower(cell))
				notification.addNotification("Leraktal egy Tornyot!");
			else notification.addNotification("Nem tudsz Tornyot lerakni!");
			break; }
		case blocker:{
			if(user.createBlocker(cell))
				notification.addNotification("Leraktal egy Akadályt!");
			else notification.addNotification("Nem tudsz Akadályt lerakni!");
			break; }
		case greenStone:{
			if(user.createGreenStone(cell))
				notification.addNotification("Zold kovet raktal a toronyra!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		case blackStone:{
			if(user.createBlackStone(cell))
				notification.addNotification("Fekete kovet raktal a toronyra!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		case blueStone:{
			if(user.createBlueStone(cell))
				notification.addNotification("Kek kovet raktal a toronyra!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		case elfRedStone:{
			if(user.createElfRedStone(cell))
				notification.addNotification("Piros kovet raktal a toronyra, ami elfek ellen erosit!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		case humanRedStone:{
			if(user.createHumanRedStone(cell))
				notification.addNotification("Piros kovet raktal a toronyra, ami emberek ellen erosit!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		case hobbitRedStone:{
			if(user.createHobbitRedStone(cell))
				notification.addNotification("Piros kovet raktal a toronyra, ami hobbitok ellen erosit!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		case dwarfRedStone:{
			if(user.createDwarfRedStone(cell))
				notification.addNotification("Piros kovet raktal a toronyra, ami torpek ellen erosit!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Point> getRoads() {
		ArrayList<Cell> roadsCell = gameField.getRoads();
		ArrayList<Point> roadsPoint = new ArrayList<Point>();
		for(Cell cell:roadsCell){
			roadsPoint.add(converter.getCoords(cell));
		}	
		return roadsPoint;
	}

	public void drawAll(){
		view.drawField();
		
		view.refreshDetails(user.getMaxMana(), user.getMana(), gameState.getDeadEnemiesNumber(), 
				gameState.getMaximumEnemy(), notification.getNotification());
		gameState.getEnemyList().visitEnemies(this);
		gameState.getElementList().visitElements(this);
		view.repaint();
		
	}
	@Override
	public void affect(Hobbit hobbit) {
		Point point = converter.getCoords(hobbit.getCell());
		view.drawHobbit(point);
	}
	@Override
	public void affect(Elf elf) {
		Point point = converter.getCoords(elf.getCell());
		view.drawElf(point);
		
	}
	@Override
	public void affect(Dwarf dwarf) {
		Point point = converter.getCoords(dwarf.getCell());
		view.drawDwarf(point);
		
	}
	@Override
	public void affect(Human human) {
		Point point = converter.getCoords(human.getCell());
		view.drawHuman(point);
		
	}
	@Override
	public void affect(Tower tower) {
		Point point = converter.getCoords(tower.getCell());
		view.drawTower(point);
		
		if(tower.getEnhancedByBlue()) {
			point = converter.getCoords(tower.getCell());
			view.drawBlueStone(point);
		}
		
		if(tower.getEnhancedByRed()) {
			point = converter.getCoords(tower.getCell());
			view.drawRedStone(point);
		}
		
		if(tower.getEnhancedByGreen()) {
			point = converter.getCoords(tower.getCell());
			view.drawGreenStone(point);
		}
		
	}
	@Override
	public void affect(Blocker blocker) {
		Point point = converter.getCoords(blocker.getCell());
		view.drawBlocker(point);
		
		if(blocker.getEnhanced()) {
			point = converter.getCoords(blocker.getCell());
			view.drawBlackStone(point);
		}
		
	}
}
