package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A fekete varazskovet megvalosito osztaly, (akadaly lassitas mertekenek novelese)
 * Ososztaly: MagicStone
 */
public class BlackStone extends MagicStone {
	private int slowingRate=2; /**A lassitas mertekere vonatkozo szam. Alapertelmezett erteke 2.*/ 
	/**
	 * Ez a metodus valtoztatja meg az akadaly lassitasanak merteket.
	 * @param blocker: az akadaly, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet az akadalyra.
	 */
	public boolean effect(Blocker blocker) {
		if(blocker.getEnhanced()==false){	
			blocker.increaseSlowing(slowingRate);
			return true;
		} else return false;
	}

	/**
	 * Ez a metodus valtoztatja meg a torony lassitasanak merteket.
	 * Mivel ilyen attributuma nincs a toronynak, ezert ez a metodus nem csinal semmit.
	 * @param t: a torony, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet a toronyra (false).
	 */
	public boolean effect(Tower t){
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