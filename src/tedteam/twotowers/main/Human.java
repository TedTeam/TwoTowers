package tedteam.twotowers.main;

/**
 * Az ember ellenseget megvalosito osztaly.
 * Ososztaly: Enemy
 */
public class Human extends Enemy {

	/**
	 * Ezen a metoduson keresztul valtozik az ellenseg eletereje.
	 * @param damage: a valtozas merteke.
	 */
	public void acceptDamage(IDamage damage){
		damage.affect(this);
	}

	/**
	 * Beallitja az ellenseg tulajdonsagainak alapertekeit.
	 * @param g: ezt allitja be a gameState attributumba.
	 * @param c: ezen a cellan tartozkodik az ellenseg.
	 */
	public void init(GameState g, Cell c){
		gameState = g;
		cell = c;
		formerCell = c;
		maxLifePoint = 150;
		currentLifePoint = 150;
		speed = 7;
	}

	/**
	 * A kettevago loves metodusa. 
	 * @param damage: 
	 */
	public void cut(int damage) {
		Human newHuman = new Human();
		newHuman.init(gameState, cell);
		newHuman.formerCell = this.formerCell;
		cell.addEnemy(newHuman);
		newHuman.damage(damage);
		newHuman.gameState.addEnemy(newHuman);
		this.halved = true;
		newHuman.setHalved();
		this.damage(damage);
	}

}