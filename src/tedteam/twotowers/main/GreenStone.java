package tedteam.twotowers.main;

/**
 * A zold varazskovet megvalosito osztaly.
 * Ososztaly: MagicStone
 */
public class GreenStone extends MagicStone {
	// A tuzelesi sebesseg mertekere vonatkozo szam. Alapertelmezett erteke 4. 
	private int speedRate = 4;
	
	/**
	 * Ez a metodus valtoztatja meg az akadaly lovesi sebesseget.
	 * Mivel ilyen attributuma nincs az akadalynak, ezert ez a metodus nem csinal semmit.
	 * @param b: az akadaly, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet az akadalyra (false).
	 */
	public boolean effect(Blocker b){
		return false;
	}

	/**
	 * Ez a metodus valtoztatja meg a torony lovesi sebesseget.
	 * @param t: a torony, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet a toronyra.
	 */
	public boolean effect(Tower tower){
		if(tower.getStoneNumber() < 2)
			if(tower.getEnhancedByGreen()) {
				return false;
			} else {
				tower.setEnhancedByGreen();
				tower.increaseStoneNumber();
				tower.increaseSpeed(speedRate);
				return true;
			}
		return false;
		
	}

}