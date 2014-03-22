package tedteam.twotowers.main; 

import tedteam.twotowers.logger.Logger;

public class Generator {

	private ElementList elementList = new ElementList();
	private EnemyList enemyList = new EnemyList();
	private GameField gameField = new GameField();
	private GameState gameState = new GameState();

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
		Logger.enter("gen", "generateEnemies", "", "");
		Cell cell = gameField.getStartCell();
		Hobbit hobbit = new Hobbit();
		hobbit.init(gameState, cell);
		enemyList.addEnemy(hobbit);
		
		Logger.exit("void");
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