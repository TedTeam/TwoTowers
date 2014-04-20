package tedteam.twotowers.main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
/**
 * A jatekteret megvalosito osztaly.
 */
public class GameField {
	// A palyat alkoto cellak.
	//private Map<Point,Cell> cells = new HashMap<Point,Cell>();  //most nem kell meg
	
	//ideiglenes tarolo a prototipushoz,utana toroljuk
	private List<Cell> cells = new ArrayList<Cell>();
	
	//A kezdo cellat eltarolo valtozo. Innet indulnak majd ki az ellensegek.
	private Cell startCell;
	
	//Az utolso cellat eltarolo valtozo. Ezt a cellat akarjak az ellensegek elerni.
	private Cell finalCell;
	
	/**
	 * Lekeri a palya utolso cellajat.
	 * @return az utolso cella.
	 */
	public Cell getFinalCell(){
		return finalCell;
	}
	
	/**
	 * A parameterkent kapott Cell objektumot 
	 * eltarolja a finalCell valtozoba.
	 * @param cell: tarolando Cella
	 */
	public void setFinalCell(Cell cell){
		finalCell = cell;
	}
	
	/**
	 * A parameterkent kapott Cell objektumot eltarolja a startCell valtozoba.
	 * @param cell: tarolando Cella
	 */
	public void setStartCell(Cell cell){
		startCell = cell;
	}
	
	/**
	 * Lekeri a palya kezdo cellajat.
	 * @return a kezdo cella.
	 */
	public Cell getStartCell(){
		return startCell;
	}

	/**
	 * Az inicializalo fuggveny. Feladata a cellak letrehozasa,
	 * es azok szomszedossaganak beallitasa.
	 */
	public void init(){ 
		
		//TODO
		/**cells[0].setNeighbors(cells);
		cells[1].setNeighbors(cells);
		cells[2].setNeighbors(cells);
		cells[3].setNeighbors(cells);*/
		
		
	}

	/**
	 * Parancsfeldolgozo - temporalis fuggveny
	 * Visszaadja a parameterben megadott nevu cellat.
	 * @param name
	 * @return
	 */
	public Cell getCellByName(String name) {
		// TODO Auto-generated method stub
		for (Cell cell : cells) {
			if (cell.getCellName().equals(name)) return cell;
		}
		return null;
	}

	/**
	 * A parameterkent kapott Cell objektumot eltarolja a cells 
	 * kollekcioba a Point tipuskent kapott kulccsal.
	 * @param c: kapott Cell objektum
	 * @param point: kulcs koordinatak
	 * @return
	 */
	public void addCell(Cell c, Point point) {
		// TODO Auto-generated method stub
		cells.add(c);
	}

}