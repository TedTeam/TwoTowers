package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a zold ko lerakasa
 * gombra kattintottunk.
 */
public class GreenStoneController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		creationState=Creation.greenStone;
	}
}
