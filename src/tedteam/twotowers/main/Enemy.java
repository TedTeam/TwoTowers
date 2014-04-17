package tedteam.twotowers.main;

import java.util.ArrayList;
import java.util.Random;

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
	// es tudja magat torolni az ellens√©g listabol
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
	// Alapertelmezett erteke: 0.
	private int tick = 0;
	
	//Temp - megadott nev
	protected String cName = new String();
	//Temp - Erre megy az ellenseg keresztezodesben
	protected String cDirection = new String(); 

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
	 * Az ellenseg leptetesenek metodusa.
	 */
	public void step(){
		if(10 - speed != tick) {
			tick++;
		} else {
			tick = 0;
			Cell nextCell;
			ArrayList<Cell> road = new ArrayList<Cell>();
			ArrayList<Cell> neighbors = new ArrayList<Cell>();
			neighbors.addAll(cell.getNeighbors().values());
			
			for(Cell c : neighbors) {
				if(c.hasRoad() == true && !c.equals(formerCell)) {
					road.add(c);
				}
			}
			
			if(road.size() > 1) {
				Random random = new Random();
				int r = random.nextInt(road.size() - 1);
				nextCell = road.get(r);
			} else {
				nextCell = road.get(0);
			}
			
			nextCell.addEnemy(this);
			cell.removeEnemy(this);
			blocked = false;
			formerCell = cell;
			cell = nextCell;
		}
	}

	/**
	 * Parancsfeldolgozo - tempor·lis fuggveny
	 * Beallitja az iranyt, amerre mennie kell keresztezodesben az ellensegnek.
	 * @param direction
	 */
	public void setDirection(String direction) {
		cDirection = direction;
		
	}

	public int getCurrentLifePoint() {
		return currentLifePoint;
	}

	public Cell getCell() {
		// TODO Auto-generated method stub
		return cell;
	}

	public Cell getFormerCell() {
		return formerCell;
	}
	
	public String getName() {
		return cName;
	}



}