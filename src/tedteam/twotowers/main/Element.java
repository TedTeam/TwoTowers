package tedteam.twotowers.main;

public abstract class Element {

	public Element(){

	}

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
}