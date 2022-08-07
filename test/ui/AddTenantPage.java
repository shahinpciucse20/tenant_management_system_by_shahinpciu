package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;

public class AddTenantPage extends javax.swing.JFrame { 
    
    private ResultSet rs = null;
    private String imagePath = null;
    
  
    public AddTenantPage() {
        initComponents();              
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        clear();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResponsiveSize();  
        setAptID();       
        cb_aptid.setSelectedIndex(-1);
        //cb_aptid.removeItemAt(0);
        
        
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
        cb_gender.setSelectedIndex(-1);
        cb_profession.setSelectedIndex(-1);
        lbl_imagepath.setText("");   
        txt_age.setText("");   
        txt_nationality.setText("");
        lbl_photo.setIcon(null);
        txt_religion.setText("");
        txt_aptname.setText("");            
                
        cb_aptid.removeAllItems();
        //cb_aptid.setSelectedIndex(-1);
        setAptID();
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
            Logger.getLogger(AddTenantPage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    
    
    
    private void setResponsiveSize()
    {
        Dimension screensize = Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension maxSize = new Dimension(screensize.width,screensize.height-50);
        Dimension minSize = new Dimension(screensize.width-400,screensize.height-200);        
        this.setMinimumSize(minSize);
        this.setMaximumSize(minSize);
        this.setSize(minSize);
    }
    
    
    private void addTenant()
    {
        long  nid = Long.parseLong(txt_nid.getText());
        String full_name = txt_fullname.getText();
        int age = Integer.parseInt(txt_age.getText());
        String gender = cb_gender.getSelectedItem().toString();
        String religion = txt_religion.getText().toUpperCase();
        String nationality = txt_nationality.getText().toUpperCase();
        String profession = cb_profession.getSelectedItem().toString();
        long mobile = Long.parseLong(txt_mobile.getText());        
        String email = txt_email.getText();
        String permanant_address = txt_permaddress.getText().toUpperCase();
        int total_member = Integer.parseInt(txt_totalmember.getText());
        int apt_id = Integer.parseInt(cb_aptid.getSelectedItem().toString());
        double security_deposit = Double.parseDouble(txt_securitydeposit.getText());
        String starting_month = txt_startingmonth.getText().toUpperCase();               
                
                
                
        tenantModel Ten = new tenantModel();
        Ten.INSERT(nid, full_name, age, gender, religion, nationality, profession, mobile, email, permanant_address, imagePath, total_member, apt_id, security_deposit, starting_month);
        apartmentModel A = new apartmentModel();
        A.UPDATE_AVAILABLE(apt_id, "NO");
        
        clear();
        
        
        
    }
    
    private boolean validInput()
    {
        if(txt_nid.getText().length()>0 && txt_fullname.getText().length()>0 && txt_email.getText().length()>0 && txt_mobile.getText().length()>0 && txt_permaddress.getText().length()>0 && txt_nationality.getText().length()>0 && txt_securitydeposit.getText().length()>0 && txt_startingmonth.getText().length()>0 && txt_totalmember.getText().length()>0
                && cb_gender.getSelectedIndex()!=-1 && cb_profession.getSelectedIndex()!=-1 && lbl_imagepath.getText().length()>0 && txt_age.getText().length()>0 && txt_nationality.getText().length()>0)
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
            Logger.getLogger(AddTenantPage.class.getName()).log(Level.SEVERE, null, ex);
        }    
         
    }   
  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        forms = new javax.swing.JPanel();
        leftbox = new javax.swing.JPanel();
        cb_profession = new javax.swing.JComboBox<>();
        cb_gender = new javax.swing.JComboBox<>();
        txt_totalmember = new javax.swing.JTextField();
        txt_nationality = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_mobile = new javax.swing.JTextField();
        txt_nid = new javax.swing.JTextField();
        txt_fullname = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_religion = new javax.swing.JTextField();
        rightbox = new javax.swing.JPanel();
        lbl_photo = new javax.swing.JLabel();
        btn_chooseimage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_permaddress = new javax.swing.JTextArea();
        txt_startingmonth = new javax.swing.JTextField();
        txt_securitydeposit = new javax.swing.JTextField();
        lbl_imagepath = new javax.swing.JLabel();
        cb_aptid = new javax.swing.JComboBox<>();
        txt_aptname = new javax.swing.JTextField();
        buttons = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();

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
        jLabel2.setText("Add Tenant");

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
            .addGap(0, 2000, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                    .addContainerGap(372, Short.MAX_VALUE)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(372, Short.MAX_VALUE)))
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

        forms.setBackground(new java.awt.Color(255, 255, 255));
        forms.setPreferredSize(new java.awt.Dimension(790, 600));
        forms.setLayout(new javax.swing.BoxLayout(forms, javax.swing.BoxLayout.LINE_AXIS));

