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
	private ElementList elementList = new ElementList();
	
	// A palyan levo ellensegeket tartalmazo osztaly.
	private EnemyList enemylist = new EnemyList();
	
	// A palya utolso cellaja.
	private Cell finalCell;
	
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
	 * Meghivja az enemyList attributum addEnemy metodusat,
	 * atadva neki a parameterul kapott Enemy objektumot.
	 * @param enemy: felvett Enemy 
	 */
	public void addEnemy(Enemy enemy) {
		enemylist.addEnemy(enemy);
	}
	/**
	 * Meghivja az elementList valtozojanak addElement(Element) metodusat 
	 * atadva neki a parameterkent kapott Element objektumot.
	 * @param element: felvett Element
	 */
	public void addElement(Element element){
		elementList.addElement(element);
	}
	
	/**
	 * Torli az enemyListbol a halott ellenseget es noveli a halott ellensegek szamat.
	 * @param e: a halott ellenseg akit torolni kell.
	 */
	public void deadEnemy(Enemy enemy){
		enemylist.deleteEnemy(enemy);
	}

	/**
	 * Torli az elementListbol a tonkrement akadalyt.
	 * @param blocker: ezt az akadalyt kell torolni.
	 */
	public void deleteElement(Element element){
		elementList.deleteElement(element);
	}

	/**
	 * Beallitja a palya utolso cellajat.
	 * @param c: ez lesz az utolso cella.
	 */
	public void setFinalCell(Cell cell){
		finalCell = cell;
	}

	public void setStartCell(Cell c) {//ez minek is?
		// TODO Auto-generated method stub
		
	}

	/**
	 * Parancsfeldolgozo - temporális fuggveny
	 * @return
	 */
	public EnemyList getEnemyList() {
		return enemylist;
	}

	/**
	 * Parancsfeldolgozo - temporális fuggveny
	 * @return
	 */
	public ElementList getElementList() {
		return elementList;
	}



}