package tedteam.twotowers.main;

public class GameState {

	private int countEnemy;
	private int deadEnemiesNumber;
	private ElementList elementList;
	private EnemyList enemylist;
	private Cell finalCell;
	private int maximumEnemy;
	public ElementList m_ElementList;
	public EnemyList m_EnemyList;

	public GameState(){

	}

	public void finalize() throws Throwable {

	}

	public boolean checkGame(){
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

	}

}