/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vst.Herramienta;

/**
 *
 * @author admin
 */
public class VstHerramienta_Lista extends javax.swing.JInternalFrame {

    /**
     * Creates new form Admin_Vuelos1
     */
    public VstHerramienta_Lista() {
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

        jpnlPestañaAdministrarVuelos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jbtnAñadirHerramientaNueva = new javax.swing.JButton();
        jbtnEditarHerramienta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblTablaDeHerramientas = new javax.swing.JTable();
        jbtnBuscarHerramienta = new javax.swing.JButton();
        jlblNumeroDeHerramientas = new javax.swing.JLabel();
        jcbxTipoHerramienta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jbtnInformacionHerramienta = new javax.swing.JButton();
        jbtnReiniciar = new javax.swing.JButton();
        jbtnMantenimiento = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1121, 784));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlPestañaAdministrarVuelos.setBackground(new java.awt.Color(27, 23, 51));
        jpnlPestañaAdministrarVuelos.setMinimumSize(new java.awt.Dimension(930, 490));
        jpnlPestañaAdministrarVuelos.setPreferredSize(new java.awt.Dimension(930, 490));
        jpnlPestañaAdministrarVuelos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(30, 151, 196));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("REGISTRO DE HERRAMIENTAS");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

        jpnlPestañaAdministrarVuelos.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1090, 30));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jpnlPestañaAdministrarVuelos.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 1090, 10));

        jbtnAñadirHerramientaNueva.setBackground(new java.awt.Color(102, 0, 51));
        jbtnAñadirHerramientaNueva.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAñadirHerramientaNueva.setText("Nueva Herrramienta ");
        jpnlPestañaAdministrarVuelos.add(jbtnAñadirHerramientaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, 40));

        jbtnEditarHerramienta.setBackground(new java.awt.Color(102, 0, 51));
        jbtnEditarHerramienta.setForeground(new java.awt.Color(255, 255, 255));
        jbtnEditarHerramienta.setText("Editar");
        jpnlPestañaAdministrarVuelos.add(jbtnEditarHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 120, 40));

        jtblTablaDeHerramientas.setBackground(new java.awt.Color(217, 217, 217));
        jtblTablaDeHerramientas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblTablaDeHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTablaDeHerramientasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblTablaDeHerramientas);

        jpnlPestañaAdministrarVuelos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, 1090, 560));

        jbtnBuscarHerramienta.setBackground(new java.awt.Color(153, 0, 0));
        jbtnBuscarHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar 24x24.png"))); // NOI18N
        jpnlPestañaAdministrarVuelos.add(jbtnBuscarHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 60, 40));

        jlblNumeroDeHerramientas.setBackground(new java.awt.Color(102, 0, 51));
        jlblNumeroDeHerramientas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlblNumeroDeHerramientas.setForeground(new java.awt.Color(255, 255, 255));
        jlblNumeroDeHerramientas.setText("Numero de Registros: ");
        jlblNumeroDeHerramientas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnlPestañaAdministrarVuelos.add(jlblNumeroDeHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 695, 220, 40));

        jcbxTipoHerramienta.setBackground(new java.awt.Color(217, 217, 217));
        jcbxTipoHerramienta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        jpnlPestañaAdministrarVuelos.add(jcbxTipoHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TIPO DE HERRAMIENTA");
        jpnlPestañaAdministrarVuelos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, -1));

        jbtnInformacionHerramienta.setBackground(new java.awt.Color(102, 0, 51));
        jbtnInformacionHerramienta.setForeground(new java.awt.Color(255, 255, 255));
        jbtnInformacionHerramienta.setText("Info. Herramienta");
        jpnlPestañaAdministrarVuelos.add(jbtnInformacionHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 130, 40));

        jbtnReiniciar.setBackground(new java.awt.Color(0, 102, 153));
        jbtnReiniciar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnReiniciar.setText("Actualizar lista");
        jpnlPestañaAdministrarVuelos.add(jbtnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 140, 40));

        jbtnMantenimiento.setBackground(new java.awt.Color(102, 0, 51));
        jbtnMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        jbtnMantenimiento.setText("MANTENIMIENTO");
        jpnlPestañaAdministrarVuelos.add(jbtnMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 130, 40));

        getContentPane().add(jpnlPestañaAdministrarVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblTablaDeHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblTablaDeHerramientasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblTablaDeHerramientasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton jbtnAñadirHerramientaNueva;
    public javax.swing.JButton jbtnBuscarHerramienta;
    public javax.swing.JButton jbtnEditarHerramienta;
    public javax.swing.JButton jbtnInformacionHerramienta;
    public javax.swing.JButton jbtnMantenimiento;
    public javax.swing.JButton jbtnReiniciar;
    public javax.swing.JComboBox<String> jcbxTipoHerramienta;
    public javax.swing.JLabel jlblNumeroDeHerramientas;
    private javax.swing.JPanel jpnlPestañaAdministrarVuelos;
    public javax.swing.JTable jtblTablaDeHerramientas;
    // End of variables declaration//GEN-END:variables
}
