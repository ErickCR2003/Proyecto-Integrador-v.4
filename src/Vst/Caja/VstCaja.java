/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vst.Caja;

import Vst.Reporte.*;
import Vst.Reporte.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author admin
 */
public class VstCaja extends javax.swing.JInternalFrame {

    /**
     * Creates new form prueba
     */
    public VstCaja() {
        initComponents();       
      
        jTabbedPane2.setEnabledAt(0, true);
        jTabbedPane2.setEnabledAt(1, true);
    }
    
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPestañaAdministrarUsuarios = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSalEfectivo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaIngEfectivo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaIngME = new javax.swing.JTable();
        total_hAlquiladas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fecha_desde = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        fecha_hasta = new com.toedter.calendar.JDateChooser();
        lbl2 = new javax.swing.JLabel();
        lblTotalME = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lblTotalEnCaja = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnActualizarListas = new javax.swing.JButton();
        btnRetiroDeCaja = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtImpRetiro = new javax.swing.JSpinner();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlPestañaAdministrarUsuarios.setBackground(new java.awt.Color(27, 23, 51));
        jpnlPestañaAdministrarUsuarios.setPreferredSize(new java.awt.Dimension(930, 490));
        jpnlPestañaAdministrarUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jpnlPestañaAdministrarUsuarios.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 1090, 10));

        jTabbedPane2.setBackground(new java.awt.Color(27, 23, 51));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(27, 23, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaSalEfectivo.setBackground(new java.awt.Color(217, 217, 217));
        tablaSalEfectivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaSalEfectivo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 500, 440));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SALIDAS EN EFECTIVO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 150, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("INGRESOS EN EFECTIVO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 150, -1));

        tablaIngEfectivo.setBackground(new java.awt.Color(217, 217, 217));
        tablaIngEfectivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaIngEfectivo);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 490, 440));

        jTabbedPane2.addTab("Efectivo", null, jPanel1, "");

        jPanel3.setBackground(new java.awt.Color(27, 23, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(1060, 735));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaIngME.setBackground(new java.awt.Color(217, 217, 217));
        tablaIngME.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaIngME);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 630, 430));

        total_hAlquiladas.setBackground(new java.awt.Color(102, 0, 51));
        total_hAlquiladas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total_hAlquiladas.setForeground(new java.awt.Color(255, 255, 255));
        total_hAlquiladas.setText("Total de herramientas alquiladas:");
        total_hAlquiladas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(total_hAlquiladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 290, 30));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("INGRESOS POR MEDIOS ELECTRONICOS");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 240, -1));

        jTabbedPane2.addTab("Medios Electrónicos (ME)", jPanel3);

        jpnlPestañaAdministrarUsuarios.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1080, 550));

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(51, 0, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CAJA");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 30));

        jpnlPestañaAdministrarUsuarios.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1070, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Desde");
        jpnlPestañaAdministrarUsuarios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jpnlPestañaAdministrarUsuarios.add(fecha_desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 150, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Monto a retirar:");
        jpnlPestañaAdministrarUsuarios.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 90, -1));
        jpnlPestañaAdministrarUsuarios.add(fecha_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 150, 30));

        lbl2.setBackground(new java.awt.Color(102, 0, 51));
        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("Total ingreso por M.E. en el día :");
        lbl2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpnlPestañaAdministrarUsuarios.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 230, 30));

        lblTotalME.setBackground(new java.awt.Color(102, 0, 51));
        lblTotalME.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalME.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalME.setText("S/ 0.00");
        lblTotalME.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnlPestañaAdministrarUsuarios.add(lblTotalME, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 100, 30));

        lbl1.setBackground(new java.awt.Color(102, 0, 51));
        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("Total Efectivo en caja            :");
        lbl1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpnlPestañaAdministrarUsuarios.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 230, 30));

        lblTotalEnCaja.setBackground(new java.awt.Color(102, 0, 51));
        lblTotalEnCaja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalEnCaja.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalEnCaja.setText("S/ 0.00");
        lblTotalEnCaja.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnlPestañaAdministrarUsuarios.add(lblTotalEnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 100, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hasta");
        jpnlPestañaAdministrarUsuarios.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        btnActualizarListas.setBackground(new java.awt.Color(0, 102, 153));
        btnActualizarListas.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarListas.setText("Actualizar listas");
        jpnlPestañaAdministrarUsuarios.add(btnActualizarListas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 130, 30));

        btnRetiroDeCaja.setBackground(new java.awt.Color(0, 153, 0));
        btnRetiroDeCaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRetiroDeCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiroDeCaja.setText("Retiro de Caja");
        jpnlPestañaAdministrarUsuarios.add(btnRetiroDeCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, 130, 30));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Lista de movimientos:");
        jpnlPestañaAdministrarUsuarios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, -1));
        jpnlPestañaAdministrarUsuarios.add(txtImpRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 110, 30));

        getContentPane().add(jpnlPestañaAdministrarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarListas;
    public javax.swing.JButton btnRetiroDeCaja;
    public com.toedter.calendar.JDateChooser fecha_desde;
    public com.toedter.calendar.JDateChooser fecha_hasta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JPanel jpnlPestañaAdministrarUsuarios;
    public javax.swing.JLabel lbl1;
    public javax.swing.JLabel lbl2;
    public javax.swing.JLabel lblTotalEnCaja;
    public javax.swing.JLabel lblTotalME;
    public javax.swing.JTable tablaIngEfectivo;
    public javax.swing.JTable tablaIngME;
    public javax.swing.JTable tablaSalEfectivo;
    public javax.swing.JLabel total_hAlquiladas;
    public javax.swing.JSpinner txtImpRetiro;
    // End of variables declaration//GEN-END:variables
}
