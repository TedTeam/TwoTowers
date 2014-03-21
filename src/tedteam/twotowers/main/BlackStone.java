package tedteam.twotowers.main;

public class BlackStone extends MagicStone {

	public BlackStone(){

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