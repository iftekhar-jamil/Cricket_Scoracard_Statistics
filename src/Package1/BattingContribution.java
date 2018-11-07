package Package1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BattingContribution {
	JFrame frame;
	private Scanner sn;
	private TeamBatting team1,team2 ;
	private int wicket;
	private double [] contribution = new double [11];
	private int [] scoredRun = new int [11];
	private String batsManInfoFile;
	public BattingContribution(final TeamBatting team,String BatsmanInfo,final int a){
		this.team1 = team;
		batsManInfoFile = BatsmanInfo;
		takeInputAndInitialize();
		calculateBattingContribution();
		JFrame f1 = new JFrame();
		JButton bb1 = new JButton("Individual Contribution");
		JButton bb2 = new JButton("Runrate Scenario");
		f1.setLayout(new FlowLayout());
		f1.setSize(500,300);
		f1.add(bb1);
		f1.add(bb2);
	
		f1.setVisible(true);
	
		bb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ShowGraph_piecharts("Individual Contribution", contribution);
			}
		});
		
		bb2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//showGraph_barcharts chart = new showGraph_barcharts("Batting Statistics", "Over to Over progress",team.runsPerOver);
				int [] p = {0,0,0,0,0,0,0,0,0,0};
				new ShowBarGraph(a,p);
				
			}
		});
		
		//new showGraph_XY("Browser Usage Statistics", "Which Browser are you using?");
	     
	}
	
	public BattingContribution(TeamBatting team1,TeamBatting team2){
		this.team1 = team1;
		this.team2 = team2;
		//new showGraph_XY("Total Run comparison", "Total Run comparison",team1.cumulativeSum,team2.cumulativeSum);
		Manual_XY mXy =new Manual_XY(team1.cumulativeSum, team2.cumulativeSum);
		JFrame f = new JFrame("Run Comparison");
	    f.setSize(600, 600);
		f.add(mXy);
		f.setVisible(true);
	    
	}
	
	private void fileOpening(){
			try {
			 sn = new Scanner(new File(batsManInfoFile));
			 wicket = sn.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void takeInputAndInitialize(){
		fileOpening();
		int number;
		for(int i=1; i<=wicket; i++){
			number = sn.nextInt();
			scoredRun[number] = sn.nextInt();
		}
	}
	
	public void calculateBattingContribution(){
		int temp=0,total = team1.calculateTotalRun();
		for(int i=1; i<=wicket; i++){
			contribution[i] = (scoredRun[i]*100)/total;
			temp+=contribution[i];
			System.out.println(i+ "  "+ contribution[i]+"%");
			
		}
		
		System.out.println("Extras "+ (100-temp)+ "%");
	}
	
	
}
