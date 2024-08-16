/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.proyectospand.Interfaces.Citas;

import java.awt.Component;
import javax.swing.JTextField;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ING. Lomelí
 */
public class ventanaCitas extends javax.swing.JPanel {
    boolean modoEditar = false;
    boolean modoAgregar = false;
    boolean tablaClientes = false;
    boolean tablaCitas = true;
    boolean tablaMasajistas = false;
    panelCitas pnlCitas = new panelCitas();
    panelMasajistas pnlMasajistas = new panelMasajistas();
    panelClientes pnlClientes = new panelClientes();
    citasForm citas = new citasForm();
    public ventanaCitas() {
        initComponents();
        citas.setSize(338,532);
        citas.setLocation(0,0);
        pnlFormCita.removeAll();
        pnlFormCita.add(citas);
        pnlFormCita.revalidate();
        pnlFormCita.repaint();
        pnlCitas.setSize(796, 376);
        pnlCitas.setLocation(0, 0);
        pnlTablas.removeAll();
        pnlTablas.add(pnlCitas);
        pnlTablas.revalidate();
        pnlTablas.repaint();
        
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
        lblRegistrarCita = new javax.swing.JLabel();
        pnlFormCita = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAviso = new javax.swing.JLabel();
        pnlTablas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        bttnEliminar = new javax.swing.JButton();
        bttnAgregar = new javax.swing.JButton();
        bttnEditar = new javax.swing.JButton();
        bttnBuscar = new javax.swing.JButton();
        bttnGuardar = new javax.swing.JButton();
        bttnCancelar = new javax.swing.JButton();
        lblAgregar = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        bttnSeleccionar = new javax.swing.JButton();
        cargarDatosCitas();

        setBackground(new java.awt.Color(230, 230, 250));
        setPreferredSize(new java.awt.Dimension(1180, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(230, 230, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRegistrarCita.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRegistrarCita.setText("¡REGISTRA UNA CITA!");

        pnlFormCita.setBackground(new java.awt.Color(230, 230, 250));

        javax.swing.GroupLayout pnlFormCitaLayout = new javax.swing.GroupLayout(pnlFormCita);
        pnlFormCita.setLayout(pnlFormCitaLayout);
        pnlFormCitaLayout.setHorizontalGroup(
            pnlFormCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlFormCitaLayout.setVerticalGroup(
            pnlFormCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Completa la información de la cita");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistrarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFormCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblRegistrarCita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 352, 610));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblAviso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAviso.setText("¡TODAS LAS CITAS!");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Cita", "ID Cliente", "ID Empleado", "Fecha", "Descripción", "Costo"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout pnlTablasLayout = new javax.swing.GroupLayout(pnlTablas);
        pnlTablas.setLayout(pnlTablasLayout);
        pnlTablasLayout.setHorizontalGroup(
            pnlTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlTablasLayout.setVerticalGroup(
            pnlTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("BUSCAR POR NOMBRE");

        bttnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar-producto.png"))); // NOI18N
        bttnEliminar.setBorder(null);
        bttnEliminar.setBorderPainted(false);
        bttnEliminar.setContentAreaFilled(false);

        bttnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-producto.png"))); // NOI18N
        bttnAgregar.setBorder(null);
        bttnAgregar.setBorderPainted(false);
        bttnAgregar.setContentAreaFilled(false);
        bttnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAgregarActionPerformed(evt);
            }
        });

        bttnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        bttnEditar.setBorder(null);
        bttnEditar.setBorderPainted(false);
        bttnEditar.setContentAreaFilled(false);
        bttnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEditarActionPerformed(evt);
            }
        });

        bttnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/producto.png"))); // NOI18N
        bttnBuscar.setBorder(null);
        bttnBuscar.setBorderPainted(false);
        bttnBuscar.setContentAreaFilled(false);

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

        lblAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAgregar.setForeground(new java.awt.Color(102, 102, 102));
        lblAgregar.setText("Agregar");

        lblEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEditar.setForeground(new java.awt.Color(102, 102, 102));
        lblEditar.setText("Editar");

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(102, 102, 102));
        lblBuscar.setText("Buscar");

        lblEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(102, 102, 102));
        lblEliminar.setText("Eliminar");

        lblGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(102, 102, 102));
        lblGuardar.setText("Guardar");
        lblGuardar.setEnabled(false);

        lblCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCancelar.setForeground(new java.awt.Color(102, 102, 102));
        lblCancelar.setText("Cancelar");
        lblCancelar.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(bttnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(bttnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(bttnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(bttnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(bttnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(bttnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(lblAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(67, 67, 67)
                            .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(lblCancelar)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bttnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bttnSeleccionar.setText("SELECCIONAR");
        bttnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(lblAviso))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnSeleccionar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTablas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblAviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 840, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarActionPerformed
        modoEditar = false;
        lblRegistrarCita.setText("¡REGISTRA UNA CITA!");
        if(modoAgregar){
            habilitarCampos(false);
            modoAgregar = false;
            habilitarGuardarCancelar(false);
            tablaCitas = true;
            tablaClientes = false;
            tablaMasajistas = false;
            bttnCancelarActionPerformed(evt);
        } else {
            habilitarCampos(true);
            modoAgregar = true;
            habilitarGuardarCancelar(true);
            tablaCitas = false;
            tablaMasajistas = false;
            tablaClientes = true;
            pnlClientes.setSize(796, 376);
            pnlClientes.setLocation(0, 0);
            pnlTablas.removeAll();
            pnlTablas.add(pnlClientes);
            pnlTablas.revalidate();
            pnlTablas.repaint();
            lblAviso.setText("¡SELECCIONA UN EMPLEADO!");
        }
    }//GEN-LAST:event_bttnAgregarActionPerformed

    private void bttnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEditarActionPerformed
        modoAgregar = false;
        lblRegistrarCita.setText("¡EDITA UNA CITA!");
        if(modoEditar){
            habilitarCampos(false);
            modoEditar = false;
            habilitarGuardarCancelar(false);
            tablaCitas = true;
            tablaClientes = false;
            tablaMasajistas = false;
            bttnCancelarActionPerformed(evt);
        } else {
            habilitarCampos(true);
            modoEditar = true;
            habilitarGuardarCancelar(true);
            tablaCitas = false;
            tablaMasajistas = false;
            tablaClientes = true;
            pnlClientes.setSize(796, 376);
            pnlClientes.setLocation(0, 0);
            pnlTablas.removeAll();
            pnlTablas.add(pnlClientes);
            pnlTablas.revalidate();
            pnlTablas.repaint();
            lblAviso.setText("¡SELECCIONA UN EMPLEADO!");
        }
        //Una vez que la query sea exitosa y guarde los cambios, los campos se deshabilitaran
    }//GEN-LAST:event_bttnEditarActionPerformed

    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnGuardarActionPerformed
        if(modoAgregar){

        } else if(modoEditar){

        }
    }//GEN-LAST:event_bttnGuardarActionPerformed

    private void bttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelarActionPerformed
            citas.setSize(338,532);
            citas.setLocation(0,0);
            pnlFormCita.removeAll();
            pnlFormCita.add(citas);
            pnlFormCita.revalidate();
            pnlFormCita.repaint();
            pnlCitas.setSize(796, 376);
            pnlCitas.setLocation(0, 0);
            pnlTablas.removeAll();
            pnlTablas.add(pnlCitas);
            pnlTablas.revalidate();
            pnlTablas.repaint();
            lblAviso.setText("¡TODAS LAS CITAS!");
    }//GEN-LAST:event_bttnCancelarActionPerformed

    private void bttnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSeleccionarActionPerformed
        if(tablaClientes){
            tablaCitas = false;
            tablaClientes = false;
            tablaMasajistas = true;
            pnlMasajistas.setSize(796, 376);
            pnlMasajistas.setLocation(0, 0);
            pnlTablas.removeAll();
            pnlTablas.add(pnlMasajistas);
            pnlTablas.revalidate();
            pnlTablas.repaint();
            lblAviso.setText("¡SELECCIONA UN MASAJISTA!");
        } else if(tablaMasajistas){
            tablaCitas = true;
            tablaClientes = false;
            tablaMasajistas = false;
            bttnGuardarActionPerformed(evt);
        } else {
            //seleccionar cita
        }
    }//GEN-LAST:event_bttnSeleccionarActionPerformed

    private void habilitarCampos(boolean habilitar){
        Component[] componentes = citas.getComponents();
        for (Component componente : componentes){
            if(componente instanceof JTextField){
                componente.setEnabled(habilitar);
            }
        }
    }

    private void habilitarGuardarCancelar(boolean habilitar){
        bttnGuardar.setEnabled(habilitar);
        bttnCancelar.setEnabled(habilitar);
        lblGuardar.setEnabled(habilitar);
        lblCancelar.setEnabled(habilitar);
    }

    private void cargarDatosCitas() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Limpiar la tabla

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBSPA", "root", "1613")) {
            String sql = "SELECT idCitas, Cliente_idCliente, Empleado_idEmpleado, fechaCita, descripcion, costo  FROM citas";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Object[] row = new Object[6];
                    row[0] = rs.getString("idCitas");
                    row[1] = rs.getString("Cliente_idCliente");
                    row[2] = rs.getString("Empleado_idEmpleado");
                    row[3] = rs.getString("fechaCita");
                    row[4] = rs.getString("descripcion");
                    row[5] = rs.getString("costo");
                    model.addRow(row); // Agregar fila al modelo
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al cargar los productos: " + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnBuscar;
    private javax.swing.JButton bttnCancelar;
    private javax.swing.JButton bttnEditar;
    private javax.swing.JButton bttnEliminar;
    private javax.swing.JButton bttnGuardar;
    private javax.swing.JButton bttnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblRegistrarCita;
    private javax.swing.JPanel pnlFormCita;
    private javax.swing.JPanel pnlTablas;
    // End of variables declaration//GEN-END:variables
}
