package tedteam.twotowers.main; 

import tedteam.twotowers.logger.Logger;

public class Generator {

	private ElementList elementList = new ElementList();
	private EnemyList enemylist = new EnemyList();
	private GameField gameField = new GameField();
	private GameState gameState = new GameState();

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
	public boolean createBlocker(Cell cell){
		Logger.enter("gen", "createBlocker", "cell", "");
		
		cell.getElement();
		Blocker blocker = new Blocker();
		blocker.setCell(cell);
		blocker.setGameState(gameState);
		elementList.addElement(blocker);
		
		Logger.exit("true");
		return true;
	}

	/**
	 * 
	 * @param c
	 */
	public boolean createTower(Cell cell){
		Logger.enter("gen", "createTower", "cell", "");
		
		cell.getElement();		
		Tower tower = new Tower();
		tower.setCell(cell);
		elementList.addElement(tower);
		
		Logger.exit("true");
		return true;
	}

	public void generateEnemies(){

	}
	
	public void addStone(BlackStone blackStone, Cell cell) {
		Logger.enter("gen", "addStone", "blackStone", "cell");
		
		Blocker blocker = (Blocker)cell.getElement();
		blocker.enhance(blackStone);
		
		Logger.exit("void");
	}
	
	public void addStone(GreenStone greenStone, Cell cell) {
		Logger.enter("gen", "addStone", "greenStone", "cell");
		
		Tower tower = (Tower)cell.getElement();
		tower.enhance(greenStone);
		
		Logger.exit("void");
	}

}