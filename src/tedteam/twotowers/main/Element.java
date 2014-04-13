package tedteam.twotowers.main;
/**
 * Az epitmenyek (torony, akadaly) absztrakt osztalya.
 */
public abstract class Element {
	// Az epitmeny helye a palyan.
	protected Cell cell = new Cell();
	
	/**
	 * Ez a metodus donti el, hogy a varazskovel lehet-e erositeni
	 * az epitmenyt. Ha igen, akkor erositi is.
	 * @param m: a varazsko, mellyel erositeni szeretnenk az akadalyt.
	 * @return visszajelzes, hogy sikeres volt-e a muvelet.
	 */
	public abstract boolean enhance(MagicStone m);
	
	/**
	 * Az adott epitmeny akciojat vegrehajto metodus.
	 * Toronynal loves, akadalynal blokkolas.
	 */
	public abstract void action();
}