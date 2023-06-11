/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vst.Cliente;

/**
 *
 * @author User
 */
public class VstCliente_Nvo extends javax.swing.JFrame {

    /**
     * Creates new form AñadirRegistroClientes
     */
    public VstCliente_Nvo() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jtxtNombreCompleto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtNumerodeIdentificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtDireccion = new javax.swing.JTextField();
        jbtnRegistrar = new javax.swing.JButton();
        jdtcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 23, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre Completo: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 150, -1));

        jtxtNombreCompleto.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(jtxtNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero de identificacion: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jtxtNumerodeIdentificacion.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(jtxtNumerodeIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 150, 40));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jtxtTelefono.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(jtxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, 40));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        jtxtDireccion.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 150, 40));

        jbtnRegistrar.setBackground(new java.awt.Color(153, 0, 102));
        jbtnRegistrar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jbtnRegistrar.setText("Registrar");
        jbtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 250, 50));

        jdtcFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        jdtcFechaNacimiento.setMaxSelectableDate(new java.util.Date(253370786512000L));
        jdtcFechaNacimiento.setMinSelectableDate(new java.util.Date(-2208966572000L));
        jdtcFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jdtcFechaNacimientoMousePressed(evt);
            }
        });
        jPanel1.add(jdtcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 150, 40));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdtcFechaNacimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdtcFechaNacimientoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdtcFechaNacimientoMousePressed

    private void jbtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegistrarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jbtnRegistrarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstCliente_Nvo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VstCliente_Nvo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtnRegistrar;
    public com.toedter.calendar.JDateChooser jdtcFechaNacimiento;
    public javax.swing.JTextField jtxtDireccion;
    public javax.swing.JTextField jtxtNombreCompleto;
    public javax.swing.JTextField jtxtNumerodeIdentificacion;
    public javax.swing.JTextField jtxtTelefono;
    // End of variables declaration//GEN-END:variables
}