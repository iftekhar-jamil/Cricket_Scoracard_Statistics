package Package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.util.ArrayUtils;

import sun.reflect.generics.tree.IntSignature;

public class Manual_barchart extends JPanel {

	int x;
	int ax[] = { 300, 400, 480, 500, 480, 400, 300, 200, 120, 100, 120, 200 };
	int ay[] = { 100, 130, 210, 300, 390, 470, 500, 470, 390, 300, 210, 130 };
	Integer[] p;
	int q[], over;
	int [] m = new int [10];
	public Manual_barchart(int t,int [] x) {
		//m = x;
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		try {

			if(t==1)
			fr = new FileReader("team1_bat.txt");
			else 
			fr = new FileReader("team2_bat.txt");
			
			
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(fr);
			boolean isFound = false;
			int l = 0;
			sCurrentLine = br.readLine();
			while ((sCurrentLine = br.readLine()) != null) {

				System.out.println(sCurrentLine);
				String [] b = sCurrentLine.split(" ");
				int a = Integer.parseInt(b[1]);
				arr1.add(a);
				System.out.println(b.length);
				m[l++] = Integer.parseInt(b[2]);

			}
			
			p = arr1.toArray(new Integer[arr1.size()]);

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
		for (int i = 0; i <= 600; i += 10) {
			g.setColor(Color.GREEN);
			g.drawLine(0, i, 600, i);
		}
		for (int i = 0; i <= 600; i += 50) {
			g.setColor(Color.RED);
			g.drawLine(0, i, 600, i);
			g.drawString("" + (45-i/10), 0, i);
		}
		for (int i = 0; i <= 600; i += 10) {
			g.setColor(Color.GREEN);
			g.drawLine(i, 0, i, 600);
		}
		for (int i = 0; i <= 600; i += 50) {
			g.setColor(Color.RED);
			g.drawLine(i, 0, i, 600);
			g.drawString("" + i/50, i, 480);
		}
		int x = 50, y1 = 200, y2 = 450;
		/*
		 * for(int i=0; i<10; i++){ g.drawLine(x, y1, x+50, y1-p[i]*5); y1 =
		 * y1-p[i]*5; x+=50;
		 * 
		 * } x =50; y1 = 450; y2 = 450; for(int i=0; i<10; i++){
		 * 
		 * g.drawLine(x, y2, x+50, y2-q[i]*5); y2 = y2-q[i]*5; x+=50; }
		 */
		scoreInput ss = new scoreInput();
		x = 50;
		y1 = 450;
		int px = x;
		for (int i = 0; i < 10; i += 1) {
			g.setColor(Color.blue);
			g.fillRect(x, y1 - p[i] * 10, 20, p[i] * 10);
			System.out.println(m[i]+".............");
			g.setColor(Color.RED);
			for(int j=0; j<m[i]; j++){
				g.fillOval(px, y1-p[i]*10-15*(j+1), 15, 15);
				
			}
			g.setColor(Color.blue);
			
			x = x + 50;
			px+=50;
		}

		
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.setColor(Color.BLUE);
		
		g.drawString("R", 20, 300);
		g.drawString("u", 20, 350);
		g.drawString("n", 20, 400);
		g.drawString("s", 20, 450);
		
		g.drawString("Overs",300, 550);
		// g.setColor(Color.BLUE);
		// g.drawLine(300, 300, ax[x],ay[x]);
	}

	public void traverseArray() {
		if (x == 12) {

		}
	}
}
