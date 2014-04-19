package tedteam.twotowers.main;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Az ellensegeket megvalosito absztrakt osztaly.
 */
public abstract class Enemy {
	// Az ellenseg aktualis tartozkodasi helye.
	protected Cell cell;
	// Az ellenseg elozo tartozkodasi helye.
	protected Cell formerCell;
	// Az ellenseg aktualis eletereje.
	protected int currentLifePoint;
	// Az ellenseg eredeti eletereje.
	protected int maxLifePoint;
	// Az ellenseg sebessege.
	protected int speed;
	// Ezen a GameState referencian keresztul tudja magat
	// leelenorizni az elleseg, hogy meghalt-e,
	// es tudja magat torolni az ellenség listabol
	protected GameState gameState;
	// egy boolean valtozo, ami ha true, akkor az adott 
	// objektum eppen blokkolva van.
	// Alapertelmezett ertek: false.
	protected boolean blocked = false;
	// egy boolean valtozo, ami ha true, az ellenseg kette
	// van felezve a jatekteren. Alapertelmezett ertek: false.
	protected boolean halved = false;
	// A cellavaltashoz szukseges segedvaltozo, amely mindig
	// novekszik, ha a 10-speed=tick keplet nem teljesul.
	// A prototipusban nem hasznaljuk.
	// Alapertelmezett erteke: 0.
	private int tick = 0;
	
	//Temp - megadott nev
	protected String cName = new String();
	//Temp - Erre megy az ellenseg keresztezodesben
	protected String cDirection; 

	/**
	 * Abstract metodus, amit a leszarmaztatott osztalyoknak
	 * kell implementalniuk.
	 * @param damage.
	 */
	public abstract void acceptDamage(IDamage damage);
	
	/**
	 * Abstract metodus, amit a leszarmaztatott osztalyoknak
	 * kell implementalniuk.
	 * @param g.
	 * @param c.
	 */
	public abstract void init(GameState g, Cell c);
	
	/**
	 * Abstract metodus, amit a leszarmaztatott osztalyoknak
	 * kell implementalniuk.
	 * @param damage
	 */
	public abstract void cut(int damage);

	/**
	 * Vegrehajtja az ellenseg blokkolasat.
	 * @param slowing: ilyen mertekben lassitja le az ellenseget.
	 */
	public boolean block(int slowing){
		if(blocked == true) {
			return false;
		} else {
			tick -= slowing;
			blocked = true;
			return true;
		}
	}

	/**
	 * Vegrehajtja az ellenseg sebzeset.
	 * @param damageValue: a sebzes nagysaga.
	 */
	public void damage(int damageValue){
		currentLifePoint -= damageValue;
		if(currentLifePoint <= 0) {
			gameState.deadEnemy(this);
			cell.removeEnemy(this);
		}
	}

	/**
	 * A halved attributum true-ra allitasa.
	 */
	public void setHalved() {
		halved = true;
	}
	
	/**
	 * A halved attributum ertekenek visszaadasa.
	 * @return a halved erteke
	 */
	public boolean getHalved() {
		return halved;
	}

	/**
	 * Az ellenseg leptetesenek metodusa a prototipusban.
	 */
	public void step(){
		Cell nextCell = new Cell();
		HashMap<String,Cell> neighbors = new HashMap<String,Cell>();
		neighbors.putAll(cell.getNeighbors());
		
		if(cDirection != null) {
			nextCell = neighbors.get(cDirection);
			if(nextCell != null){
				if(nextCell.hasRoad() == true && !nextCell.equals(formerCell)) {
					System.out.println("lepes irannyal");
					formerCell = cell;
					cell.removeEnemy(this);
					cell = nextCell;
					nextCell.addEnemy(this);
				}
			}
			cDirection = null;
		} else {
			for(Entry<String,Cell> h : neighbors.entrySet()) {
				nextCell = h.getValue();
				if(nextCell != null){
					if(nextCell.hasRoad() == true && !nextCell.equals(formerCell)) {
						System.out.println("lepes irany nelkul");
						formerCell = cell;
						cell.removeEnemy(this);
						cell = nextCell;
						nextCell.addEnemy(this);
					}
				}
			}
		}
	}

	/**
	 * Parancsfeldolgozo - temporalis fuggveny
	 * Beallitja az iranyt, amerre mennie kell keresztezodesben az ellensegnek.
	 * @param direction
	 */
	public void setDirection(String direction) {
		cDirection = direction;
	}

	/**
	 * Visszaadja az aktualis eleterot.
	 * @return az aktualis eletero
	 */
	public int getCurrentLifePoint() {
		return currentLifePoint;
	}

	/**
	 * Visszaadja a jelenlegi cellat.
	 * @return a jelenlegi cella
	 */
	public Cell getCell() {
		return cell;
	}

	/**
	 * Visszaadja az elozo cellat.
	 * @return az elozo cella
	 */
	public Cell getFormerCell() {
		return formerCell;
	}
	
	/**
	 * Parancsfeldolgozo - temporalis fuggveny
	 * @return visszadja a cella nevet
	 */
	public String getName() {
		return cName;
	}

	/**
	 * Parancsfeldolgozo - temporalis fuggveny
	 * @param name: beallitja nevnek az itt kapott stringet
	 */
	public void setName(String name) {
		cName = name;
	}

}