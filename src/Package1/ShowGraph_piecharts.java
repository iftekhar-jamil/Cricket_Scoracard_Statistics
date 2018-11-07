package Package1;
												//jamil, tui mara kha taratari :) 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class ShowGraph_piecharts extends ApplicationFrame 
{
	public static double [] contribution;
   public ShowGraph_piecharts(String title,double[] contribution) 
   {
	   super( title );
	   //ShowGraph demo = new ShowGraph( "Individual Contribution",contribution );
       this.contribution = contribution;
       setContentPane(createDemoPanel( ));
       setSize( 560 , 367 );    
      //RefineryUtilities.centerFrameOnScreen();    
       setVisible( true );
       
       //JFrame f =   new JFrame();
       //f.setContentPane(createDemoPanel());
       //f.setVisible(true);
      
   }
   private static PieDataset createDataset( ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      //int i=1;
      double sum = 0;
      for(int i=1; i<contribution.length; i++){
      dataset.setValue( "Batsman  "+String.valueOf(i) , new Double( contribution[i] ) );  
      	sum+=contribution[i];
      }
      // dataset.setValue( "B" , new Double( contribution[i++] ) );   
     // dataset.setValue( "C" , new Double( contribution[i++] ) );    
      //dataset.setValue( "D" , new Double( contribution[i++] ) );
      dataset.setValue( "Extra" , new Double( 100-sum ) );
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Individual contributon(in percentage)",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);
      
      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      ChartPanel c =  new ChartPanel( chart );
      return c; 
   }
  /* public static void main( String[ ] args )
   {
        
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }*/
}