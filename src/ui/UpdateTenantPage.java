package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import values.Values;

public class UpdateTenantPage extends javax.swing.JFrame { 
    
    private ResultSet rs = null;
    private String imagePath = null;
    tenantModel Ten = null;
    
    
  
    public UpdateTenantPage() {
        initComponents();        
        Ten = new tenantModel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        clear();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResponsiveSize();  
        //setAptID();       
        cb_aptid.setSelectedIndex(-1);
        cb_aptid.removeAllItems();
       
        displayAllTenant(Ten.VIEW_ALL_ACTIVE());
        txt_Search.requestFocus();
        
        
        
    }
    
    private void deleteTenant(long id)
    {
        Ten.DELETE(id);
    }
    
    

    private void clear()
    {
        txt_nid.setText("");   
        txt_fullname.setText("");   
        txt_email.setText("");   
        txt_mobile.setText("");   
        txt_permaddress.setText("");   
        txt_nationality.setText("");   
        txt_securitydeposit.setText("");   
        txt_startingmonth.setText("");   
        txt_totalmember.setText("");                             
        txt_age.setText("");   
        txt_nationality.setText("");
        lbl_photo.setIcon(null);
        txt_religion.setText("");
        txt_aptname.setText("");           
                
        cb_aptid.removeAllItems();
        tbl_tenant.clearSelection();
        txt_profession.setText("");
        txt_gender.setText("");
        
    } 
    
    
    private void setAptNameByID(int apt_id)
    {
        apartmentModel A = new apartmentModel();
        rs = A.VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(apt_id);
        try {
            if(rs.next())
            {
                txt_aptname.setText(rs.getString("apt_name")+"-"+rs.getString("b_name")+"-"+rs.getString("location"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTenantPage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    
    
    
    private void setResponsiveSize()
    {
        Dimension screensize = Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension maxSize = new Dimension(screensize.width,screensize.height-50);
        Dimension minSize = new Dimension(screensize.width-400,screensize.height-200);        
        //this.setMinimumSize(minSize);
        //this.setMaximumSize(minSize);
        this.setSize(maxSize);
    }
    
    
    private void updateTenant()
    {
        long  nid = Long.parseLong(txt_nid.getText());
        String full_name = txt_fullname.getText();
        int age = Integer.parseInt(txt_age.getText());
        String religion = txt_religion.getText().toUpperCase();
        String nationality = txt_nationality.getText().toUpperCase();
        long mobile = Long.parseLong(txt_mobile.getText());        
        String email = txt_email.getText();
        String permanant_address = txt_permaddress.getText().toUpperCase();
        int total_member = Integer.parseInt(txt_totalmember.getText());
        double security_deposit = Double.parseDouble(txt_securitydeposit.getText());
        String starting_month = txt_startingmonth.getText().toUpperCase();  
        
        
        
        Ten.UPDATE(nid, full_name, age, email, religion, nationality, age, email, permanant_address,total_member, security_deposit, starting_month);
                       
        clear();  
    }
    
    
    private void searchByName(String text)
    {
        ResultSet rs = Ten.SEARCH_BY_ACTIVE_NAME(text);
        displayAllTenant(rs);
    }
    
    private void searchByNID(String nid)
    {
        long id = Long.parseLong(nid);
        ResultSet rs = Ten.SEARCH_BY_ACTIVE_ID(id);
        displayAllTenant(rs);
    }
    
    private void searchByMobile(String text)
    {
        int id = Integer.parseInt(text);
        ResultSet rs = Ten.SEARCH_BY_ACT_MOBILE(text);
        displayAllTenant(rs);
    }
    
    private void searchByAptId(String text)
    {
        int id = Integer.parseInt(text);
        ResultSet rs = Ten.SEARCH_BY_APTID(id);
        displayAllTenant(rs);
    }
    
    
    
    
    private boolean validInput()
    {
        if(txt_nid.getText().length()>0 && txt_fullname.getText().length()>0 && txt_email.getText().length()>0 && txt_mobile.getText().length()>0 && txt_permaddress.getText().length()>0 && txt_nationality.getText().length()>0 && txt_securitydeposit.getText().length()>0 && txt_startingmonth.getText().length()>0 && txt_totalmember.getText().length()>0
                && txt_gender.getText().length()>0&& txt_profession.getText().length()>0 &&  txt_age.getText().length()>0 && txt_nationality.getText().length()>0)
            return true;
        else{
            return false;
        }
    }
    
    private void setAptID()
    {
        apartmentModel A = new apartmentModel();        
        rs = A.VIEW_ALL_ID_BY_AVAILABLE();
        
        try {
            //cb_aptid.removeAllItems();            
            while (rs.next()) 
            {
                cb_aptid.addItem(String.valueOf(rs.getInt("apt_id")));                
            }   
           
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTenantPage.class.getName()).log(Level.SEVERE, null, ex);
        }    
         
    }   
    
    private void displaySelectRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tbl_tenant.getModel();   
        int selectedRow = tbl_tenant.getSelectedRow(); 
        cb_aptid.removeAllItems();
        if(selectedRow>=0)
        {
            txt_nid.setText(recordTable.getValueAt(selectedRow,0).toString());
            long nid =Long.parseLong(txt_nid.getText());     
            
            ImageIcon icon = new ImageIcon(new ImageIcon(Ten.GET_PIC_BY_ID(nid)).getImage().getScaledInstance(lbl_photo.getWidth(),lbl_photo.getHeight(), Image.SCALE_SMOOTH));
            lbl_photo.setIcon(icon);
            txt_fullname.setText(recordTable.getValueAt(selectedRow,1).toString()); 
            txt_age.setText(recordTable.getValueAt(selectedRow,2).toString()); 
            txt_gender.setText(recordTable.getValueAt(selectedRow,3).toString()); 
            txt_religion.setText(recordTable.getValueAt(selectedRow,4).toString()); 
            txt_nationality.setText(recordTable.getValueAt(selectedRow,5).toString()); 
            txt_profession.setText(recordTable.getValueAt(selectedRow,6).toString()); 
            txt_mobile.setText("0"+recordTable.getValueAt(selectedRow,7).toString()); 
            txt_email.setText(recordTable.getValueAt(selectedRow,8).toString()); 
            txt_permaddress.setText(recordTable.getValueAt(selectedRow,9).toString()); 
            txt_totalmember.setText(recordTable.getValueAt(selectedRow,10).toString()); 
            cb_aptid.addItem(recordTable.getValueAt(selectedRow,11).toString()); 
            txt_securitydeposit.setText(recordTable.getValueAt(selectedRow,12).toString()); 
            txt_startingmonth.setText(recordTable.getValueAt(selectedRow,13).toString()); 
            setAptNameByID(Integer.parseInt(cb_aptid.getItemAt(0)));
                     
        }
          
    }
    
    
    private void displayAllTenant(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_tenant.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getLong("nid"));
                    columData.add(rs.getString("full_name"));                       
                    columData.add(rs.getInt("age"));
                    columData.add(rs.getString("gender"));
                    columData.add(rs.getString("religion"));
                    columData.add(rs.getString("nationality"));
                    columData.add(rs.getString("profession"));
                    columData.add(rs.getLong("mobile"));
                    columData.add(rs.getString("email"));
                    columData.add(rs.getString("permanant_address"));
                    columData.add(rs.getInt("total_member"));
                    columData.add(rs.getInt("apt_id"));
                    columData.add(rs.getDouble("security_deposit"));
                    columData.add(rs.getString("starting_month"));
                    
                    
                                            
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTenantPage.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        table = new javax.swing.JPanel();
        search_bar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        txt_Search = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        table_main = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tenant = new javax.swing.JTable();
        forms = new javax.swing.JPanel();
        leftbox = new javax.swing.JPanel();
        txt_nationality = new javax.swing.JTextField();
        txt_nid = new javax.swing.JTextField();
        txt_fullname = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_religion = new javax.swing.JTextField();
        txt_totalmember = new javax.swing.JTextField();
        txt_gender = new javax.swing.JTextField();
        txt_profession = new javax.swing.JTextField();
        middlebox = new javax.swing.JPanel();
        txt_mobile = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_permaddress = new javax.swing.JTextArea();
        rightbox = new javax.swing.JPanel();
        cb_aptid = new javax.swing.JComboBox<>();
        txt_aptname = new javax.swing.JTextField();
        lbl_photo = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        txt_securitydeposit = new javax.swing.JTextField();
        txt_startingmonth = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Home - TMS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(1280, 60));

        heading.setBackground(new java.awt.Color(0, 0, 0));
        heading.setPreferredSize(new java.awt.Dimension(963, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Update Tenant");

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
        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.Y_AXIS));

        table.setBackground(new java.awt.Color(255, 102, 102));
        table.setMaximumSize(new java.awt.Dimension(3110, 450));
        table.setPreferredSize(new java.awt.Dimension(3110, 450));
        table.setLayout(new javax.swing.BoxLayout(table, javax.swing.BoxLayout.Y_AXIS));

        search_bar.setBackground(new java.awt.Color(255, 255, 255));
        search_bar.setPreferredSize(new java.awt.Dimension(2118, 90));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("SEARCH BY:");

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "MOBILE" }));

        txt_Search.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });

        btn_Search.setBackground(new java.awt.Color(255, 51, 51));
        btn_Search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Search.setForeground(new java.awt.Color(255, 255, 255));
        btn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search-24x.png"))); // NOI18N
        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout search_barLayout = new javax.swing.GroupLayout(search_bar);
        search_bar.setLayout(search_barLayout);
        search_barLayout.setHorizontalGroup(
            search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_barLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cb_SearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(725, Short.MAX_VALUE))
        );
        search_barLayout.setVerticalGroup(
            search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_SearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        table.add(search_bar);

        table_main.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_tenant.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tbl_tenant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "Full Name", "Age", "Gender", "Religion", "Nationality", "Profession", "Mobile", "Email", "Permanant Address", "Total Member", "Apt ID", "Security Deposit", "Starting Month"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tenant.setRowHeight(50);
        tbl_tenant.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_tenant.getTableHeader().setReorderingAllowed(false);
        tbl_tenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tenantMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_tenant);
        if (tbl_tenant.getColumnModel().getColumnCount() > 0) {
            tbl_tenant.getColumnModel().getColumn(2).setMinWidth(50);
            tbl_tenant.getColumnModel().getColumn(2).setMaxWidth(50);
            tbl_tenant.getColumnModel().getColumn(11).setMinWidth(50);
            tbl_tenant.getColumnModel().getColumn(11).setMaxWidth(50);
        }

        javax.swing.GroupLayout table_mainLayout = new javax.swing.GroupLayout(table_main);
        table_main.setLayout(table_mainLayout);
        table_mainLayout.setHorizontalGroup(
            table_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 2098, Short.MAX_VALUE)
                .addContainerGap())
        );
        table_mainLayout.setVerticalGroup(
            table_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        table.add(table_main);

        body.add(table);

        forms.setBackground(new java.awt.Color(255, 255, 255));
        forms.setPreferredSize(new java.awt.Dimension(790, 200));
        forms.setLayout(new javax.swing.BoxLayout(forms, javax.swing.BoxLayout.LINE_AXIS));

        leftbox.setBackground(new java.awt.Color(255, 255, 255));
        leftbox.setPreferredSize(new java.awt.Dimension(120, 560));
        leftbox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nationality.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nationality.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NATIONALITY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_nationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nationalityActionPerformed(evt);
            }
        });
        leftbox.add(txt_nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 230, 80));

        txt_nid.setEditable(false);
        txt_nid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_nid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nidActionPerformed(evt);
            }
        });
        leftbox.add(txt_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 440, 70));

        txt_fullname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_fullname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FULL NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fullnameActionPerformed(evt);
            }
        });
        leftbox.add(txt_fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 440, 70));

        txt_age.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_age.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "AGE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ageActionPerformed(evt);
            }
        });
        txt_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ageKeyTyped(evt);
            }
        });
        leftbox.add(txt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 80));

        txt_religion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_religion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "RELIGION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_religionActionPerformed(evt);
            }
        });
        leftbox.add(txt_religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, 80));

        txt_totalmember.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_totalmember.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "TOTAL MEMBER", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_totalmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalmemberActionPerformed(evt);
            }
        });
        txt_totalmember.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totalmemberKeyTyped(evt);
            }
        });
        leftbox.add(txt_totalmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 170, 80));

        txt_gender.setEditable(false);
        txt_gender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_gender.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "GENDER", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_genderActionPerformed(evt);
            }
        });
        leftbox.add(txt_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 230, 80));

        txt_profession.setEditable(false);
        txt_profession.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_profession.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PROFESSION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_profession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_professionActionPerformed(evt);
            }
        });
        leftbox.add(txt_profession, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 250, 80));

        forms.add(leftbox);

        middlebox.setBackground(new java.awt.Color(255, 255, 255));
        middlebox.setPreferredSize(new java.awt.Dimension(180, 713));
        middlebox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_mobile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_mobile.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "MOBILE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mobileActionPerformed(evt);
            }
        });
        txt_mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mobileKeyTyped(evt);
            }
        });
        middlebox.add(txt_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 500, 80));

        txt_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_email.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        middlebox.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 500, 80));

        txt_permaddress.setColumns(20);
        txt_permaddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_permaddress.setRows(5);
        txt_permaddress.setWrapStyleWord(true);
        txt_permaddress.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "PERMANANT ADDRESS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        jScrollPane1.setViewportView(txt_permaddress);

        middlebox.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 500, 260));

        forms.add(middlebox);

        rightbox.setBackground(new java.awt.Color(255, 255, 255));
        rightbox.setPreferredSize(new java.awt.Dimension(500, 713));
        rightbox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_aptid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_aptid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "RENT APARTMENT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        cb_aptid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_aptidActionPerformed(evt);
            }
        });
        rightbox.add(cb_aptid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 70));

        txt_aptname.setEditable(false);
        txt_aptname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_aptname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_aptname.setBorder(null);
        txt_aptname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aptnameActionPerformed(evt);
            }
        });
        rightbox.add(txt_aptname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 610, 70));

        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rightbox.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 350, 350));

        btn_close.setBackground(new java.awt.Color(0, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.setBorderPainted(false);
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        rightbox.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 130, 60));

        btn_reset.setBackground(new java.awt.Color(0, 0, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/resetWhite-24x.png"))); // NOI18N
        btn_reset.setText("RESET");
        btn_reset.setBorderPainted(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        rightbox.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 140, 60));

        btn_add.setBackground(new java.awt.Color(0, 0, 0));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("UPDATE");
        btn_add.setBorderPainted(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        rightbox.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, 60));

        txt_securitydeposit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_securitydeposit.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "SECURITY DEPOSIT AMOUNT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_securitydeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_securitydepositActionPerformed(evt);
            }
        });
        txt_securitydeposit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_securitydepositKeyTyped(evt);
            }
        });
        rightbox.add(txt_securitydeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 430, 80));

        txt_startingmonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_startingmonth.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "STARTING MONTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_startingmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_startingmonthActionPerformed(evt);
            }
        });
        rightbox.add(txt_startingmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 430, 80));

        forms.add(rightbox);

        body.add(forms);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new UpdateTenantPage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
       if(validInput()==true)
       {
           updateTenant();         
           displayAllTenant(Ten.VIEW_ALL_ACTIVE());
           
           JOptionPane.showMessageDialog(this, "Tenant Updated"); 
       }       
       else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_startingmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_startingmonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_startingmonthActionPerformed

    private void txt_totalmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalmemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalmemberActionPerformed

    private void txt_nationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nationalityActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_securitydepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_securitydepositActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_securitydepositActionPerformed

    private void txt_mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mobileActionPerformed

    private void txt_nidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nidActionPerformed

    private void txt_fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fullnameActionPerformed

    private void txt_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageActionPerformed

    private void txt_religionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_religionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_religionActionPerformed

    private void txt_aptnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aptnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_aptnameActionPerformed

    private void cb_aptidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_aptidActionPerformed
        
        
        
    }//GEN-LAST:event_cb_aptidActionPerformed

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased

    }//GEN-LAST:event_txt_SearchKeyReleased

    private void txt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyTyped

    }//GEN-LAST:event_txt_SearchKeyTyped

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        if(txt_Search.getText().length()>0)
        {
            
            clear();
            
            String selection = cb_SearchFilter.getSelectedItem().toString();
            String query = txt_Search.getText();
            
            try {
                
                switch(selection)
                    {
                        case "ID":
                            
                            searchByNID(query);
                            break;

                        case "NAME":
                            searchByName(query);
                            break;  

                         case "MOBILE":                            
                            searchByMobile(query);
                            break;

                        case "APT ID":
                            searchByAptId(query);
                            break;      
                    }
            
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this, "Invalid Search Query!");
            }
            
            
        }
        else{
            displayAllTenant(Ten.VIEW_ALL_ACTIVE());
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void txt_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_genderActionPerformed

    private void txt_professionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_professionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_professionActionPerformed

    private void tbl_tenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tenantMouseClicked
        
        displaySelectRow();
    }//GEN-LAST:event_tbl_tenantMouseClicked

    private void txt_ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ageKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_ageKeyTyped

    private void txt_totalmemberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalmemberKeyTyped
       char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_totalmemberKeyTyped

    private void txt_mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mobileKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_mobileKeyTyped

    private void txt_securitydepositKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_securitydepositKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_securitydepositKeyTyped

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new UpdateTenantPage().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JComboBox<String> cb_aptid;
    private javax.swing.JPanel forms;
    private javax.swing.JPanel header;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JPanel leftbox;
    private javax.swing.JPanel middlebox;
    private javax.swing.JPanel rightbox;
    private javax.swing.JPanel search_bar;
    private javax.swing.JPanel table;
    private javax.swing.JPanel table_main;
    private javax.swing.JTable tbl_tenant;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_aptname;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextField txt_gender;
    private javax.swing.JTextField txt_mobile;
    private javax.swing.JTextField txt_nationality;
    private javax.swing.JTextField txt_nid;
    private javax.swing.JTextArea txt_permaddress;
    private javax.swing.JTextField txt_profession;
    private javax.swing.JTextField txt_religion;
    private javax.swing.JTextField txt_securitydeposit;
    private javax.swing.JTextField txt_startingmonth;
    private javax.swing.JTextField txt_totalmember;
    // End of variables declaration//GEN-END:variables
}