        leftbox.setBackground(new java.awt.Color(255, 255, 255));
        leftbox.setPreferredSize(new java.awt.Dimension(570, 560));
        leftbox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_profession.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_profession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRIVATE JOB", "GOVT JOB", "BUSINESS", "OTHERS" }));
        cb_profession.setSelectedIndex(-1);
        cb_profession.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "PROFESSION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        cb_profession.setFocusable(false);
        leftbox.add(cb_profession, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 250, 70));

        cb_gender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        cb_gender.setSelectedIndex(-1);
        cb_gender.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "GENDER", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        leftbox.add(cb_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 230, 70));

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
        leftbox.add(txt_totalmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 230, 80));

        txt_nationality.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nationality.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NATIONALITY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_nationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nationalityActionPerformed(evt);
            }
        });
        leftbox.add(txt_nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 230, 80));

        txt_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_email.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        leftbox.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 550, 80));

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
        leftbox.add(txt_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 550, 80));

        txt_nid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_nid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nidActionPerformed(evt);
            }
        });
        txt_nid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nidKeyTyped(evt);
            }
        });
        leftbox.add(txt_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 550, 70));

        txt_fullname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_fullname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FULL NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fullnameActionPerformed(evt);
            }
        });
        leftbox.add(txt_fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 550, 70));

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
        leftbox.add(txt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 250, 80));

        txt_religion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_religion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "RELIGION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_religionActionPerformed(evt);
            }
        });
        leftbox.add(txt_religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 250, 80));

        forms.add(leftbox);

        rightbox.setBackground(new java.awt.Color(255, 255, 255));
        rightbox.setPreferredSize(new java.awt.Dimension(700, 713));
        rightbox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rightbox.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 190));

        btn_chooseimage.setBackground(new java.awt.Color(0, 0, 0));
        btn_chooseimage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_chooseimage.setForeground(new java.awt.Color(255, 255, 255));
        btn_chooseimage.setText("CHOOSE IMAGE");
        btn_chooseimage.setBorderPainted(false);
        btn_chooseimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseimageActionPerformed(evt);
            }
        });
        rightbox.add(btn_chooseimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 200, 60));

        txt_permaddress.setColumns(20);
        txt_permaddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_permaddress.setRows(5);
        txt_permaddress.setWrapStyleWord(true);
        txt_permaddress.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "PERMANANT ADDRESS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        jScrollPane1.setViewportView(txt_permaddress);

        rightbox.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 770, 190));

        txt_startingmonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_startingmonth.setToolTipText("MMM - YYYY");
        txt_startingmonth.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "STARTING MONTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_startingmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_startingmonthActionPerformed(evt);
            }
        });
        rightbox.add(txt_startingmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 380, 80));

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
        rightbox.add(txt_securitydeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 360, 80));

        lbl_imagepath.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rightbox.add(lbl_imagepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 530, 30));

        cb_aptid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_aptid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "RENT APARTMENT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        cb_aptid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_aptidActionPerformed(evt);
            }
        });
        rightbox.add(cb_aptid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 200, 70));

        txt_aptname.setEditable(false);
        txt_aptname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_aptname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_aptname.setBorder(null);
        txt_aptname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aptnameActionPerformed(evt);
            }
        });
        rightbox.add(txt_aptname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 560, 70));

        forms.add(rightbox);

        body.add(forms);

        buttons.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setBackground(new java.awt.Color(0, 0, 0));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_add.setForeground(new java.awt.Color(204, 204, 204));
        btn_add.setText("ADD");
        btn_add.setBorderPainted(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 220, 70));

        btn_reset.setBackground(new java.awt.Color(0, 0, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(204, 204, 204));
        btn_reset.setText("RESET");
        btn_reset.setBorderPainted(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 190, 70));

        btn_close.setBackground(new java.awt.Color(0, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(204, 204, 204));
        btn_close.setText("CLOSE");
        btn_close.setBorderPainted(false);
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 190, 70));

        buttons.add(jPanel1, java.awt.BorderLayout.CENTER);

        body.add(buttons);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new AddTenantPage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
       if(validInput()==true)
       {
           addTenant();         
           
           JOptionPane.showMessageDialog(this, "Tenant Added"); 
       }       
       else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_chooseimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseimageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & PNG Images", "jpg", "png");
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION)
        {
          File img = fileChooser.getSelectedFile();          
          
          imagePath = img.getAbsolutePath();
          
          ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(lbl_photo.getWidth(),lbl_photo.getHeight(), Image.SCALE_SMOOTH));
          lbl_photo.setIcon(icon);
          
          lbl_imagepath.setText("File Selected: " +img.getAbsolutePath());
         }
        
    }//GEN-LAST:event_btn_chooseimageActionPerformed

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
        if(cb_aptid.getSelectedIndex()!=-1)
        {
            int apt_id = Integer.parseInt(cb_aptid.getSelectedItem().toString());
            setAptNameByID(apt_id);
        }
        else if(cb_aptid.getSelectedIndex()==-1)
        {
            txt_aptname.setText("");
        }
        
        
    }//GEN-LAST:event_cb_aptidActionPerformed

    private void txt_nidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nidKeyReleased
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_nidKeyReleased

    private void txt_nidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nidKeyPressed
        
    }//GEN-LAST:event_txt_nidKeyPressed

    private void txt_nidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nidKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_nidKeyTyped

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
                
                new AddTenantPage().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_chooseimage;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reset;
    private javax.swing.JPanel buttons;
    private javax.swing.JComboBox<String> cb_aptid;
    private javax.swing.JComboBox<String> cb_gender;
    private javax.swing.JComboBox<String> cb_profession;
    private javax.swing.JPanel forms;
    private javax.swing.JPanel header;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_imagepath;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JPanel leftbox;
    private javax.swing.JPanel rightbox;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_aptname;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextField txt_mobile;
    private javax.swing.JTextField txt_nationality;
    private javax.swing.JTextField txt_nid;
    private javax.swing.JTextArea txt_permaddress;
    private javax.swing.JTextField txt_religion;
    private javax.swing.JTextField txt_securitydeposit;
    private javax.swing.JTextField txt_startingmonth;
    private javax.swing.JTextField txt_totalmember;
    // End of variables declaration//GEN-END:variables
}
