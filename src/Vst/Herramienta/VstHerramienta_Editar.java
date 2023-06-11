/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vst.Herramienta;

import java.awt.Color;

/**
 *
 * @author User
 */
public class VstHerramienta_Editar extends javax.swing.JFrame {

    /**
     * Creates new form AgregarLibroNuevo
     */
    public VstHerramienta_Editar() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNroSerie = new javax.swing.JTextField();
        btnLimpiarDatos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbTipoHerramienta = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtPrecXdia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescrip = new javax.swing.JTextArea();
        txtPeso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAnioFabrica = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNroAlquileres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtImpValorRef = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jcbxEstado = new javax.swing.JComboBox<>();
        txtFecAdquisicion = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Herramienta Nueva");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 23, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Editar Herramienta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nro. Serie: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio por día (S/):");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 120, -1));

        txtNroSerie.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(txtNroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 140, 40));

        btnLimpiarDatos.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarDatos.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnLimpiarDatos.setText("Limpiar");
        jPanel1.add(btnLimpiarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 110, 50));

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 120, 50));

        cmbTipoHerramienta.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(cmbTipoHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 40));

        txtNombre.setBackground(new java.awt.Color(217, 217, 217));
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 320, 40));

        txtPrecXdia.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(txtPrecXdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 140, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripción:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, -1));

        txtDescrip.setBackground(new java.awt.Color(217, 217, 217));
        txtDescrip.setColumns(20);
        txtDescrip.setRows(5);
        txtDescrip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtDescrip);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 320, -1));

        txtPeso.setBackground(new java.awt.Color(217, 217, 217));
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesoKeyPressed(evt);
            }
        });
        jPanel1.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 140, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Peso (Kg):");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Año fabricación:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 130, -1));

        txtAnioFabrica.setBackground(new java.awt.Color(217, 217, 217));
        txtAnioFabrica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnioFabricaKeyPressed(evt);
            }
        });
        jPanel1.add(txtAnioFabrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 140, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha adquisición:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 130, -1));

        txtNroAlquileres.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(txtNroAlquileres, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 140, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nro. Alquileres: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 130, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Valor referencial (S/):");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 130, -1));

        txtImpValorRef.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.add(txtImpValorRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 140, 40));

        btnGuardar.setBackground(new java.awt.Color(51, 153, 255));
        btnGuardar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 120, 50));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 10, 320));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Estado:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 120, -1));

        jcbxEstado.setBackground(new java.awt.Color(217, 217, 217));
        jcbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "ALQUILADO", "EN MANTENIMIENTO" }));
        jPanel1.add(jcbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 320, 40));

        txtFecAdquisicion.setDateFormatString("yyyy-MM-dd");
        txtFecAdquisicion.setMaxSelectableDate(new java.util.Date(253370786512000L));
        txtFecAdquisicion.setMinSelectableDate(new java.util.Date(-2208966572000L));
        txtFecAdquisicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFecAdquisicionMousePressed(evt);
            }
        });
        jPanel1.add(txtFecAdquisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAnioFabricaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioFabricaKeyPressed
        // TODO add your handling code here:
        
        //para que solo acepte números
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtAnioFabricaKeyPressed

    private void txtPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyPressed
        // TODO add your handling code here:
        
        //para que acepte decimales
        char c=evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()){
            evt.consume();
        }               
        
//        try{
//            Double.parseDouble(txtPeso.getText()+evt.getKeyChar());
//        }catch(NumberFormatException e){
//            evt.consume();
//        }
    }//GEN-LAST:event_txtPesoKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFecAdquisicionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFecAdquisicionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFecAdquisicionMousePressed

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
            java.util.logging.Logger.getLogger(VstHerramienta_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstHerramienta_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstHerramienta_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstHerramienta_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstHerramienta_Editar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiarDatos;
    public javax.swing.JComboBox<String> cmbTipoHerramienta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> jcbxEstado;
    public javax.swing.JTextField txtAnioFabrica;
    public javax.swing.JTextArea txtDescrip;
    public com.toedter.calendar.JDateChooser txtFecAdquisicion;
    public javax.swing.JTextField txtImpValorRef;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNroAlquileres;
    public javax.swing.JTextField txtNroSerie;
    public javax.swing.JTextField txtPeso;
    public javax.swing.JTextField txtPrecXdia;
    // End of variables declaration//GEN-END:variables
}
