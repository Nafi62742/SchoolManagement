/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package schoolmanagementsystem;
//
//import schoolmanagementsystem.Database.JConnection;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import net.codejava.sql.JConnection;
import org.apache.commons.codec.binary.Base64;
import schoolmanagementsystem.Database.StudentDatabase;

public class UpdateAccountStudent extends javax.swing.JFrame {
//    
//    Connection conn = null;
//    PreparedStatement pst = null;
    private String id;
    StudentDatabase stdb;
    private ResultSet rs = null;
    
    public UpdateAccountStudent() {
        this.setUndecorated(true);
        initComponents();
        
//        stdb = new StudentDatabase();
//        conn = JConnection.connectdb();
    }
    
    //override..
    public UpdateAccountStudent(String id) {
        this.setUndecorated(true);
        initComponents();
//        conn = JConnection.connectdb();
        this.id = id;
        stdb = new StudentDatabase(this.id);
        profileShow();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        updateText1 = new javax.swing.JLabel();
        updateText4 = new javax.swing.JLabel();
        updateText = new javax.swing.JLabel();
        updateText3 = new javax.swing.JLabel();
        updateText2 = new javax.swing.JLabel();
        NumberText = new javax.swing.JLabel();
        UpdateLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        EmailField = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        studentClassField = new javax.swing.JTextField();
        EmailText = new javax.swing.JLabel();
        sectionField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        confirmPasswordField = new javax.swing.JPasswordField();
        NumberField = new javax.swing.JTextField();
        back_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        idField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/image/close.png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, 30));

        updateText1.setBackground(new java.awt.Color(255, 255, 255));
        updateText1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        updateText1.setForeground(new java.awt.Color(0, 0, 0));
        updateText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateText1.setText("(***@email.com)");
        updateText1.setOpaque(true);
        jPanel2.add(updateText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 90, 20));

        updateText4.setBackground(new java.awt.Color(255, 255, 255));
        updateText4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        updateText4.setForeground(new java.awt.Color(0, 0, 0));
        updateText4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateText4.setText("(a/b/c)");
        updateText4.setOpaque(true);
        jPanel2.add(updateText4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 40, 30));

        updateText.setBackground(new java.awt.Color(255, 255, 255));
        updateText.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        updateText.setForeground(new java.awt.Color(0, 0, 0));
        updateText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateText.setText("Update Account");
        updateText.setOpaque(true);
        jPanel2.add(updateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 360, 60));

        updateText3.setBackground(new java.awt.Color(255, 255, 255));
        updateText3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        updateText3.setForeground(new java.awt.Color(0, 0, 0));
        updateText3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateText3.setText("(1-10)");
        updateText3.setOpaque(true);
        jPanel2.add(updateText3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 40, 20));

        updateText2.setBackground(new java.awt.Color(255, 255, 255));
        updateText2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        updateText2.setForeground(new java.awt.Color(0, 0, 0));
        updateText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateText2.setText("(Must be less or equal 30 words)");
        updateText2.setOpaque(true);
        jPanel2.add(updateText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 180, 30));

        NumberText.setBackground(new java.awt.Color(255, 255, 255));
        NumberText.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        NumberText.setForeground(new java.awt.Color(0, 0, 0));
        NumberText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NumberText.setText("Phone number");
        NumberText.setOpaque(true);
        jPanel2.add(NumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 190, 30));

        UpdateLogo.setBackground(new java.awt.Color(255, 255, 255));
        UpdateLogo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        UpdateLogo.setForeground(new java.awt.Color(0, 0, 153));
        UpdateLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UpdateLogo.setText("Update");
        UpdateLogo.setOpaque(true);
        jPanel2.add(UpdateLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 670, 180, 80));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 430, 20));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 430, 10));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 430, 10));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 430, 10));

        EmailField.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        EmailField.setBorder(null);
        EmailField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        EmailField.setOpaque(false);
        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });
        EmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EmailFieldKeyPressed(evt);
            }
        });
        jPanel2.add(EmailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 430, 30));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 430, 20));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 430, 10));

        studentClassField.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        studentClassField.setBorder(null);
        studentClassField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        studentClassField.setOpaque(false);
        studentClassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentClassFieldActionPerformed(evt);
            }
        });
        studentClassField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentClassFieldKeyPressed(evt);
            }
        });
        jPanel2.add(studentClassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 430, 30));

        EmailText.setBackground(new java.awt.Color(255, 255, 255));
        EmailText.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        EmailText.setForeground(new java.awt.Color(0, 0, 0));
        EmailText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EmailText.setText("Email");
        EmailText.setOpaque(true);
        jPanel2.add(EmailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 320, -1));

        sectionField.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        sectionField.setBorder(null);
        sectionField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sectionField.setOpaque(false);
        sectionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sectionFieldKeyPressed(evt);
            }
        });
        jPanel2.add(sectionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 430, 30));

        nameField.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        nameField.setBorder(null);
        nameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameField.setOpaque(false);
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameFieldKeyPressed(evt);
            }
        });
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 430, -1));

        confirmPasswordField.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        confirmPasswordField.setBorder(null);
        confirmPasswordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        confirmPasswordField.setOpaque(false);
        confirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordFieldActionPerformed(evt);
            }
        });
        confirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmPasswordFieldKeyPressed(evt);
            }
        });
        jPanel2.add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 440, 30));

        NumberField.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        NumberField.setBorder(null);
        NumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NumberField.setOpaque(false);
        NumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberFieldActionPerformed(evt);
            }
        });
        NumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NumberFieldKeyPressed(evt);
            }
        });
        jPanel2.add(NumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 430, 30));

        back_btn.setBorder(null);
        back_btn.setBorderPainted(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        jPanel2.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 70, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/image/New Account Page_1.PNG"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 770));

        updateButton.setBorder(null);
        updateButton.setBorderPainted(false);
        updateButton.setContentAreaFilled(false);
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 680, 180, 60));

        idField1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        idField1.setBorder(null);
        idField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        idField1.setOpaque(false);
        idField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idField1ActionPerformed(evt);
            }
        });
        jPanel2.add(idField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 430, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//.......................Start Custom Functions....................//
    
    private String EncryptPass(String passwordString) {
        try {
            String originalInput = passwordString;
            Base64 base64 = new Base64();
            String encodedString = new String(base64.encode(originalInput.getBytes()));
            return encodedString;
        } catch (Exception e) {
            System.out.println("Password encryption failed");
        }
        return null;
    }
    
    
    private void clearTextField() {
        nameField.setText("");
        studentClassField.setText("");
        sectionField.setText("");
        NumberField.setText("");
        EmailField.setText("");
        confirmPasswordField.setText("");
    }
    
    public void profileShow() {
        
        String student_id = this.id;
        String StudentName = stdb.getStudentName();
        nameField.setText(StudentName);
        EmailField.setText(stdb.getStudentEmail());
        sectionField.setText(stdb.getSection());
        studentClassField.setText(stdb.getStudentClass());
        NumberField.setText(stdb.getStudentPhoneNo());
        
        
    }
       public void updateTrigger() {

        String Stu_Id = stdb.getId();
        
        String pass = null;
        String DBpass = stdb.getPassFromDB();
        String originalPass = confirmPasswordField.getText();
        pass = EncryptPass(originalPass);
        
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", EmailField.getText()))) 
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else{
                if (originalPass.length() >= 4  && pass.equals(DBpass)) {
                  int response = stdb.updateStudentAccount(nameField.getText(), studentClassField.getText(), sectionField.getText(),Stu_Id , NumberField.getText(), EmailField.getText());
                 switch (response) {
                      case 1:
                          JOptionPane.showMessageDialog(null, "Updated Successfully");
                          //clearTextField();
                          new StudentProfile(this.id).setVisible(true);
                          dispose();
                          break;
                      default:
                          clearTextField();
                          break;
                  }
              } 
              else {
                  JOptionPane.showMessageDialog(this, "Please set password correctly", "Warning", JOptionPane.WARNING_MESSAGE);
              }
        }
    }
//.......................End Custom Functions....................//   
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Quit", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
            System.exit(0);
        } 
    }//GEN-LAST:event_exitButtonActionPerformed

    private void studentClassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentClassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentClassFieldActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        dispose();
        new StudentProfile(this.id).setVisible(true);
    }//GEN-LAST:event_back_btnActionPerformed
    

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed
    

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
         updateTrigger();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void confirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordFieldActionPerformed

    private void idField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idField1ActionPerformed

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    private void NumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumberFieldActionPerformed

    private void confirmPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordFieldKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            updateTrigger();
        }
    }//GEN-LAST:event_confirmPasswordFieldKeyPressed

    private void NumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumberFieldKeyPressed
                // TODO add your handling code here:
        String phoneNo=NumberField.getText();
        int length=phoneNo.length();
        
        char c = evt.getKeyChar();
        if(c>='0'&&c<='9'){
            if(length<11){
                NumberField.setEditable(true);
            }
            else{
                NumberField.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                NumberField.setEditable(true);
            }
            else{
                 NumberField.setEditable(false);
            }
        }
    }//GEN-LAST:event_NumberFieldKeyPressed

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyPressed
        String name=nameField.getText();
        int length=name.length();
        
        char c = evt.getKeyChar();
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c==' ')){
            if(length<30){
                nameField.setEditable(true);
            }
            else{
                nameField.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                nameField.setEditable(true);
            }
            else{
                 nameField.setEditable(false);
            }
        }
    }//GEN-LAST:event_nameFieldKeyPressed

    private void studentClassFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentClassFieldKeyPressed
        String classStu=studentClassField.getText();
        int length=classStu.length();
        
            char c = evt.getKeyChar();
        if(c>='0'&&c<='9'){
            if(length<2){
                studentClassField.setEditable(true);
            }
            else{
                studentClassField.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                studentClassField.setEditable(true);
            }
            else{
                 studentClassField.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_studentClassFieldKeyPressed

    private void sectionFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sectionFieldKeyPressed
        // TODO add your handling code here:sectionField
        String sec=sectionField.getText();
        int length=sec.length();
        
        char c = evt.getKeyChar();
        if((c>='A'&&c<='C')||(c>='a'&&c<='c')){
            if(length<1){
                sectionField.setEditable(true);
            }
            else{
                sectionField.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                sectionField.setEditable(true);
            }
            else{
                 sectionField.setEditable(false);
            }
        }
    }//GEN-LAST:event_sectionFieldKeyPressed

    private void EmailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailFieldKeyPressed
        // TODO add your handling code here:EmailField
        String emailtxt=EmailField.getText();
        int length=emailtxt.length();
        
        char c = evt.getKeyChar();
        /*
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email.getText()))) 
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The email is valid", "Good!", JOptionPane.INFORMATION_MESSAGE);

            }
        */
        
        if(c>=33&&c<=127){
            if(length<35){
                EmailField.setEditable(true);
            }
            else{
                EmailField.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                EmailField.setEditable(true);
            }
            else{
                 EmailField.setEditable(false);
            }
        }
    }//GEN-LAST:event_EmailFieldKeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAccountStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAccountStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailText;
    private javax.swing.JTextField NumberField;
    private javax.swing.JLabel NumberText;
    private javax.swing.JLabel UpdateLogo;
    private javax.swing.JButton back_btn;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField idField1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField sectionField;
    private javax.swing.JTextField studentClassField;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel updateText;
    private javax.swing.JLabel updateText1;
    private javax.swing.JLabel updateText2;
    private javax.swing.JLabel updateText3;
    private javax.swing.JLabel updateText4;
    // End of variables declaration//GEN-END:variables
    
    private int len(String originalPass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}