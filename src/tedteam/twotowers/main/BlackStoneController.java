package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a fekete ko lerakasa
 * gombra kattintottunk.
 */
public class BlackStoneController extends Controller{

@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		creationState = Creation.blackStone;
	}
}
