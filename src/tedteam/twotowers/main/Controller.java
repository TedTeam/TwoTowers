package tedteam.twotowers.main;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Controller implements ActionListener, MouseListener,EnemyVisitor {

	enum Creation{none,tower,blocker,elfRedStone,humanRedStone,hobbitRedStone,dwarfRedStone,blueStone,greenStone,blackStone}
	protected static View view;
	protected static Creation creationState = Creation.none;
	private User user;
	private Converter converter;
	private GameField gameField;
	private GameState gameState;
	
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
		case tower:{user.createTower(cell);break;}
		case blocker:{user.createBlocker(cell);break;}
		case greenStone:{user.createGreenStone(cell);break;}
		case blueStone:{user.createBlueStone(cell);break;}
		case blackStone:{user.createBlackStone(cell);break;}
		case elfRedStone:{user.createElfRedStone(cell);break;}
		case humanRedStone:{user.createHumanRedStone(cell);break;}
		case hobbitRedStone:{user.createHobbitRedStone(cell);break;}
		case dwarfRedStone:{user.createDwarfRedStone(cell);break;}
		}
		//
		
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
		gameState.getEnemyList().visitEnemies(this);
		view.repaint();
		
	}
	@Override
	public void affect(Hobbit hobbit) {
		Point point = converter.getCoords(hobbit.getCell());
		view.drawHobbit(point);
	}
	@Override
	public void affect(Elf e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void affect(Dwarf d) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void affect(Human h) {
		// TODO Auto-generated method stub
		
	}
}
