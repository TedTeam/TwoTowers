package tedteam.twotowers.main;
/**
 * A kek varazskovet megvalosito osztaly, (torony hatotavolsagot novel)
 * Ososztaly: MagicStone
 */
public class BlueStone extends MagicStone {
	/**A hat�t�vols�g m�rt�k�re vonatkoz� sz�m. */
	private int rangeRate=2;
	/**
	 * Ez a metodus valtoztatja meg az akadaly hatotavolsaganak nagysagat.
	 * Mivel ilyen attributuma nincs az akadalynak, ezert ez a metodus nem csinal semmit.
	 * @param b: az akadaly, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet az akadalyra (false).
	 */
	public boolean effect(Blocker b){
		return false;
	}

	/**
	 * Ez a metodus valtoztatja meg a torony hatotavolsaganak nagysagat.
	 * @param t: a torony, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet a toronyra.
	 */
	public boolean effect(Tower t){
		if(t.getStoneNumber()<2) 
			if(t.getEnhancedByBlue()) return false;
			else { 
				t.setEnhancedByBlue();
				t.increaseStoneNumber();
				t.increaseRange(this.rangeRate);
				return true;
			}
		return false;
	}

	public void setName(String name) {
		cName = name;	
	}

	@Override
	public String getName() {
		return cName;
	}

}