package tedteam.twotowers.main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Egy JFrame leszarmazott osztaly, mely a jatek elejen talalhato
 * menu kirajzolasaert es gombjainak hasznalataert felelos.
 */
public class MenuView extends JFrame{

	private static final long serialVersionUID = 1L;
	boolean wait=true;
    JPanel alul;
    JButton felvesz;
   
    /*
     * Itt hozzuk letre es adjuk hozza az ablakunkhoz a kulonbozo komponenseket
     */
    public void initComponents() {
    	alul=new JPanel();
    	JButton start1 = new JButton("Start");
    	JButton help1 = new JButton("Help");
    	JButton exit1 = new JButton("Kilep");
    	OkButtonActionListener OAL=new OkButtonActionListener(); 
    	ExitButtonActionListener EAL=new ExitButtonActionListener();
    	HelpButtonActionListener HAL=new HelpButtonActionListener();
    	start1.addActionListener(OAL);
    	exit1.addActionListener(EAL);
    	help1.addActionListener(HAL);
    	alul.add(start1);
    	alul.add(help1);
    	alul.add(exit1);
    	this.setLayout(new BorderLayout());
    	this.add(alul,BorderLayout.CENTER);
    	this.setPreferredSize(new Dimension(300,300));
		this.setLocation(500,300);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("logo.jpg").getImage());
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
    }
    
    /**
     * Az OK gomb megnyomasat lekezelo osztaly.
     */
    public class OkButtonActionListener implements ActionListener {
  	 
    	public void actionPerformed(ActionEvent e) {
			wait=false;
	    }
	}
    
    /**
     * Az Exit gomb megnyomasat lekezelo osztaly.
     */
    public class ExitButtonActionListener implements ActionListener {
    	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
	    }
	}
    
    /**
     * A Help gomb megnyomasat lekezelo osztaly.
     */
    public class HelpButtonActionListener implements ActionListener {
	  	 
		public void actionPerformed(ActionEvent e) {
			HelpView helpView = new HelpView();
			helpView.initComponents();
	    }
	}

}
