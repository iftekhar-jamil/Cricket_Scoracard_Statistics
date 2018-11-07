package Package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

public class TeamBatting {
	private double overalRunRate = 0.0;
	private double [] cumulativeRunRate;
	public int over,sum = 0;
	private Scanner sn;
	public int [] runsPerOver,cumulativeSum;
	private boolean token = false;
	private double overalRequiredRunRate;
	private double [] cumulativeRequiredRunRate;
	private int opponentTotal = 0;
	private int [] numberOfFours,numberOfSixes,numberOfwickets ;
	private String fileName;
	public TeamBatting(boolean token,String fileName){
		this.token = token;
		this.fileName = fileName;
		takeInputAndInitialize();
		calculateCumulativeRun();
	}
	

	public TeamBatting(boolean token,int runOfFirstTeam,String fileName){
		this.token = token;
		this.fileName = fileName;
		
		
		takeInputAndInitialize();
		calculateCumulativeRun();
		if(token == false){ 
			runOfFirstTeam = 0;
			opponentTotal = runOfFirstTeam;
		}	
		else{
			opponentTotal =  runOfFirstTeam;
		}
		
	}
	
	
	private void fileOpening(){
		try {
			 sn = new Scanner(new File(fileName));
			over = sn.nextInt();
			 runsPerOver = new int [over+1];
			 cumulativeSum = new int [over+1];
			 cumulativeRunRate = new double[over+1];
			 cumulativeRequiredRunRate = new double [over+1];
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void takeInputAndInitialize(){
		fileOpening();
		for(int i=1; i<=over; i++){
			runsPerOver[i] = sn.nextInt();
		}
	}
	
	public int calculateTotalRun(){
		
		for(int i=1; i<=over; i++){
			sum+=runsPerOver[i];
		}
		return sum;
	}
	
	
	public void calculateCumulativeRun(){
		
		for(int i = 1; i<=over; i++){
			cumulativeSum[i] = cumulativeSum[i-1]+runsPerOver[i];
			System.out.println(cumulativeSum[i]);
		}
	}
	
	public void calculateOveralRunRate(){
		
		overalRunRate = (double)sum/(double)over;
				
	}
	
	public void calculateCumulativeCurrentRunRate(){
		for(int i=1; i<=over; i++){
			cumulativeRunRate[i] = (double)cumulativeSum[i]/(double)i;
		}
	}
	
	public void calculateTotalRequiredRunRate(){
			if(token == false){
				System.out.println("Required method is applicable for the team batting at second");
				return;
			}
			
			else{
					overalRequiredRunRate = (double)opponentTotal/(double)over;
					System.out.println("The overal required runrate for team batting 2nd is"+overalRequiredRunRate);
			}
	}
	
	public void calculateCumulativeRequiredRunRate(){
		for(int i=1; i<=over; i++){
			cumulativeRequiredRunRate[i] = (double)(opponentTotal-cumulativeSum[i])/(double)i;
		}
	}
	
	public void calculateNumberOfFours(){
		
	}
	
	public void calculateNumberOfSixes(){
		
	}
	
	
}
