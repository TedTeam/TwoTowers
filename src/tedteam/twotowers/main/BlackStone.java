

/**
 * @author Zsolt
 * @version 1.0
 * @created 21-Mar-2014 22:13:16
 */
public class BlackStone extends MagicStone {

	public BlackStone(){

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