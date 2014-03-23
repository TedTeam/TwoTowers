package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A palyan levo ellensegeket tarolo osztaly.
 */
public class EnemyList {
	// A palyan levo ellensegek tombje.
	private Enemy enemies[] = new Enemy[20];

	/**
	 * Hozzaad egy ellenseget az enemies tombhoz.
	 * @param enemy: a hozzaadando ellenseg.
	 */
	public void addEnemy(Enemy enemy){
		Logger.enter("enemyList", "addEnemy", "hobbit", "");
		
		Logger.exit("void");
	}

	/**
	 * Torol egy ellenseget az enemies tombbol.
	 * @param e: ezt torli a tombbol.
	 */
	public void deleteEnemy(Enemy e){

	}

	/**
	 * Meghivja az osszes tartalmazott ellenseg lepteto metodusat.
	 */
	public void stepAll(){
		Logger.enter("enemyList", "stepAll", "","");
		
		enemies[0] = new Hobbit();
		enemies[0].step();
		Logger.exit("void");
	}

	/**
	 * Meghivja az osszes tartalmazott ellenseg acceptDamage metodusat.
	 * @param d: ezt adja parameterul az acceptDamage metodusoknak.
	 */
	public void notifyAllEnemy(IDamage d) {
		
	}

}