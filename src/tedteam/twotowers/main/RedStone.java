package tedteam.twotowers.main;
/**
 * A piros varazskovet megvalosito osztaly.
 * Ososztaly: MagicStone
 */
public class RedStone extends MagicStone {

	private int DwarfDamage = 30;
	private int elfDamage = 30;
	private int hobbitDamage = 30;
	private int humanDamage = 30;

	/**
	 * Ez a metodus valtoztatja meg az akadaly sebzesenek nagysagat.
	 * Mivel ilyen attributuma nincs az akadalynak, ezert ez a metodus nem csinal semmit.
	 * @param b: az akadaly, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet az akadalyra (false).
	 */
	public boolean effect(Blocker b){
		return false;
	}

	/**
	 * Ez a metodus valtoztatja meg a torony sebzesenek nagysagat.
	 * @param t: a torony, melyre a valtoztatast alkalmazni akarjuk.
	 * @return a visszateresi ertek, hogy sikerult-e rarakni a kovet a toronyra.
	 */
	public boolean effect(Tower t){
		if(t.getStoneNumber() <2){
			if(t.getEnhancedByRed() == false){
				t.setEnhancedByRed();
				t.increaseStoneNumber();
				t.increaseDamage(DwarfDamage, elfDamage, hobbitDamage, humanDamage);
				return true;
			}
		}
		return false;
	}

	public void setName(String name) {
		cName = name;	
	}

	@Override
	public String getName() {
		return cName;
	}

}