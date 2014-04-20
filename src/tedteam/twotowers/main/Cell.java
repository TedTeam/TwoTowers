package tedteam.twotowers.main;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * A jatekter mezoi.
 * Eltarolja a rajta levo epitmenyeket, ellensegeket.
 */
public class Cell {
	// A cellan levo ellensegek.
	private ArrayList<Enemy> actualEnemies = new ArrayList<Enemy>();
	// A cellara rakott akadaly vagy torony.
	private Element element = null;
	// A szomszedos cellak referenciai.
	private HashMap<String,Cell> neighbors = new HashMap<String,Cell>();
	// Ez donti el, hogy a cellan talalhato-e ut.
	private boolean road = false;
	
	//temp-parancsfeldolgozo
	private String cName = new String();

	/**
	 * Hozzaad egy ellenseget az actualEnemies lancolt listahoz.
	 * @param enemy: ezt az ellenseget adja hozza.
	 */
	public void addEnemy(Enemy enemy) {
		this.actualEnemies.add(enemy);
	}
	
	/**
	 * Lekeri cella szomszedait.
	 * @return a cella szomszedos cellai.
	 */
	public HashMap<String,Cell> getNeighbors() {
		return neighbors;
	}

	/**
	 * Kitorol egy ellenseget az actualEnemies lancolt listabol.
	 * @param e: ezt az ellenseget torli ki.
	 */
	public void removeEnemy(Enemy e) {
		this.actualEnemies.remove(e);
	}

	/**
	 * Beallitja a cella szomszed cellait.
	 * @param c: a kapott tomb tartalmazza a szomszedokat.
	 */
	public void setNeighbors(HashMap<String,Cell> neighbors2) {
		this.neighbors.putAll(neighbors2);
	}
	
	/* Lekeri a cellan talalhato osszes ellenseget.
	 * @return a cellan talalhato ellensegeket tartalmazo tomb.
	 */
	public boolean hasEnemy() {
		if(actualEnemies.size()==0) return false;
		else return true;
	}
	
	/**
	 * Lekeri a cellan talalhato osszes ellenseget.
	 * @return a cellan talalhato ellensegeket tartalmazo tomb.
	 */
	public ArrayList<Enemy> getEnemy() {
		return actualEnemies;
	}
	/**
	 * Ha az element valtozo erteke null, akkor false ertekkel ter vissza. 
	 * Egyeb esetben true-val.
	 */
	public boolean hasElement() {
		if(element==null) return false; 
		else return true;
	}
	
	/**
	 * Lekeri a cellan talalhato epitmenyt.
	 * @return a cellan talahato epitmeny.
	 */
	public Element getElement() {
		return element;
	}
	/**
	 * Torli a cellan talalhato epitmenyt
	 */
	public void removeElement(Element element) {
		this.element=null;
	}

	/**
	 * Beallitja a cellara egy tornyot vagy akadalyt.
	 * @param element: ezt allitja be.
	 */
	public void setElement(Element element) {
		this.element = element;
	}

	/**
	 * Megvizsgalja, hogy a cellan talalhato-e ut.
	 * @return a vizsgalat eredmenye.
	 */
	public boolean hasRoad() {
		return road;
	}
	/**
	 * Beallitja a road attributumot igazra.
	 */
	public void setRoad() {
		road=true;
	}
	
	public String getCellName() {
		return cName;
	}

	public void setCellName(String name) {
		cName = name;
	}
}