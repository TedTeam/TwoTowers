package tedteam.twotowers.main; 

import tedteam.twotowers.logger.Logger;
/**
 * Ez az osztaly felelos a felhasznalo altal jelzett muveletek
 * vegrehajtasara, valamint az ellensegek letrehozasara.
 */
public class Generator {
	
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
		
		if(cell.hasRoad() == true && cell.hasElement() == false){		
			Blocker blocker = new Blocker();
			blocker.setCell(cell);
			cell.setElement(blocker);
			gameState.addElement(blocker);
			return true;
		}
		
		return false;
	}
	//temporalis fuggveny a prototipushoz, alap esetben a String parameter nem kellene
	public boolean createBlocker(Cell cell,String elementName){
		
		if(cell.hasRoad() == true && cell.hasElement() == false){		
			Blocker blocker = new Blocker();
			blocker.setCell(cell);
			blocker.setName(elementName);
			cell.setElement(blocker);
			gameState.addElement(blocker);
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Ez a metodus felelos egy torony letrehozasaert
	 * es cellara helyezeseert. Beallitja annak alapertekeit.
	 * @param cell: erre a cellara akarjuk helyezni a tornyot.
	 * @return true ertekkel ter vissza, ha az adott cellara
	 * rahelyezheto a torony. false ha nem.
	 */
	public boolean createTower(Cell cell){  //protoban ez nem hivodik meg

		if(cell.hasRoad() == false && cell.hasElement() == false){		
			Tower tower = new Tower();
			tower.setCell(cell);
			cell.setElement(tower);
			gameState.addElement(tower);
			return true;
		}
		return false;
	}
	//temporalis fuggveny a prototipushoz, alap esetben a String parameter nem kellene
	public boolean createTower(Cell cell,String elementName){
		
		if(cell.hasRoad() == false && cell.hasElement() == false){		
			Tower tower = new Tower();
			tower.setCell(cell);
			tower.setName(elementName);
			cell.setElement(tower);
			gameState.addElement(tower);
			return true;
		}
		
		return false;
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
		gameState.addEnemy(hobbit);
		
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

	/**
	 * Parancsfeldolgozo - temporális fuggveny
	 * @return
	 */
	public GameField getGameField() {
		return gameField;
	}

	/**
	 * Parancsfeldolgozo - temporális fuggveny
	 * @return
	 */
	public GameState getGameState() {
		// TODO Auto-generated method stub
		return gameState;
	}

	

}