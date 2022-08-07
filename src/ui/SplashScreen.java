
package ui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import values.Values;


public class SplashScreen extends javax.swing.JFrame {
    
    private int loadingSpeed = 60;
    private HomePage homePage;
    
       
    public SplashScreen() {
        initComponents(); 
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Action();
            }
        });
        t1.start();
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                homePage = new HomePage();
                System.out.println("HomePage Initialized!");
            }
        });
        t2.start();
        
        

    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bottom = new javax.swing.JPanel();
        progressbar = new javax.swing.JProgressBar();
        txt_title = new javax.swing.JLabel();
        percent = new javax.swing.JLabel();
        top = new javax.swing.JPanel();
        lbl_gif = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
        jPanel1.setLayout(new java.awt.BorderLayout());

        bottom.setBackground(new java.awt.Color(255, 0, 0));
        bottom.setPreferredSize(new java.awt.Dimension(900, 50));
        bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressbar.setForeground(new java.awt.Color(0, 204, 0));
        bottom.add(progressbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 920, 30));

        txt_title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_title.setForeground(new java.awt.Color(255, 255, 255));
        txt_title.setText("Loading...");
        bottom.add(txt_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 260, 20));

        percent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        percent.setForeground(new java.awt.Color(255, 255, 255));
        percent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        percent.setText("0%");
        bottom.add(percent, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 70, 30));

        jPanel1.add(bottom, java.awt.BorderLayout.PAGE_END);

        top.setBackground(new java.awt.Color(255, 255, 255));
        top.setForeground(new java.awt.Color(51, 51, 51));
        top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_gif.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/loading3.gif"))); // NOI18N
        lbl_gif.setMaximumSize(new java.awt.Dimension(500, 500));
        lbl_gif.setMinimumSize(new java.awt.Dimension(500, 500));
        lbl_gif.setPreferredSize(new java.awt.Dimension(500, 500));
        top.add(lbl_gif, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 240, 220));

        jLabel1.setFont(new java.awt.Font("MingLiU-ExtB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO");
        top.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 870, 70));

        jLabel2.setFont(new java.awt.Font("MingLiU-ExtB", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Designed & Developed by Md Shahin Shah");
        top.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 870, 70));

        jLabel3.setFont(new java.awt.Font("MingLiU-ExtB", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tenant Management System");
        top.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 870, 70));

        jPanel1.add(top, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private static boolean netIsAvailable() {
        try {
        final URL url = new URL("http://www.google.com");
        final URLConnection conn = url.openConnection();
        conn.connect();
        conn.getInputStream().close();
        return true;
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        return false;
    }
}
    
    
    
    
    public void Action(){
        
        for(int i=0; i<=100; i++)
        {
            try {
                Thread.sleep(loadingSpeed);
                percent.setText(i+"%");
                if(i==10)
                    txt_title.setText("Turning On Modules....");
                
                if(i==30)
                    txt_title.setText("Loading Modules....");
                
                if(i==50){
                    txt_title.setText("Connecting Database....");  
                    
                }
                
                if(i==70)
                    txt_title.setText("Loading UI....");   
                    
                if(i==90)
                    txt_title.setText("Starting Application....");
                
                
                progressbar.setValue(i);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        this.dispose();
        homePage.setVisible(true);
        
        
        
    }
   
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_gif;
    private static javax.swing.JLabel percent;
    private static javax.swing.JProgressBar progressbar;
    private javax.swing.JPanel top;
    private static javax.swing.JLabel txt_title;
    // End of variables declaration//GEN-END:variables
}
