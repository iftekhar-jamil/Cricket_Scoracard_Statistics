package Package1;

import java.awt.Color; 
import java.awt.BasicStroke; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class showGraph_XY extends ApplicationFrame 
{
	int [] arr1,arr2;
   public showGraph_XY( String applicationTitle, String chartTitle,int [] arr1,int [] arr2 )
   {
      super(applicationTitle);
      this.arr1 = arr1;
      this.arr2 = arr2; 
      
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Overs" ,
         "Runs" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.GREEN );
      renderer.setSeriesPaint( 2 , Color.YELLOW );
      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel );
      pack( );          
      //RefineryUtilities.centerFrameOnScreen( chart );          
     setVisible( true ); 
   }
   
   private XYDataset createDataset( )
   {
      final XYSeries team1 = new XYSeries( "Team A" );
      for(int i = 1; i<arr1.length; i++)
    	  team1.add((double)i,(double)arr1[i]);
     /* team1.add( 1.0 , 1.0 );          
      team1.add( 2.0 , 4.0 );          
      team1.add( 3.0 , 3.0 ); */          
      final XYSeries team2 = new XYSeries( "Team B" );          
      for(int i = 1; i<arr1.length; i++)
    	  team2.add((double)i,(double)arr2[i]);
      /*team2.add( 1.0 , 4.0 );          
      team2.add( 2.0 , 5.0 );          
      team2.add( 3.0 , 6.0 );*/          
      /*final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
      iexplorer.add( 3.0 , 4.0 );          
      iexplorer.add( 4.0 , 5.0 );          
      iexplorer.add( 5.0 , 4.0 ); */         
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( team1 );          
      dataset.addSeries( team2 );          
      
      return dataset;
   }

   /*public static void main( String[ ] args ) 
   {
      showGraph_XY chart = new showGraph_XY("Browser Usage Statistics", "Which Browser are you using?");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }*/
}
