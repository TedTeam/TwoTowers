package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Cell {

	private static int logger_number_setNeigh = 0;
	private static int logger_number_hasRoad = 0;

	private Enemy actualEnemies[];
	private Element element = null;
	private Cell[] neighbor = new Cell[4];
	private boolean road = false;

	/**
	 * 
	 * @param e
	 */
	public void addEnemy(Enemy enemy) {
		Logger.enter("cell", "addEnemy", "enemy", "");
		
		Logger.exit("void");
	}

	public Cell[] getNeighbors() {
		Logger.enter("cell", "getNeighbors", "", "");

		neighbor[0] = new Cell();
		neighbor[1] = new Cell();
		neighbor[2] = new Cell();
		neighbor[3] = new Cell();
		Logger.exit("Cell[c1,c2,c3,c4]");
		return neighbor;
	}

	/**
	 * 
	 * @param e
	 */
	public void removeEnemy(Enemy e) {

	}

	/**
	 * 
	 * @param c
	 */
	public void setNeighbors(Cell[] c) {
		logger_number_setNeigh++;
		Logger.enter("cell" + (logger_number_setNeigh % 5), "setNeighbors", "",
				"");

		Logger.exit("void");
	}

	public Enemy[] getEnemy() {
		Logger.enter("cell", "getEnemy", "", "");

		Logger.exit("e:Enemy[]");
		return actualEnemies;
	}

	public Element getElement() {
		Logger.enter("cell", "getElement", "", "");

		if (element == null)
			Logger.exit("element");
		else
			Logger.exit(element.loggerGetName().toLowerCase());
		return element;
	}

	public void setElement(Element element) {
		if (element.loggerGetName().equals("Tower"))
			Logger.enter("cell", "setElement", "tower", "");
		if (element.loggerGetName().equals("Blocker"))
			Logger.enter("cell", "setElement", "blocker", "");
		this.element = element;

		Logger.exit("void");
	}

	public boolean hasRoad() {
		logger_number_hasRoad++;
		Logger.enter("cell" + (logger_number_hasRoad % 5), "hasRoad", "", "");
		if ((logger_number_hasRoad % 4) == 0) {
			Logger.exit("true");
			return true;
		} else
			Logger.exit("false");
		return false;
	}
}