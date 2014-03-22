package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;

public class GameState {

	private int countEnemy;
	private int deadEnemiesNumber;
	private ElementList elementList;
	private EnemyList enemylist;
	private Cell finalCell = new Cell();
	private int maximumEnemy;
	public ElementList m_ElementList;
	public EnemyList m_EnemyList;

	public boolean checkGame(){
		Logger.enter("gameState", "checkGame", "", "");
		finalCell.getEnemy();
		
		if(Logger.question("Van ellenség az utolsó cellán?")) {
			System.out.println("Kommunikáció: Vereség, vesztettél!");
			Logger.exit("true");
			return true;
		} 
		if(Logger.question("Ellenség száma megegyezik a megölt ellenségek számával?")) {
			System.out.println("Kommunikáció: Győzelem, nyertél!");
			Logger.exit("true");
			return true;
		}
		
		Logger.exit("false");
		return false;
	}

	/**
	 * 
	 * @param e
	 */
	public void deadEnemy(Enemy e){

	}

	/**
	 * 
	 * @param blocker
	 */
	public void deleteBlocker(Blocker blocker){

	}

	/**
	 * 
	 * @param c
	 */
	public void setFinalCell(Cell c){
		Logger.enter("gameState", "setFinalCell", "cell4", "");
		
		Logger.exit("void");
	}

}