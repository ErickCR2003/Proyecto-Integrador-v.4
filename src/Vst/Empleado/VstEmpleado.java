/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vst.Empleado;


import java.awt.Color;

/**
 *
 * @author admin
 */
public class VstEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form AñadirUsuarios
     */
    public VstEmpleado() {
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
        txtApellidos = new javax.swing.JTextField();
        txtNumeroCelular = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jtxtNombres = new javax.swing.JTextField();
        cmbTipoEmpleado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtConfirmarContraseña = new javax.swing.JPasswordField();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 23, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(320, 490));
        jPanel1.setMinimumSize(new java.awt.Dimension(320, 490));
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 490));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtApellidos.setBackground(new java.awt.Color(217, 217, 217));
        txtApellidos.setText("Apellidos");
        txtApellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidosMousePressed(evt);
            }
        });
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 40));

        txtNumeroCelular.setBackground(new java.awt.Color(217, 217, 217));
        txtNumeroCelular.setText("Número de celular");
        txtNumeroCelular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNumeroCelularMousePressed(evt);
            }
        });
        jPanel1.add(txtNumeroCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 130, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Género:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 60, -1));

        cmbGenero.setBackground(new java.awt.Color(217, 217, 217));
        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        jPanel1.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 130, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 140, -1));

        btnGuardar.setBackground(new java.awt.Color(51, 153, 255));
        btnGuardar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 250, 40));

        jtxtNombres.setBackground(new java.awt.Color(217, 217, 217));
        jtxtNombres.setText("Nombres");
        jtxtNombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtxtNombresMousePressed(evt);
            }
        });
        jPanel1.add(jtxtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 40));

        cmbTipoEmpleado.setBackground(new java.awt.Color(217, 217, 217));
        cmbTipoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "EMPLEADO" }));
        jPanel1.add(cmbTipoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 130, 40));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de empleado:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 130, -1));

        txtConfirmarContraseña.setBackground(new java.awt.Color(217, 217, 217));
        txtConfirmarContraseña.setText("**********");
        txtConfirmarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtConfirmarContraseñaMousePressed(evt);
            }
        });
        jPanel1.add(txtConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 130, 40));

        txtContraseña.setBackground(new java.awt.Color(217, 217, 217));
        txtContraseña.setText("**********");
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseñaMousePressed(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 130, 40));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingresar contaseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 130, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirmar contaseña:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 130, -1));

        txtCorreo.setBackground(new java.awt.Color(217, 217, 217));
        txtCorreo.setText("Correo Electrónico");
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoMousePressed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 130, 40));

        txtDNI.setBackground(new java.awt.Color(217, 217, 217));
        txtDNI.setText("DNI");
        txtDNI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDNIMousePressed(evt);
            }
        });
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 130, 40));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 70, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 70, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DNI:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 70, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Número de celular:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 110, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Correo Electrónico:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, -1));

        txtUsuario.setBackground(new java.awt.Color(217, 217, 217));
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 130, 40));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 70, -1));

        chkActivo.setBackground(new java.awt.Color(217, 217, 217));
        chkActivo.setText("Activo");
        jPanel1.add(chkActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Estado del Usuario: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        txtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        txtFechaNacimiento.setMaxSelectableDate(new java.util.Date(253370786512000L));
        txtFechaNacimiento.setMinSelectableDate(new java.util.Date(-2208966572000L));
        txtFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoMousePressed(evt);
            }
        });
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jtxtNombresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtNombresMousePressed
        if (jtxtNombres.getText().equals("Nombres")){
            jtxtNombres.setText("");
            jtxtNombres.setForeground(Color.BLACK);            
        }
        if (txtApellidos.getText().equals("") || txtApellidos.getText() == null || txtApellidos.getText().equals(" "))
                txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(Color.GRAY);
            if (txtNumeroCelular.getText().equals("") || txtNumeroCelular.getText() == null || txtNumeroCelular.getText().equals(" "))
                txtNumeroCelular.setText("Número de celular");
            txtNumeroCelular.setForeground(Color.GRAY);
            if (txtCorreo.getText().equals("") || txtCorreo.getText() == null || txtCorreo.getText().equals(" "))
                txtCorreo.setText("Correo Electrónico");
            txtCorreo.setForeground(Color.GRAY);
            if (txtDNI.getText().equals("") || txtDNI.getText() == null || txtDNI.getText().equals(" "))
                txtDNI.setText("DNI");
            txtDNI.setForeground(Color.GRAY);
            if (String.valueOf(txtContraseña.getPassword()).equals("") || String.valueOf(txtContraseña.getPassword()) == null || String.valueOf(txtContraseña.getPassword()).equals(" "))
                txtContraseña.setText("**********");
            txtContraseña.setForeground(Color.GRAY);
            if (String.valueOf(txtConfirmarContraseña.getPassword()).equals("") || String.valueOf(txtConfirmarContraseña.getPassword()) == null || String.valueOf(txtConfirmarContraseña.getPassword()).equals(" "))
                txtConfirmarContraseña.setText("**********");
            txtConfirmarContraseña.setForeground(Color.GRAY);
            
    }//GEN-LAST:event_jtxtNombresMousePressed

    private void txtApellidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosMousePressed
        if (txtApellidos.getText().equals("Apellidos")){
            txtApellidos.setText("");
            txtApellidos.setForeground(Color.BLACK);            
        }
        if (jtxtNombres.getText().equals("") || jtxtNombres.getText() == null || jtxtNombres.getText().equals(" "))
                jtxtNombres.setText("Nombres");
                jtxtNombres.setForeground(Color.GRAY);
            if (txtNumeroCelular.getText().equals("") || txtNumeroCelular.getText() == null || txtNumeroCelular.getText().equals(" "))
                txtNumeroCelular.setText("Número de celular");
            txtNumeroCelular.setForeground(Color.GRAY);
            if (txtCorreo.getText().equals("") || txtCorreo.getText() == null || txtCorreo.getText().equals(" "))
                txtCorreo.setText("Correo Electrónico");
            txtCorreo.setForeground(Color.GRAY);
            if (txtDNI.getText().equals("") || txtDNI.getText() == null || txtDNI.getText().equals(" "))
                txtDNI.setText("DNI");
            txtDNI.setForeground(Color.GRAY);
            if (String.valueOf(txtContraseña.getPassword()).equals("") || String.valueOf(txtContraseña.getPassword()) == null || String.valueOf(txtContraseña.getPassword()).equals(" "))
                txtContraseña.setText("**********");
            txtContraseña.setForeground(Color.GRAY);
            if (String.valueOf(txtConfirmarContraseña.getPassword()).equals("") || String.valueOf(txtConfirmarContraseña.getPassword()) == null || String.valueOf(txtConfirmarContraseña.getPassword()).equals(" "))
                txtConfirmarContraseña.setText("**********");
            txtConfirmarContraseña.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtApellidosMousePressed

    private void txtNumeroCelularMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumeroCelularMousePressed
        if (txtNumeroCelular.getText().equals("Número de celular")){
            txtNumeroCelular.setText("");
            txtNumeroCelular.setForeground(Color.BLACK);
        }
        if (jtxtNombres.getText().equals("") || jtxtNombres.getText() == null || jtxtNombres.getText().equals(" "))
                jtxtNombres.setText("Nombres");
                jtxtNombres.setForeground(Color.GRAY);
            if (txtApellidos.getText().equals("") || txtApellidos.getText() == null || txtApellidos.getText().equals(" "))
                txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(Color.GRAY);
            if (txtCorreo.getText().equals("") || txtCorreo.getText() == null || txtCorreo.getText().equals(" "))
                txtCorreo.setText("Correo Electrónico");
            txtCorreo.setForeground(Color.GRAY);
            if (txtDNI.getText().equals("") || txtDNI.getText() == null || txtDNI.getText().equals(" "))
                txtDNI.setText("DNI");
            txtDNI.setForeground(Color.GRAY);
            if (String.valueOf(txtContraseña.getPassword()).equals("") || String.valueOf(txtContraseña.getPassword()) == null || String.valueOf(txtContraseña.getPassword()).equals(" "))
                txtContraseña.setText("**********");
            txtContraseña.setForeground(Color.GRAY);
            if (String.valueOf(txtConfirmarContraseña.getPassword()).equals("") || String.valueOf(txtConfirmarContraseña.getPassword()) == null || String.valueOf(txtConfirmarContraseña.getPassword()).equals(" "))
                txtConfirmarContraseña.setText("**********");
            txtConfirmarContraseña.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtNumeroCelularMousePressed

    private void txtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMousePressed
        if (String.valueOf(txtContraseña.getPassword()).equals("**********")){
            txtContraseña.setText("");
            txtContraseña.setForeground(Color.BLACK);
        }
        if (jtxtNombres.getText().equals("") || jtxtNombres.getText() == null || jtxtNombres.getText().equals(" "))
                jtxtNombres.setText("Nombres");
                jtxtNombres.setForeground(Color.GRAY);
            if (txtApellidos.getText().equals("") || txtApellidos.getText() == null || txtApellidos.getText().equals(" "))
                txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(Color.GRAY);
            if (txtNumeroCelular.getText().equals("") || txtNumeroCelular.getText() == null || txtNumeroCelular.getText().equals(" "))
                txtNumeroCelular.setText("Número de celular");
            txtNumeroCelular.setForeground(Color.GRAY);
            if (txtCorreo.getText().equals("") || txtCorreo.getText() == null || txtCorreo.getText().equals(" "))
                txtCorreo.setText("Correo Electrónico");
            txtCorreo.setForeground(Color.GRAY);
            if (txtDNI.getText().equals("") || txtDNI.getText() == null || txtDNI.getText().equals(" "))
                txtDNI.setText("DNI");
            txtDNI.setForeground(Color.GRAY);
            if (String.valueOf(txtConfirmarContraseña.getPassword()).equals("") || String.valueOf(txtConfirmarContraseña.getPassword()) == null || String.valueOf(txtConfirmarContraseña.getPassword()).equals(" "))
                txtConfirmarContraseña.setText("**********");
            txtConfirmarContraseña.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtContraseñaMousePressed

    private void txtConfirmarContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfirmarContraseñaMousePressed
        if (String.valueOf(txtConfirmarContraseña.getPassword()).equals("**********")){
            txtConfirmarContraseña.setText("");
            txtConfirmarContraseña.setForeground(Color.BLACK);
        }
