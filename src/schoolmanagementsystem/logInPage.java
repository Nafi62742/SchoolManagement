package schoolmanagementsystem;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import schoolmanagementsystem.Database.Accounts;


public class logInPage extends javax.swing.JFrame {
    Accounts account;
    public logInPage() {
        this.setUndecorated(true);
        account=new Accounts();
        
        String userId=account.isUserLoggedIn();
        if(userId==null){
            initComponents();
        }else{
            if(userId.contains("100.")){
            new StudentProfile(userId).setVisible(true);
            dispose();
        }else if(userId.contains("400.")){
            new TeacherProfile(userId).setVisible(true);
            dispose();
        }
        }
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
        jTextPane1 = new javax.swing.JTextPane();
        jTextPane2 = new javax.swing.JTextPane();
        rememberUserCheckbox = new javax.swing.JCheckBox();
        idField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passwordField = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        signinButton = new javax.swing.JButton();
        signupButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        BackgroundLebel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane1.setFont(new java.awt.Font("Comic Sans MS", 1, 27)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane1.setText("ID");
        jTextPane1.setOpaque(false);
        jPanel1.add(jTextPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, 70, 40));

        jTextPane2.setEditable(false);
        jTextPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane2.setFont(new java.awt.Font("Comic Sans MS", 1, 27)); // NOI18N
        jTextPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane2.setText("Password");
        jTextPane2.setOpaque(false);
        jPanel1.add(jTextPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(878, 270, 140, 40));

        rememberUserCheckbox.setBackground(new java.awt.Color(44, 27, 95));
        rememberUserCheckbox.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        rememberUserCheckbox.setForeground(new java.awt.Color(250, 250, 250));
        rememberUserCheckbox.setText("    Remember me");
        rememberUserCheckbox.setContentAreaFilled(false);
        rememberUserCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberUserCheckboxActionPerformed(evt);
            }
        });
        jPanel1.add(rememberUserCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 390, 200, 40));

        idField.setBackground(new java.awt.Color(255, 255, 255));
        idField.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        idField.setForeground(new java.awt.Color(255, 255, 255));
        idField.setText("Enter Your ID");
        idField.setBorder(null);
        idField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        idField.setOpaque(false);
        idField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idFieldFocusGained(evt);
            }
        });
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, 360, 50));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, 360, 10));

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setText("Enter Pass");
        passwordField.setBorder(null);
        passwordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordField.setOpaque(false);
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 370, 40));

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 360, 10));

        signinButton.setBorder(null);
        signinButton.setBorderPainted(false);
        signinButton.setContentAreaFilled(false);
        signinButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinButtonActionPerformed(evt);
            }
        });
        jPanel1.add(signinButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 550, 140, 50));

        signupButton.setBorder(null);
        signupButton.setBorderPainted(false);
        signupButton.setContentAreaFilled(false);
        signupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        jPanel1.add(signupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 550, 130, 50));

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/image/close.png"))); // NOI18N
        exitButton.setBorder(null);
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, 30, 30));

        BackgroundLebel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/image/Webp.net-resizeimage.PNG"))); // NOI18N
        jPanel1.add(BackgroundLebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 320, 50));

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
    
//...................Start Custom Functions....................//

    private void clearTextField(){
        idField.setText("");
        passwordField.setText("");
    }
    
//...................End Custom Functions....................//
    
    
    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void idFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFieldFocusGained
        idField.setText("");
    }//GEN-LAST:event_idFieldFocusGained

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        passwordField.setText("");
    }//GEN-LAST:event_passwordFieldFocusGained

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        popUp pU = new popUp(account);
        
        pU.setVisible(true);
        pU.setResizable(false);
        
        pU.setDefaultCloseOperation(pU.DO_NOTHING_ON_CLOSE);
        
        logInPage lF = new logInPage();
        dispose();
    }//GEN-LAST:event_signupButtonActionPerformed
    
    private void signinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinButtonActionPerformed
        boolean userValid = false;
        try {
            userValid = account.accountLogin(idField.getText(),passwordField.getText(),rememberUserCheckbox.isSelected());
        } catch (SQLException ex) {
            Logger.getLogger(logInPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(userValid==true){
            dispose();
        }else{
            clearTextField();
        }     
    }//GEN-LAST:event_signinButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Quit", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void rememberUserCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberUserCheckboxActionPerformed
        
    }//GEN-LAST:event_rememberUserCheckboxActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            boolean userValid = false;
            try {
                userValid = account.accountLogin(idField.getText(), passwordField.getText(), false);
            } catch (SQLException ex) {
                Logger.getLogger(logInPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(userValid==true){
                dispose();
            }else{
                clearTextField();
            }
        }
    }//GEN-LAST:event_passwordFieldKeyPressed
    
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
            java.util.logging.Logger.getLogger(logInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logInPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLebel;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField idField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JCheckBox rememberUserCheckbox;
    private javax.swing.JButton signinButton;
    private javax.swing.JButton signupButton;
    // End of variables declaration//GEN-END:variables
}