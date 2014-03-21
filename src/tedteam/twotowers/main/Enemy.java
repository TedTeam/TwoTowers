package tedteam.twotowers.main;

public abstract class Enemy {

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

	/**
	 * 
	 * @param d
	 */
	public abstract void acceptDamage(IDamage d);

	/**
	 * 
	 * @param s
	 */
	public void block(int slowing){

	}

	/**
	 * 
	 * @param dv
	 */
	public void damage(int damageValue){

	}

	/**
	 * 
	 * @param g
	 * @param c
	 */
	public abstract void init(GameState g, Cell c);

	public void step(){

	}

}