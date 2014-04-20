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
	// Parancsfeldolgozohoz a blokkolt enemyk nevei ebbe írodnak.
	private String BlockedEnemies = new String();
	private boolean enhanced=false;/**Erteke true, ha az objektumhoz lett csatolva MagicStone. Alapertelmezett erteke: false.*/
	
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
				if(BlockedEnemies.equals(""))
					BlockedEnemies = el.get(i).getName(); 
				else
						BlockedEnemies.concat(el.get(i).getName()+" ");
				this.countRemain--;
				if(this.countRemain==0){ 
					this.gameState.deleteElement(this);
					this.cell.removeElement(this);
				}
			}
		}
			
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
		return BlockedEnemies;
	}

	public int getSlowing() {
		return slowing;
	}

	public int getCountRemain() {
		return countRemain;
	}
	

}