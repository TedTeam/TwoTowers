package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A hobbit ellenseget megvalosito osztaly.
 * Ososztaly: Enemy
 */
public class Hobbit extends Enemy {

	/**
	 * Ezen a metoduson keresztul valtozik az ellenseg eletereje.
	 * @param d: a valtozas merteke.
	 */
	public void acceptDamage(IDamage d){
		Logger.enter("hobbit", "acceptDamage", "tower", "");
		
		d.affect(this);
		
		Logger.exit("void");

	}

	/**
	 * Beallitja az ellenseg tulajdonsagainak alapertekeit.
	 * @param g: ezt allitja be a gameState attributumba.
	 * @param c: ezen a cellan tartozkodik az ellenseg.
	 */
	public void init(GameState gameState, Cell cell){
		Logger.enter("hobbit", "init", "gameState", "cell");
		
		Logger.exit("void");
	}

	/**
	 * Az ellenseg leptetesenek metodusa.
	 * Alapesetben ez az Enemy osztalyban valosul meg, de a szkeleton
	 * mukodesenek lathatosaga miatt itt kellett megvalositani.
	 */
	public void step() {
		//TODO
		/**
		Cell neighbors[] = cell.getNeighbors();
		neighbors[0].hasRoad();
		neighbors[1].hasRoad();
		neighbors[2].hasRoad();
		neighbors[3].hasRoad();
		neighbors[3].addEnemy(this);
		formerCell.removeEnemy(this);
		Logger.exit("void");
		*/
	}
	
	/**
	 * Vegrehajtja az ellenseg sebzeset.
	 * Alapesetben ez az Enemy osztalyban valosul meg, de a szkeleton
	 * mukodesenek lathatosaga miatt itt kellett megvalositani.
	 * @param damageValue: a sebzes nagysaga.
	 */
	public void damage(int damageValue) {
		Logger.enter("hobbit", "damageValue", "damageValue:int", "");
		
		Logger.exit("void");
	}
}