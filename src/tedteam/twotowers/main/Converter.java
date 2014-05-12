package tedteam.twotowers.main;

import java.awt.Point;

/**
 * Az ablak koordinatait a jatekter koordinataira es 
 * a jatekter koordinatait az ablak koordinataira atalakito osztaly.
 */
public class Converter {
	// Referencia egy GameField objektumra.
	private GameField gameField;
	//private int width = 660;
	//private int height = 540;
	// Egy cella szelessege es magassaga.
	private int cellWidth = 30;
	private int cellHeight = 30;
	
	/**
	 * A gameField attributum beallitasa.
	 * @param gameField: erre.
	 */
	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	/**
	 * Az adott ablak-koordinatan talalhato cellat visszadja.
	 * @param point: ablak-koordinata.
	 * @return az ott talalhato cella.
	 */
	public Cell getCell(Point point){
		//gamefield-ben 1-tol kezdodik az index,ezert kell meg novelni x es y-t eggyel
		int x =point.x/cellWidth;
		x++;
		int y = point.y/cellHeight;
		y++;
		return gameField.getCell(new Point(x,y));
	}
	
	/**
	 * Visszaadja a cella ablak-koordinatait.
	 * @param cell: cella.
	 * @return a hozza tartozo ablak-koordinatak.
	 */
	public Point getCoords(Cell cell){ 
		Point point = gameField.getPoint(cell);
		int x = point.x;
		int y = point.y;
		x = x-1;
		x = x*cellWidth;
		y = y-1;
		y = y*cellHeight;
		return new Point(x,y);
	}
}
