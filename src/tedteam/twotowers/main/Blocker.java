package tedteam.twotowers.main;

import java.util.ArrayList;

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
	private int countRemain = 10;
	// Az akadaly lassitasanak merteke.
	private int slowing = 0;
	private boolean enhanced=false;/**Erteke true, ha az objektumhoz lett csatolva MagicStone. Alapertelmezett erteke: false.*/
	
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
		if (effect) this.setEnhanced(effect);
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
		slowing=slowing+i;
		Logger.exit("void");
	}
	
	/**
	 * A blokkolast vegrehajto metodus.
	 */
	public void action() {
		Logger.enter("blocker", "action", "", "");
		ArrayList<Enemy> el;
		el=cell.getEnemy();
		for(int i=0;i<el.size();i++) {
			boolean bl=el.get(i).block(slowing);
			if (bl) {
				this.countRemain--;
				if(this.countRemain==0){ 
					this.gameState.deleteBlocker(this);
					this.cell.removeElement(this);
				}
			}
		}
		
		Logger.exit("void");	
	}
	

	/**enhanced attributum ertekenek visszaadasa.*/
	public boolean getEnhanced() {
		return enhanced;
	}

	public void setEnhanced(boolean enhanced) {
		this.enhanced = enhanced;
	}
	

}