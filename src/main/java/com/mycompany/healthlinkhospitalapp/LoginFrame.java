

package com.mycompany.healthlinkhospitalapp;

import Model.Login;
import javax.swing.JOptionPane;

import Presenter.PatientPersister;

import Model.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.cache.*;



public class LoginFrame extends javax.swing.JFrame {
    
    private PatientPersister patientPersister;
    private Login login = new Login();

    /** Creates new form LoginFrame */
    public LoginFrame() {
        initComponents();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        closeBt = new javax.swing.JButton();
        loginBt = new javax.swing.JButton();
        regisBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 249, -1));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, -1));

        txtPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 249, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, -1, -1));

        closeBt.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        closeBt.setText("Close");
        closeBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtActionPerformed(evt);
            }
        });
        jPanel1.add(closeBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 390, -1, -1));

        loginBt.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        loginBt.setText("Login");
        loginBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtActionPerformed(evt);
            }
        });
        jPanel1.add(loginBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, -1, -1));

        regisBt.setForeground(new java.awt.Color(51, 102, 255));
        regisBt.setText("Register");
        regisBt.setContentAreaFilled(false);
        regisBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisBtActionPerformed(evt);
            }
        });
        jPanel1.add(regisBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1359, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void loginBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        PatientPersister persister = new PatientPersister();
        
        Map<String, String> userDetails = persister.authenticateUser(username, password);
        if(userDetails != null){
            String role = userDetails.get("role");
            String retrievedUsername = userDetails.get("username");
            
<<<<<<< HEAD
            Home home = new Home(role, retrievedUsername);
=======
            this.login.setName(retrievedUsername);
            
            Home home = new Home(role, retrievedUsername, this.login);
>>>>>>> cec82c3 ([commit]-function)
            setVisible(false);
            if("admin".equals(role)){
                home.setVisible(true);
            }else if("staff".equals(role)){
                home.setVisible(true);
            }else{
                home.setVisible(true);
<<<<<<< HEAD
            }            
            
=======
            }
>>>>>>> cec82c3 ([commit]-function)
        }else
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
    }//GEN-LAST:event_loginBtActionPerformed

    private void closeBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null,"Do you want to close the Application?","Exit",JOptionPane.YES_NO_OPTION);
        if (a==0)
            System.exit(0);
    }//GEN-LAST:event_closeBtActionPerformed

    private void regisBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisBtActionPerformed
        // TODO add your handling code here:
        new UserRegister().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regisBtActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBt;
    private javax.swing.JButton regisBt;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
