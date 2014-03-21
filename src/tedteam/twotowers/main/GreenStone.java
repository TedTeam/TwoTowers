package tedteam.twotowers.main;

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