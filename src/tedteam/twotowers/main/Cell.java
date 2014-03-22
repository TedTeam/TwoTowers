package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Cell {

	private static int logger_number = 0;

	private Enemy actualEnemies[];
	private Element element = null;
	private Cell[] neighbor;
	private boolean road;

	public Cell() {

	}

	/**
	 * 
	 * @param e
	 */
	public void addEnemy(Enemy e) {

	}

	public Cell[] getNeighbors() {
		return null;
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
		logger_number++;
		Logger.enter("cell" + (logger_number % 5), "setNeighbors", "", "");

		Logger.exit("void");
	}

	public Enemy[] getEnemy() {
		Logger.enter("finalcell", "getEnemy", "", "");

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

}