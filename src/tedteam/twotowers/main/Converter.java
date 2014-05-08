package tedteam.twotowers.main;

import java.awt.Point;

public class Converter {

	private GameField gameField;
	//private int width = 660;
	//private int height = 540;
	private int cellWidth = 30;
	private int cellHeight = 30;
	
	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	public Cell getCell(Point point){
		//gamefield-ben 1-tol kezdodik az index,ezert kell meg novelni x es y-t eggyel
		int x =point.x/cellWidth;
		x++;
		int y = point.y/cellHeight;
		y++;
		return gameField.getCell(new Point(x,y));
	}
	
	public Point getCoords(Cell cell){
		return gameField.getPoint(cell);	
	}
}
