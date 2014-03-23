package tedteam.twotowers.main;
/**
 * A varazskovek absztrakt ososztalya.
 */
public abstract class MagicStone {


	/**
	 * Ez a metodus valtoztaja meg az akadaly tulajdonsagait.
	 * @param b: az akadaly, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet az akadalyra.
	 */
	public abstract boolean effect(Blocker b);

	/**
	 * Ez a metodus valtoztatja meg a torony tulajdonsagait.
	 * @param t: a torony, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet a toronyra.
	 */
	public abstract boolean effect(Tower t);

}