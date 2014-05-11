package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a piros ko lerakasa
 * gombra kattintottunk es a hobbit ellenseg volt kivalasztva.
 */
public class HobbitRedStoneController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		creationState = Creation.hobbitRedStone;
	}
}
