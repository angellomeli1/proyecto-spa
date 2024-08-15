package com.proyectospand.Interfaces.Clientes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omarr
 */
public class VentanaClientes extends javax.swing.JPanel {
    RegistrarClientesForm rclient = new RegistrarClientesForm();
    boolean modoAgregar = false;
    boolean modoEditar = false;

    /**
     * Creates new form VentanaClientes
     */
    public VentanaClientes() {
        initComponents();
        
        rclient.setSize(338,452);
        rclient.setLocation(0,0);
        pnlFormClient.removeAll();
        pnlFormClient.add(rclient, BorderLayout.CENTER);
        pnlFormClient.revalidate();
        pnlFormClient.repaint();

        cargarDatosClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOpcionesClientes = new javax.swing.JPanel();
        lblRegistrarCliente = new javax.swing.JLabel();
        lblInformacionCliente = new javax.swing.JLabel();
        pnlFormClient = new javax.swing.JPanel();
        pnlVentanaClient = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtBusqueda = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        bttnAgregar = new javax.swing.JButton();
        lblAgregar = new javax.swing.JLabel();
        bttnEditar = new javax.swing.JButton();
        lblEditar = new javax.swing.JLabel();
        bttnBuscar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        bttnEliminar = new javax.swing.JButton();
        lblEliminar = new javax.swing.JLabel();
        bttnGuardar = new javax.swing.JButton();
        lblGuardar = new javax.swing.JLabel();
        bttnCancelar = new javax.swing.JButton();
        lblCancelar = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOpcionesClientes.setBackground(new java.awt.Color(230, 230, 250));
        pnlOpcionesClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRegistrarCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRegistrarCliente.setText("¡REGISTRA UN CLIENTE!");

        lblInformacionCliente.setForeground(new java.awt.Color(105, 105, 105));
        lblInformacionCliente.setText("Completa la información del cliente");

        pnlFormClient.setBackground(new java.awt.Color(230, 230, 250));

        javax.swing.GroupLayout pnlFormClientLayout = new javax.swing.GroupLayout(pnlFormClient);
        pnlFormClient.setLayout(pnlFormClientLayout);
        pnlFormClientLayout.setHorizontalGroup(
            pnlFormClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        pnlFormClientLayout.setVerticalGroup(
            pnlFormClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlOpcionesClientesLayout = new javax.swing.GroupLayout(pnlOpcionesClientes);
        pnlOpcionesClientes.setLayout(pnlOpcionesClientesLayout);
        pnlOpcionesClientesLayout.setHorizontalGroup(
            pnlOpcionesClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOpcionesClientesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlOpcionesClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInformacionCliente)
                            .addComponent(pnlFormClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlOpcionesClientesLayout.setVerticalGroup(
            pnlOpcionesClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesClientesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformacionCliente)
                .addGap(18, 18, 18)
                .addComponent(pnlFormClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(pnlOpcionesClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 352, 610));

        pnlVentanaClient.setBackground(new java.awt.Color(255, 255, 255));
        pnlVentanaClient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("TODOS LOS CLIENTES");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Apellidos", "Calle", "Numero", "Colonia", "Activo", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtBusqueda.setForeground(new java.awt.Color(153, 153, 153));
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqueda.setText("INGRESA EL NOMBRE DEL CLIENTE A BUSCAR");

        pnlBotones.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar_Proveedor.png"))); // NOI18N
        bttnAgregar.setBorder(null);
        bttnAgregar.setBorderPainted(false);
        bttnAgregar.setContentAreaFilled(false);
        bttnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAgregarActionPerformed(evt);
            }
        });
        pnlBotones.add(bttnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 72, 60));

        lblAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAgregar.setForeground(new java.awt.Color(102, 102, 102));
        lblAgregar.setText("Agregar");
        pnlBotones.add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        bttnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        bttnEditar.setBorder(null);
        bttnEditar.setBorderPainted(false);
        bttnEditar.setContentAreaFilled(false);
        bttnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEditarActionPerformed(evt);
            }
        });
        pnlBotones.add(bttnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 72, 60));

        lblEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEditar.setForeground(new java.awt.Color(102, 102, 102));
        lblEditar.setText("Editar");
        pnlBotones.add(lblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        bttnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Buscar_Proveedor.png"))); // NOI18N
        bttnBuscar.setBorder(null);
        bttnBuscar.setBorderPainted(false);
        bttnBuscar.setContentAreaFilled(false);
        pnlBotones.add(bttnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 72, 60));

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(102, 102, 102));
        lblBuscar.setText("Buscar");
        pnlBotones.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        bttnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Eliminar_Proveedor.png"))); // NOI18N
        bttnEliminar.setBorder(null);
        bttnEliminar.setBorderPainted(false);
        bttnEliminar.setContentAreaFilled(false);
        bttnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEliminarActionPerformed(evt);
            }
        });
        pnlBotones.add(bttnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 72, 60));

        lblEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(102, 102, 102));
        lblEliminar.setText("Eliminar");
        pnlBotones.add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        bttnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar-el-archivo.png"))); // NOI18N
        bttnGuardar.setBorder(null);
        bttnGuardar.setBorderPainted(false);
        bttnGuardar.setContentAreaFilled(false);
        bttnGuardar.setEnabled(false);
        bttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnGuardarActionPerformed(evt);
            }
        });
        pnlBotones.add(bttnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 72, 60));

        lblGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(102, 102, 102));
        lblGuardar.setText("Guardar");
        lblGuardar.setEnabled(false);
        pnlBotones.add(lblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        bttnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        bttnCancelar.setBorder(null);
        bttnCancelar.setBorderPainted(false);
        bttnCancelar.setContentAreaFilled(false);
        bttnCancelar.setEnabled(false);
        pnlBotones.add(bttnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 72, 60));

        lblCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCancelar.setForeground(new java.awt.Color(102, 102, 102));
        lblCancelar.setText("Cancelar");
        lblCancelar.setEnabled(false);
        pnlBotones.add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, -1));

        javax.swing.GroupLayout pnlVentanaClientLayout = new javax.swing.GroupLayout(pnlVentanaClient);
        pnlVentanaClient.setLayout(pnlVentanaClientLayout);
        pnlVentanaClientLayout.setHorizontalGroup(
            pnlVentanaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentanaClientLayout.createSequentialGroup()
                .addGroup(pnlVentanaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVentanaClientLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(lblTitulo)
                        .addGap(0, 329, Short.MAX_VALUE))
                    .addGroup(pnlVentanaClientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentanaClientLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
            .addGroup(pnlVentanaClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlVentanaClientLayout.setVerticalGroup(
            pnlVentanaClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentanaClientLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlVentanaClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 830, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarActionPerformed
        modoEditar = false;
        lblRegistrarCliente.setText("¡REGISTRA UN CLIENTE!");
        if(modoAgregar){
            habilitarCampos(false);
            modoAgregar = false;
            habilitarGuardarCancelar(false);
        } else {
            habilitarCampos(true);
            modoAgregar = true;
            habilitarGuardarCancelar(true);
        }
    }//GEN-LAST:event_bttnAgregarActionPerformed

    private void bttnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEditarActionPerformed
        modoAgregar = false;
        lblRegistrarCliente.setText("¡EDITA UN CLIENTE!");
        if(modoEditar){
            habilitarCampos(false);
            modoEditar = false;
            habilitarGuardarCancelar(false);
        } else {
            habilitarCampos(true);
            modoEditar = true;
            habilitarGuardarCancelar(true);
        }
        //Una vez que la query sea exitosa y guarde los cambios, los campos se deshabilitaran
    }//GEN-LAST:event_bttnEditarActionPerformed

    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnGuardarActionPerformed
        if  (modoAgregar == true) {
            // Obtener los valores de los campos de texto
            String nombreCliente = rclient.getTxtNombreCliente().getText();
            String apellidosCliente = rclient.getTxtApellidosCliente().getText();
            String calleCliente = rclient.getTxtCalleCliente().getText();
            String numeroCliente = rclient.getTxtNumeroCliente().getText();
            String coloniaCliente = rclient.getTxtColoniaCliente().getText();
            String telefonoCliente = rclient.getTxtTelefonoCliente().getText();
        
            // Asumimos que el idEmpleado es conocido, aquí por ejemplo es 1
            int idEmpleado = 1;  
        
            // Conectar a la base de datos y llamar al procedimiento almacenado AgregarCliente
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbspa", "root", "1613")) {
                String sql = "{CALL AgregarCliente(?, ?, ?, ?, ?, ?, ?)}";
                try (CallableStatement stmt = conn.prepareCall(sql)) {
                    stmt.setInt(1, idEmpleado);
                    stmt.setString(2, nombreCliente);
                    stmt.setString(3, apellidosCliente);
                    stmt.setString(4, calleCliente);
                    stmt.setString(5, numeroCliente);
                    stmt.setString(6, coloniaCliente);
                    stmt.setBoolean(7, true); // Activo
                    
                    // Ejecutar el procedimiento almacenado
                    stmt.execute();
                    
                    System.out.println("Cliente agregado exitosamente.");
                }
                cargarDatosClientes();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al agregar el cliente: " + ex.getMessage());
            }  
        } if (modoAgregar == false) {
            // Obtener los valores de los campos de texto
            String nombreCliente = rclient.getTxtNombreCliente().getText();
            String apellidosCliente = rclient.getTxtApellidosCliente().getText();
            String calleCliente = rclient.getTxtCalleCliente().getText();
            String numeroCliente = rclient.getTxtNumeroCliente().getText();
            String coloniaCliente = rclient.getTxtColoniaCliente().getText();
            String telefonoCliente = rclient.getTxtTelefonoCliente().getText();
        
            // Asumimos que el idEmpleado es conocido, aquí por ejemplo es 1
            int idEmpleado = 1;  
            int idCliente = 0;

            // Conectar a la base de datos y llamar al procedimiento almacenado AgregarCliente
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBSPA", "root", "1613")) {
                String sql = "{CALL ActualizarCliente(?, ?, ?, ?, ?, ?, ?,?)}";
                try (CallableStatement stmt = conn.prepareCall(sql)) {
                    stmt.setInt(1, idEmpleado);
                    stmt.setInt(2, idCliente);
                    stmt.setString(3, nombreCliente);
                    stmt.setString(4, apellidosCliente);
                    stmt.setString(5, calleCliente);
                    stmt.setString(6, numeroCliente);
                    stmt.setString(7, coloniaCliente);
                    stmt.setBoolean(8, true); // Activo
                    
                    // Ejecutar el procedimiento almacenado
                    stmt.execute();
                    
                    System.out.println("Cliente actualizado exitosamente.");
                }
                cargarDatosClientes();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al actualizar el cliente: " + ex.getMessage());
            }  
        } else {
            System.out.println("Error al agregar el cliente.");
        }
    }//GEN-LAST:event_bttnGuardarActionPerformed

    private void bttnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEliminarActionPerformed
        // Obtener la fila seleccionada
    int filaSeleccionada = jTable1.getSelectedRow();
    int idEmpleado = 1;

    if (filaSeleccionada == -1) {
        // No se ha seleccionado ninguna fila
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para eliminar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtener el ID del cliente de la primera columna
    int idCliente = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 0).toString());

    // Confirmar la eliminación
    int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este cliente?", "Confirmación", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
        // Proceder con la eliminación
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBSPA", "root", "1613")) {
            String sql = "{CALL EliminarCliente(?,?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setInt(1, idCliente);
                stmt.setInt(2, idEmpleado);

                // Ejecutar el procedimiento almacenado
                stmt.execute();
                
                javax.swing.JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            // Recargar los datos de la tabla
            cargarDatosClientes();
        } catch (SQLException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el cliente: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_bttnEliminarActionPerformed

    // Funciones
    private void habilitarCampos(boolean habilitar){
        Component[] componentes = rclient.getComponents();
        for (Component componente : componentes){
            if(componente instanceof JTextField){
                componente.setEnabled(habilitar);
            }
        }
    }// Fin de la función
    
    private void habilitarGuardarCancelar(boolean habilitar){
        bttnGuardar.setEnabled(habilitar);
        bttnCancelar.setEnabled(habilitar);
        lblGuardar.setEnabled(habilitar);
        lblCancelar.setEnabled(habilitar);
    }

    // Función para cargar los datos de la base de datos
    private void cargarDatosClientes() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Limpiar la tabla

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBSPA", "root", "1613")) {
        String sql = "SELECT idCliente, nombreCliente, apellidos, calle, numero, colonia, activo FROM cliente";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getInt("idCliente");
                row[1] = rs.getString("nombreCliente");
                row[2] = rs.getString("apellidos");
                row[3] = rs.getString("calle");
                row[4] = rs.getString("numero");
                row[5] = rs.getString("colonia");
                row[6] = rs.getBoolean("activo")?"Si":"No";
                model.addRow(row); // Agregar fila al modelo
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.out.println("Error al cargar los clientes: " + ex.getMessage());
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnBuscar;
    private javax.swing.JButton bttnCancelar;
    private javax.swing.JButton bttnEditar;
    private javax.swing.JButton bttnEliminar;
    private javax.swing.JButton bttnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblInformacionCliente;
    private javax.swing.JLabel lblRegistrarCliente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormClient;
    private javax.swing.JPanel pnlOpcionesClientes;
    private javax.swing.JPanel pnlVentanaClient;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
