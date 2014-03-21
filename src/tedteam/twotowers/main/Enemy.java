

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:13:55
 */
public class Enemy {

	private Cell cell;
	private int currentLifePoint;
	private Cell formerCell;
	private GameState gameState;
	private int maxLifePoint;
	private int speed;
	public GameState m_GameState;
	public Cell m_Cell;

	public Enemy(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param d
	 */
	public abstract acceptDamage(IDamage d);

	/**
	 * 
	 * @param s
	 */
	public block(slowing s){

	}

	/**
	 * 
	 * @param dv
	 */
	public damage(damageValue dv){

	}

	/**
	 * 
	 * @param g
	 * @param c
	 */
	public abstract init(GameState g, Cell c);

	public step(){

	}

}