
package com.proyectospand.Interfaces.Inventario;
import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ventanaInventario extends javax.swing.JPanel {

    RegistrarProductoForm rp = new RegistrarProductoForm();
    boolean modoAgregar = false;
    boolean modoEditar = false;
    public ventanaInventario() {
        initComponents();
        rp.setSize(340,529);
        rp.setLocation(0,0);
        pnlForm.removeAll();
        pnlForm.add(rp, BorderLayout.CENTER);
        pnlForm.revalidate();
        pnlForm.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlOpcionesProducto = new javax.swing.JPanel();
        lblRegistrarProducto = new javax.swing.JLabel();
        lblInformaciónProducto = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        apartadoProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1180, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOpcionesProducto.setBackground(new java.awt.Color(230, 230, 250));
        pnlOpcionesProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlOpcionesProducto.setPreferredSize(new java.awt.Dimension(346, 567));

        lblRegistrarProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRegistrarProducto.setText("¡REGISTRA UN PRODUCTO!");

        lblInformaciónProducto.setForeground(new java.awt.Color(105, 105, 105));
        lblInformaciónProducto.setText("Completa la información del producto");

        pnlForm.setBackground(new java.awt.Color(230, 230, 250));

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlOpcionesProductoLayout = new javax.swing.GroupLayout(pnlOpcionesProducto);
        pnlOpcionesProducto.setLayout(pnlOpcionesProductoLayout);
        pnlOpcionesProductoLayout.setHorizontalGroup(
            pnlOpcionesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlOpcionesProductoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlOpcionesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInformaciónProducto)
                    .addComponent(lblRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlOpcionesProductoLayout.setVerticalGroup(
            pnlOpcionesProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesProductoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblInformaciónProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(pnlOpcionesProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 352, 610));

        apartadoProductos.setBackground(new java.awt.Color(255, 255, 255));
        apartadoProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setToolTipText("");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "DESCRIPCIÓN", "PRECIO", "EXISTENCIA"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar-producto.png"))); // NOI18N
        bttnEliminar.setBorder(null);
        bttnEliminar.setBorderPainted(false);
        bttnEliminar.setContentAreaFilled(false);
        jPanel3.add(bttnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 15, 72, 60));

        bttnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-producto.png"))); // NOI18N
        bttnAgregar.setBorder(null);
        bttnAgregar.setBorderPainted(false);
        bttnAgregar.setContentAreaFilled(false);
        bttnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(bttnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 15, 72, 60));

        bttnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        bttnEditar.setBorder(null);
        bttnEditar.setBorderPainted(false);
        bttnEditar.setContentAreaFilled(false);
        bttnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(bttnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 15, 72, 60));

        bttnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/producto.png"))); // NOI18N
        bttnBuscar.setBorder(null);
        bttnBuscar.setBorderPainted(false);
        bttnBuscar.setContentAreaFilled(false);
        jPanel3.add(bttnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 15, 72, 60));

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
        jPanel3.add(bttnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 15, 72, 60));

        bttnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        bttnCancelar.setBorder(null);
        bttnCancelar.setBorderPainted(false);
        bttnCancelar.setContentAreaFilled(false);
        bttnCancelar.setEnabled(false);
        jPanel3.add(bttnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 15, 72, 60));

        lblAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAgregar.setForeground(new java.awt.Color(102, 102, 102));
        lblAgregar.setText("Agregar");
        jPanel3.add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 85, -1, 20));

        lblEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEditar.setForeground(new java.awt.Color(102, 102, 102));
        lblEditar.setText("Editar");
        jPanel3.add(lblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 85, -1, 20));

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(102, 102, 102));
        lblBuscar.setText("Buscar");
        jPanel3.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 85, -1, 20));

        lblEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(102, 102, 102));
        lblEliminar.setText("Eliminar");
        jPanel3.add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 85, -1, 20));

        lblGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(102, 102, 102));
        lblGuardar.setText("Guardar");
        lblGuardar.setEnabled(false);
        jPanel3.add(lblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 85, -1, 20));

        lblCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCancelar.setForeground(new java.awt.Color(102, 102, 102));
        lblCancelar.setText("Cancelar");
        lblCancelar.setEnabled(false);
        jPanel3.add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 85, -1, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TODOS LOS PRODUCTOS");

        txtBusqueda.setForeground(new java.awt.Color(153, 153, 153));
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqueda.setText("INGRESA EL NOMBRE DEL PRODUCTO A BUSCAR");

        javax.swing.GroupLayout apartadoProductosLayout = new javax.swing.GroupLayout(apartadoProductos);
        apartadoProductos.setLayout(apartadoProductosLayout);
        apartadoProductosLayout.setHorizontalGroup(
            apartadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apartadoProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(apartadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(apartadoProductosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(15, 15, 15))
                    .addGroup(apartadoProductosLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(apartadoProductosLayout.createSequentialGroup()
                .addGroup(apartadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(apartadoProductosLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1))
                    .addGroup(apartadoProductosLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        apartadoProductosLayout.setVerticalGroup(
            apartadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apartadoProductosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(apartadoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 840, 610));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarActionPerformed
        modoEditar = false;
        lblRegistrarProducto.setText("¡REGISTRA UN PRODUCTO!");
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
        lblRegistrarProducto.setText("¡EDITA UN PRODUCTO!");
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
        if(modoAgregar){

        } else if(modoEditar){
            
        }
    }//GEN-LAST:event_bttnGuardarActionPerformed

    //Funciones

    private void habilitarCampos(boolean habilitar){
        Component[] componentes = rp.getComponents();
        for (Component componente : componentes){
            if(componente instanceof JTextField){
                componente.setEnabled(habilitar);
            } else if(componente instanceof JComboBox){
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel apartadoProductos;
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnBuscar;
    private javax.swing.JButton bttnCancelar;
    private javax.swing.JButton bttnEditar;
    private javax.swing.JButton bttnEliminar;
    private javax.swing.JButton bttnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblInformaciónProducto;
    private javax.swing.JLabel lblRegistrarProducto;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlOpcionesProducto;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