//        if (jtxtNombres.getText().equals("") || jtxtNombres.getText() == null || jtxtNombres.getText().equals(" "))
//                jtxtNombres.setText("Nombres");
//                jtxtNombres.setForeground(Color.GRAY);
//            if (txtApellidos.getText().equals("") || txtApellidos.getText() == null || txtApellidos.getText().equals(" "))
//                txtApellidos.setText("Apellidos");
//            txtApellidos.setForeground(Color.GRAY);
//            if (txtNumeroCelular.getText().equals("") || txtNumeroCelular.getText() == null || txtNumeroCelular.getText().equals(" "))
//                txtNumeroCelular.setText("Número de celular");
//            txtNumeroCelular.setForeground(Color.GRAY);
//            if (txtCorreo.getText().equals("") || txtCorreo.getText() == null || txtCorreo.getText().equals(" "))
//                txtCorreo.setText("Correo Electrónico");
//            txtCorreo.setForeground(Color.GRAY);
//            if (txtDNI.getText().equals("") || txtDNI.getText() == null || txtDNI.getText().equals(" "))
//                txtDNI.setText("DNI");
//            txtDNI.setForeground(Color.GRAY);
//            if (String.valueOf(txtContraseña.getPassword()).equals("") || String.valueOf(txtContraseña.getPassword()) == null || String.valueOf(txtContraseña.getPassword()).equals(" "))
//                txtContraseña.setText("**********");
//            txtContraseña.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtConfirmarContraseñaMousePressed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMousePressed
        if (txtCorreo.getText().equals("Correo Electrónico")){
            txtCorreo.setText("");
            txtCorreo.setForeground(Color.BLACK);
        }
        if (jtxtNombres.getText().equals("") || jtxtNombres.getText() == null || jtxtNombres.getText().equals(" "))
                jtxtNombres.setText("Nombres");
                jtxtNombres.setForeground(Color.GRAY);
            if (txtApellidos.getText().equals("") || txtApellidos.getText() == null || txtApellidos.getText().equals(" "))
                txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(Color.GRAY);
            if (txtNumeroCelular.getText().equals("") || txtNumeroCelular.getText() == null || txtNumeroCelular.getText().equals(" "))
                txtNumeroCelular.setText("Número de celular");
            txtNumeroCelular.setForeground(Color.GRAY);
            if (txtDNI.getText().equals("") || txtDNI.getText() == null || txtDNI.getText().equals(" "))
                txtDNI.setText("DNI");
            txtDNI.setForeground(Color.GRAY);
            if (String.valueOf(txtContraseña.getPassword()).equals("") || String.valueOf(txtContraseña.getPassword()) == null || String.valueOf(txtContraseña.getPassword()).equals(" "))
                txtContraseña.setText("**********");
            txtContraseña.setForeground(Color.GRAY);
            if (String.valueOf(txtConfirmarContraseña.getPassword()).equals("") || String.valueOf(txtConfirmarContraseña.getPassword()) == null || String.valueOf(txtConfirmarContraseña.getPassword()).equals(" "))
                txtConfirmarContraseña.setText("**********");
            txtConfirmarContraseña.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtCorreoMousePressed

    private void txtDNIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDNIMousePressed
        if (txtDNI.getText().equals("DNI")){
            txtDNI.setText("");
            txtDNI.setForeground(Color.BLACK);
        }
        if (jtxtNombres.getText().equals("") || jtxtNombres.getText() == null || jtxtNombres.getText().equals(" "))
                jtxtNombres.setText("Nombres");
                jtxtNombres.setForeground(Color.GRAY);
            if (txtApellidos.getText().equals("") || txtApellidos.getText() == null || txtApellidos.getText().equals(" "))
                txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(Color.GRAY);
            if (txtNumeroCelular.getText().equals("") || txtNumeroCelular.getText() == null || txtNumeroCelular.getText().equals(" "))
                txtNumeroCelular.setText("Número de celular");
            txtNumeroCelular.setForeground(Color.GRAY);
            if (txtCorreo.getText().equals("") || txtCorreo.getText() == null || txtCorreo.getText().equals(" "))
                txtCorreo.setText("Correo Electrónico");
            txtCorreo.setForeground(Color.GRAY);
            if (String.valueOf(txtContraseña.getPassword()).equals("") || String.valueOf(txtContraseña.getPassword()) == null || String.valueOf(txtContraseña.getPassword()).equals(" "))
                txtContraseña.setText("**********");
            txtContraseña.setForeground(Color.GRAY);
            if (String.valueOf(txtConfirmarContraseña.getPassword()).equals("") || String.valueOf(txtConfirmarContraseña.getPassword()) == null || String.valueOf(txtConfirmarContraseña.getPassword()).equals(" "))
                txtConfirmarContraseña.setText("**********");
            txtConfirmarContraseña.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtDNIMousePressed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtFechaNacimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaNacimientoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoMousePressed

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
            java.util.logging.Logger.getLogger(VstEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VstEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JCheckBox chkActivo;
    public javax.swing.JComboBox<String> cmbGenero;
    public javax.swing.JComboBox<String> cmbTipoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jtxtNombres;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JPasswordField txtConfirmarContraseña;
    public javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDNI;
    public com.toedter.calendar.JDateChooser txtFechaNacimiento;
    public javax.swing.JTextField txtNumeroCelular;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}