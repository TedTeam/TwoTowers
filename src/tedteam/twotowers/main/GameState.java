package tedteam.twotowers.main;

/**
 * A jatekallapotot megvalosito osztaly.
 */
public class GameState {
	// A jatek soran letrehozott ellensegek szama.
	@SuppressWarnings("unused")
	private int countEnemy;
	
	// A jatek soran megolt ellensegek szama. default értéke 0
	private int deadEnemiesNumber=0;
	
	// A palyan levo epitmenyeket tartalmazo osztaly.
	private ElementList elementList = new ElementList();
	
	// A palyan levo ellensegeket tartalmazo osztaly.
	private EnemyList enemylist = new EnemyList();
	
	// A palya utolso cellaja.
	private Cell finalCell;
	
	// Ellenségek maximális száma. Jelenleg ez a létrehozott ellenségek száma a protóban
	private int maximumEnemy=0;
	
	//Processor osztaly szamara annak az eldontesere, h ha vege a jateknak, akkor az win v lose.
	private boolean win = false;

	/**
	 * Ez a metodus ellenorzi, hogy veget ert-e a jatek. 
	 * @return true, ha valamelyik ellenseg eljutott az utolso cellaba
	 * vagy a halott ellensegek szama megegyezik az osszes letrehozhato
	 * ellenseg szamaval. Ellenkezo esetben false.
	 */
	public boolean checkGame(){
		try {
		if(finalCell.getEnemy().size()>0) {
			win = false;
			return true;
		} 
		if(deadEnemiesNumber==maximumEnemy) {
			win = true;
			return true;
		}
		} catch (NullPointerException e) {
			//Nincs inicializalva a final cell!!!
			System.out.println("error");
		}
		return false;
	}

	/**
	 * Meghivja az enemyList attributum addEnemy metodusat,
	 * atadva neki a parameterul kapott Enemy objektumot.
	 * @param enemy: felvett Enemy 
	 */
	public void addEnemy(Enemy enemy) {
		enemylist.addEnemy(enemy);
		countEnemy++;
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
		deadEnemiesNumber++;
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
	
	/**
	 * Parancsfeldolgozo - temporális fuggveny
	 * Letrehozott ellenségek számával növekszik
	 * @return
	 */
	public void increaseMaxEnemy() {
		maximumEnemy++;
		
	}
	
	/**
	 * Annak az eldontesere, h ki gyozott.
	 * @return true, ha gyoztunk, false, ha veszitettunk
	 */
	public boolean getWin() {
		return win;
	}



}