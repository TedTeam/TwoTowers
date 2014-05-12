package tedteam.twotowers.main;

/**
 * Az ellensegek megolese utan jaro varazsero novekedest megvalosito osztaly.
 */
public class ManaController implements EnemyVisitor {
	// Referencia egy User objektumra.
	private User user;
	
	/**
	 * Meghivja a user referencia increaseMana(int) metodusat
	 * atadva neki a hobbit elpusztitasaert jaro varazsero novekedest
	 */
	public void affect(Hobbit e) {
		user.increaseMana(30);
	}

	/**
	 * Meghivja a user referencia increaseMana(int) metodusat
	 * atadva neki a tunde elpusztitasaert jaro varazsero novekedest
	 */
	public void affect(Elf e) {
		user.increaseMana(50);
	}

	/**
	 * Meghivja a user referencia increaseMana(int) metodusat
	 * atadva neki a torpe elpusztitasaert jaro varazsero novekedest
	 */
	public void affect(Dwarf d) {
		user.increaseMana(70);
	}

	/**
	 * Meghivja a user referencia increaseMana(int) metodusat
	 * atadva neki az ember elpusztitasaert jaro varazsero novekedest
	 */
	public void affect(Human h) {
		user.increaseMana(50);
	}

	/**
	 * Beallitjuk a user attributumot.
	 * @param user: erre.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
