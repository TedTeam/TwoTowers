package tedteam.twotowers.main;

import java.util.ArrayList;

/**
 * A palyan levo ellensegeket tarolo osztaly.
 */
public class EnemyList {
	// A palyan levo ellensegek tombje.
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	/**
	 * Hozzaad egy ellenseget az enemies lancolt listahoz.
	 * @param enemy: a hozzaadando ellenseg.
	 */
	public void addEnemy(Enemy enemy){
		enemies.add(enemy);
	}

	/**
	 * Torol egy ellenseget az enemies lancolt listabol.
	 * @param enemy: ezt torli a lancolt listabol.
	 */
	public void deleteEnemy(Enemy enemy){
		enemies.remove(enemy);
	}

	/**
	 * Meghivja az osszes tartalmazott ellenseg lepteto metodusat.
	 */
	public void stepAll(){
		for(Enemy e : enemies) {
			e.step();
		}
	}

	/**
	 * Parancsfeldolgozo - temporalis fuggveny
	 * Visszadja a name nevu ellenseget.
	 * @param name: az ilyen nevu enemyt keressuk
	 * @return a megtalalt enemy (ha van)
	 */
	public Enemy getEnemyByName(String name) {
		int index = -1;
		for(Enemy e : enemies) {
			if(e.getName().equals(name))
				index = enemies.indexOf(e);
		}
		if(index == -1)
			return null;
		return enemies.get(index);
	}

}