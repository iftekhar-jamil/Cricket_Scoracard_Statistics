package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowBarGraph {

		JFrame frame;
		JButton b1,b2;
		int a=1;
		int [] x;
	public ShowBarGraph(final int a,int [] x) {
		this.a = a;
		this.x = x;
		Manual_barchart b = new Manual_barchart(a,x);
		frame = new JFrame("Over to Over Run");
		
		frame.setSize(600, 700);
		b.setBounds(0, 50, 600, 600);
		frame.add(b);
		
		JPanel p = new JPanel();
		p.setSize(600, 100);
			
		b1 = new JButton("Refresh");
		p.add(b1);
		b2 = new JButton("Exit");
		p.add(b2);
		frame.add(p);
		actionAdding();
		frame.setVisible(true);
	}
	
	public void actionAdding(){
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Refresh key is applicable only for instant input");
				frame.setVisible(false);
		
				scoreInput s1 = new scoreInput();
				s1.takeInput();
				new ShowBarGraph(a,x);

			}
					
		});

	}
	
	public void clear(){
		frame.setVisible(false);
	}
	
}
