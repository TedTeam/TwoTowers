package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a piros ko lerakasa
 * gombra kattintottunk.
 */
public class RedStoneController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		view.enableAllRadioButtons(true);
		creationState = Creation.elfRedStone;
	}
}
