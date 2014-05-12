package tedteam.twotowers.main;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 * A hid osztaly a View es a Modell kozott.
 * Ez az osztaly kezeli le az egerkattintasokat es o szol
 * a viewnek, hogy miket rajzolhat ki (illetve azt is hogy rajzolhat).
 */
public class Controller implements ActionListener, MouseListener,EnemyVisitor,ElementVisitor {
	// 
	enum Creation{none,tower,blocker,elfRedStone,humanRedStone,hobbitRedStone,dwarfRedStone,blueStone,greenStone,blackStone}
	// Referencia a View objektumra.
	protected static View view;
	// 
	protected static Creation creationState = Creation.none;
	// Referencia a User objektumra.
	private User user;
	// Referencia a converter objektumra.
	private Converter converter;
	// Referencia a GameField objektumra.
	private GameField gameField;
	// Referencia a GameState objektumra.
	private GameState gameState;
	// Referencia a Hit objektumra.
	private Hit hit;
	// Referencia a Notification objektumra.
	private Notification notification = new Notification();
	
	/**
	 * A user attributum beallitasa.
	 * @param user: erre.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * A view attributum beallitasa.
	 * @param view2: erre.
	 */
	public void setView(View view2) {
		view = view2;
	}
	
	/**
	 * A hit attributum beallitasa.
	 * @param hit: erre.
	 */
	public void setHit(Hit hit) {
		this.hit = hit;
	}
	
	/**
	 * A gameState attributum beallitasa.
	 * @param gameState: erre.
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	/**
	 * A gameField attributum beallitasa.
	 * @param gameField: erre.
	 */
	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}
	
	/**
	 * A converter attributum beallitasa.
	 * @param converter: erre.
	 */
	public void setConverter(Converter converter) {
		this.converter = converter;
	}
	
	/**
	 * Az eger kattintasbol adodo akciot feldolgozo metodus.
	 */
	public void actionPerformed(ActionEvent clicked) {
		JButton button = (JButton)clicked.getSource();
		view.enableAllButtons();
		button.setEnabled(false);
		
	}
	
	/**
	 * Az eger kattintast feldolgozo metodus.
	 */
	public void mouseClicked(MouseEvent clicked) {
		Cell cell = converter.getCell(new Point(clicked.getX(),clicked.getY()));

		switch(creationState){
		case none:break;
		case tower: {
			if(user.createTower(cell))
				notification.addNotification("Leraktal egy Tornyot!");
			else notification.addNotification("Nem tudsz Tornyot lerakni!");
			break; }
		case blocker:{
			if(user.createBlocker(cell))
				notification.addNotification("Leraktal egy Akad�lyt!");
			else notification.addNotification("Nem tudsz Akad�lyt lerakni!");
			break; }
		case greenStone:{
			if(user.createGreenStone(cell))
				notification.addNotification("Zold kovet raktal a toronyra!");
			else notification.addNotification("Nem sikerult a ko lerakasa!");
			break; }
		case blackStone:{
			if(user.createBlackStone(cell))
				notification.addNotification("Fekete kovet raktal az akadalyra!");
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
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	/**
	 * Az utakat lekerdezo metodus.
	 * @return visszater a palyan talalhato utak koordinatajaval.
	 */
	public ArrayList<Point> getRoads() {
		ArrayList<Cell> roadsCell = gameField.getRoads();
		ArrayList<Point> roadsPoint = new ArrayList<Point>();
		for(Cell cell:roadsCell){
			roadsPoint.add(converter.getCoords(cell));
		}	
		return roadsPoint;
	}

	/**
	 * A kirajzolo fuggveny.
	 */
	public void drawAll(){
		view.drawField();
		
		view.refreshDetails(user.getMaxMana(), user.getMana(), gameState.getDeadEnemiesNumber(), 
				gameState.getMaximumEnemy(), notification.getNotification());
		ArrayList<Point> from = hit.getFrom();
		ArrayList<Point> to = hit.getTo();
		if(from != null){
		for(int i=0;i<from.size();i++){
			view.drawHit(from.get(i),to.get(i));
		}
		hit.clearAll();
		}
		gameState.getEnemyList().visitEnemies(this);
		gameState.getElementList().visitElements(this);
		view.repaint();
		
		if(gameState.checkGame()) {
			if(gameState.getWin())
				view.drawGameOver(true);
			else view.drawGameOver(false);
		}
		
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
		if(tower.getFog())
			view.drawFog(point);
		
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
