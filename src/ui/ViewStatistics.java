package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Statistics;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import system.GraphChart;
import system.Time;
import values.Values;

public class ViewStatistics extends javax.swing.JFrame { 
    
    private ResultSet rs = null;
    private String imagePath = null;
    private tenantModel Ten = null;
    private Statistics statModel = null;
    
    
  
    public ViewStatistics() {
        initComponents();      
        statModel = new Statistics();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
                
        setResponsiveSize();     
        
        loadIncVsExpPiChartByMonth(Time.getCurMonth());
        loadBarChart();
  
        loadIncPiChartByApt();
        loadRecentTrTable();
        
    }
    
    
    private void loadIncVsExpPiChartByMonth(String month){
        
        HashMap<String,Double> dbData = new HashMap<String,Double>();
        ArrayList<Color> colors = new ArrayList<Color>();
        
        double income = statModel.getTotalIncomeInMonth(Time.getCurMonthYear());
        double expense = statModel.getTotalExpenseInMonth(Time.getCurMonthYear());
        
        //Pi data
        dbData.put("Income ("+income+")", income);
        dbData.put("Expense ("+expense+")", expense);
        
        //Pi colors
        colors.add(new Color(200,0,0));
        colors.add(new Color(0,128,255));
        
        GraphChart.showPieChart(pichartL, "Income Vs Expense In ("+month+")", dbData, colors);
        
   
    }
    
    
     private void loadIncPiChartByApt(){
        
        HashMap<String,Double> dbData = new HashMap<String,Double>();
        ArrayList<Color> colors = new ArrayList<Color>();
        
        
        rs = statModel.getIncomeGroupByAptId();
        
       int r = 0, g= 102, b=100;
       
        try {
            while(rs.next()){
                
                dbData.put("APT: "+rs.getString("apt_id"), rs.getDouble("amount"));
                colors.add(new Color(r,g,b));
                r = r+20;
                g= g+50;
                b = b+50;      
                
                if(r>255){
                    r = 50;
                }
                if(g>255){
                    g = 70;
                }
                if(b>255){
                    b = 80;
                }
                
   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
        //Pi colors
        
        
        GraphChart.showPieChart(pichartBottom, "Total Income By Apartments", dbData, colors);
   
    }
    
    
      private void loadBarChart(){
        
        HashMap<String,Double> dbData = new HashMap<String,Double>();
        
        rs = statModel.getIncomeGroupByMonths();
        
        try {
            while(rs.next()){
                
                dbData.put(rs.getString("rent_month"), rs.getDouble("amount"));
   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
        
        
        GraphChart.showBarChart(barchart, "Monthy Income", "Rent", "Month", dbData, new Color(255,0,0));
        
        
    }
      
      
    private void loadRecentTrTable(){
        rs = statModel.getRecentTXN();
        
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_recentTr.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("tr_id"));
                    columData.add(rs.getString("tr_type"));  
                    columData.add(rs.getDouble("tr_amount"));
                    columData.add(rs.getString("tr_purpose"));
                    
       
                }
                recordTable.addRow(columData);
            } 
              
            }
        
        catch (SQLException ex){
            
        }
    }
    
    
    
    
   

    
    private void setResponsiveSize()
    {
        Dimension screensize = Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension maxSize = new Dimension(screensize.width,screensize.height-50);
        Dimension minSize = new Dimension(screensize.width-500,screensize.height-300);     
        this.setMaximumSize(maxSize);
        this.setMinimumSize(minSize);
        
        this.setSize(maxSize);
    }
    

    
    
    
    

  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        pichartL = new javax.swing.JPanel();
        barchart = new javax.swing.JPanel();
        pichartBottom = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_recentTr = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Home - TMS"); // NOI18N

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(1280, 60));

        heading.setBackground(new java.awt.Color(0, 0, 0));
        heading.setPreferredSize(new java.awt.Dimension(963, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Statistics");

        javax.swing.GroupLayout headingLayout = new javax.swing.GroupLayout(heading);
        heading.setLayout(headingLayout);
        headingLayout.setHorizontalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headingLayout.setVerticalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2118, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                    .addContainerGap(431, Short.MAX_VALUE)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(431, Short.MAX_VALUE)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.GridLayout(2, 3, 50, 50));

        pichartL.setLayout(new java.awt.BorderLayout());
        body.add(pichartL);

        barchart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        barchart.setLayout(new java.awt.BorderLayout());
        body.add(barchart);

        pichartBottom.setLayout(new java.awt.BorderLayout());
        body.add(pichartBottom);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        tbl_recentTr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_recentTr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TXN ID", "TXN Type", "TXN Amount", "TXN Purpose"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_recentTr.setRowHeight(30);
        tbl_recentTr.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_recentTr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_recentTrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_recentTr);
        if (tbl_recentTr.getColumnModel().getColumnCount() > 0) {
            tbl_recentTr.getColumnModel().getColumn(0).setMinWidth(140);
            tbl_recentTr.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Most Recent Transactions");
        jLabel1.setPreferredSize(new java.awt.Dimension(307, 59));
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        body.add(jPanel4);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(2118, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2118, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_recentTrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_recentTrMouseClicked

    }//GEN-LAST:event_tbl_recentTrMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new ViewStatistics().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barchart;
    private javax.swing.JPanel body;
    private javax.swing.JPanel header;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pichartBottom;
    private javax.swing.JPanel pichartL;
    private static javax.swing.JTable tbl_recentTr;
    // End of variables declaration//GEN-END:variables
}
