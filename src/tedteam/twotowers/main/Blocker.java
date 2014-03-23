package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * Az akadalyt megvalosito osztaly, amely az akadaly
 * tulajdonsagait tartalmazza.
 * Ososztaly: Element
 */
public class Blocker extends Element {
	// Ezen a GameState referencian keresztul tudja majd torolni
	// magat a listabol, ha eleg ellenseg haladt at rajta.
	private GameState gameState= new GameState();
	// A feltarthato ellensegek szama.
	private int countRemain = 0;
	// Az akadaly lassitasanak merteke.
	private int slowing = 0;
	
	/**
	 * Ez a metodus donti el, hogy a varazskovel lehet-e erositeni
	 * az akadalyt. Ha igen, akkor erositi is.
	 * @param blackStone: a varazsko, mellyel erositeni szeretnenk az akadalyt.
	 * @return visszajelzes, hogy sikeres volt-e a muvelet.
	 */
	public boolean enhance(MagicStone blackStone) {
		Logger.enter("blocker", "enhance", "blackStone", "");
		//blackStone.effect(this);
		boolean effect=blackStone.effect(this);
		Logger.exit("true");
		return effect;
	}

	/**
	 * Beallitja magat egy cellaba.
	 * @param cell: ebbe a cellaba allitja be magat.
	 */
	public void setCell(Cell cell) {
		Logger.enter("blocker", "setCell", "", "");
		
		cell.setElement(this);
		
		Logger.exit("void");
	}

	/**
	 * Beallitja a GameState attributumot
	 * @param gameState: ezt allitja be a gameState attributumba
	 */
	public void setGameState(GameState gameState) {
		Logger.enter("blocker", "setGameState", "gameState","");
		this.gameState = gameState;
		
		Logger.exit("void");
	}
	/**
	 * Modositja az akadaly lassitasanak merteket
	 * @param i: a modositas merteke
	 */
	public void setSlowing(int i) {
		Logger.enter("blocker", "setSlowing", "i:int", "");
		
		Logger.exit("void");
	}
	
	/**
	 * A blokkolast vegrehajto metodus.
	 */
	public void action() {
		Logger.enter("blocker", "action", "", "");
		int slowing=0;
		cell.getEnemy();
		Enemy elf=new Elf();
		elf.block(slowing);
		Logger.exit("void");	
	}
	
	/**
	 * Loggolashoz, skeleton után torlendo!
	 * @return
	 */
	public String loggerGetName() {
		return "Blocker";
	}
	

}