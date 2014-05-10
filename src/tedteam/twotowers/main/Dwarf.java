package tedteam.twotowers.main;
/**
 * A torp ellenseget megvalosito osztaly.
 * Ososztaly: Enemy
 */
public class Dwarf extends Enemy {

	/**
	 * Ezen a metoduson keresztul tudatjuk az EnemyVisitor
	 * objektummal, hogy ez az ellenseg valojaba torpe.
	 * @param evisitor: a valtozas merteke.
	 */
	public void accept(EnemyVisitor evisitor){
		evisitor.affect(this);
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
		maxLifePoint = 200;
		currentLifePoint = 200;
		speed = 5;
	}

	/**
	 * A kettevago loves metodusa. 
	 * @param damage: 
	 */
	public void cut(int damage) {
		Dwarf newDwarf = new Dwarf();
		newDwarf.init(gameState, cell);
		newDwarf.formerCell = this.formerCell;
		cell.addEnemy(newDwarf);
		newDwarf.damage(damage);
		newDwarf.gameState.addEnemy(newDwarf);
		this.halved = true;
		newDwarf.setHalved();
		this.damage(damage);
	}

}