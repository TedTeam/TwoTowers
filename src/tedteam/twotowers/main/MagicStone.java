

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:14:34
 */
public class MagicStone {

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