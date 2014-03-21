package tedteam.twotowers.main;

public abstract class MagicStone {

	public MagicStone(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param b
	 */
	public abstract boolean effect(Blocker b);

	/**
	 * 
	 * @param t
	 */
	public abstract boolean effect(Tower t);

}