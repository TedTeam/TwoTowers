

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:14:40
 */
public class RedStone extends MagicStone {

	public RedStone(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param b
	 */
	public boolean effect(Blocker b){
		return false;
	}

	/**
	 * 
	 * @param t
	 */
	public boolean effect(Tower t){
		return false;
	}

}