package tedteam.twotowers.main;

import java.util.ArrayList;

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
	// Erteke true, ha az objektumhoz lett csatolva MagicStone.
	// Alapertelmezett erteke: false.
	private boolean enhanced = false;
	
	/**
	 * Ez a metodus donti el, hogy a varazskovel lehet-e erositeni
	 * az akadalyt. Ha igen, akkor erositi is.
	 * @param blackStone: a varazsko, mellyel erositeni szeretnenk az akadalyt.
	 * @return visszajelzes, hogy sikeres volt-e a muvelet.
	 */
	public boolean enhance(MagicStone blackStone) {
		boolean effect=blackStone.effect(this);
		if (effect) this.setEnhanced(effect);
		return effect;
	}

	/**
	 * Beallitja a GameState attributumot
	 * @param gameState: ezt allitja be a gameState attributumba
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
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
	}

	/**
	 * Az enhanced attributum ertekenek visszaadasa.
	 */
	public boolean getEnhanced() {
		return enhanced;
	}

	/**
	 * Az enhanced attributum ertekenek beallitasa.
	 * @param enhanced: erre.
	 */
	public void setEnhanced(boolean enhanced) {
		this.enhanced = enhanced;
	}
	
	/**
	 * Az akadalyhoz tartozo visitor mintanak az osztalya.
	 */
	public void visitElement(ElementVisitor visitor) {
		visitor.affect(this);
		
	}

}