
package com.proyectospand.Interfaces.Proveedores;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.proyectospand.Entidades.Empleados;
import com.proyectospand.Entidades.Proveedores;
import com.proyectospand.datos.ProveedoresDAO;
import java.util.List;
/**
 *
 * @author omarr
 */
public class VentanaProveedor extends javax.swing.JPanel {
    //objeto para el panel de registrar proveedor
    RegistrarProveedorForm rprov = new RegistrarProveedorForm();
    //Variables para las acciones de los botones (buscar,editar,agregar)
    boolean modoAgregar = false;
    boolean modoEditar = false;
    boolean modoBuscar = false;
    //Fin variables para las acciones

    //Instancias para los proveedores
    int provedorAE;
    boolean provedorEstado;
    //Fin instancias proveedores

    Empleados empleadoE; //Empleado que está manipulando el sistema
    ProveedoresDAO proDAO = new ProveedoresDAO(); //Instancia para la clase ProveedoresDAO
    DefaultTableModel modeloTabla; //Tabla para mostrar los datos
    
    public VentanaProveedor(Empleados empleado) {
        initComponents();
        this.empleadoE = empleado;
        rprov.setSize(331,515);
        rprov.setLocation(0,0);
        pnlFormProv.removeAll();
        pnlFormProv.add(rprov, BorderLayout.CENTER);
        pnlFormProv.revalidate();
        pnlFormProv.repaint();

        cargarDatosProveedores();

        //Metodo para rellenar los campos con los datos de la tabla.
        jTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    if(!modoAgregar){
                        int selectedRow = jTable1.getSelectedRow();
                        if(selectedRow >= 0){
                            provedorAE = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
                            rprov.setNombreProv(jTable1.getValueAt(selectedRow, 1).toString());
                            rprov.setCalle(jTable1.getValueAt(selectedRow, 2).toString());
                            rprov.setColonia(jTable1.getValueAt(selectedRow, 3).toString());
                            String estado = jTable1.getValueAt(selectedRow, 4).toString();
                            provedorEstado = estado.equalsIgnoreCase("Activo") ? true : false;
                            habilitarActDes();
                            if(!modoEditar){
                                lblActDes.setText(provedorEstado ? "Desactivar" : "Activar");
                                lblActDes.revalidate();
                                lblActDes.repaint();
                            }
                        }
                    }
                }
            }
        });
        //Fin del metodo para rellenar los campos con los datos de la tabla.

        //Metodo para el campo de busqueda
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

            private void actualizarTabla() {
                if(!txtBusqueda.getText().equals("INGRESA EL NOMBRE DEL PROVEEDOR A BUSCAR")){
                    String textoBusqueda = txtBusqueda.getText().trim();
                    List<Proveedores> proveedores;
                    if(textoBusqueda.isEmpty()){
                        proveedores = proDAO.listar();
                    } else {
                        proveedores = proDAO.buscar(textoBusqueda);
                    }

                    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                    modelo.setRowCount(0);
                    
                    for(Proveedores prov : proveedores){
                        Object[] fila = new Object[]{
                            prov.getIdProveedores(),
                            prov.getNombreProv(),
                            prov.getCalle(),
                            prov.getColonia(),
                            prov.getActivo() ? "Activo" : "Inactivo"
                        };
                        modelo.addRow(fila);
                    }
                }
            }
        });
        //Fin del metodo para el campo de busqueda
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOpcionesProveedor = new javax.swing.JPanel();
        lblRegistrarProveedor = new javax.swing.JLabel();
        lblInformacionProveedor = new javax.swing.JLabel();
        pnlFormProv = new javax.swing.JPanel();
        pnlVentanaProv = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
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
        txtBusqueda = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOpcionesProveedor.setBackground(new java.awt.Color(230, 230, 250));
        pnlOpcionesProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlOpcionesProveedor.setPreferredSize(new java.awt.Dimension(346, 567));

        lblRegistrarProveedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRegistrarProveedor.setText("¡REGISTRA UN PROVEEDOR!");

        lblInformacionProveedor.setForeground(new java.awt.Color(105, 105, 105));
        lblInformacionProveedor.setText("Completa la información del proveedor");

        pnlFormProv.setBackground(new java.awt.Color(230, 230, 250));

        javax.swing.GroupLayout pnlFormProvLayout = new javax.swing.GroupLayout(pnlFormProv);
        pnlFormProv.setLayout(pnlFormProvLayout);
        pnlFormProvLayout.setHorizontalGroup(
            pnlFormProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        pnlFormProvLayout.setVerticalGroup(
            pnlFormProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlOpcionesProveedorLayout = new javax.swing.GroupLayout(pnlOpcionesProveedor);
        pnlOpcionesProveedor.setLayout(pnlOpcionesProveedorLayout);
        pnlOpcionesProveedorLayout.setHorizontalGroup(
            pnlOpcionesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFormProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegistrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInformacionProveedor))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pnlOpcionesProveedorLayout.setVerticalGroup(
            pnlOpcionesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesProveedorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRegistrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformacionProveedor)
                .addGap(18, 18, 18)
                .addComponent(pnlFormProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        add(pnlOpcionesProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 352, 610));

        pnlVentanaProv.setBackground(new java.awt.Color(255, 255, 255));
        pnlVentanaProv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Proveedor", "Nombre", "Calle", "Colonia", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTable1);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("TODOS LOS PROVEEDORES");

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
        pnlBotones.add(lblActDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 70, -1, -1));

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

        txtBusqueda.setForeground(new java.awt.Color(153, 153, 153));
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqueda.setText("INGRESA EL NOMBRE DEL PROVEEDOR A BUSCAR");
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

        javax.swing.GroupLayout pnlVentanaProvLayout = new javax.swing.GroupLayout(pnlVentanaProv);
        pnlVentanaProv.setLayout(pnlVentanaProvLayout);
        pnlVentanaProvLayout.setHorizontalGroup(
            pnlVentanaProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentanaProvLayout.createSequentialGroup()
                .addGroup(pnlVentanaProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVentanaProvLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlVentanaProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(pnlVentanaProvLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlVentanaProvLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        pnlVentanaProvLayout.setVerticalGroup(
            pnlVentanaProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentanaProvLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlVentanaProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 830, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarActionPerformed
        modoEditar = false;
        lblRegistrarProveedor.setText("¡REGISTRA UN PROVEEDOR!");
        if(modoAgregar){
            rprov.habilitarCampos(false);
            modoAgregar = false;
            habilitarGuardarCancelar(false);
            bttnActDes.setEnabled(true);
            lblActDes.setEnabled(true);
            lblBuscar.setEnabled(true);
            bttnBuscar.setEnabled(true);
        } else {
            rprov.limpiarCampos();
            rprov.habilitarCampos(true);
            modoAgregar = true;
            habilitarGuardarCancelar(true);
            bttnActDes.setEnabled(false);
            lblActDes.setEnabled(false);
            lblBuscar.setEnabled(false);
            bttnBuscar.setEnabled(false);
        }
    }//GEN-LAST:event_bttnAgregarActionPerformed

    private void bttnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEditarActionPerformed
        modoAgregar = false;
        lblRegistrarProveedor.setText("¡EDITA UN PROVEEDOR!");
        if(modoEditar){
            rprov.habilitarCampos(false);
            modoEditar = false;
            habilitarGuardarCancelar(false);
            bttnActDes.setEnabled(true);
            lblActDes.setEnabled(true);
            lblBuscar.setEnabled(true);
            bttnBuscar.setEnabled(true);
         } else {
            rprov.habilitarCampos(true);
            modoEditar = true;
            habilitarGuardarCancelar(true);
            bttnActDes.setEnabled(false);
            lblActDes.setEnabled(false);
            lblBuscar.setEnabled(false);
            bttnBuscar.setEnabled(false);
         }
        //Una vez que la query sea exitosa y guarde los cambios, los campos se deshabilitaran
    }//GEN-LAST:event_bttnEditarActionPerformed

    private void txtBusquedaFocusGained(java.awt.event.FocusEvent evt) {
        txtBusqueda.setText("");
        txtBusqueda.setForeground(Color.black);
    }

    private void txtBusquedaMouseExited(java.awt.event.MouseEvent evt) {
        if(txtBusqueda.getText().isEmpty()){
            txtBusqueda.setText("INGRESA EL NOMBRE DEL PROVEEDOR A BUSCAR");
            txtBusqueda.setForeground(Color.GRAY);
        }
    }

    private void txtBusquedaMousePressed(java.awt.event.MouseEvent evt) {
        txtBusqueda.setText("");
        txtBusqueda.setForeground(Color.black);
    }

    private void bttnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        if(modoBuscar){
            txtBusqueda.setEnabled(false);
            lblBuscar.setEnabled(false);
            txtBusqueda.setFocusable(false);
            modoBuscar = false;
            txtBusqueda.setText("INGRESA EL NOMBRE DEL PROVEEDOR A BUSCAR");
        } else {
            txtBusqueda.setEnabled(true);
            lblBuscar.setEnabled(true);
            txtBusqueda.setFocusable(true);
            modoBuscar = true;
            txtBusqueda.setText("");
        }
    }

    private void bttnActDesActionPerformed(java.awt.event.ActionEvent evt) {
        if(provedorEstado){
            if(proDAO.desactivar(provedorAE, empleadoE)){
                JOptionPane.showMessageDialog(null, "Proveedoredor desactivado con exito");
                cargarDatosProveedores();
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo desactivar el proveedor");
            }
        }
        else {
            if(proDAO.activar(provedorAE)){
                JOptionPane.showMessageDialog(null, "Proveedoredor activado con exito");
                cargarDatosProveedores();
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo activar el proveedor");
            }
        }
    }

    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        String nombreProveedor = rprov.getNombreProv();
        String calleProveedor = rprov.getCalle();
        String coloniaProveedor = rprov.getColonia();
        Proveedores proveedor = new Proveedores();
        if(modoAgregar){
            proveedor = new Proveedores(0,nombreProveedor,calleProveedor,coloniaProveedor,true);
            if(proDAO.insertar(proveedor, empleadoE)){
                JOptionPane.showMessageDialog(null, "Proveedoredor agregado con exito");
                cargarDatosProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el proveedor");
            }
        }
        if(modoEditar){
            proveedor = new Proveedores(provedorAE,nombreProveedor,calleProveedor,coloniaProveedor,provedorEstado);
            if(proDAO.actualizar(proveedor, empleadoE)){
                JOptionPane.showMessageDialog(null, "Proveedoredor editado con exito");
                cargarDatosProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar el proveedor");
            }
        }
    }

    private void bttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        rprov.limpiarCampos();
        habilitarGuardarCancelar(false);
        habilitarActDes();
        rprov.habilitarCampos(false);
        modoEditar = false;
        modoAgregar = false;
        lblRegistrarProveedor.setText("¡REGISTRA UN PROVEEDOR!");
    }
    

    //Funciones para habilitación de componentes
    private void habilitarGuardarCancelar(boolean habilitar){
        bttnGuardar.setEnabled(habilitar);
        bttnCancelar.setEnabled(habilitar);
        lblGuardar.setEnabled(habilitar);
        lblCancelar.setEnabled(habilitar);
    }

    private void habilitarActDes(){
        if(provedorAE == 0){
            bttnActDes.setEnabled(false);
        } else {
            bttnActDes.setEnabled(true);
        }
    }
    //fin funciones para habilitar componentes

    private void cargarDatosProveedores() {
        List<Proveedores> listaProveedores = proDAO.listar();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        modeloTabla.setRowCount(0);
        for(Proveedores prov : listaProveedores){
            modeloTabla.addRow(new Object[]{
                prov.getIdProveedores(),
                prov.getNombreProv(),
                prov.getCalle(),
                prov.getColonia(),
                prov.getActivo() ? "Activo" : "Inactivo"
            });
        }

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
    private javax.swing.JLabel lblInformacionProveedor;
    private javax.swing.JLabel lblRegistrarProveedor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormProv;
    private javax.swing.JPanel pnlOpcionesProveedor;
    private javax.swing.JPanel pnlVentanaProv;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
