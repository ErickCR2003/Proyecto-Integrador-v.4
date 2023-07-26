/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vst.Alquiler;

/**
 *
 * @author admin
 */
public class VstAlquiler_Confirmar extends javax.swing.JFrame {

    /**
     * Creates new form ConfirmarCompra
     */
    public VstAlquiler_Confirmar() {
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
        jbtnConfirmarCompra = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtxaBorradorRecibo = new javax.swing.JTextArea();
        jbtnCancelarCompra = new javax.swing.JButton();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNroTransaccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Borrador Alquiler");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 23, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnConfirmarCompra.setBackground(new java.awt.Color(13, 101, 5));
        jbtnConfirmarCompra.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnConfirmarCompra.setForeground(new java.awt.Color(255, 255, 255));
        jbtnConfirmarCompra.setText("Confirmar");
        jPanel1.add(jbtnConfirmarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 100, 40));

        jtxaBorradorRecibo.setEditable(false);
        jtxaBorradorRecibo.setBackground(new java.awt.Color(217, 217, 217));
        jtxaBorradorRecibo.setColumns(20);
        jtxaBorradorRecibo.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jtxaBorradorRecibo.setRows(5);
        jScrollPane5.setViewportView(jtxaBorradorRecibo);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 390));

        jbtnCancelarCompra.setBackground(new java.awt.Color(204, 0, 0));
        jbtnCancelarCompra.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnCancelarCompra.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCancelarCompra.setText("Cancelar");
        jbtnCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarCompraActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCancelarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 90, 40));

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Electrónico", " " }));
        jPanel1.add(cmbTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 120, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nro. Transacción:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Forma de pago:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        txtNroTransaccion.setText("-");
        txtNroTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroTransaccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtNroTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCancelarCompraActionPerformed

    private void txtNroTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroTransaccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroTransaccionActionPerformed

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
            java.util.logging.Logger.getLogger(VstAlquiler_Confirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstAlquiler_Confirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstAlquiler_Confirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstAlquiler_Confirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstAlquiler_Confirmar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JButton jbtnCancelarCompra;
    public javax.swing.JButton jbtnConfirmarCompra;
    public javax.swing.JTextArea jtxaBorradorRecibo;
    public javax.swing.JTextField txtNroTransaccion;
    // End of variables declaration//GEN-END:variables
}
