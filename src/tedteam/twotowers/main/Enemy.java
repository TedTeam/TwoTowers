package tedteam.twotowers.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
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
	// Alapertelmezett erteke: 0.
	private int tick = 0;


	/**
	 * Abstract metodus, amit a leszarmaztatott osztalyoknak
	 * kell implementalniuk.
	 * @param evisitor.
	 */
	public abstract void accept(EnemyVisitor evisitor);
	
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
	 * @throws Exception 
	 */
	public void step(){
		if(10 - tick == speed){
			//szomszed cellak lekerese
			ArrayList<Cell> neighbors = new ArrayList<Cell>();
			neighbors.addAll(cell.getNeighbors().values());
			ArrayList<Cell> stepChances = new ArrayList<Cell>();
			Random rand = new Random();
			int stepChanceIndex = 0;
			for(Cell c:neighbors) {
				if(c != null)
					if(c.hasRoad() == true && c != formerCell) {
						stepChanceIndex++;
						stepChances.add(c);
					}
			}
			int direction = 0;
			if(stepChanceIndex > 0)
				direction = rand.nextInt(stepChanceIndex);//1-tol random szam generalas,amennyi lepheto cella van,a lepes iranyat donti el
			for(int i=0; i < stepChanceIndex; i++) {
				if(i == direction) {
					formerCell = cell;
					cell.removeEnemy(this);
					cell = stepChances.get(i);
					cell.addEnemy(this);
					tick = 0;
					return;
				}
			}
		}
		else tick++;
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

}