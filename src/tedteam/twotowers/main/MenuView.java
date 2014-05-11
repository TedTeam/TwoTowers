package tedteam.twotowers.main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MenuView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean wait=true;
   JPanel alul;
   
   JButton felvesz;
   
   /*
    * Itt hozzuk létre és adjuk hozzá az ablakunkhoz a különbözõ komponenseket
    */
   public void initComponents() {
       alul=new JPanel();
       JButton start1 = new JButton("Start");
       JButton help1 = new JButton("Help");
       JButton exit1 = new JButton("Kilép");
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
   public class OkButtonActionListener implements ActionListener {
  	 
		public void actionPerformed(ActionEvent e) {
			wait=false;
	    }
	}
   public class ExitButtonActionListener implements ActionListener {
	  	 
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
	    }
	}
   public class HelpButtonActionListener implements ActionListener {
	  	 
		public void actionPerformed(ActionEvent e) {
			HelpView helpView = new HelpView();
			helpView.initComponents();
	    }
	}

}
