package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

public class RedStoneController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		view.enableAllRadioButtons(true);
		creationState = Creation.elfRedStone;
	}
}
