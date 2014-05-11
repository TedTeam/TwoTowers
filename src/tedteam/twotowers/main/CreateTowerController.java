package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a torony keszitese
 * gombra kattintottunk.
 */
public class CreateTowerController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		creationState = Creation.tower;
		
	}
}
