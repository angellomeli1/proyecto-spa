package com.proyectospand.Interfaces.Clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.proyectospand.Entidades.Clientes;
import com.proyectospand.Entidades.Empleados;
import com.proyectospand.datos.ClientesDAO;

/**
 *
 * @author omarr
 */
public class VentanaClientes extends javax.swing.JPanel {
    RegistrarClientesForm rclient = new RegistrarClientesForm(); //objeto para el panel de registrar cliente
    //Variables para las acciones de los botones (agregar, editar, buscar)
    boolean modoAgregar = false;
    boolean modoEditar = false;
    boolean modoBuscar = false;
    //Fin variables para las acciones

    //variables para los clientes
    int clienteAE;
    boolean clienteEstado;
    //Fin variables clientes

    Empleados empleadoE;
    ClientesDAO clienteDAO = new ClientesDAO();
    DefaultTableModel modeloTabla;




    /**
     * Creates new form VentanaClientes
     */
    public VentanaClientes(Empleados empleado) {
        initComponents();
        this.empleadoE = empleado;
        rclient.setSize(338,452);
        rclient.setLocation(0,0);
        pnlFormClient.removeAll();
        pnlFormClient.add(rclient, BorderLayout.CENTER);
        pnlFormClient.revalidate();
        pnlFormClient.repaint();

        cargarDatosClientes();

        jTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    if(!modoAgregar) {
                        int selectedRow = jTable1.getSelectedRow();
                        if(selectedRow >= 0){
                            clienteAE = (int)jTable1.getValueAt(selectedRow, 0);
                            rclient.setNombre((String)jTable1.getValueAt(selectedRow, 1));
                            rclient.setApellidos((String)jTable1.getValueAt(selectedRow, 2));
                            rclient.setCalle((String)jTable1.getValueAt(selectedRow, 3));
                            rclient.setNumero((String)jTable1.getValueAt(selectedRow, 4));
                            rclient.setColonia((String)jTable1.getValueAt(selectedRow, 5));
                            String estado = jTable1.getValueAt(selectedRow, 6).toString();
                            clienteEstado = estado.equalsIgnoreCase("Activo") ? true : false;
                            habilitarActDes();
                            if (!modoEditar) {
                                lblActDes.setText(clienteEstado ? "Desactivar" : "Activar");
                                lblActDes.revalidate();
                                lblActDes.repaint();
                            }
                        }
                    }
                }
            }
        });

        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTabla();
            }

            private void actualizarTabla(){
                if(!txtBusqueda.getText().equalsIgnoreCase("INGRESA EL NOMBRE DEL CLIENTE A BUSCAR")){
                    String textoBusqueda = txtBusqueda.getText().trim();
                    List<Clientes> clientes;
                    if(textoBusqueda.isEmpty()){
                        clientes = clienteDAO.listar();
                    }else{
                        clientes = clienteDAO.buscar(textoBusqueda);
                    }

                    DefaultTableModel modeloTabla = (DefaultTableModel)jTable1.getModel();
                    modeloTabla.setRowCount(0);
                    for(Clientes cliente : clientes){
                        Object[] fila = new Object[]{
                            cliente.getIdCliente(),
                            cliente.getNombreCliente(),
                            cliente.getApellidos(),
                            cliente.getCalle(),
                            cliente.getNumero(),
                            cliente.getColonia(),
                            cliente.getActivo() ? "Activo" : "Inactivo"
                        };
                        modeloTabla.addRow(fila);
                    }
                }
            }

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
        bttnActDes = new javax.swing.JButton();
        lblActDes = new javax.swing.JLabel();
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Apellidos", "Calle", "Numero", "Colonia", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtBusqueda.setForeground(new java.awt.Color(153, 153, 153));
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqueda.setText("INGRESA EL NOMBRE DEL CLIENTE A BUSCAR");
        txtBusqueda.setEnabled(false);
        txtBusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBusquedaFocusGained(evt);
            }
        });
        txtBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBusquedaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBusquedaMousePressed(evt);
            }
        });

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
        bttnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBuscarActionPerformed(evt);
            }
        });
        pnlBotones.add(bttnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 72, 60));

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(102, 102, 102));
        lblBuscar.setText("Buscar");
        pnlBotones.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        bttnActDes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Eliminar_Proveedor.png"))); // NOI18N
        bttnActDes.setBorder(null);
        bttnActDes.setBorderPainted(false);
        bttnActDes.setContentAreaFilled(false);
        bttnActDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnActDesActionPerformed(evt);
            }
        });
        pnlBotones.add(bttnActDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 72, 60));

        lblActDes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblActDes.setForeground(new java.awt.Color(102, 102, 102));
        lblActDes.setText("Activar");
        pnlBotones.add(lblActDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

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
        bttnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCancelarActionPerformed(evt);
            }
        });
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
            bttnActDes.setEnabled(true);
            lblActDes.setEnabled(true);
            lblBuscar.setEnabled(true);
            bttnBuscar.setEnabled(true);
        } else {
            habilitarCampos(true);
            modoAgregar = true;
            rclient.limpiarCampos();
            habilitarGuardarCancelar(true);
            bttnActDes.setEnabled(false);
            lblActDes.setEnabled(false);
            lblBuscar.setEnabled(false);
            bttnBuscar.setEnabled(false);
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

    private void bttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        rclient.limpiarCampos();
        modoAgregar = false;
        modoEditar = false;
        habilitarCampos(false);
        habilitarGuardarCancelar(false);
        bttnActDes.setEnabled(true);
        lblActDes.setEnabled(true);
        lblBuscar.setEnabled(true);
        bttnBuscar.setEnabled(true);
        lblRegistrarCliente.setText("¡REGISTRA UN CLIENTE!");
    }

    private void txtBusquedaFocusGained(java.awt.event.FocusEvent evt) {
        txtBusqueda.setText("");
        txtBusqueda.setForeground(Color.black);
    }

    private void txtBusquedaMousePressed(java.awt.event.MouseEvent evt) {
        txtBusqueda.setText("");
        txtBusqueda.setForeground(Color.black);
    }

    private void txtBusquedaMouseExited(java.awt.event.MouseEvent evt) {
        if(txtBusqueda.getText().isEmpty()){
            txtBusqueda.setText("INGRESA EL NOMBRE DEL CLIENTE A BUSCAR");
            txtBusqueda.setForeground(Color.GRAY);
        }
    }

    private void bttnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        if(modoBuscar){
            txtBusqueda.setEnabled(false);
            txtBusqueda.setFocusable(false);
            modoBuscar = false;
            txtBusqueda.setText("INGRESA EL NOMBRE DEL CLIENTE A BUSCAR");
            cargarDatosClientes();
        }
        else {
            txtBusqueda.setEnabled(true);
            txtBusqueda.setFocusable(true);
            modoBuscar = true;
        }
    }

    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String nombreCliente = rclient.getNombre();
        String apellidos = rclient.getApellidos();
        String calle = rclient.getCalle();
        String colonia = rclient.getColonia();
        String numero = rclient.getNumero();
        Clientes cliente = new Clientes();
        if(modoAgregar){
            cliente = new Clientes(0, nombreCliente, apellidos, calle, numero, colonia, true);
            if(clienteDAO.insertar(cliente, empleadoE)){
                JOptionPane.showMessageDialog(null, "¡El cliente se ha registrado exitosamente!");
                cargarDatosClientes();
            }
            else {
                JOptionPane.showMessageDialog(null, "¡El cliente no se ha podido registrar!");
            }
        }
        if(modoEditar){
            cliente = new Clientes(clienteAE, nombreCliente, apellidos, calle, numero, colonia,clienteEstado);
            if(clienteDAO.actualizar(cliente, empleadoE)){
                JOptionPane.showMessageDialog(null, "¡El cliente se ha editado exitosamente!");
                cargarDatosClientes();
            }
            else {
                JOptionPane.showMessageDialog(null, "¡El cliente no se ha podido editar!");
            }
        }
    }

    private void bttnActDesActionPerformed(java.awt.event.ActionEvent evt) {
        if(clienteEstado){
            if(clienteDAO.desactivar(clienteAE, empleadoE)){
                JOptionPane.showMessageDialog(null, "¡El cliente se ha desactivado exitosamente!");
            }
            else {
                JOptionPane.showMessageDialog(null, "¡El cliente no se ha podido desactivar!");
            }
        }
        else {
            if(clienteDAO.activar(clienteAE)){
                JOptionPane.showMessageDialog(null, "¡El cliente se ha activado exitosamente!");
            }
            else {
                JOptionPane.showMessageDialog(null, "¡El cliente no se ha podido activar!");
            }
        }
        clienteAE = 0;
        habilitarActDes();
        cargarDatosClientes();
    }

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
        List<Clientes> clientes = clienteDAO.listar();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        modeloTabla.setRowCount(0);
        for(Clientes cliente : clientes){
            modeloTabla.addRow(new Object[]{
                cliente.getIdCliente(),
                cliente.getNombreCliente(),
                cliente.getApellidos(),
                cliente.getCalle(),
                cliente.getNumero(),
                cliente.getColonia(),
                cliente.getActivo() ? "Activo" : "Inactivo"
            });
        }
    }

    public void habilitarActDes(){
        if(clienteAE == 0){
            bttnActDes.setEnabled(false);
            lblActDes.setEnabled(false);
        } else {
            bttnActDes.setEnabled(true);
            lblActDes.setEnabled(true);
        }
        lblActDes.setText("Activar");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnActDes;
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnBuscar;
    private javax.swing.JButton bttnCancelar;
    private javax.swing.JButton bttnEditar;
    private javax.swing.JButton bttnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblActDes;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblEditar;
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
