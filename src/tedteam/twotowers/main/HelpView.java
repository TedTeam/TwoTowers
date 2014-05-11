package tedteam.twotowers.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpView extends JFrame{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		JPanel panel;
		
		Scanner fileStream = new Scanner("help.txt");
		String file = new String("");		

	   public void initComponents() {
		   while(fileStream.hasNextLine())
				file += fileStream.nextLine();
		   JTextArea area = new JTextArea();
		   area.setText(file); 
	       panel=new JPanel();
	       panel.add(area);
	       this.setLayout(new BorderLayout());
	       this.add(panel,BorderLayout.CENTER);
	       this.setPreferredSize(new Dimension(500,500));
			this.setSize(800,600);
			this.setLocation(500,300);
			this.setIconImage(new ImageIcon("logo.jpg").getImage());
			this.setResizable(false);
			this.pack();
			this.setVisible(true);
	   }
}
