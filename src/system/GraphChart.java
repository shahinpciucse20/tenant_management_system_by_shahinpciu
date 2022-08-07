
package system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class GraphChart {
    
    
    
    
    
    
    public static void showPieChart(JPanel panel,String title,HashMap<String,Double> dataMap,ArrayList<Color> colors){
        
      //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
      for(Map.Entry<String,Double> item : dataMap.entrySet()){
          
         barDataset.setValue(item.getKey(), item.getValue());          
      }
      

      //create chart
       //JFreeChart piechart = ChartFactory.createPieChart(title,barDataset, false,true,false);//explain
       JFreeChart piechart = ChartFactory.createPieChart3D(title,barDataset);
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       int i=0;
       for(Map.Entry<String,Double> item : dataMap.entrySet()){
           piePlot.setSectionPaint(item.getKey(),colors.get(i));
           i++;
       }
       
 
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panel.removeAll();
        panel.add(barChartPanel, BorderLayout.CENTER);
        panel.validate();
    }
    
    
    
    public static void showBarChart(JPanel panel,String title,String leftTitle, String botTitle,HashMap<String,Double> dataMap,Color barColor){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        
        for(Map.Entry<String,Double> item : dataMap.entrySet()){
          
         dataset.setValue(item.getValue(),leftTitle,item.getKey());          
      }
        
        //dataset.setValue(200, "Amount", "january");
        
        
        JFreeChart chart = ChartFactory.createBarChart(title,botTitle,leftTitle, 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        
        renderer.setSeriesPaint(0, barColor);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        panel.removeAll();
        panel.add(barpChartPanel, BorderLayout.CENTER);
        panel.validate();
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
