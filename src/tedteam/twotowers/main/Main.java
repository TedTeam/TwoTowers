package tedteam.twotowers.main;

import java.io.IOException;

import tedteam.twotowers.processor.Processor;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Processor p = new Processor();
		p.inputProcessLoop();
	}

}
