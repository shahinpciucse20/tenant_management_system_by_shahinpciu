
package ui;

public class TransactionPage extends javax.swing.JFrame {

   
    public TransactionPage() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        button0 = new javax.swing.JPanel();
        btn_rcvrent = new javax.swing.JButton();
        button3 = new javax.swing.JPanel();
        btn_createbill = new javax.swing.JButton();
        button4 = new javax.swing.JPanel();
        btn_viewtransaction = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(450, 350));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 350));

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(700, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        body.setForeground(new java.awt.Color(255, 255, 255));
        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.Y_AXIS));

        button0.setBackground(new java.awt.Color(255, 255, 255));
        button0.setPreferredSize(new java.awt.Dimension(600, 100));

        btn_rcvrent.setBackground(new java.awt.Color(204, 204, 204));
        btn_rcvrent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_rcvrent.setForeground(new java.awt.Color(51, 51, 51));
        btn_rcvrent.setText("Recieve Rent");
        btn_rcvrent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_rcvrent.setBorderPainted(false);
        btn_rcvrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rcvrentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button0Layout = new javax.swing.GroupLayout(button0);
        button0.setLayout(button0Layout);
        button0Layout.setHorizontalGroup(
            button0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_rcvrent, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );
        button0Layout.setVerticalGroup(
            button0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button0Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_rcvrent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        body.add(button0);

        button3.setBackground(new java.awt.Color(255, 255, 255));
        button3.setPreferredSize(new java.awt.Dimension(600, 100));

        btn_createbill.setBackground(new java.awt.Color(204, 204, 204));
        btn_createbill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_createbill.setForeground(new java.awt.Color(51, 51, 51));
        btn_createbill.setText("Create Bill");
        btn_createbill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_createbill.setBorderPainted(false);
        btn_createbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createbillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button3Layout = new javax.swing.GroupLayout(button3);
        button3.setLayout(button3Layout);
        button3Layout.setHorizontalGroup(
            button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_createbill, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );
        button3Layout.setVerticalGroup(
            button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_createbill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        body.add(button3);

        button4.setBackground(new java.awt.Color(255, 255, 255));
        button4.setPreferredSize(new java.awt.Dimension(600, 100));

        btn_viewtransaction.setBackground(new java.awt.Color(204, 204, 204));
        btn_viewtransaction.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_viewtransaction.setForeground(new java.awt.Color(51, 51, 51));
        btn_viewtransaction.setText("View All Transaction");
        btn_viewtransaction.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_viewtransaction.setBorderPainted(false);
        btn_viewtransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewtransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button4Layout = new javax.swing.GroupLayout(button4);
        button4.setLayout(button4Layout);
        button4Layout.setHorizontalGroup(
            button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_viewtransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );
        button4Layout.setVerticalGroup(
            button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_viewtransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        body.add(button4);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createbillActionPerformed
        this.dispose();
        new CreateBillPage().setVisible(true);
    }//GEN-LAST:event_btn_createbillActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btn_rcvrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rcvrentActionPerformed
    this.dispose();
    new RcvRentPage().setVisible(true);
        
    }//GEN-LAST:event_btn_rcvrentActionPerformed

    private void btn_viewtransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewtransactionActionPerformed
              
    }//GEN-LAST:event_btn_viewtransactionActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               TransactionPage ap =  new TransactionPage();                            
               ap.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_createbill;
    private javax.swing.JButton btn_rcvrent;
    private javax.swing.JButton btn_viewtransaction;
    private javax.swing.JPanel button0;
    private javax.swing.JPanel button3;
    private javax.swing.JPanel button4;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
