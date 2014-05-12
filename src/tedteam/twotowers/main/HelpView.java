package tedteam.twotowers.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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

	   public void initComponents() {
		   String content;
		try {
			content = readFile("resources/help.txt", Charset.defaultCharset());

		   JTextArea area = new JTextArea();
		   area.setText(content); 
	       panel=new JPanel();
	       panel.add(area);
	       this.setLayout(new BorderLayout());
	       this.add(panel,BorderLayout.CENTER);
	       //this.setPreferredSize(new Dimension(500,500));
			this.setSize(800,600);
			this.setLocation(500,300);
			this.setIconImage(new ImageIcon("logo.jpg").getImage());
			this.setResizable(false);
			this.pack();
			this.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   static String readFile(String path, Charset encoding) 
			   throws IOException 
			 {
			   byte[] encoded = Files.readAllBytes(Paths.get(path));
			   return new String(encoded, encoding);
			 }
}
