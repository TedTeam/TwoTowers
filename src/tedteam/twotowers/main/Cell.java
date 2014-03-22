package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class Cell {

	private static int logger_number = 0;
	
	private Enemy actualEnemies[];
	private Element element;
	private Cell[] neighbor;
	private boolean road;
	public Element m_Element;

	public Cell(){

	}

	/**
	 * 
	 * @param e
	 */
	public void addEnemy(Enemy e){

	}

	public Cell[] getNeighbors(){
		return null;
	}

	/**
	 * 
	 * @param e
	 */
	public void removeEnemy(Enemy e){

	}

	/**
	 * 
	 * @param c
	 */
	public void setNeighbors(Cell[] c){
		logger_number++;
		Logger.enter("cell"+(logger_number%5), "setNeighbors", "", "");
		
		Logger.exit("void");
	}

}