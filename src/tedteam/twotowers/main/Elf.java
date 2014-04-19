package tedteam.twotowers.main;

/**
 * A tunde ellenseget megvalosito osztaly.
 * Ososztaly: Enemy
 */
public class Elf extends Enemy {

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
	public void init(GameState g, Cell c) {
		gameState = g;
		cell = c;
		formerCell = c;
		maxLifePoint = 150;
		currentLifePoint = 150;
		speed = 10;
	}

	/**
	 * A kettevago loves metodusa. 
	 * @param damage: 
	 */
	public void cut(int damage) {
		Elf newElf = new Elf();
		newElf.init(gameState, cell);
		newElf.formerCell = this.formerCell;
		cell.addEnemy(newElf);
		newElf.damage(damage);
		newElf.gameState.addEnemy(newElf);
		this.halved = true;
		newElf.setHalved();
		this.damage(damage);
	}

}