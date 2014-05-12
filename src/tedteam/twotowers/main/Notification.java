package tedteam.twotowers.main;

/**
 * A kepernyo aljan megjeleno ertesiteseket lekezelo osztaly.
 */
public class Notification {
	// Az ertesites szovege.
	private String notification;
	
	/**
	 * Ertesites hozzaadasa.
	 * @param s
	 */
	public void addNotification(String s) {
		notification = s;
	}
	
	/**
	 * Ertesites lekerdezese.
	 * @return
	 */
	public String getNotification() {
		return notification;
	}
}
