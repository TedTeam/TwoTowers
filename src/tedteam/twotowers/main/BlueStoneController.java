package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a kek ko lerakasa
 * gombra kattintottunk.
 */
public class BlueStoneController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		creationState=Creation.blueStone;
	}
}
