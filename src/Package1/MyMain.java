package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Application;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyMain{
	public static void main(String [] args) throws InterruptedException{
		
	
		JFrame f = new JFrame("Welcome to cricket scoreboard");
		
		f.setLayout(new BorderLayout());
		f.setSize(400, 600);
		Thread t = new Thread();
		JLabel l = new JLabel(new ImageIcon("C:/Users/user/Desktop/abc.png"));
		l.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		JLabel l1 = new JLabel("At first you need to choose whether\n ");
		JLabel l2 = new JLabel("to take input or \n using an existing file.After taking input you need to select\n ");
		JLabel l3 = new JLabel("team whose stat you want to see.\n And further specify what stat should be displayed\n");
		JButton b1 = new JButton("Ok");
		b1.setSize(200, 100);
		b1.setForeground(Color.blue);
		b1.setBackground(Color.green);
		l1.setFont(new Font("Serif", Font.PLAIN, 30));
		l2.setFont(new Font("Serif", Font.PLAIN, 30));
		l3.setFont(new Font("Serif", Font.PLAIN, 30));
		l1.setForeground(Color.MAGENTA);
		l2.setForeground(Color.MAGENTA);
		l3.setForeground(Color.MAGENTA);
		l.add(l1,c);
		c.gridy++;
		f.add(l);
		f.pack();
		f.setVisible(true);
		f.dispose();
		//t.sleep(1000);
		l.add(l2,c);
		l.repaint();
		c.gridy++;
		//t.sleep(1000);
		
		f.add(l);
		//f.repaint();
		l.add(l3,c);
		l.repaint();
		c.gridy++;
		
		
		
		l.add(b1,c);
		
		
		f.add(l);
		//c.gridy++;
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		//		f.setVisible(false);
				new InputFormat();
				
			}
		});
		//new InputFormat();
		//new Options();
		
		/*String s1 = "";
		String [] s =  s1.split("");
		System.out.println(s.length);
		System.out.println(s[0]+"...");
		*/
	}

}
