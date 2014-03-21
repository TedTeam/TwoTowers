package tedteam.twotowers.main;

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