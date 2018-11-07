package Package1;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.sun.istack.internal.FinalArrayList;

import jdk.nashorn.internal.ir.ReturnNode;

public class scoreInput {
	private FileWriter fw;
	public int [] count = new int [10];
	private BufferedWriter bw;
	int a;
	
	ShowBarGraph sb;
	JFrame f = new JFrame("Score input");
	 JTextField b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	public scoreInput(){}
	public scoreInput(final int a) {
		this.a = a;
		f.setSize(500, 500);
		f.setLayout(new GridLayout(6, 2, 5, 5));
		for(int i=0; i<10; i++) count[i] = 0;
		
		JLabel l1 = new JLabel("Over 1");
		f.add(l1);
		b1 = new JTextField("");
		b1.setSize(200, 50);
		f.add(b1);

		JLabel l2 = new JLabel("Over 2");
		f.add(l2);
		b2 = new JTextField("");
		b2.setSize(200, 50);
		f.add(b2);

		JLabel l3 = new JLabel("Over 3");
		f.add(l3);

		b3 = new JTextField("");
		b3.setSize(200, 50);
		f.add(b3);
		JLabel l4 = new JLabel("Over 4");
		f.add(l4);

		b4 = new JTextField("");
		b4.setSize(200, 50);
		f.add(b4);

		JLabel l5 = new JLabel("Over 5");
		f.add(l5);
		b5 = new JTextField("");
		b2.setSize(200, 50);
		f.add(b5);

		
		JLabel l6 = new JLabel("Over 6");
		f.add(l6);
		b6 = new JTextField("");
		b1.setSize(200, 50);
		f.add(b6);

		
		JLabel l7 = new JLabel("Over 7");
		f.add(l7);
		b7 = new JTextField("");
		b1.setSize(200, 50);
		f.add(b7);
	
		JLabel l8 = new JLabel("Over 8");
		f.add(l8);
		b8 = new JTextField("");
		b1.setSize(200, 50);
		f.add(b8);

		JLabel l9 = new JLabel("Over 9");
		f.add(l9);
		b9 = new JTextField("");
		b1.setSize(200, 50);
		f.add(b9);

		JLabel l10 = new JLabel("Over 10");
		f.add(l10);
		b10 = new JTextField("");
		b1.setSize(200, 50);
		f.add(b10);

		JButton b11 = new JButton("Finish");
		f.add(b11);
		
		JButton b21 = new JButton("Show stats");
		f.add(b21);
		
		if(a==1){
		JOptionPane.showMessageDialog(null, "Enter runs of Team1");
		f.setVisible(true);}
		else {JOptionPane.showMessageDialog(null, "Enter runs of Team2");
		f.setVisible(true);}
		
		b11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a==1){
					takeInput();
					f.setVisible(false);
					new scoreInput(2);
				}
				else {
					f.setVisible(false);
					new Options();
				}
				
			}
		
		});
		
		b21.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				takeInput();
				if(sb!=null) sb.clear();
				sb = new ShowBarGraph(a,count);
				//sb.clear();
			}
		
		});

		
	}

	public int calculate(String[] s,int a) {
		int p = 0;
		
		if(s.length==0) return 0;
		if(s.equals("")) return 0;
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
			if (s[i].equals("wd") || s[i].equals("nb"))
				p += 1;
			else if (s[i].equals("w")||s[i].equals(""))
				p += 0;
			else
				p += Integer.parseInt(s[i]);
			if(s[i].equals("w")) count[a]++;	
		}
		return p;
	}
	
	public void takeInput(){
		String [] s1 = b1.getText().split(" ");
		String [] s2 = b2.getText().split(" ");
		String [] s3 = b3.getText().split(" ");
		String [] s4 = b4.getText().split(" ");
		String [] s5 = b5.getText().split(" ");
		String [] s6 = b6.getText().split(" ");
		String [] s7 = b7.getText().split(" ");
		String [] s8 = b8.getText().split(" ");
		String [] s9 = b9.getText().split(" ");
		String [] s10 = b10.getText().split(" ");
		//int [] count = new int [10];

		try {

			// open filewriter as append mode
			if (a == 1) {
				
				fw = new FileWriter("team1_bat.txt");
				//f.setVisible(false);
				//new scoreInput(2);
				//new ShowBarGraph(a);
			} else {
				f.setVisible(true);
				fw = new FileWriter("team2_bat.txt");
				//f.setVisible(false);
				//new ShowBarGraph(a);
			}
			bw = new BufferedWriter(fw);
			bw.write("10\n");
				
			bw.write("1 " + calculate(s1,0)+" "+count[0]);
		
			bw.write("\n");
		
			bw.write("2 " + calculate(s2,1)+" "+count[1]);
			bw.write("\n");

			bw.write("3 " + calculate(s3,2)+" "+count[2]);
			bw.write("\n");

			bw.write("4 " +calculate(s4,3)+" "+count[3]);
			bw.write("\n");

			bw.write("5 " + calculate(s5,4)+" "+count[4]);
			bw.write("\n");

			bw.write("6 " + calculate(s6,5)+" "+count[5]);
			bw.write("\n");

			bw.write("7 " + calculate(s7,6)+" "+count[6]);
			bw.write("\n");

			bw.write("8 " + calculate(s8,7)+" "+count[7]);
			bw.write("\n");

			bw.write("9 " + calculate(s9,8)+" "+count[8]);
			bw.write("\n");

			bw.write("10 " + calculate(s10,9)+" "+count[9]);
			bw.write("\n");
			
			for(int i=0; i<10; i++) System.out.println("--"+count[i]+"--");

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

			//f.setVisible(false);

		} catch(IOException e1) {
			e1.printStackTrace();
		
		}
		
	}
	
	
}
