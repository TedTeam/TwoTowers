package tedteam.twotowers.main;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Controller implements ActionListener, MouseListener {

	enum Creation{none,tower,blocker,elfRedStone,humanRedStone,hobbitRedStone,dwarfRedStone,blueStone,greenStone,blackStone}
	protected static View view;
	protected static Creation creationState = Creation.none;
	private User user;
	private Converter converter;
	
	public void setUser(User user) {
		this.user = user;
	}
	public void setView(View view2) {
		view = view2;
	}
	
	public void setConverter(Converter converter) {
		this.converter = converter;
	}
	@Override
	public void actionPerformed(ActionEvent clicked) {
		//System.out.println(clicked.getActionCommand());
		JButton button = (JButton)clicked.getSource();
		view.enableAllButtons();
		button.setEnabled(false);
		//view.field.repaint();
		
	}
	@Override
	public void mouseClicked(MouseEvent clicked) {
		System.out.println("X: "+clicked.getX()+" Y: "+clicked.getY());
		
		view.drawIcon(clicked.getX(),clicked.getY());
		System.out.println(converter.getCell(new Point(clicked.getX(),clicked.getY())));
		switch(creationState){
		case none:break;
		case tower:{user.createTower();break;}
		case blocker:{user.createBlocker();break;}
		case greenStone:{user.createGreenStone();break;}
		case blueStone:{user.createBlueStone();break;}
		case blackStone:{user.createBlackStone();break;}
		case elfRedStone:{user.createElfRedStone();break;}
		case humanRedStone:{user.createHumanRedStone();break;}
		case hobbitRedStone:{user.createHobbitRedStone();break;}
		case dwarfRedStone:{user.createDwarfRedStone();break;}
		}
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
