

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:14:05
 */
public class Generator {

	private ElementList elementList;
	private EnemyList enemylist;
	private GameField gameField;
	private GameState gameState;
	public GameField m_GameField;
	public GameState m_GameState;
	public EnemyList m_EnemyList;
	public ElementList m_ElementList;

	public Generator(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param m
	 * @param c
	 */
	public boolean addStone(MagicStone m, Cell c){
		return false;
	}

	public buildField(){

	}

	/**
	 * 
	 * @param c
	 */
	public boolean createBlocker(Cell c){
		return false;
	}

	/**
	 * 
	 * @param c
	 */
	public boolean createTower(Cell c){
		return false;
	}

	public generateEnemies(){

	}

}