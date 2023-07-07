/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vst;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class VstLogin extends javax.swing.JFrame {

    public VstLogin() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtnIniciarSesion = new javax.swing.JButton();
        jpswContraseña = new javax.swing.JPasswordField();
        jtxtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 23, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inicia Sesión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnIniciarSesion.setBackground(new java.awt.Color(13, 101, 5));
        jbtnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jbtnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jbtnIniciarSesion.setText("Iniciar Sesión");
        jbtnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 180, 50));

        jpswContraseña.setForeground(new java.awt.Color(153, 153, 153));
        jpswContraseña.setText("**********");
        jpswContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpswContraseñaMousePressed(evt);
            }
        });
        jpswContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpswContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(jpswContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 180, 40));

        jtxtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jtxtUsuario.setText("Usuario");
        jtxtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtUsuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtxtUsuarioMousePressed(evt);
            }
        });
        jPanel1.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario-1.gif"))); // NOI18N
        jLabel2.setText("jLabel1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 40, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Contraseña-1.gif"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 280, 320));

        jlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Portada-1.gif"))); // NOI18N
        getContentPane().add(jlblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpswContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpswContraseñaActionPerformed
        
    }//GEN-LAST:event_jpswContraseñaActionPerformed

    private void jtxtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtUsuarioMouseClicked
        
    }//GEN-LAST:event_jtxtUsuarioMouseClicked

    private void jtxtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtUsuarioMousePressed
        if (jtxtUsuario.getText().equals("Usuario")){
            jtxtUsuario.setText("");
            jtxtUsuario.setForeground(Color.BLACK);            
        }
        if (String.valueOf(jpswContraseña.getPassword()).equals("") || String.valueOf(jpswContraseña.getPassword()) == null || String.valueOf(jpswContraseña.getPassword()).equals(" "))
                jpswContraseña.setText("**********");
            jpswContraseña.setForeground(Color.GRAY);
    }//GEN-LAST:event_jtxtUsuarioMousePressed

    private void jpswContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpswContraseñaMousePressed
        if (String.valueOf(jpswContraseña.getPassword()).equals("**********")){
            jpswContraseña.setText("");
            jpswContraseña.setForeground(Color.BLACK);
        }
        if (jtxtUsuario.getText().equals("") || jtxtUsuario.getText() == null || jtxtUsuario.getText().equals(" "))
                jtxtUsuario.setText("Usuario");
        jtxtUsuario.setForeground(Color.GRAY);
    }//GEN-LAST:event_jpswContraseñaMousePressed

    private void jbtnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnIniciarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VstLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtnIniciarSesion;
    private javax.swing.JLabel jlblFondo;
    public javax.swing.JPasswordField jpswContraseña;
    public javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
