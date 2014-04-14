package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A tunde ellenseget megvalosito osztaly.
 * Ososztaly: Enemy
 */
public class Elf extends Enemy {

	/**
	 * Ezen a metoduson keresztul valtozik az ellenseg eletereje.
	 * @param d: a valtozas merteke.
	 */
	public void acceptDamage(IDamage v){

	}

	/**
	 * Beallitja az ellenseg tulajdonsagainak alapertekeit.
	 * @param g: ezt allitja be a gameState attributumba.
	 * @param c: ezen a cellan tartozkodik az ellenseg.
	 */
	public void init(GameState g, Cell c) {

	}
	
	/**
	 * Vegrehajtja az ellenseg blokkolasat.
	 * Alapesetben ez az Enemy osztalyban valosul meg, de a szkeleton
	 * mukodesenek lathatosaga miatt itt kellett megvalositani.
	 * @param slowing: ilyen mertekben lassitja le az ellenseget.
	 */
	public boolean block(int slowing) {
		return false;
	}

	@Override
	public void cut(int damage) {
		// TODO Auto-generated method stub
		
	}

}