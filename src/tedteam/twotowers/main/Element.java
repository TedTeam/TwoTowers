package tedteam.twotowers.main;

public abstract class Element {

	protected Cell cell = new Cell();
	
	/**
	 * 
	 * @param m
	 */
	public abstract boolean enhance(MagicStone m);

	/**
	 * Loggoláshoz, skeleton után törlendő!
	 * @return
	 */
	public abstract String loggerGetName();
	
	public abstract void action();
}