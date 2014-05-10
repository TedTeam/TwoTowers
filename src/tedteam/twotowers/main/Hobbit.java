package tedteam.twotowers.main;
/**
 * A hobbit ellenseget megvalosito osztaly.
 * Ososztaly: Enemy
 */
public class Hobbit extends Enemy {

	/**
	 * Ezen a metoduson keresztul valtozik az ellenseg eletereje.
	 * @param damage: a valtozas merteke.
	 */
	public void accept(EnemyVisitor damage){
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
		maxLifePoint = 100;
		currentLifePoint = 100;
		speed = 5;
	}

	/**
	 * A kettevago loves metodusa. 
	 * @param damage: 
	 */
	public void cut(int damage) {
		Hobbit newHobbit = new Hobbit();
		newHobbit.init(gameState, cell);
		newHobbit.formerCell = this.formerCell;
		cell.addEnemy(newHobbit);
		newHobbit.damage(damage);
		newHobbit.gameState.addEnemy(newHobbit);
		this.halved = true;
		newHobbit.setHalved();
		this.damage(damage);		
	}

}