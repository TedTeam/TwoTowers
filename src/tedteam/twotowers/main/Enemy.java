package tedteam.twotowers.main;
/**
 * Az ellensegeket megvalosito absztrakt osztaly.
 */

public abstract class Enemy {
	// Az ellenseg aktualis tartozkodasi helye.
	protected Cell cell = new Cell();
	
	// Az ellenseg aktualis eletereje.
	private int currentLifePoint;
	
	// Az ellenseg elozo tartozkodasi helye.
	protected Cell formerCell=new Cell();
	
	// Ezen a GameState referencian keresztul tudja magat
	// leelenorizni az elleseg, hogy meghalt-e,
	// es tudja magat torolni az ellenség listabol
	private GameState gameState;
	
	// Az ellenseg eredeti eletereje.
	private int maxLifePoint;
	
	// Az ellenseg sebessege.
	private int speed;

	/**
	 * Ezen a metoduson keresztul valtozik az ellenseg eletereje.
	 * @param d: a valtozas merteke.
	 */
	public abstract void acceptDamage(IDamage d);

	/**
	 * Vegrehajtja az ellenseg blokkolasat.
	 * @param slowing: ilyen mertekben lassitja le az ellenseget.
	 */
	public void block(int slowing){

	}

	/**
	 * Vegrehajtja az ellenseg sebzeset.
	 * @param damageValue: a sebzes nagysaga.
	 */
	public void damage(int damageValue){
		
	}

	/**
	 * Beallitja az ellenseg tulajdonsagainak alapertekeit.
	 * @param g: ezt allitja be a gameState attributumba.
	 * @param c: ezen a cellan tartozkodik az ellenseg.
	 */
	public abstract void init(GameState g, Cell c);

	/**
	 * Az ellenseg leptetesenek metodusa.
	 */
	public void step(){
		
	}

}