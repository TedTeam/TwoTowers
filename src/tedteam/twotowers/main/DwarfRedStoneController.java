package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

/**
 * Ez az osztaly kezeli azt, hogy a piros ko lerakasa
 * gombra kattintottunk es a torp ellenseg volt kivalasztva.
 */
public class DwarfRedStoneController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		creationState = Creation.dwarfRedStone;
	}
}
