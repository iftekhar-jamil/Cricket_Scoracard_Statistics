package Package1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InputFormat {
	JFrame frame;
	JButton  b1,b2;
	public InputFormat(){
		frame = new JFrame ("Input Format Confirmation");
		frame.setLayout(new BorderLayout());
		JLabel back=new JLabel(new ImageIcon("C:/Users/user/Desktop/images2.png"));
		frame.setSize(700,700);
		back.setLayout(new FlowLayout());

		b1 = new JButton("Give input instantly");
		b2 = new JButton("Use existing files");
		b1.setSize(500, 100);
		b2.setSize(200, 100);
		frame.setVisible(true);
		back.setLayout(new FlowLayout());
		back.add(b1);
		back.add(b2);
		frame.add(back);
		frame.pack();
		ActionAdding();
	}

	private void ActionAdding() {
		// TODO Auto-generated method stub
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				JFrame f = new JFrame();
				frame.setVisible(false);
				f.setSize(200,500);
				new Options();
				
			}
		});

		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				JFrame f = new JFrame();
				frame.setVisible(false);
				//f.setSize(200,500);
				new scoreInput(1);
				//new scoreInput(2);
				//new Options();
				
			}
		});

		
	}
	
}
