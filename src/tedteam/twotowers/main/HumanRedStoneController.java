package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a piros ko lerakasa
 * gombra kattintottunk es az ember ellenseg volt kivalasztva.
 */
public class HumanRedStoneController extends Controller{
	
	@Override
	public void actionPerformed(ActionEvent clicked) {
		creationState = Creation.humanRedStone;
	}

}
