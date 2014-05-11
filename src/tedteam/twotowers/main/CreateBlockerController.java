package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy az akadaly keszitese
 * gombra kattintottunk.
 */
public class CreateBlockerController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		creationState = Creation.blocker;
	}
}
