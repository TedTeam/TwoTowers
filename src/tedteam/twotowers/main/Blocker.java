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
	private GameState gameState;
	// A feltarthato ellensegek szama.
	private int countRemain = 10;
	// Az akadaly lassitasanak merteke.
	private int slowing = 2;
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
	public void increaseSlowing(int i) {
		slowing=slowing+i;
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
					this.gameState.deleteElement(this);
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

	/**
	 * Parancsfeldolgozo - temporális fuggveny
	 * Ez visszaadja azokat az egységeket (osszefuzve egy Stringbe), amik blokkoltak a blocker altal
	 * @return
	 */
	public String getBlockedEnemies() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSlowing() {
		return slowing;
	}

	public int getCountRemain() {
		return countRemain;
	}
	

}