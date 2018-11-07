package Package1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Options {
	
	private int target;
	public Options(){
		initializer();
		actionAdding();
	}


	
	JFrame f = new JFrame();
	JButton b1 = new JButton("Team 1");
	JButton b2 = new JButton("Team 2");
	JButton b3 = new JButton("Compare");
	JButton b4 = new JButton("Exit");
	
	
	public void initializer(){
		//f.setLayout(new FlowLayout());
		f.setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("C:/Users/user/Desktop/images.png"));
		background.setLayout(new FlowLayout());
		
		f.setSize(500,300);
		background.add(b1);
		background.add(b2);
		background.add(b3);
		background.add(b4);
		f.add(background);
		f.setVisible(true);
		//f.add(new JLabel(new ImageIcon("C:/Users/user/Desktop/images.png")));
		f.pack();
		
		
	}
	
	public void actionAdding(){
		b1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					TeamBatting a = new TeamBatting(false,0,"team1_bat.txt");
					f.setVisible(false);
					
					BattingContribution bc1 = new BattingContribution(a,"team1_batsmen.txt",1);
					target = a.sum;
					//Manual_barchart mb1 = new Manual_barchart(1);
						
				}
		});
	
	
		b2.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					TeamBatting b = new TeamBatting(true,target, "team2_bat.txt");
					//Manual_barchart mb2 = new Manual_barchart(2);
					BattingContribution bc2 = new BattingContribution(b,"team_2_batsmen.txt",2);
					
				}
		});
		
		b3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				TeamBatting a = new TeamBatting(false,0,"team1_bat.txt");
				TeamBatting b = new TeamBatting(true,target, "team2_bat.txt");
				BattingContribution bc3 = new BattingContribution(a,b);	
		
			}
	});
	
		
	
		
		b4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				System.exit(0);
		
			}
	});
	}

	
	

}
