package tedteam.twotowers.main; 

import tedteam.twotowers.logger.Logger;
/**
 * Ez az osztaly felelos a felhasznalo altal jelzett muveletek
 * vegrehajtasara, valamint az ellensegek letrehozasara.
 */
public class Generator {
	// A palyan levo epitmenyeket tartalmazo osztaly.
	private ElementList elementList = new ElementList();
	
	// A palyan levo ellensegeket tartalmazo osztaly.
	private EnemyList enemyList = new EnemyList();
	
	// A jatekteret tartalmazo osztaly.
	private GameField gameField = new GameField();
	
	// A jatekallapotot tartalmazo osztaly.
	private GameState gameState = new GameState();

	/**
	 * Ez a metodus adja oda a cellan talalhato epitmenynek
	 * a varazskovet.
	 * @param m: az epitmenyre rakando varazsko.
	 * @param c: a cella melyre a varazskovet akarjuk rakni.
	 * @return sikeres volt-e a varazsko rarakasa az epitmenyre (false)
	 */
	public boolean addStone(MagicStone m, Cell c){
		return false;
	}

	/**
	 * Ez a metodus inicializalja a jatekteret.
	 */
	public void buildField(){
		Logger.enter("generator", "buildField", "", "");
		
		gameField.init();
		Cell cell4 = gameField.getFinalCell();
		gameState.setFinalCell(cell4);
		
		Logger.exit("void");
	}

	/**
	 * Ez a metodus felelos egy akadaly letrehozasaert
	 * es cellara helyezeseert. Beallitja annak alapertekeit.
	 * @param cell: erre a cellara akarjuk helyezni az akadalyt.
	 * @return true ertekkel ter vissza ha az adott cellara
	 * rahelyezheto az akadaly. false ha nem.
	 */
	public boolean createBlocker(Cell cell){
		Logger.enter("generator", "createBlocker", "cell", "");
		
		cell.getElement();
		Blocker blocker = new Blocker();
		blocker.setCell(cell);
		blocker.setGameState(gameState);
		elementList.addElement(blocker);
		
		Logger.exit("true");
		return true;
	}

	/**
	 * Ez a metodus felelos egy torony letrehozasaert
	 * es cellara helyezeseert. Beallitja annak alapertekeit.
	 * @param cell: erre a cellara akarjuk helyezni a tornyot.
	 * @return true ertekkel ter vissza, ha az adott cellara
	 * rahelyezheto a torony. false ha nem.
	 */
	public boolean createTower(Cell cell){
		Logger.enter("generator", "createTower", "cell", "");
		
		cell.getElement();		
		Tower tower = new Tower();
		tower.setCell(cell);
		elementList.addElement(tower);
		
		Logger.exit("true");
		return true;
	}

	/**
	 * Ez a metodus generalja az uj ellensegeket a palyara.
	 * Letrehozasa utan beallitja annak alapertekeit es
	 * a palyara rakja.
	 */
	public void generateEnemies(){
		Logger.enter("generator", "generateEnemies", "", "");
		Cell cell = gameField.getStartCell();
		Hobbit hobbit = new Hobbit();
		hobbit.init(gameState, cell);
		enemyList.addEnemy(hobbit);
		
		Logger.exit("void");
	}
	
	/**
	 * Ez a metodus adja oda a cellan talalhato epitmenynek
	 * a varazskovet.
	 * A szkeleton erthetosegenek celjabol itt konkret pelda talahato.
	 * @param blackStone: a fekete varazsko melyet le akarunk rakni.
	 * @param cell: a cella melyre a varazskovet akarjuk rakni.
	 */
	public boolean addStone(BlackStone blackStone, Cell cell) {
		Logger.enter("generator", "addStone", "blackStone", "cell");
		
		Blocker blocker = (Blocker)cell.getElement();
		blocker.enhance(blackStone);
		
		Logger.exit("true");
		return true;
	}
	/**
	 * Ez a metodus adja oda a cellan talalhato epitmenynek
	 * a varazskovet.
	 * A szkeleton erthetosegenek celjabol itt konkret pelda talalhato.
	 * @param greenStone: a  zold varazsko melyet le akarunk rakni.
	 * @param cell: a cella melyre a varazskovet akarjuk rakni.
	 */
	public boolean addStone(GreenStone greenStone, Cell cell) {
		Logger.enter("generator", "addStone", "greenStone", "cell");
		
		Tower tower = (Tower)cell.getElement();
		tower.enhance(greenStone);
		
		Logger.exit("true");
		return true;
	}

}