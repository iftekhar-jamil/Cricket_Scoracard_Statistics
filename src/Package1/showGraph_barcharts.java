package Package1;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class showGraph_barcharts extends ApplicationFrame
{
	private int [] runs;
   public showGraph_barcharts( String applicationTitle , String chartTitle,int [] runs )
   {
      super( applicationTitle );        
      this.runs = runs;
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Overs",            
         "Runs",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 500 , 500 ) );        
      setContentPane( chartPanel );
      //showGraph_barcharts chart = new showGraph_barcharts("Car Usage Statistics", "Which car do you like?");
      pack( );
 
      //RefineryUtilities.centerFrameOnScreen( chart );        
      setDefaultCloseOperation(EXIT_ON_CLOSE); 
      //new Options();
      setVisible( true );
      
   }
   private CategoryDataset createDataset( )
   {
      final String Team_A = "Team A";        
      final String Team_B = "Team B";        
      final String Total_Runs_B = "Team B";        
      final String totalRuns_A = "Team A";        
           
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  
      
	for(int i=1; i<=10; i++){ 
		if(i<3)
			dataset.addValue(runs[i],"a",toString().valueOf(i));
		else
			dataset.addValue(runs[i],"b",toString().valueOf(i));

	}	
      return dataset; 
   }
   
}