package Package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Manual_XY extends JPanel {
	int [] p,q;
	public Manual_XY(int [] a,int [] b){
			ArrayList<Integer> arr1 = new ArrayList<Integer>();
			p = new int [10];
			q = new int [10];
			takeInput(1);
			takeInput(2);
	}
	
	public void takeInput(int i){
		
		BufferedReader br = null;
		FileReader fr = null;
	
		try {

			if(i==1) fr = new FileReader("team1_bat.txt");
			else 
			fr = new FileReader("team2_bat.txt");
			
			
			br = new BufferedReader(fr);

			String sCurrentLine;
			int k = 0;
			br = new BufferedReader(fr);
			boolean isFound = false;
			sCurrentLine = br.readLine();
			while ((sCurrentLine = br.readLine()) != null) {

				System.out.println(sCurrentLine);
				String [] b = sCurrentLine.split(" ");
				int a = Integer.parseInt(b[1]);
				if(i==1) p[k++] = a;
				else q[k++] =a;
			}
			
		

			// p = ArrayUtils.toPrimitive(arr1.toArray(new Integer[0]));
			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		
		for(int i=0;i<=600;i+=10){
			g.setColor(Color.GREEN);
			g.drawLine(0, i, 600, i);
		}
		for(int i=0;i<=600;i+=50){
			g.setColor(Color.RED);
			g.drawLine(0, i, 600, i);
			g.drawString(""+(45-i/10)*2, 0, i);
		}
		for(int i=0;i<=600;i+=10){
			g.setColor(Color.GREEN);
			g.drawLine(i, 0, i, 600);
		}
		for(int i=0;i<=600;i+=50){
			g.setColor(Color.RED);
			g.drawLine(i, 0, i, 600);
			g.drawString(""+(i/50-1), i, 480);
		}	
		g.setColor(Color.RED);
		g.setPaintMode();
		g.setFont(new Font("TimesRoman", Font.BOLD, 80));
		int x =50,y1 = 450,y2 = 450;
		for(int i=0; i<10; i++){
			g.drawLine(x, y1, x+50, y1-p[i]*5);
			y1 = y1-p[i]*5;
			x+=50;
			
		}
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("TimesRoman", Font.BOLD, 80));
		 x =50; y1 = 450; y2 = 450;
		for(int i=0; i<10; i++){
			
				g.drawLine(x, y1, x+50, y1-q[i]*5);
				//g.fillRect(x, y1 - p[i] * 10, 20, p[i] * 10);
				y1 = y1-q[i]*5;
				x+=50;
		}
		x = 50; y1 = 350;
		for(int i=0;i<10;i+=1){
			g.setColor(Color.blue);
			//g.fillRect(x,y1-p[i]*15, 15, p[i]*15);
		
			x = x+50;
		}
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.setColor(Color.BLUE);
		
		g.drawString("R", 20, 300);
		g.drawString("u", 20, 350);
		g.drawString("n", 20, 400);
		g.drawString("s", 20, 450);
		
		g.drawString("Overs",300, 550);

			
	}

}
