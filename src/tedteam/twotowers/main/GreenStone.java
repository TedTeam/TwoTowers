

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:14:07
 */
public class GreenStone extends MagicStone {

	public GreenStone(){

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