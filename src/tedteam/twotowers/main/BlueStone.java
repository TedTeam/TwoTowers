package tedteam.twotowers.main;

public class BlueStone extends MagicStone {

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