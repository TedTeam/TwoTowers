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
			try {
				e.step();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void visitEnemies(EnemyVisitor visitor){
		for(Enemy e : enemies){
			e.accept(visitor);
		}
		
	}

}