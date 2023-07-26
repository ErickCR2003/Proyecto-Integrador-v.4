package Vst;

import Principal.Main;

public class VstMenuPrincipal extends javax.swing.JFrame {
  
    public VstMenuPrincipal() {
        initComponents();
        //-------------
        AsignarPermisos();
    }
    
    private void AsignarPermisos(){
    
        if (Main.UsrActual.getTipo().equals("EMPLEADO")) {
            BtnReporte.setEnabled(false);
            BtnEmpleados.setEnabled(false);
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
        BtnReporte = new javax.swing.JButton();
        jdesktoppnlContenedor = new javax.swing.JDesktopPane();
        BtnCerrarSesion = new javax.swing.JButton();
        BtnTipoHerr = new javax.swing.JButton();
        BtnAlquileres = new javax.swing.JButton();
        BtnHerramientas = new javax.swing.JButton();
        BtnClientes = new javax.swing.JButton();
        BtnHistorialFact = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnEmpleados = new javax.swing.JButton();
        BtnCaja = new javax.swing.JButton();
        BtnMantenimiento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1270, 820));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 23, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1265, 780));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnReporte.setBackground(new java.awt.Color(51, 0, 51));
        BtnReporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnReporte.setForeground(new java.awt.Color(255, 255, 255));
        BtnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cinco.gif"))); // NOI18N
        BtnReporte.setText("Reportes");
        BtnReporte.setAlignmentY(0.0F);
        BtnReporte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnReporte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(BtnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 150, 50));

        javax.swing.GroupLayout jdesktoppnlContenedorLayout = new javax.swing.GroupLayout(jdesktoppnlContenedor);
        jdesktoppnlContenedor.setLayout(jdesktoppnlContenedorLayout);
        jdesktoppnlContenedorLayout.setHorizontalGroup(
            jdesktoppnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        jdesktoppnlContenedorLayout.setVerticalGroup(
            jdesktoppnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        jPanel1.add(jdesktoppnlContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1120, 780));

        BtnCerrarSesion.setBackground(new java.awt.Color(0, 0, 0));
        BtnCerrarSesion.setForeground(new java.awt.Color(204, 0, 0));
        BtnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cerrar Sesion 28x32.png"))); // NOI18N
        BtnCerrarSesion.setText("Cerrar Sesión");
        BtnCerrarSesion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 150, 60));

        BtnTipoHerr.setBackground(new java.awt.Color(51, 0, 51));
        BtnTipoHerr.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnTipoHerr.setForeground(new java.awt.Color(255, 255, 255));
        BtnTipoHerr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuatro.gif"))); // NOI18N
        BtnTipoHerr.setText("Tipos de Herr.");
        BtnTipoHerr.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnTipoHerr.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnTipoHerr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTipoHerrActionPerformed(evt);
            }
        });
        jPanel1.add(BtnTipoHerr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 150, 50));

        BtnAlquileres.setBackground(new java.awt.Color(51, 0, 51));
        BtnAlquileres.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnAlquileres.setForeground(new java.awt.Color(255, 255, 255));
        BtnAlquileres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/uno.gif"))); // NOI18N
        BtnAlquileres.setText("Alquileres");
        BtnAlquileres.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnAlquileres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlquileresActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAlquileres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 150, 50));

        BtnHerramientas.setBackground(new java.awt.Color(51, 0, 51));
        BtnHerramientas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnHerramientas.setForeground(new java.awt.Color(255, 255, 255));
        BtnHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dos.gif"))); // NOI18N
        BtnHerramientas.setText("Herramientas");
        BtnHerramientas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnHerramientas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHerramientasActionPerformed(evt);
            }
        });
        jPanel1.add(BtnHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 150, 50));

        BtnClientes.setBackground(new java.awt.Color(51, 0, 51));
        BtnClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnClientes.setForeground(new java.awt.Color(255, 255, 255));
        BtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tres.gif"))); // NOI18N
        BtnClientes.setText("Registro Clientes");
        BtnClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        BtnClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnClientes.setMargin(new java.awt.Insets(1, 1, 1, 1));
        BtnClientes.setMaximumSize(new java.awt.Dimension(110, 37));
        BtnClientes.setMinimumSize(new java.awt.Dimension(110, 37));
        BtnClientes.setPreferredSize(new java.awt.Dimension(110, 37));
        BtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(BtnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 150, 50));

        BtnHistorialFact.setBackground(new java.awt.Color(51, 0, 51));
        BtnHistorialFact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnHistorialFact.setForeground(new java.awt.Color(255, 255, 255));
        BtnHistorialFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cinco.gif"))); // NOI18N
        BtnHistorialFact.setText("Historial Facturas");
        BtnHistorialFact.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.add(BtnHistorialFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 150, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 110));

        BtnEmpleados.setBackground(new java.awt.Color(51, 0, 51));
        BtnEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        BtnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siete.gif"))); // NOI18N
        BtnEmpleados.setText("Adm. Empleados");
        BtnEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 150, 50));

        BtnCaja.setBackground(new java.awt.Color(51, 0, 51));
        BtnCaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnCaja.setForeground(new java.awt.Color(255, 255, 255));
        BtnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caja2.png"))); // NOI18N
        BtnCaja.setText("Caja");
        BtnCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCajaActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 150, 50));

        BtnMantenimiento.setBackground(new java.awt.Color(51, 0, 51));
        BtnMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        BtnMantenimiento.setText("Mantenimiento");
        BtnMantenimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        BtnMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMantenimientoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1265, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnReporteActionPerformed

    private void BtnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEmpleadosActionPerformed

    private void BtnTipoHerrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTipoHerrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnTipoHerrActionPerformed

    private void BtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnClientesActionPerformed

    private void BtnHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHerramientasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnHerramientasActionPerformed

    private void BtnAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlquileresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnAlquileresActionPerformed

    private void BtnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCajaActionPerformed

    private void BtnMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnMantenimientoActionPerformed

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
            java.util.logging.Logger.getLogger(VstMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            new VstMenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnAlquileres;
    public javax.swing.JButton BtnCaja;
    public javax.swing.JButton BtnCerrarSesion;
    public javax.swing.JButton BtnClientes;
    public javax.swing.JButton BtnEmpleados;
    public javax.swing.JButton BtnHerramientas;
    public javax.swing.JButton BtnHistorialFact;
    public javax.swing.JButton BtnMantenimiento;
    public javax.swing.JButton BtnReporte;
    public javax.swing.JButton BtnTipoHerr;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JDesktopPane jdesktoppnlContenedor;
    // End of variables declaration//GEN-END:variables
}
