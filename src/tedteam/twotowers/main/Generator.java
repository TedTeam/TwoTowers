package tedteam.twotowers.main; 

import java.util.Random;

/**
 * Ez az osztaly felelos a felhasznalo altal jelzett muveletek
 * vegrehajtasara, valamint az ellensegek letrehozasara.
 */
public class Generator {
	
	// A jatekteret tartalmazo osztaly.
	private GameField gameField;
	
	// A jatekallapotot tartalmazo osztaly.
	private GameState gameState;

	private Hit hit;
	/**
	 * Ez a metodus adja oda a cellan talalhato epitmenynek
	 * a varazskovet.
	 * @param m: az epitmenyre rakando varazsko.
	 * @param c: a cella melyre a varazskovet akarjuk rakni.
	 * @return sikeres volt-e a varazsko rarakasa az epitmenyre (false)
	 */
	public boolean addStone(MagicStone stone, Cell cell){
		Element element = cell.getElement();
		if(element != null)
			return element.enhance(stone);
		return false;
	}
	
	/**
	 * Beallitja a hit attributumot.
	 * @param hit: erre.
	 */
	public void setHit(Hit hit) {
		this.hit = hit;
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
			tower.setHit(hit);
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
		Cell cell = gameField.getStartCell();
		Random randgen = new Random();
		int random = randgen.nextInt(4);
		if(random == 0) {
			Dwarf dwarf = new Dwarf();
			dwarf.init(gameState, cell);
			gameState.addEnemy(dwarf);
		} if(random == 1) {
			Elf elf = new Elf();
			elf.init(gameState, cell);
			gameState.addEnemy(elf);
		} if(random == 2) {
			Hobbit hobbit = new Hobbit();
			hobbit.init(gameState, cell);
			gameState.addEnemy(hobbit);
		} if(random == 3) {
			Human human = new Human();
			human.init(gameState, cell);
			gameState.addEnemy(human);
		}
	}

	/**
	 * Parancsfeldolgozo - tempor�lis fuggveny
	 * @return
	 */
	public GameField getGameField() {
		return gameField;
	}

	/**
	 * Parancsfeldolgozo - tempor�lis fuggveny
	 * @return
	 */
	public GameState getGameState() {
		return gameState;
	}
	/**
	 * GameState referencia beallitasa
	 * @param gamestate
	 */
	public void setGameState(GameState gamestate){
		this.gameState = gamestate;
	}

	/**
	 * GameField referencia beallitasa
	 * @param gamefield
	 */
	public void setGameField(GameField gamefield){
		this.gameField = gamefield;
	}

}