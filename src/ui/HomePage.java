package ui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import model.transactionsModel;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.DBConnector;
import model.DueModel;
import model.UserInfo;
import values.Values;
import system.Time;

public class HomePage extends javax.swing.JFrame {
    
     private static DueModel dueModel= null;
     

    public HomePage() {
        initComponents();
        this.setTitle(Values.APP_NAME+"-"+Values.APP_CREDIT);        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        
        btn_hideMenu.setText("<");

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension maxSize = new Dimension(screensize.width, screensize.height - 50);
        //Dimension minSize = new Dimension(maxSize.width - 300, maxSize.height - 150);
        Dimension minSize = new Dimension(maxSize.width - 350, maxSize.height - 200);

        this.setMinimumSize(minSize);
        this.setMaximumSize(maxSize);
        this.setPreferredSize(screensize);
        
        setIcon();   
        
           Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dueModel= new DueModel();
                setDashboardLabel();

            }
        });
        
        t1.start();

        
    }
    
    private void setIcon()
    {
            
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));        
    }

    public static void setDashboardLabel() {
        buildingModel B = new buildingModel();
        apartmentModel A = new apartmentModel();
        tenantModel Ten = new tenantModel();
        dueModel= new DueModel();       
        
        transactionsModel Tr = new transactionsModel();
        
        
        lbl_totalbuilding.setText(String.valueOf(B.GET_NUM_OF_BUILDING()));
        lbl_totalapartment.setText(String.valueOf(A.GET_NUM_OF_APARTMENT()));
        lbl_emptyapartment.setText(String.valueOf(A.GET_NUM_OF_AVAILABLE_APT()));
        lbl_totaltenant.setText(String.valueOf(Ten.GET_NUM_OF_ACTIVE_TENANT()));
        lbl_totalsecuritydeposit.setText(String.valueOf(Ten.GET_SUM_OF_SECURITY_DEPOSIT()));
        lbl_due.setText(String.valueOf(Tr.GET_TOTAL_RENT()));
        lbl_totalexpenses.setText(String.valueOf(Tr.GET_TOTAL_EXPENSE()));
        txt_rentDueInMonth.setText("Due Rent in "+ getCurrentMonth());
        
        txt_currDate.setText("   "+getCurrentDate());
        lbl_due.setText(String.valueOf(dueModel.getTotalDueAmount()));
        
        txt_totalIncome.setText("Income in "+ getCurrentMonth());
        lbl_totalincome.setText(String.valueOf(Tr.getTotalIncomeAmountByMonth(Time.getCurMonthYear())));
        
        lbl_rentDueMonth.setText(String.valueOf(dueModel.getTotalDueByMonth(getCurrentMonthYear())));
        
        lbl_expenes.setText("Expense in "+ getCurrentMonth());
        lbl_totalexpenses.setText(String.valueOf(Tr.getTotalExpenseByMonth(getCurrentMonthYear())));
        
    }
    
    
    static String getCurrentDate()
    {
        return Time.getCurDayMonthYear();
    }
    
    static String getCurrentMonth()
    {
        return Time.getCurMonth();
    }
    static String getCurrentMonthYear()
    {
        return Time.getCurMonthYear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg_addnewP = new javax.swing.JDialog();
        body1 = new javax.swing.JPanel();
        inbody = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        btn_addb = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        btn_adda = new javax.swing.JButton();
        dlg_manageP = new javax.swing.JDialog();
        body2 = new javax.swing.JPanel();
        btn_addb1 = new javax.swing.JButton();
        btn_addb2 = new javax.swing.JButton();
        btn_editBuilding = new javax.swing.JButton();
        btn_editApartment = new javax.swing.JButton();
        dlg_manageT = new javax.swing.JDialog();
        body3 = new javax.swing.JPanel();
        btn_tenantProfile = new javax.swing.JButton();
        btn_viewTenant = new javax.swing.JButton();
        btn_editTenant = new javax.swing.JButton();
        btn_tenantLeave = new javax.swing.JButton();
        dlg_createTr = new javax.swing.JDialog();
        body4 = new javax.swing.JPanel();
        btn_rcvDue = new javax.swing.JButton();
        btn_rcvRent = new javax.swing.JButton();
        btn_createBill = new javax.swing.JButton();
        dlg_ViewTr = new javax.swing.JDialog();
        body5 = new javax.swing.JPanel();
        btn_rcvDue1 = new javax.swing.JButton();
        btn_rcvRent1 = new javax.swing.JButton();
        btn_createBill1 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        txt_currDate = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        LOGOUT_PANEL = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        leftmenu = new javax.swing.JPanel();
        left_item_01 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        btn_addnew = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        btn_update = new javax.swing.JButton();
        left_item_2 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        btn_addTenant = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        btn_manageTenant = new javax.swing.JButton();
        left_item_3 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        btn_createTransaction = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        btn_view3 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        btn_view6 = new javax.swing.JButton();
        left_item_5 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        btn_view4 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        btn_view5 = new javax.swing.JButton();
        mainbody = new javax.swing.JPanel();
        borderbg = new javax.swing.JPanel();
        dashboard_panel = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        btn_hideMenu = new javax.swing.JButton();
        container1 = new javax.swing.JPanel();
        topbox = new javax.swing.JPanel();
        b01 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_totalbuilding = new javax.swing.JLabel();
        b02 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbl_totalapartment = new javax.swing.JLabel();
        b03 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_emptyapartment = new javax.swing.JLabel();
        middlebox = new javax.swing.JPanel();
        b2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_totaltenant = new javax.swing.JLabel();
        b3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txt_rentDueInMonth = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lbl_rentDueMonth = new javax.swing.JLabel();
        b4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        txt_totalIncome = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_totalincome = new javax.swing.JLabel();
        bottombox = new javax.swing.JPanel();
        b5 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbl_due = new javax.swing.JLabel();
        b6 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        lbl_expenes = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        lbl_totalexpenses = new javax.swing.JLabel();
        b7 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        lbl_totalsecuritydeposit = new javax.swing.JLabel();

        dlg_addnewP.setAlwaysOnTop(true);
        dlg_addnewP.setBackground(new java.awt.Color(255, 255, 255));
        dlg_addnewP.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_addnewP.setMinimumSize(new java.awt.Dimension(570, 300));
        dlg_addnewP.setResizable(false);

        body1.setBackground(new java.awt.Color(255, 255, 255));
        body1.setMaximumSize(new java.awt.Dimension(570, 300));
        body1.setMinimumSize(new java.awt.Dimension(570, 300));
        body1.setPreferredSize(new java.awt.Dimension(570, 300));
        body1.setLayout(new java.awt.CardLayout(50, 50));

        inbody.setBackground(new java.awt.Color(255, 255, 255));
        inbody.setMaximumSize(new java.awt.Dimension(570, 400));
        inbody.setMinimumSize(new java.awt.Dimension(570, 400));
        inbody.setPreferredSize(new java.awt.Dimension(570, 400));
        inbody.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setMaximumSize(new java.awt.Dimension(200, 200));
        jPanel28.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel28.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel28.setLayout(new java.awt.CardLayout(20, 50));

        btn_addb.setBackground(new java.awt.Color(255, 0, 0));
        btn_addb.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_addb.setForeground(new java.awt.Color(255, 255, 255));
        btn_addb.setText("Add Building");
        btn_addb.setBorder(null);
        btn_addb.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_addb.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_addb.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_addb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addbActionPerformed(evt);
            }
        });
        jPanel28.add(btn_addb, "card2");

        inbody.add(jPanel28);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setMaximumSize(new java.awt.Dimension(200, 200));
        jPanel31.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel31.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel31.setLayout(new java.awt.CardLayout(20, 50));

        btn_adda.setBackground(new java.awt.Color(255, 0, 0));
        btn_adda.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_adda.setForeground(new java.awt.Color(255, 255, 255));
        btn_adda.setText("Add Apartment");
        btn_adda.setBorder(null);
        btn_adda.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_adda.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_adda.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_adda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addaActionPerformed(evt);
            }
        });
        jPanel31.add(btn_adda, "card2");

        inbody.add(jPanel31);

        body1.add(inbody, "card2");

        dlg_addnewP.getContentPane().add(body1, java.awt.BorderLayout.CENTER);

        dlg_manageP.setAlwaysOnTop(true);
        dlg_manageP.setBackground(new java.awt.Color(255, 255, 255));
        dlg_manageP.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_manageP.setResizable(false);
        dlg_manageP.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body2.setBackground(new java.awt.Color(255, 255, 255));
        body2.setMaximumSize(new java.awt.Dimension(570, 300));
        body2.setMinimumSize(new java.awt.Dimension(570, 300));
        body2.setPreferredSize(new java.awt.Dimension(570, 300));
        body2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addb1.setBackground(new java.awt.Color(255, 0, 0));
        btn_addb1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_addb1.setForeground(new java.awt.Color(255, 255, 255));
        btn_addb1.setText("View Apartment");
        btn_addb1.setBorder(null);
        btn_addb1.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_addb1.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_addb1.setPreferredSize(new java.awt.Dimension(200, 200));
        body2.add(btn_addb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 190, 90));

        btn_addb2.setBackground(new java.awt.Color(255, 0, 0));
        btn_addb2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_addb2.setForeground(new java.awt.Color(255, 255, 255));
        btn_addb2.setText("View Building");
        btn_addb2.setBorder(null);
        btn_addb2.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_addb2.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_addb2.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_addb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addb2ActionPerformed(evt);
            }
        });
        body2.add(btn_addb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 190, 90));

        btn_editBuilding.setBackground(new java.awt.Color(255, 0, 0));
        btn_editBuilding.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_editBuilding.setForeground(new java.awt.Color(255, 255, 255));
        btn_editBuilding.setText("Edit Building");
        btn_editBuilding.setBorder(null);
        btn_editBuilding.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_editBuilding.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_editBuilding.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_editBuilding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editBuildingActionPerformed(evt);
            }
        });
        body2.add(btn_editBuilding, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 190, 90));

        btn_editApartment.setBackground(new java.awt.Color(255, 0, 0));
        btn_editApartment.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_editApartment.setForeground(new java.awt.Color(255, 255, 255));
        btn_editApartment.setText("Edit Apartment");
        btn_editApartment.setBorder(null);
        btn_editApartment.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_editApartment.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_editApartment.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_editApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editApartmentActionPerformed(evt);
            }
        });
        body2.add(btn_editApartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 190, 90));

        dlg_manageP.getContentPane().add(body2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dlg_manageT.setAlwaysOnTop(true);
        dlg_manageT.setBackground(new java.awt.Color(255, 255, 255));
        dlg_manageT.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_manageT.setResizable(false);
        dlg_manageT.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body3.setBackground(new java.awt.Color(255, 255, 255));
        body3.setMaximumSize(new java.awt.Dimension(570, 300));
        body3.setMinimumSize(new java.awt.Dimension(570, 300));
        body3.setPreferredSize(new java.awt.Dimension(570, 300));
        body3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_tenantProfile.setBackground(new java.awt.Color(255, 0, 0));
        btn_tenantProfile.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_tenantProfile.setForeground(new java.awt.Color(255, 255, 255));
        btn_tenantProfile.setText("Tenant Profile");
        btn_tenantProfile.setBorder(null);
        btn_tenantProfile.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_tenantProfile.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_tenantProfile.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_tenantProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tenantProfileActionPerformed(evt);
            }
        });
        body3.add(btn_tenantProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 190, 90));

        btn_viewTenant.setBackground(new java.awt.Color(255, 0, 0));
        btn_viewTenant.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_viewTenant.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewTenant.setText("View All Tenant");
        btn_viewTenant.setBorder(null);
        btn_viewTenant.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_viewTenant.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_viewTenant.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_viewTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewTenantActionPerformed(evt);
            }
        });
        body3.add(btn_viewTenant, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 190, 90));

        btn_editTenant.setBackground(new java.awt.Color(255, 0, 0));
        btn_editTenant.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_editTenant.setForeground(new java.awt.Color(255, 255, 255));
        btn_editTenant.setText("Edit Tenant");
        btn_editTenant.setBorder(null);
        btn_editTenant.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_editTenant.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_editTenant.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_editTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editTenantActionPerformed(evt);
            }
        });
        body3.add(btn_editTenant, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 190, 90));

        btn_tenantLeave.setBackground(new java.awt.Color(255, 0, 0));
        btn_tenantLeave.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_tenantLeave.setForeground(new java.awt.Color(255, 255, 255));
        btn_tenantLeave.setText("Tenant Leave");
        btn_tenantLeave.setBorder(null);
        btn_tenantLeave.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_tenantLeave.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_tenantLeave.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_tenantLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tenantLeaveActionPerformed(evt);
            }
        });
        body3.add(btn_tenantLeave, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 190, 90));

        dlg_manageT.getContentPane().add(body3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dlg_createTr.setAlwaysOnTop(true);
        dlg_createTr.setBackground(new java.awt.Color(255, 255, 255));
        dlg_createTr.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_createTr.setResizable(false);
        dlg_createTr.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body4.setBackground(new java.awt.Color(255, 255, 255));
        body4.setMaximumSize(new java.awt.Dimension(570, 300));
        body4.setMinimumSize(new java.awt.Dimension(570, 300));
        body4.setPreferredSize(new java.awt.Dimension(570, 300));
        body4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_rcvDue.setBackground(new java.awt.Color(255, 0, 0));
        btn_rcvDue.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_rcvDue.setForeground(new java.awt.Color(255, 255, 255));
        btn_rcvDue.setText("Receive Due");
        btn_rcvDue.setBorder(null);
        btn_rcvDue.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_rcvDue.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_rcvDue.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_rcvDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rcvDueActionPerformed(evt);
            }
        });
        body4.add(btn_rcvDue, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 190, 90));

        btn_rcvRent.setBackground(new java.awt.Color(255, 0, 0));
        btn_rcvRent.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_rcvRent.setForeground(new java.awt.Color(255, 255, 255));
        btn_rcvRent.setText("Receive Rent");
        btn_rcvRent.setBorder(null);
        btn_rcvRent.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_rcvRent.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_rcvRent.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_rcvRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rcvRentActionPerformed(evt);
            }
        });
        body4.add(btn_rcvRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 190, 90));

        btn_createBill.setBackground(new java.awt.Color(255, 0, 0));
        btn_createBill.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_createBill.setForeground(new java.awt.Color(255, 255, 255));
        btn_createBill.setText("Create Bill");
        btn_createBill.setBorder(null);
        btn_createBill.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_createBill.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_createBill.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_createBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createBillActionPerformed(evt);
            }
        });
        body4.add(btn_createBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 190, 90));

        dlg_createTr.getContentPane().add(body4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dlg_ViewTr.setAlwaysOnTop(true);
        dlg_ViewTr.setBackground(new java.awt.Color(255, 255, 255));
        dlg_ViewTr.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_ViewTr.setResizable(false);
        dlg_ViewTr.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body5.setBackground(new java.awt.Color(255, 255, 255));
        body5.setMaximumSize(new java.awt.Dimension(570, 300));
        body5.setMinimumSize(new java.awt.Dimension(570, 300));
        body5.setPreferredSize(new java.awt.Dimension(570, 300));
        body5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_rcvDue1.setBackground(new java.awt.Color(255, 0, 0));
        btn_rcvDue1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_rcvDue1.setForeground(new java.awt.Color(255, 255, 255));
        btn_rcvDue1.setText("View All Unpaid Dues");
        btn_rcvDue1.setBorder(null);
        btn_rcvDue1.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_rcvDue1.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_rcvDue1.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_rcvDue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rcvDue1ActionPerformed(evt);
            }
        });
        body5.add(btn_rcvDue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 350, 50));

        btn_rcvRent1.setBackground(new java.awt.Color(255, 0, 0));
        btn_rcvRent1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_rcvRent1.setForeground(new java.awt.Color(255, 255, 255));
        btn_rcvRent1.setText("View All Collected Rent");
        btn_rcvRent1.setBorder(null);
        btn_rcvRent1.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_rcvRent1.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_rcvRent1.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_rcvRent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rcvRent1ActionPerformed(evt);
            }
        });
        body5.add(btn_rcvRent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 350, 50));

        btn_createBill1.setBackground(new java.awt.Color(255, 0, 0));
        btn_createBill1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_createBill1.setForeground(new java.awt.Color(255, 255, 255));
        btn_createBill1.setText("View All Paid Dues");
        btn_createBill1.setBorder(null);
        btn_createBill1.setMaximumSize(new java.awt.Dimension(200, 200));
        btn_createBill1.setMinimumSize(new java.awt.Dimension(200, 200));
        btn_createBill1.setPreferredSize(new java.awt.Dimension(200, 200));
        btn_createBill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createBill1ActionPerformed(evt);
            }
        });
        body5.add(btn_createBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 350, 50));

        dlg_ViewTr.getContentPane().add(body5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 650));
        setName("Home - TMS"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        header.setBackground(new java.awt.Color(255, 51, 51));
        header.setPreferredSize(new java.awt.Dimension(1287, 70));
        header.setLayout(new java.awt.GridLayout(1, 3));

        txt_currDate.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        txt_currDate.setForeground(new java.awt.Color(255, 255, 255));
        txt_currDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_currDate.setPreferredSize(new java.awt.Dimension(400, 0));
        header.add(txt_currDate);

        title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Tenant Management System");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setPreferredSize(new java.awt.Dimension(800, 44));
        title.setRequestFocusEnabled(false);
        header.add(title);

        LOGOUT_PANEL.setBackground(new java.awt.Color(255, 51, 51));
        LOGOUT_PANEL.setPreferredSize(new java.awt.Dimension(40, 70));

        btn_logout.setBackground(new java.awt.Color(255, 51, 51));
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logout-24x-w.png"))); // NOI18N
        btn_logout.setText("LOG OUT");
        btn_logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LOGOUT_PANELLayout = new javax.swing.GroupLayout(LOGOUT_PANEL);
        LOGOUT_PANEL.setLayout(LOGOUT_PANELLayout);
        LOGOUT_PANELLayout.setHorizontalGroup(
            LOGOUT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGOUT_PANELLayout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LOGOUT_PANELLayout.setVerticalGroup(
            LOGOUT_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        header.add(LOGOUT_PANEL);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        leftmenu.setBackground(new java.awt.Color(51, 51, 51));
        leftmenu.setPreferredSize(new java.awt.Dimension(310, 50));
        leftmenu.setLayout(new javax.swing.BoxLayout(leftmenu, javax.swing.BoxLayout.Y_AXIS));

        left_item_01.setBackground(new java.awt.Color(0, 0, 0));
        left_item_01.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROPERTY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        left_item_01.setPreferredSize(new java.awt.Dimension(312, 198));
        left_item_01.setLayout(new javax.swing.BoxLayout(left_item_01, javax.swing.BoxLayout.Y_AXIS));

        jPanel29.setBackground(new java.awt.Color(0, 0, 0));
        jPanel29.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_addnew.setBackground(new java.awt.Color(255, 255, 255));
        btn_addnew.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_addnew.setText("ADD NEW");
        btn_addnew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_addnew.setBorderPainted(false);
        btn_addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addnewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_addnew, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_addnew, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        left_item_01.add(jPanel29);

        jPanel30.setBackground(new java.awt.Color(0, 0, 0));
        jPanel30.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update.setText("MANAGE");
        btn_update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_update.setBorderPainted(false);
        btn_update.setMaximumSize(new java.awt.Dimension(93, 27));
        btn_update.setMinimumSize(new java.awt.Dimension(93, 27));
        btn_update.setPreferredSize(new java.awt.Dimension(93, 27));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_01.add(jPanel30);

        leftmenu.add(left_item_01);

        left_item_2.setBackground(new java.awt.Color(0, 0, 0));
        left_item_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TENANT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        left_item_2.setPreferredSize(new java.awt.Dimension(312, 198));
        left_item_2.setLayout(new javax.swing.BoxLayout(left_item_2, javax.swing.BoxLayout.Y_AXIS));

        jPanel32.setBackground(new java.awt.Color(0, 0, 0));
        jPanel32.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_addTenant.setBackground(new java.awt.Color(255, 255, 255));
        btn_addTenant.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_addTenant.setText("ADD NEW");
        btn_addTenant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_addTenant.setBorderPainted(false);
        btn_addTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTenantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_addTenant, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_addTenant, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_2.add(jPanel32);

        jPanel36.setBackground(new java.awt.Color(0, 0, 0));
        jPanel36.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_manageTenant.setBackground(new java.awt.Color(255, 255, 255));
        btn_manageTenant.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_manageTenant.setText("MANAGE");
        btn_manageTenant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_manageTenant.setBorderPainted(false);
        btn_manageTenant.setPreferredSize(new java.awt.Dimension(93, 27));
        btn_manageTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageTenantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_manageTenant, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_manageTenant, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_2.add(jPanel36);

        leftmenu.add(left_item_2);

        left_item_3.setBackground(new java.awt.Color(0, 0, 0));
        left_item_3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRANSACTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        left_item_3.setLayout(new javax.swing.BoxLayout(left_item_3, javax.swing.BoxLayout.Y_AXIS));

        jPanel37.setBackground(new java.awt.Color(0, 0, 0));
        jPanel37.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_createTransaction.setBackground(new java.awt.Color(255, 255, 255));
        btn_createTransaction.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_createTransaction.setText("CREATE");
        btn_createTransaction.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_createTransaction.setBorderPainted(false);
        btn_createTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createTransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_createTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_createTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_3.add(jPanel37);

        jPanel38.setBackground(new java.awt.Color(0, 0, 0));
        jPanel38.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_view3.setBackground(new java.awt.Color(255, 255, 255));
        btn_view3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_view3.setText("VIEW");
        btn_view3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_view3.setBorderPainted(false);
        btn_view3.setPreferredSize(new java.awt.Dimension(93, 27));
        btn_view3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_3.add(jPanel38);

        jPanel40.setBackground(new java.awt.Color(0, 0, 0));
        jPanel40.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_view6.setBackground(new java.awt.Color(255, 255, 255));
        btn_view6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_view6.setText("STATISTICS");
        btn_view6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_view6.setBorderPainted(false);
        btn_view6.setPreferredSize(new java.awt.Dimension(93, 27));
        btn_view6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view6, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view6, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_3.add(jPanel40);

        leftmenu.add(left_item_3);

        left_item_5.setBackground(new java.awt.Color(0, 0, 0));
        left_item_5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MISC", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        left_item_5.setLayout(new javax.swing.BoxLayout(left_item_5, javax.swing.BoxLayout.Y_AXIS));

        jPanel39.setBackground(new java.awt.Color(0, 0, 0));
        jPanel39.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_view4.setBackground(new java.awt.Color(255, 255, 255));
        btn_view4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_view4.setText("SEND REMINDER MAIL");
        btn_view4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_view4.setBorderPainted(false);
        btn_view4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view4, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view4, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_5.add(jPanel39);

        jPanel41.setBackground(new java.awt.Color(0, 0, 0));
        jPanel41.setPreferredSize(new java.awt.Dimension(300, 80));

        btn_view5.setBackground(new java.awt.Color(255, 255, 255));
        btn_view5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_view5.setText("SETTINGS");
        btn_view5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_view5.setBorderPainted(false);
        btn_view5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view5, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_view5, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        left_item_5.add(jPanel41);

        leftmenu.add(left_item_5);

        body.add(leftmenu, java.awt.BorderLayout.LINE_START);

        mainbody.setLayout(new java.awt.BorderLayout());

        borderbg.setBackground(new java.awt.Color(255, 255, 255));

        dashboard_panel.setBackground(new java.awt.Color(255, 255, 255));
        dashboard_panel.setLayout(new java.awt.BorderLayout());

        heading.setBackground(new java.awt.Color(0, 0, 0));
        heading.setPreferredSize(new java.awt.Dimension(963, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DASHBOARD");

        btn_refresh.setBackground(new java.awt.Color(255, 51, 51));
        btn_refresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/resetWhite-24x.png"))); // NOI18N
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_hideMenu.setBackground(new java.awt.Color(255, 0, 0));
        btn_hideMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_hideMenu.setForeground(new java.awt.Color(255, 255, 255));
        btn_hideMenu.setText("<");
        btn_hideMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hideMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headingLayout = new javax.swing.GroupLayout(heading);
        heading.setLayout(headingLayout);
        headingLayout.setHorizontalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_hideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headingLayout.setVerticalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(headingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dashboard_panel.add(heading, java.awt.BorderLayout.PAGE_START);

        container1.setLayout(new javax.swing.BoxLayout(container1, javax.swing.BoxLayout.Y_AXIS));

        topbox.setPreferredSize(new java.awt.Dimension(963, 500));
        topbox.setLayout(new javax.swing.BoxLayout(topbox, javax.swing.BoxLayout.LINE_AXIS));

        b01.setBackground(new java.awt.Color(255, 51, 51));
        b01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b01.setPreferredSize(new java.awt.Dimension(400, 296));
        b01.setLayout(new javax.swing.BoxLayout(b01, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/building (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b01.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total Building");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        b01.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_totalbuilding.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totalbuilding.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totalbuilding.setText("07");
        lbl_totalbuilding.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_totalbuilding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_totalbuildingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalbuilding, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalbuilding, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b01.add(jPanel3);

        topbox.add(b01);

        b02.setBackground(new java.awt.Color(204, 204, 204));
        b02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b02.setPreferredSize(new java.awt.Dimension(400, 296));
        b02.setLayout(new javax.swing.BoxLayout(b02, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/living-room.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b02.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total Apartment");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        b02.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_totalapartment.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totalapartment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totalapartment.setText("35");
        lbl_totalapartment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalapartment, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalapartment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b02.add(jPanel9);

        topbox.add(b02);

        b03.setBackground(new java.awt.Color(255, 255, 255));
        b03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b03.setPreferredSize(new java.awt.Dimension(400, 296));
        b03.setLayout(new javax.swing.BoxLayout(b03, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/warning.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b03.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Empty Apartment");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        b03.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_emptyapartment.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_emptyapartment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_emptyapartment.setText("31");
        lbl_emptyapartment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_emptyapartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_emptyapartmentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_emptyapartment, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_emptyapartment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b03.add(jPanel12);

        topbox.add(b03);

        container1.add(topbox);

        middlebox.setBackground(new java.awt.Color(102, 102, 102));
        middlebox.setPreferredSize(new java.awt.Dimension(50, 500));
        middlebox.setLayout(new javax.swing.BoxLayout(middlebox, javax.swing.BoxLayout.LINE_AXIS));

        b2.setBackground(new java.awt.Color(255, 51, 51));
        b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b2.setPreferredSize(new java.awt.Dimension(400, 296));
        b2.setLayout(new javax.swing.BoxLayout(b2, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/people.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Active Tenant");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        b2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_totaltenant.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totaltenant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totaltenant.setText("0");
        lbl_totaltenant.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_totaltenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_totaltenantMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totaltenant, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totaltenant, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b2.add(jPanel6);

        middlebox.add(b2);

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b3.setPreferredSize(new java.awt.Dimension(400, 296));
        b3.setLayout(new javax.swing.BoxLayout(b3, javax.swing.BoxLayout.Y_AXIS));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/due-rent-64x.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b3.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(200, 30));

        txt_rentDueInMonth.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_rentDueInMonth.setForeground(new java.awt.Color(255, 51, 51));
        txt_rentDueInMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_rentDueInMonth.setText("Due Rent In");
        txt_rentDueInMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_rentDueInMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_rentDueInMonthMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rentDueInMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rentDueInMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        b3.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_rentDueMonth.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_rentDueMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rentDueMonth.setText("0");
        lbl_rentDueMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rentDueMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_rentDueMonthMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_rentDueMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_rentDueMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b3.add(jPanel15);

        middlebox.add(b3);

        b4.setBackground(new java.awt.Color(255, 255, 255));
        b4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b4.setPreferredSize(new java.awt.Dimension(400, 296));
        b4.setLayout(new javax.swing.BoxLayout(b4, javax.swing.BoxLayout.Y_AXIS));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/income.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b4.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(200, 30));

        txt_totalIncome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_totalIncome.setForeground(new java.awt.Color(255, 51, 51));
        txt_totalIncome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_totalIncome.setText("Total Income");
        txt_totalIncome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_totalIncome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_totalIncomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_totalIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_totalIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        b4.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_totalincome.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totalincome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totalincome.setText("0");
        lbl_totalincome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_totalincome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_totalincomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalincome, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalincome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        b4.add(jPanel18);

        middlebox.add(b4);

        container1.add(middlebox);

        bottombox.setBackground(new java.awt.Color(102, 102, 102));
        bottombox.setPreferredSize(new java.awt.Dimension(50, 500));
        bottombox.setLayout(new javax.swing.BoxLayout(bottombox, javax.swing.BoxLayout.LINE_AXIS));

        b5.setBackground(new java.awt.Color(255, 51, 51));
        b5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b5.setPreferredSize(new java.awt.Dimension(400, 296));
        b5.setLayout(new javax.swing.BoxLayout(b5, javax.swing.BoxLayout.Y_AXIS));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/clock-time.png"))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        b5.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Total Dues");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        b5.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_due.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_due.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_due.setText("0");
        lbl_due.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_due.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_due, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_due, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        b5.add(jPanel21);

        bottombox.add(b5);

        b6.setBackground(new java.awt.Color(204, 204, 204));
        b6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b6.setPreferredSize(new java.awt.Dimension(400, 296));
        b6.setLayout(new javax.swing.BoxLayout(b6, javax.swing.BoxLayout.Y_AXIS));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/expenses.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        b6.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(200, 30));

        lbl_expenes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_expenes.setForeground(new java.awt.Color(255, 51, 51));
        lbl_expenes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_expenes.setText("Total Expenses");
        lbl_expenes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_expenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_expenesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_expenes, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_expenes, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );

        b6.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_totalexpenses.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totalexpenses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totalexpenses.setText("0");
        lbl_totalexpenses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_totalexpenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_totalexpensesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalexpenses, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalexpenses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        b6.add(jPanel24);

        bottombox.add(b6);

        b7.setBackground(new java.awt.Color(255, 255, 255));
        b7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));
        b7.setPreferredSize(new java.awt.Dimension(400, 296));
        b7.setLayout(new javax.swing.BoxLayout(b7, javax.swing.BoxLayout.Y_AXIS));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/security-box.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        b7.add(jPanel25);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 51, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Total Security Deposit");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );

        b7.add(jPanel26);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(200, 50));

        lbl_totalsecuritydeposit.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totalsecuritydeposit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totalsecuritydeposit.setText("0");
        lbl_totalsecuritydeposit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalsecuritydeposit, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_totalsecuritydeposit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        b7.add(jPanel27);

        bottombox.add(b7);

        container1.add(bottombox);

        dashboard_panel.add(container1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout borderbgLayout = new javax.swing.GroupLayout(borderbg);
        borderbg.setLayout(borderbgLayout);
        borderbgLayout.setHorizontalGroup(
            borderbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderbgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE)
                .addContainerGap())
        );
        borderbgLayout.setVerticalGroup(
            borderbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderbgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainbody.add(borderbg, java.awt.BorderLayout.CENTER);

        body.add(mainbody, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int deleteItem = JOptionPane.showConfirmDialog(null,"Do You Want to Log Out?", "WARNING!",JOptionPane.YES_NO_OPTION );
            if(deleteItem == JOptionPane.YES_OPTION)
            {                              
                dispose();
                new loginPage().setVisible(true); 
                
            }
        
        
        
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addnewActionPerformed
        //dlg_addnewP.setSize(570,310);               
        dlg_addnewP.setVisible(true);   
    }//GEN-LAST:event_btn_addnewActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        dlg_manageP.setVisible(true);
        dlg_manageP.setSize(570, 300);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        DBConnector.closeCon();
        setDashboardLabel();
        
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_addTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTenantActionPerformed
        new AddTenantPage().setVisible(true);
    }//GEN-LAST:event_btn_addTenantActionPerformed

    private void btn_manageTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageTenantActionPerformed
        dlg_manageT.setVisible(true);
        dlg_manageT.setSize(570, 300);
    }//GEN-LAST:event_btn_manageTenantActionPerformed

    private void btn_createTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createTransactionActionPerformed
        dlg_createTr.setVisible(true);
        dlg_createTr.setSize(570, 300);
    }//GEN-LAST:event_btn_createTransactionActionPerformed

    private void btn_view3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view3ActionPerformed
       dlg_ViewTr.setVisible(true);
       dlg_ViewTr.setSize(570, 300);
    }//GEN-LAST:event_btn_view3ActionPerformed

    private void btn_view4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view4ActionPerformed
        new SendRemMail().setVisible(true);
    }//GEN-LAST:event_btn_view4ActionPerformed

    private void btn_addaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addaActionPerformed
        dlg_addnewP.dispose();
        new AddApartmentPage().setVisible(true);
    }//GEN-LAST:event_btn_addaActionPerformed

    private void btn_addbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addbActionPerformed
        dlg_addnewP.dispose();
        new AddBuildingPage().setVisible(true);
    }//GEN-LAST:event_btn_addbActionPerformed

    private void btn_editBuildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editBuildingActionPerformed
        dlg_manageP.dispose();
        new UpdateBuildingPage().setVisible(true);
    }//GEN-LAST:event_btn_editBuildingActionPerformed

    private void btn_editApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editApartmentActionPerformed
        dlg_manageP.dispose();
        new UpdateApartmentPage().setVisible(true);
    }//GEN-LAST:event_btn_editApartmentActionPerformed

    private void btn_editTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editTenantActionPerformed
       dlg_manageT.dispose();
       new UpdateTenantPage().setVisible(true);
    }//GEN-LAST:event_btn_editTenantActionPerformed

    private void btn_tenantLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tenantLeaveActionPerformed
        dlg_manageT.dispose();
        new TenantLeavePage().setVisible(true);
    }//GEN-LAST:event_btn_tenantLeaveActionPerformed

    private void btn_view5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view5ActionPerformed
       new SettingsPage().setVisible(true);
    }//GEN-LAST:event_btn_view5ActionPerformed

    private void btn_view6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view6ActionPerformed
        new ViewStatistics().setVisible(true);
    }//GEN-LAST:event_btn_view6ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       new BuildingProfile().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_addb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addb2ActionPerformed
        dlg_manageP.dispose();
        new BuildingProfile().setVisible(true);
    }//GEN-LAST:event_btn_addb2ActionPerformed

    private void btn_rcvRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rcvRentActionPerformed
        dlg_createTr.dispose();
        new RcvRentPage().setVisible(true);
    }//GEN-LAST:event_btn_rcvRentActionPerformed

    private void btn_createBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createBillActionPerformed
        dlg_createTr.dispose();
        new CreateBillPage().setVisible(true);
    }//GEN-LAST:event_btn_createBillActionPerformed

    private void btn_rcvDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rcvDueActionPerformed
       dlg_createTr.dispose();
       new RcvDuePage().setVisible(true);
    }//GEN-LAST:event_btn_rcvDueActionPerformed

    private void txt_rentDueInMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_rentDueInMonthMouseClicked
        new DueRentTenant().setVisible(true);
    }//GEN-LAST:event_txt_rentDueInMonthMouseClicked

    private void lbl_totalbuildingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_totalbuildingMouseClicked
        new BuildingProfile().setVisible(true);
    }//GEN-LAST:event_lbl_totalbuildingMouseClicked

    private void lbl_rentDueMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rentDueMonthMouseClicked
        new DueRentTenant().setVisible(true);
    }//GEN-LAST:event_lbl_rentDueMonthMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        new RcvDuePage().setVisible(true);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void lbl_dueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dueMouseClicked
       new RcvDuePage().setVisible(true);
    }//GEN-LAST:event_lbl_dueMouseClicked

    private void txt_totalIncomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_totalIncomeMouseClicked
        new IncomeInMonth().setVisible(true);
    }//GEN-LAST:event_txt_totalIncomeMouseClicked

    private void lbl_totalincomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_totalincomeMouseClicked
        new IncomeInMonth().setVisible(true);
    }//GEN-LAST:event_lbl_totalincomeMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        new ViewActiveTenant().setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void lbl_totaltenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_totaltenantMouseClicked
        new ViewActiveTenant().setVisible(true);
    }//GEN-LAST:event_lbl_totaltenantMouseClicked

    private void lbl_emptyapartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_emptyapartmentMouseClicked
        new EmptyApartment().setVisible(true);
    }//GEN-LAST:event_lbl_emptyapartmentMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        new EmptyApartment().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    private void btn_rcvDue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rcvDue1ActionPerformed
        dlg_ViewTr.dispose();
        new RcvDuePage().setVisible(true);
    }//GEN-LAST:event_btn_rcvDue1ActionPerformed

    private void btn_rcvRent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rcvRent1ActionPerformed
        dlg_ViewTr.dispose();
        new ViewCollectedRent().setVisible(true);
    }//GEN-LAST:event_btn_rcvRent1ActionPerformed

    private void btn_createBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createBill1ActionPerformed
        dlg_ViewTr.dispose();
        new ViewPaidDues().setVisible(true);
    }//GEN-LAST:event_btn_createBill1ActionPerformed

    private void btn_hideMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hideMenuActionPerformed
      if(leftmenu.isVisible()){
           leftmenu.setVisible(false);
           btn_hideMenu.setText(">");
       }
      else{
          leftmenu.setVisible(true);
          btn_hideMenu.setText("<");
      }
        
    }//GEN-LAST:event_btn_hideMenuActionPerformed

    private void btn_viewTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewTenantActionPerformed
        dlg_manageT.dispose();        

         
       new ViewAllTenant().setVisible(true);;
            

    }//GEN-LAST:event_btn_viewTenantActionPerformed

    private void lbl_expenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_expenesMouseClicked
        new ExpenseInMonth().setVisible(true);
    }//GEN-LAST:event_lbl_expenesMouseClicked

    private void lbl_totalexpensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_totalexpensesMouseClicked
        new ExpenseInMonth().setVisible(true);
    }//GEN-LAST:event_lbl_totalexpensesMouseClicked

    private void btn_tenantProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tenantProfileActionPerformed
       dlg_manageT.dispose();
       new TenantSelect().setVisible(true);
    }//GEN-LAST:event_btn_tenantProfileActionPerformed

    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new HomePage().setVisible(true);           
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LOGOUT_PANEL;
    private javax.swing.JPanel b01;
    private javax.swing.JPanel b02;
    private javax.swing.JPanel b03;
    private javax.swing.JPanel b2;
    private javax.swing.JPanel b3;
    private javax.swing.JPanel b4;
    private javax.swing.JPanel b5;
    private javax.swing.JPanel b6;
    private javax.swing.JPanel b7;
    private javax.swing.JPanel body;
    private javax.swing.JPanel body1;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel body3;
    private javax.swing.JPanel body4;
    private javax.swing.JPanel body5;
    private javax.swing.JPanel borderbg;
    private javax.swing.JPanel bottombox;
    private javax.swing.JButton btn_addTenant;
    private javax.swing.JButton btn_adda;
    private javax.swing.JButton btn_addb;
    private javax.swing.JButton btn_addb1;
    private javax.swing.JButton btn_addb2;
    private javax.swing.JButton btn_addnew;
    private javax.swing.JButton btn_createBill;
    private javax.swing.JButton btn_createBill1;
    private javax.swing.JButton btn_createTransaction;
    private javax.swing.JButton btn_editApartment;
    private javax.swing.JButton btn_editBuilding;
    private javax.swing.JButton btn_editTenant;
    private javax.swing.JButton btn_hideMenu;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_manageTenant;
    private javax.swing.JButton btn_rcvDue;
    private javax.swing.JButton btn_rcvDue1;
    private javax.swing.JButton btn_rcvRent;
    private javax.swing.JButton btn_rcvRent1;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_tenantLeave;
    private javax.swing.JButton btn_tenantProfile;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view3;
    private javax.swing.JButton btn_view4;
    private javax.swing.JButton btn_view5;
    private javax.swing.JButton btn_view6;
    private javax.swing.JButton btn_viewTenant;
    private javax.swing.JPanel container1;
    private javax.swing.JPanel dashboard_panel;
    private javax.swing.JDialog dlg_ViewTr;
    private javax.swing.JDialog dlg_addnewP;
    private javax.swing.JDialog dlg_createTr;
    private javax.swing.JDialog dlg_manageP;
    private javax.swing.JDialog dlg_manageT;
    private javax.swing.JPanel header;
    private javax.swing.JPanel heading;
    private javax.swing.JPanel inbody;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private static javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private static javax.swing.JLabel lbl_due;
    private static javax.swing.JLabel lbl_emptyapartment;
    public static javax.swing.JLabel lbl_expenes;
    private static javax.swing.JLabel lbl_rentDueMonth;
    private static javax.swing.JLabel lbl_totalapartment;
    private static javax.swing.JLabel lbl_totalbuilding;
    private static javax.swing.JLabel lbl_totalexpenses;
    private static javax.swing.JLabel lbl_totalincome;
    private static javax.swing.JLabel lbl_totalsecuritydeposit;
    private static javax.swing.JLabel lbl_totaltenant;
    private javax.swing.JPanel left_item_01;
    private javax.swing.JPanel left_item_2;
    private javax.swing.JPanel left_item_3;
    private javax.swing.JPanel left_item_5;
    private javax.swing.JPanel leftmenu;
    private javax.swing.JPanel mainbody;
    private javax.swing.JPanel middlebox;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topbox;
    private static javax.swing.JLabel txt_currDate;
    private static javax.swing.JLabel txt_rentDueInMonth;
    private static javax.swing.JLabel txt_totalIncome;
    // End of variables declaration//GEN-END:variables
}
