package tedteam.twotowers.main;

public class BlueStone extends MagicStone {

	public BlueStone(){

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