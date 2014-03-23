package tedteam.twotowers.main;

import tedteam.twotowers.logger.Logger;
/**
 * A fekete varazskovet megvalosito osztaly.
 * Ososztaly: MagicStone
 */
public class BlackStone extends MagicStone {

	/**
	 * Ez a metodus valtoztatja meg az akadaly lassitasanak merteket.
	 * @param blocker: az akadaly, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet az akadalyra.
	 */
	public boolean effect(Blocker blocker) {
		Logger.enter("blackStone", "effect", "blocker", "");
		
		int i = 0;
		
		blocker.setSlowing(i);
		
		Logger.exit("true");
		return true;
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

}