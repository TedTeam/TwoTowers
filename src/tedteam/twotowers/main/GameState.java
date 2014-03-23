package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A jatekallapotot megvalosito osztaly.
 */
public class GameState {
	// A jatek soran letrehozott ellensegek szama.
	private int countEnemy;
	
	// A jatek soran megolt ellensegek szama.
	private int deadEnemiesNumber;
	
	// A palyan levo epitmenyeket tartalmazo osztaly.
	private ElementList elementList;
	
	// A palyan levo ellensegeket tartalmazo osztaly.
	private EnemyList enemylist;
	
	// A palya utolso cellaja.
	private Cell finalCell = new Cell();
	
	// Az osszes letrehozhato ellenseg szama.
	private int maximumEnemy;

	/**
	 * Ez a metodus ellenorzi, hogy veget ert-e a jatek. 
	 * @return true, ha valamelyik ellenseg eljutott az utolso cellaba
	 * vagy a halott ellensegek szama megegyezik az osszes letrehozhato
	 * ellenseg szamaval. Ellenkezo esetben false.
	 */
	public boolean checkGame(){
		Logger.enter("gameState", "checkGame", "", "");
		finalCell.getEnemy();
		
		if(Logger.question("Van ellenseg az utolso cellan?")) {
			System.out.println("Kommunikacio: Vereseg, vesztettel!");
			Logger.exit("true");
			return true;
		} 
		if(Logger.question("Ellenseg szama megegyezik a megolt ellensegek szamaval?")) {
			System.out.println("Kommunikacio: Gyozelem, nyertel!");
			Logger.exit("true");
			return true;
		}
		
		Logger.exit("false");
		return false;
	}

	/**
	 * Torli az enemyListbol a halott ellenseget es noveli a halott ellensegek szamat.
	 * @param e: a halott ellenseg akit torolni kell.
	 */
	public void deadEnemy(Enemy e){

	}

	/**
	 * Torli az elementListbol a tonkrement akadalyt.
	 * @param blocker: ezt az akadalyt kell torolni.
	 */
	public void deleteBlocker(Blocker blocker){

	}

	/**
	 * Beallitja a palya utolso cellajat.
	 * @param c: ez lesz az utolso cella.
	 */
	public void setFinalCell(Cell c){
		Logger.enter("gameState", "setFinalCell", "cell4", "");
		
		Logger.exit("void");
	}

}