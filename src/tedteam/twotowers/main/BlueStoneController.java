package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

public class BlueStoneController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		creationState=Creation.blueStone;
	}
}
