
package ui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.transactionsModel;
import system.MailSender;
import values.Values;


public class TenantProfile extends javax.swing.JFrame {
    
    transactionsModel trM= new transactionsModel();
    ResultSet rs = null;

    public TenantProfile() {
        initComponents();
        this.setSize(1286,755);        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        sep_find.setVisible(false);
        sep_print.setVisible(false);
        
    
    
    }
    
     public TenantProfile(HashMap<String,String> data,ImageIcon icon) {
        initComponents();
        this.setSize(1290,760);        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        loadData(data,icon);
        sep_find.setVisible(false);
        sep_print.setVisible(false);
        
    }
     
     private void loadData(HashMap<String,String> data,ImageIcon icon){
         
            if(!data.isEmpty()){
                lbl_photo.setIcon(icon);
                lbl_name.setText(data.get("name"));                
                lbl_nid.setText(data.get("nid"));
                lbl_age.setText(data.get("age"));
                lbl_gender.setText(data.get("gender"));
                lbl_religion.setText(data.get("religion"));
                lbl_nationality.setText(data.get("nationality"));
                lbl_member.setText(data.get("total_member"));
                lbl_profession.setText(data.get("profession"));
                lbl_gender.setText(data.get("gender"));
                lbl_startingMonth.setText(data.get("starting_month"));
                
                
                lbl_endingMonth.setText(data.get("ending_month"));
                
                if(lbl_endingMonth.getText().equals("null")){
                    lbl_endingMonth.setVisible(false);
                    lbl_to.setVisible(false);
                }
                else{
                    lbl_endingMonth.setVisible(true);
                    lbl_to.setVisible(true);
                }
                
                
                lbl_tMobile.setText("0"+data.get("mobile"));
                
                lbl_tEmail.setText(data.get("email"));
                lbl_tAddress.setText(data.get("permanant_address"));
                
                lbl_aptId.setText(data.get("apt_id"));
                lbl_status.setText(data.get("t_status"));
                if(lbl_status.getText().equals("ACTIVE")){
                    lbl_status.setIcon(new ImageIcon("src/res/icons_active.png"));
                    }
                else if(lbl_status.getText().equals("INACTIVE")){
                    lbl_status.setIcon(new ImageIcon("src/res/icons_Inactive.png"));
                }
                
                lbl_bName.setText(data.get("b_name"));
                lbl_aptName.setText(data.get("apt_name"));
                lbl_bLoc.setText(data.get("b_loc"));
                
                lbl_aptRent.setText(data.get("apt_rent"));
                lbl_totalPaidRent.setText(data.get("total_income"));
                
                rs = trM.VIEW_TXN_BY_NID(Long.parseLong(data.get("nid")));
                displayTxnHistory(rs);
                
   
                
            }   
            else{
            System.out.println("Rs is Null");
        }
  
     }
     
     
     public static void displayTxnHistory(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_txnHistory.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("tr_id"));
                    columData.add(rs.getDouble("tr_amount"));                    
                    columData.add(rs.getString("tr_datetime"));
                    columData.add(rs.getString("tr_purpose"));  
                    columData.add(rs.getString("rent_month"));
                    columData.add(rs.getString("tr_payment_method"));                    
        
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(TenantProfile.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendMailDlg = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_mailSubj = new javax.swing.JTextField();
        txt_toMail1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_bodyMail = new javax.swing.JTextArea();
        btn_send = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        rightSidebar = new javax.swing.JPanel();
        lbl_nid = new javax.swing.JLabel();
        TabbedPane = new javax.swing.JTabbedPane();
        tab_about = new javax.swing.JPanel();
        lbl_age = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_religion = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_nationality = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_member = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_aptRent = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_totalPaidRent = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_profession = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        tab_transactaionsHist = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_txnHistory = new javax.swing.JTable();
        lbl_name = new javax.swing.JLabel();
        lbl_to = new javax.swing.JLabel();
        lbl_endingMonth = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_startingMonth = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sep_print = new javax.swing.JSeparator();
        sep_find = new javax.swing.JSeparator();
        leftSidebar = new javax.swing.JPanel();
        lbl_photo = new javax.swing.JLabel();
        lbl_bLoc = new javax.swing.JLabel();
        lbl_aptId = new javax.swing.JLabel();
        lbl_bName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_tMobile = new javax.swing.JLabel();
        lbl_tEmail = new javax.swing.JLabel();
        lbl_tAddress = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lbl_aptName = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();

        sendMailDlg.setResizable(false);
        sendMailDlg.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Send Custom Email");
        jPanel1.add(jLabel3, java.awt.BorderLayout.CENTER);

        sendMailDlg.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_mailSubj.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_mailSubj.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Subject", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_mailSubj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mailSubjActionPerformed(evt);
            }
        });
        txt_mailSubj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mailSubjKeyTyped(evt);
            }
        });
        jPanel2.add(txt_mailSubj, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 710, 70));

        txt_toMail1.setEditable(false);
        txt_toMail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_toMail1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_toMail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_toMail1ActionPerformed(evt);
            }
        });
        txt_toMail1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_toMail1KeyTyped(evt);
            }
        });
        jPanel2.add(txt_toMail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 710, 70));

        txt_bodyMail.setColumns(20);
        txt_bodyMail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_bodyMail.setRows(5);
        txt_bodyMail.setBorder(null);
        jScrollPane2.setViewportView(txt_bodyMail);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 710, 130));

        btn_send.setBackground(new java.awt.Color(255, 0, 0));
        btn_send.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_send.setForeground(new java.awt.Color(255, 255, 255));
        btn_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon_email_send.png"))); // NOI18N
        btn_send.setText("SEND");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });
        jPanel2.add(btn_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 190, 50));

        sendMailDlg.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 780, 440));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(244, 244, 244));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rightSidebar.setBackground(new java.awt.Color(255, 255, 255));
        rightSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nid.setFont(new java.awt.Font("SansSerif", 2, 26)); // NOI18N
        lbl_nid.setForeground(new java.awt.Color(255, 102, 102));
        lbl_nid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon_copy.png"))); // NOI18N
        lbl_nid.setText("2015534634354635463");
        lbl_nid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_nid.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_nid.setIconTextGap(25);
        lbl_nid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nidMouseClicked(evt);
            }
        });
        rightSidebar.add(lbl_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 700, 50));

        TabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TabbedPane.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        tab_about.setBackground(new java.awt.Color(255, 255, 255));
        tab_about.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_age.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_age.setForeground(new java.awt.Color(102, 102, 102));
        lbl_age.setText("56");
        tab_about.add(lbl_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 240, 40));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Age:");
        tab_about.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 40));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Gender:");
        tab_about.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 40));

        lbl_gender.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_gender.setForeground(new java.awt.Color(102, 102, 102));
        lbl_gender.setText("Male");
        tab_about.add(lbl_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 240, 40));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Religion:");
        tab_about.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 40));

        lbl_religion.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_religion.setForeground(new java.awt.Color(102, 102, 102));
        lbl_religion.setText("Islam");
        tab_about.add(lbl_religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 240, 40));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Nationality:");
        tab_about.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 40));

        lbl_nationality.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_nationality.setForeground(new java.awt.Color(102, 102, 102));
        lbl_nationality.setText("Bangladeshi");
        tab_about.add(lbl_nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 240, 40));

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Family Member:");
        tab_about.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 180, 40));

        lbl_member.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_member.setForeground(new java.awt.Color(102, 102, 102));
        lbl_member.setText("5");
        tab_about.add(lbl_member, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 240, 40));

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Apartment Rent:");
        tab_about.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 180, 40));

        lbl_aptRent.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_aptRent.setForeground(new java.awt.Color(102, 102, 102));
        lbl_aptRent.setText("18500 Tk");
        tab_about.add(lbl_aptRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 180, 40));

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Total Rent Paid:");
        tab_about.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 180, 40));

        lbl_totalPaidRent.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_totalPaidRent.setForeground(new java.awt.Color(102, 102, 102));
        lbl_totalPaidRent.setText("7850000 Tk");
        tab_about.add(lbl_totalPaidRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 180, 40));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Profession:");
        tab_about.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 40));

        lbl_profession.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_profession.setForeground(new java.awt.Color(102, 102, 102));
        lbl_profession.setText("Business");
        tab_about.add(lbl_profession, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 240, 40));

        jSeparator6.setForeground(new java.awt.Color(255, 0, 0));
        tab_about.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 420, 10));

        TabbedPane.addTab("About", tab_about);

        tab_transactaionsHist.setBackground(new java.awt.Color(255, 255, 255));
        tab_transactaionsHist.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        tbl_txnHistory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_txnHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TXN ID", "Amount", "TXN Time", "Purpose", "Rent Month", "Payment Method"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_txnHistory.setRowHeight(50);
        tbl_txnHistory.setRowMargin(5);
        tbl_txnHistory.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_txnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_txnHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_txnHistory);
        if (tbl_txnHistory.getColumnModel().getColumnCount() > 0) {
            tbl_txnHistory.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        tab_transactaionsHist.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        TabbedPane.addTab("Transactions History", tab_transactaionsHist);

        rightSidebar.add(TabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 800, 420));

        lbl_name.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(51, 51, 51));
        lbl_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon_copy.png"))); // NOI18N
        lbl_name.setText("Md Shahin Shah Shahin");
        lbl_name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_name.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_name.setIconTextGap(20);
        lbl_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nameMouseClicked(evt);
            }
        });
        rightSidebar.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 740, 50));

        lbl_to.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_to.setForeground(new java.awt.Color(102, 102, 102));
        lbl_to.setText("To       ");
        rightSidebar.add(lbl_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 60, 30));

        lbl_endingMonth.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_endingMonth.setForeground(new java.awt.Color(102, 102, 102));
        lbl_endingMonth.setText("NOV-2022");
        rightSidebar.add(lbl_endingMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 210, 30));

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("From  ");
        rightSidebar.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 70, 30));

        lbl_startingMonth.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_startingMonth.setForeground(new java.awt.Color(102, 102, 102));
        lbl_startingMonth.setText("JUL-2022");
        rightSidebar.add(lbl_startingMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 140, 30));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/-printWhite-24x.png"))); // NOI18N
        jLabel1.setText("Print");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 4, 140, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search-24x.png"))); // NOI18N
        jLabel2.setText("Find Another");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 4, 170, 30));

        sep_print.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(sep_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 150, 10));

        sep_find.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(sep_find, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 10));

        rightSidebar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        jPanel4.add(rightSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 10, 860, 700));

        leftSidebar.setBackground(new java.awt.Color(255, 255, 255));
        leftSidebar.setPreferredSize(new java.awt.Dimension(400, 800));
        leftSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        leftSidebar.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 250, 250));

        lbl_bLoc.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_bLoc.setForeground(new java.awt.Color(102, 102, 102));
        lbl_bLoc.setText("South Khulshi Road 1");
        leftSidebar.add(lbl_bLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 360, 40));

        lbl_aptId.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_aptId.setForeground(new java.awt.Color(102, 102, 102));
        lbl_aptId.setText(" 206 ");
        leftSidebar.add(lbl_aptId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 70, 40));

        lbl_bName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_bName.setForeground(new java.awt.Color(102, 102, 102));
        lbl_bName.setText("Touch Masumas Mirror");
        leftSidebar.add(lbl_bName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 340, 40));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Rented Apartment");
        leftSidebar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 20));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Contact");
        leftSidebar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 80, 20));

        jSeparator3.setForeground(new java.awt.Color(255, 0, 0));
        leftSidebar.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 250, 10));

        lbl_tMobile.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_tMobile.setForeground(new java.awt.Color(102, 102, 102));
        lbl_tMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon-phone.png"))); // NOI18N
        lbl_tMobile.setText("01794302620");
        lbl_tMobile.setIconTextGap(10);
        leftSidebar.add(lbl_tMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 350, 40));

        lbl_tEmail.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_tEmail.setForeground(new java.awt.Color(102, 102, 102));
        lbl_tEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon-email.png"))); // NOI18N
        lbl_tEmail.setText("shahinshah2620@gmail.com");
        lbl_tEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_tEmail.setIconTextGap(10);
        lbl_tEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tEmailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_tEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_tEmailMouseExited(evt);
            }
        });
        leftSidebar.add(lbl_tEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 370, 40));

        lbl_tAddress.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbl_tAddress.setForeground(new java.awt.Color(102, 102, 102));
        lbl_tAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons-location.png"))); // NOI18N
        lbl_tAddress.setText("18 Majirghat Road, Madarbari, Chittagong");
        lbl_tAddress.setIconTextGap(10);
        leftSidebar.add(lbl_tAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 370, 40));

        jSeparator4.setForeground(new java.awt.Color(255, 0, 0));
        leftSidebar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 190, 10));

        lbl_aptName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_aptName.setForeground(new java.awt.Color(102, 102, 102));
        lbl_aptName.setText("C5");
        leftSidebar.add(lbl_aptName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 270, 40));

        lbl_status.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbl_status.setForeground(new java.awt.Color(51, 51, 51));
        lbl_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons_active.png"))); // NOI18N
        lbl_status.setText("Active");
        lbl_status.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leftSidebar.add(lbl_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 250, 40));

        jPanel4.add(leftSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 700));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nameMouseClicked
        
            String myString = lbl_name.getText();
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_lbl_nameMouseClicked

    private void lbl_nidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nidMouseClicked
        String myString = lbl_nid.getText();
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_lbl_nidMouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        sep_find.setVisible(true);
        
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
       sep_find.setVisible(false);
        
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        
        sep_print.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        
        sep_print.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        new TenantSelect().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tbl_txnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_txnHistoryMouseClicked

    }//GEN-LAST:event_tbl_txnHistoryMouseClicked

    private void txt_mailSubjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mailSubjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mailSubjActionPerformed

    private void txt_mailSubjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailSubjKeyTyped
        
    }//GEN-LAST:event_txt_mailSubjKeyTyped

    private void txt_toMail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_toMail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_toMail1ActionPerformed

    private void txt_toMail1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_toMail1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_toMail1KeyTyped

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        if(txt_mailSubj.getText().length()!=0 && txt_bodyMail.getText().length()!=0 && txt_toMail1.getText().length()!=0){
            try {
                
                MailSender.sendCustomeMail(txt_toMail1.getText(), txt_mailSubj.getText(), txt_bodyMail.getText());
                JOptionPane.showMessageDialog(this, "Email has been Sent!");
                sendMailDlg.dispose();
            
            } catch (MessagingException ex) {
                Logger.getLogger(TenantProfile.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Failed to Send Email!");
            }
        }
        else{
        JOptionPane.showMessageDialog(this, "Insufficient Data for Sending Email!");
    }
        
    }//GEN-LAST:event_btn_sendActionPerformed

    private void lbl_tEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tEmailMouseClicked
       sendMailDlg.setVisible(true);
       sendMailDlg.setSize(776, 520);
       
        
        
       
       
       sendMailDlg.setLocationRelativeTo(this);
       txt_toMail1.setText(lbl_tEmail.getText());
       
    }//GEN-LAST:event_lbl_tEmailMouseClicked

    private void lbl_tEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tEmailMouseEntered
        lbl_tEmail.setForeground(Color.blue);
    }//GEN-LAST:event_lbl_tEmailMouseEntered

    private void lbl_tEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tEmailMouseExited
       //776, 508
       lbl_tEmail.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_lbl_tEmailMouseExited

    
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TenantProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton btn_send;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    public javax.swing.JLabel lbl_age;
    public javax.swing.JLabel lbl_aptId;
    public javax.swing.JLabel lbl_aptName;
    public javax.swing.JLabel lbl_aptRent;
    public javax.swing.JLabel lbl_bLoc;
    public javax.swing.JLabel lbl_bName;
    public javax.swing.JLabel lbl_endingMonth;
    public javax.swing.JLabel lbl_gender;
    public javax.swing.JLabel lbl_member;
    public javax.swing.JLabel lbl_name;
    public javax.swing.JLabel lbl_nationality;
    public javax.swing.JLabel lbl_nid;
    public static javax.swing.JLabel lbl_photo;
    public javax.swing.JLabel lbl_profession;
    public javax.swing.JLabel lbl_religion;
    public javax.swing.JLabel lbl_startingMonth;
    public javax.swing.JLabel lbl_status;
    public javax.swing.JLabel lbl_tAddress;
    public javax.swing.JLabel lbl_tEmail;
    public javax.swing.JLabel lbl_tMobile;
    public javax.swing.JLabel lbl_to;
    public javax.swing.JLabel lbl_totalPaidRent;
    private javax.swing.JPanel leftSidebar;
    private javax.swing.JPanel rightSidebar;
    private javax.swing.JDialog sendMailDlg;
    private javax.swing.JSeparator sep_find;
    private javax.swing.JSeparator sep_print;
    private javax.swing.JPanel tab_about;
    private javax.swing.JPanel tab_transactaionsHist;
    private static javax.swing.JTable tbl_txnHistory;
    private javax.swing.JTextArea txt_bodyMail;
    private javax.swing.JTextField txt_mailSubj;
    private javax.swing.JTextField txt_toMail1;
    // End of variables declaration//GEN-END:variables
}
