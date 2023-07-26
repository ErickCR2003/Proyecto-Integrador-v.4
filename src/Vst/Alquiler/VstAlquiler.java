/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vst.Alquiler;


import Formatos.Mensajes;
import Principal.Main;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JTable;

/**
 *
 * @author carra
 */
public class VstAlquiler extends javax.swing.JFrame {

    /**
     * Creates new form BuscarVuelos
     */
    public VstAlquiler() {
        initComponents();
        
        //this.setBorder(null);
    }
    
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
            java.util.logging.Logger.getLogger(VstAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VstAlquiler().setVisible(true);
        });
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
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTablaVenta = new javax.swing.JTable();
        jbtnEliminarCampos = new javax.swing.JButton();
        jtxtMarcaHerramienta = new javax.swing.JTextField();
        jtxtClienteCom = new javax.swing.JTextField();
        jtxtNumAlquiler = new javax.swing.JTextField();
        jtxtDirecciónObra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblBusquedaHerramientasAlquiler = new javax.swing.JTable();
        jbtnBuscarHerramienta = new javax.swing.JButton();
        jbtnCancelarCom = new javax.swing.JButton();
        jbtnAgregarCliente = new javax.swing.JButton();
        jbtnConfirmarAlquiler = new javax.swing.JButton();
        jcbxTipo = new javax.swing.JComboBox<>();
        btnActualizaTipos = new javax.swing.JButton();
        jcbxTraslado = new javax.swing.JComboBox<>();
        jspnDiasdeAlquiler = new javax.swing.JSpinner();
        jspnPrecioTraslado = new javax.swing.JSpinner();
        jbtnlimpiar = new javax.swing.JButton();
        lblNroHerram = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblTablaVenta1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jbtnEliminarCampos1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jspnCodigoLibro1 = new javax.swing.JSpinner();
        jtxtTituloLibro1 = new javax.swing.JTextField();
        jtxtClienteCom1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jtxtNumBoleta1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jtxtDirección1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblTablaLibros2 = new javax.swing.JTable();
        jbtnBuscarLibro2 = new javax.swing.JButton();
        jbtnCancelarCom1 = new javax.swing.JButton();
        jbtnAgregarClient1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jtxtCostoTotal1 = new javax.swing.JTextField();
        jbtnConfirmarCom1 = new javax.swing.JButton();
        jcbxeditorial1 = new javax.swing.JComboBox<>();
        jcbxAutor1 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jcbxtipolibro1 = new javax.swing.JComboBox<>();
        jbtnlimpiar1 = new javax.swing.JButton();
        jcbxDelivery1 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1121, 784));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(102, 0, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("BUSQUEDA Y ALQUILER DE HERRAMIENTAS");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1080, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1090, 30));

        jTabbedPane1.setBackground(new java.awt.Color(27, 23, 51));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(27, 23, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(780, 340));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblTablaVenta.setBackground(new java.awt.Color(217, 217, 217));
        jtblTablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nro. Serie", "Nombre", "Tipo", "Valor Referencial", "Peso", "Precio por Día", "Nro. Alquileres"
            }
        ));
        jScrollPane1.setViewportView(jtblTablaVenta);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 1060, 230));

        jbtnEliminarCampos.setBackground(new java.awt.Color(204, 0, 0));
        jbtnEliminarCampos.setForeground(new java.awt.Color(255, 255, 255));
        jbtnEliminarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tacho 20x24.png"))); // NOI18N
        jbtnEliminarCampos.setText("QUITAR HERR.");
        jPanel3.add(jbtnEliminarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 160, 40));

        jtxtMarcaHerramienta.setEditable(false);
        jtxtMarcaHerramienta.setBackground(new java.awt.Color(217, 217, 217));
        jtxtMarcaHerramienta.setForeground(new java.awt.Color(255, 255, 255));
        jtxtMarcaHerramienta.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre de la Herramienta"));
        jPanel3.add(jtxtMarcaHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 50));

        jtxtClienteCom.setEditable(false);
        jtxtClienteCom.setBackground(new java.awt.Color(217, 217, 217));
        jtxtClienteCom.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre Cliente"));
        jtxtClienteCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtClienteComActionPerformed(evt);
            }
        });
        jPanel3.add(jtxtClienteCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 300, 50));

        jtxtNumAlquiler.setEditable(false);
        jtxtNumAlquiler.setBackground(new java.awt.Color(217, 217, 217));
        jtxtNumAlquiler.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtNumAlquiler.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtNumAlquiler.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nro. Alquiler", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jtxtNumAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNumAlquilerActionPerformed(evt);
            }
        });
        jPanel3.add(jtxtNumAlquiler, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 280, 160, 60));

        jtxtDirecciónObra.setBackground(new java.awt.Color(217, 217, 217));
        jtxtDirecciónObra.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección de la Obra"));
        jPanel3.add(jtxtDirecciónObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 300, 50));

        jtblBusquedaHerramientasAlquiler.setBackground(new java.awt.Color(217, 217, 217));
        jtblBusquedaHerramientasAlquiler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nro. Serie", "Nombre", "Tipo", "Valor Referencial", "Peso", "Precio por Dia", "Nro. Alquileres"
            }
        ));
        jtblBusquedaHerramientasAlquiler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblBusquedaHerramientasAlquilerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblBusquedaHerramientasAlquiler);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1060, 190));

        jbtnBuscarHerramienta.setBackground(new java.awt.Color(27, 23, 51));
        jbtnBuscarHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar 24x24.png"))); // NOI18N
        jPanel3.add(jbtnBuscarHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 50, 40));

        jbtnCancelarCom.setBackground(new java.awt.Color(255, 51, 51));
        jbtnCancelarCom.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnCancelarCom.setText("CANCELAR");
        jPanel3.add(jbtnCancelarCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 170, 40));

        jbtnAgregarCliente.setBackground(new java.awt.Color(153, 0, 102));
        jbtnAgregarCliente.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarCliente.setText("AGREGAR CLIENTE");
        jPanel3.add(jbtnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 160, 50));

        jbtnConfirmarAlquiler.setBackground(new java.awt.Color(51, 153, 255));
        jbtnConfirmarAlquiler.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnConfirmarAlquiler.setText("PRE-VISUALIZAR");
        jPanel3.add(jbtnConfirmarAlquiler, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 170, 40));

        jcbxTipo.setBackground(new java.awt.Color(217, 217, 217));
        jcbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        jcbxTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        jPanel3.add(jcbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 160, 50));

        btnActualizaTipos.setBackground(new java.awt.Color(13, 101, 5));
        btnActualizaTipos.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizaTipos.setText("ACTUALIZAR TIPOS");
        btnActualizaTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaTiposActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizaTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 160, 40));

        jcbxTraslado.setBackground(new java.awt.Color(217, 217, 217));
        jcbxTraslado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SI", "NO" }));
        jcbxTraslado.setBorder(javax.swing.BorderFactory.createTitledBorder("Traslado"));
        jPanel3.add(jcbxTraslado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 160, 50));

        jspnDiasdeAlquiler.setBorder(javax.swing.BorderFactory.createTitledBorder("Días de Alquiler"));
        jPanel3.add(jspnDiasdeAlquiler, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 170, 50));

        jspnPrecioTraslado.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio del Traslado"));
        jPanel3.add(jspnPrecioTraslado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 170, 50));

        jbtnlimpiar.setBackground(new java.awt.Color(13, 101, 5));
        jbtnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnlimpiar.setText("LIMPIAR FILTROS");
        jbtnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnlimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 150, 40));

        lblNroHerram.setText(" ");
        jPanel3.add(lblNroHerram, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, 20));

        jTabbedPane1.addTab("HERRAMIENTAS", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1090, 680));

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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 1090, 10));

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1121, 784));
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(30, 151, 196));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(30, 151, 196));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("BUSQUEDA Y VENTA DE LIBROS");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1080, 20));

        jInternalFrame1.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1090, 30));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(780, 340));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblTablaVenta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Autor", "Editorial", "Tipo", "Num. Paginas", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane3.setViewportView(jtblTablaVenta1);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 1050, 200));

        jLabel19.setText("AUTOR DEL LIBRO");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 110, 20));

        jLabel20.setText("TÍTULO DEL LIBRO");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 110, 20));

        jbtnEliminarCampos1.setBackground(new java.awt.Color(153, 0, 0));
        jbtnEliminarCampos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tacho 20x24.png"))); // NOI18N
        jPanel6.add(jbtnEliminarCampos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 40, 40));

        jLabel21.setText("CÓDIGO");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));
        jPanel6.add(jspnCodigoLibro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 40));
        jPanel6.add(jtxtTituloLibro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 32, 160, 40));

        jtxtClienteCom1.setEditable(false);
        jPanel6.add(jtxtClienteCom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 300, 40));

        jLabel22.setText("DELIVERY");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 130, 20));

        jLabel23.setText("N° DE BOLETA");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 110, 20));

        jtxtNumBoleta1.setEditable(false);
        jtxtNumBoleta1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtNumBoleta1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtNumBoleta1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel6.add(jtxtNumBoleta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 160, 40));

        jLabel24.setText("DIRECCIÓN ");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 140, 20));
        jPanel6.add(jtxtDirección1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 300, 40));

        jtblTablaLibros2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Autor", "Editorial", "Tipo", "Precio", "Num. Paginas", "Stock"
            }
        ));
        jScrollPane4.setViewportView(jtblTablaLibros2);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1060, 200));

        jbtnBuscarLibro2.setBackground(new java.awt.Color(153, 0, 0));
        jbtnBuscarLibro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar 24x24.png"))); // NOI18N
        jPanel6.add(jbtnBuscarLibro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 50, 40));

        jbtnCancelarCom1.setBackground(new java.awt.Color(255, 51, 51));
        jbtnCancelarCom1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnCancelarCom1.setText("CANCELAR");
        jPanel6.add(jbtnCancelarCom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 120, 40));

        jbtnAgregarClient1.setBackground(new java.awt.Color(255, 153, 51));
        jbtnAgregarClient1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnAgregarClient1.setText("AGREGAR CLIENTE");
        jPanel6.add(jbtnAgregarClient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 160, 40));

        jLabel25.setText("EDITORIAL");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 80, 20));

        jLabel26.setText("COSTO TOTAL");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 350, 110, 20));

        jtxtCostoTotal1.setEditable(false);
        jtxtCostoTotal1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtCostoTotal1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(jtxtCostoTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 160, 40));

        jbtnConfirmarCom1.setBackground(new java.awt.Color(51, 153, 255));
        jbtnConfirmarCom1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jbtnConfirmarCom1.setText("CONFIRMAR");
        jPanel6.add(jbtnConfirmarCom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 120, 40));

        jcbxeditorial1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        jPanel6.add(jcbxeditorial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 32, 160, 40));

        jcbxAutor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        jPanel6.add(jcbxAutor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 32, 160, 40));

        jLabel27.setText("TIPO DE LIBRO");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 110, 20));

        jcbxtipolibro1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        jPanel6.add(jcbxtipolibro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 32, 160, 40));

        jbtnlimpiar1.setBackground(new java.awt.Color(0, 204, 204));
        jbtnlimpiar1.setText("LIMPIAR");
        jbtnlimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnlimpiar1ActionPerformed(evt);
            }
        });
        jPanel6.add(jbtnlimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 100, 40));

        jcbxDelivery1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SI", "NO" }));
        jPanel6.add(jcbxDelivery1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 140, 40));

        jLabel28.setText("NOMBRE DEL CLIENTE");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 20));

        jTabbedPane2.addTab("LIBROS", jPanel6);

        jInternalFrame1.getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1090, 680));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jInternalFrame1.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 1090, 10));

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizaTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizaTiposActionPerformed

    private void jbtnlimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnlimpiar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnlimpiar1ActionPerformed

    private void jtxtClienteComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtClienteComActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtClienteComActionPerformed

    private void jtblBusquedaHerramientasAlquilerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblBusquedaHerramientasAlquilerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblBusquedaHerramientasAlquilerMouseClicked

    private void jtxtNumAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNumAlquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNumAlquilerActionPerformed

    private void jbtnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnlimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnlimpiarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizaTipos;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JButton jbtnAgregarClient1;
    public javax.swing.JButton jbtnAgregarCliente;
    public javax.swing.JButton jbtnBuscarHerramienta;
    public javax.swing.JButton jbtnBuscarLibro2;
    public javax.swing.JButton jbtnCancelarCom;
    public javax.swing.JButton jbtnCancelarCom1;
    public javax.swing.JButton jbtnConfirmarAlquiler;
    public javax.swing.JButton jbtnConfirmarCom1;
    public javax.swing.JButton jbtnEliminarCampos;
    public javax.swing.JButton jbtnEliminarCampos1;
    public javax.swing.JButton jbtnlimpiar;
    public javax.swing.JButton jbtnlimpiar1;
    public javax.swing.JComboBox<String> jcbxAutor1;
    public javax.swing.JComboBox<String> jcbxDelivery1;
    public javax.swing.JComboBox<String> jcbxTipo;
    public javax.swing.JComboBox<String> jcbxTraslado;
    public javax.swing.JComboBox<String> jcbxeditorial1;
    public javax.swing.JComboBox<String> jcbxtipolibro1;
    public javax.swing.JSpinner jspnCodigoLibro1;
    public javax.swing.JSpinner jspnDiasdeAlquiler;
    public javax.swing.JSpinner jspnPrecioTraslado;
    public javax.swing.JTable jtblBusquedaHerramientasAlquiler;
    public javax.swing.JTable jtblTablaLibros2;
    public javax.swing.JTable jtblTablaVenta;
    public javax.swing.JTable jtblTablaVenta1;
    public javax.swing.JTextField jtxtClienteCom;
    public javax.swing.JTextField jtxtClienteCom1;
    public javax.swing.JTextField jtxtCostoTotal1;
    public javax.swing.JTextField jtxtDirección1;
    public javax.swing.JTextField jtxtDirecciónObra;
    public javax.swing.JTextField jtxtMarcaHerramienta;
    public javax.swing.JTextField jtxtNumAlquiler;
    public javax.swing.JTextField jtxtNumBoleta1;
    public javax.swing.JTextField jtxtTituloLibro1;
    public javax.swing.JLabel lblNroHerram;
    // End of variables declaration//GEN-END:variables
}
