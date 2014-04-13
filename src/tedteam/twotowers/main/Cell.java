package tedteam.twotowers.main;

import java.util.HashMap;

import tedteam.twotowers.logger.Logger;
/**
 * A jatekter mezoi.
 * Eltarolja a rajta levo epitmenyeket, ellensegeket.
 */
public class Cell {
	// A cellan levo ellensegek.
	private Enemy actualEnemies[];
	// A cellara rakott akadaly vagy torony.
	private Element element = null;
	// A szomszedos cellak referenciai.
	private HashMap<String,Cell> neighbor;
	// Ez donti el, hogy a cellan talalhato-e ut.
	private boolean road = false;

	/**
	 * Hozzaad egy ellenseget az actualEnemies lancolt listahoz.
	 * @param enemy: ezt az ellenseget adja hozza.
	 */
	public void addEnemy(Enemy enemy) {
		Logger.enter("cell", "addEnemy", "enemy", "");
		
		Logger.exit("void");
	}
	
	/**
	 * Lekeri cella szomszedait.
	 * @return a cella szomszedos cellai.
	 */
	/* részletes tervekben nincs benne, hogyan legyen??
	 * public Cell[] getNeighbors() {
		Logger.enter("cell", "getNeighbors", "", "");

		neighbor[0] = new Cell();
		neighbor[1] = new Cell();
		neighbor[2] = new Cell();
		neighbor[3] = new Cell();
		Logger.exit("Cell[c1,c2,c3,c4]");
		return neighbor;
	}*/

	/**
	 * Kitorol egy ellenseget az actualEnemies lancolt listabol.
	 * @param e: ezt az ellenseget torli ki.
	 */
	public void removeEnemy(Enemy e) {
		Logger.enter("formerCell", "removeEnemy","","");
		Logger.exit("void");
	}

	/**
	 * Beallitja a cella szomszed cellait.
	 * @param c: a kapott tomb tartalmazza a szomszedokat.
	 */
	public void setNeighbors(HashMap<String,Cell> neighbors) {
		neighbor=neighbors;
	}
	
	/**
	 * Lekeri a cellan talalhato osszes ellenseget.
	 * @return a cellan talalhato ellensegeket tartalmazo tomb.
	 */
	public Enemy[] getEnemy() {
		Logger.enter("cell", "getEnemy", "", "");
	
		Logger.exit("e:Enemy[]");
		return actualEnemies;
	}
	
	/**
	 * Lekeri a cellan talalhato epitmenyt.
	 * @return a cellan talahato epitmeny.
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * Beallitja a cellara egy tornyot vagy akadalyt.
	 * @param element: ezt allitja be.
	 */
	public void setElement(Element element) {
		this.element = element;

		Logger.exit("void");
	}

	/**
	 * Megvizsgalja, hogy a cellan talalhato-e ut.
	 * @return a vizsgalat eredmenye.
	 */
	public boolean hasRoad() {
		return road;
	}
	//Blocker action függvénye miatt kellett, de részletes tervben nincsen
	public void removeElement(Blocker blocker) {
		this.element=null;
		
	}
}