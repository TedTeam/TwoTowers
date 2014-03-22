package tedteam.twotowers.main;

public class RedStone extends MagicStone {

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