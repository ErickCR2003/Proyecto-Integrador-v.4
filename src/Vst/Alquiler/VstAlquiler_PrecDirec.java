/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vst.Alquiler;

/**
 *
 * @author admin
 */
public class VstAlquiler_PrecDirec extends javax.swing.JFrame {

    /**
     * Creates new form PrecioDireccion
     */
    public VstAlquiler_PrecDirec() {
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

        jPanel2 = new javax.swing.JPanel();
        jlblDireccion = new javax.swing.JLabel();
        jbtnCancelar = new javax.swing.JButton();
        jbtnConfirmar = new javax.swing.JButton();
        jtxtprecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(27, 23, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRECIO DEL DELIVERY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jlblDireccion.setText("DIRECCION: ");
        jPanel2.add(jlblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 290, 30));

        jbtnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        jbtnCancelar.setText("CANCELAR");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 130, 30));

        jbtnConfirmar.setBackground(new java.awt.Color(13, 101, 5));
        jbtnConfirmar.setText("CONFIRMAR");
        jPanel2.add(jbtnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 30));

        jtxtprecio.setBackground(new java.awt.Color(217, 217, 217));
        jtxtprecio.setText("0.0");
        jPanel2.add(jtxtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 290, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRECIO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VstAlquiler_PrecDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstAlquiler_PrecDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstAlquiler_PrecDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstAlquiler_PrecDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstAlquiler_PrecDirec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton jbtnCancelar;
    public javax.swing.JButton jbtnConfirmar;
    public javax.swing.JLabel jlblDireccion;
    public javax.swing.JTextField jtxtprecio;
    // End of variables declaration//GEN-END:variables
}