

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:13:34
 */
public class BlueStone extends MagicStone {

	public BlueStone(){

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