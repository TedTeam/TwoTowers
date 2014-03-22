package tedteam.twotowers.main;

import java.io.IOException;

import tedteam.twotowers.logger.Menu;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Hello TED team!");

		Menu menu = new Menu();
		while (true) {
			menu.printMenu();
			menu.handleChoice();

		}
	}

}
