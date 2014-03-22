package tedteam.twotowers.main; 

import tedteam.twotowers.logger.Logger;

public class Generator {

	private ElementList elementList;
	private EnemyList enemylist;
	private GameField gameField = new GameField();
	private GameState gameState = new GameState();
	public GameField m_GameField;
	public GameState m_GameState;
	public EnemyList m_EnemyList;
	public ElementList m_ElementList;

	public Generator(){

	}

	/**
	 * 
	 * @param m
	 * @param c
	 */
	public boolean addStone(MagicStone m, Cell c){
		return false;
	}

	public void buildField(){
		Logger.enter("gen", "buildField", "", "");
		
		gameField.init();
		Cell cell4 = gameField.getFinalCell();
		gameState.setFinalCell(cell4);
		
		Logger.exit("void");
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

	public void generateEnemies(){

	}

}