package tedteam.twotowers.main;

import java.awt.event.ActionEvent;

public class CreateTowerController extends Controller{

	@Override
	public void actionPerformed(ActionEvent clicked) {
		super.actionPerformed(clicked);
		System.out.println("create tower button clicked");
		creationState = Creation.tower;
		
	}
}
