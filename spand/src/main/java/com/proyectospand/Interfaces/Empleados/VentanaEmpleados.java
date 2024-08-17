package com.proyectospand.Interfaces.Empleados;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.proyectospand.Entidades.Empleados;
import com.proyectospand.datos.EmpleadosDAO;

/**
 *
 * @author omarr
 */
public class VentanaEmpleados extends javax.swing.JPanel {
    RegistrarEmpleadoForm remp = new RegistrarEmpleadoForm();
    RegistrarEmpleadosForm2 remp2 = new RegistrarEmpleadosForm2();
    boolean modoAgregar = false;
    boolean modoEditar = false;
    DefaultTableModel modeloTabla;
    EmpleadosDAO empleadosDAO = new EmpleadosDAO();

    public VentanaEmpleados() {
        initComponents();

        remp.setSize(338, 452);
        remp.setLocation(0, 0);
        pnlFormEmp.removeAll();
        pnlFormEmp.add(remp, BorderLayout.CENTER);
        pnlFormEmp.revalidate();
        pnlFormEmp.repaint();
        cargarDatosEmpleados();
        List<Empleados> listaEmpleados = empleadosDAO.listar();
        System.out.println("Número de empleados: " + listaEmpleados.size());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOpcionesEmpleados = new javax.swing.JPanel();
        lblRegistrarEmpleado = new javax.swing.JLabel();
        lblInformacionEmpleado = new javax.swing.JLabel();
        pnlFormEmp = new javax.swing.JPanel();
        bttnCambiar = new javax.swing.JButton();
        pnlVentanaEmp = new javax.swing.JPanel();
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
        bttnEliminar = new javax.swing.JButton();
        lblEliminar = new javax.swing.JLabel();
        bttnGuardar = new javax.swing.JButton();
        lblGuardar = new javax.swing.JLabel();
        bttnCancelar = new javax.swing.JButton();
        lblCancelar = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOpcionesEmpleados.setBackground(new java.awt.Color(230, 230, 250));
        pnlOpcionesEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRegistrarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRegistrarEmpleado.setText("¡REGISTRA UN EMPLEADO!");

        lblInformacionEmpleado.setForeground(new java.awt.Color(105, 105, 105));
        lblInformacionEmpleado.setText("Completa la información del empleado");

        pnlFormEmp.setBackground(new java.awt.Color(230, 230, 250));

        javax.swing.GroupLayout pnlFormEmpLayout = new javax.swing.GroupLayout(pnlFormEmp);
        pnlFormEmp.setLayout(pnlFormEmpLayout);
        pnlFormEmpLayout.setHorizontalGroup(
            pnlFormEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlFormEmpLayout.setVerticalGroup(
            pnlFormEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        bttnCambiar.setText("Siguiente");
        bttnCambiar.setEnabled(false);
        bttnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesEmpleadosLayout = new javax.swing.GroupLayout(pnlOpcionesEmpleados);
        pnlOpcionesEmpleados.setLayout(pnlOpcionesEmpleadosLayout);
        pnlOpcionesEmpleadosLayout.setHorizontalGroup(
            pnlOpcionesEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFormEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlOpcionesEmpleadosLayout.createSequentialGroup()
                        .addGroup(pnlOpcionesEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegistrarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlOpcionesEmpleadosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblInformacionEmpleado)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlOpcionesEmpleadosLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(bttnCambiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpcionesEmpleadosLayout.setVerticalGroup(
            pnlOpcionesEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesEmpleadosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRegistrarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformacionEmpleado)
                .addGap(18, 18, 18)
                .addComponent(pnlFormEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttnCambiar)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(pnlOpcionesEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 352, 610));

        pnlVentanaEmp.setBackground(new java.awt.Color(255, 255, 255));
        pnlVentanaEmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Empleado", "Tipo de Empleado", "Nombre", "Apellidos", "Calle", "Numero", "Colonia", "NSS", "Fecha de contrato", "Activo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("TODOS LOS EMPLEADOS");

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

        txtBusqueda.setForeground(new java.awt.Color(153, 153, 153));
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqueda.setText("INGRESA EL NOMBRE DEL EMPLEADO A BUSCAR");

        javax.swing.GroupLayout pnlVentanaEmpLayout = new javax.swing.GroupLayout(pnlVentanaEmp);
        pnlVentanaEmp.setLayout(pnlVentanaEmpLayout);
        pnlVentanaEmpLayout.setHorizontalGroup(
            pnlVentanaEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentanaEmpLayout.createSequentialGroup()
                .addGroup(pnlVentanaEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVentanaEmpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlVentanaEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)))
                    .addGroup(pnlVentanaEmpLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentanaEmpLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        pnlVentanaEmpLayout.setVerticalGroup(
            pnlVentanaEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentanaEmpLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlVentanaEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 830, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnGuardarActionPerformed
        cargarDatosEmpleados();
    }//GEN-LAST:event_bttnGuardarActionPerformed

    private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bttnAgregarActionPerformed
        modoEditar = false;
        lblRegistrarEmpleado.setText("¡REGISTRA UN EMPLEADO!");
        if (modoAgregar) {
            habilitarCampos(false);
            habilitarCampos2(false);
            modoAgregar = false;
            habilitarGuardarCancelar(false);
            bttnCambiar.setEnabled(false);
        } else {
            habilitarCampos(true);
            habilitarCampos2(true);
            modoAgregar = true;
            habilitarGuardarCancelar(true);
            bttnCambiar.setEnabled(true);
        }
    }// GEN-LAST:event_bttnAgregarActionPerformed

    private void bttnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bttnEditarActionPerformed
        modoAgregar = false;
        lblRegistrarEmpleado.setText("¡EDITA UN PROVEEDOR!");
        if (modoEditar) {
            habilitarCampos(false);
            modoEditar = false;
            habilitarGuardarCancelar(false);
        } else {
            habilitarCampos(true);
            modoEditar = true;
            habilitarGuardarCancelar(true);
        }
        // Una vez que la query sea exitosa y guarde los cambios, los campos se
        // deshabilitaran
    }// GEN-LAST:event_bttnEditarActionPerformed

    private void bttnCambiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bttnCambiarActionPerformed
        String text = bttnCambiar.getText();
        if (text == "Siguiente") {
            remp2.setSize(338, 452);
            remp2.setLocation(0, 0);
            pnlFormEmp.removeAll();
            pnlFormEmp.add(remp2, BorderLayout.CENTER);
            pnlFormEmp.revalidate();
            pnlFormEmp.repaint();
            bttnCambiar.setText("Anterior");
        } else if (text == "Anterior") {
            remp.setSize(338, 452);
            remp.setLocation(0, 0);
            pnlFormEmp.removeAll();
            pnlFormEmp.add(remp, BorderLayout.CENTER);
            pnlFormEmp.revalidate();
            pnlFormEmp.repaint();
            bttnCambiar.setText("Siguiente");
        }
    }// GEN-LAST:event_bttnCambiarActionPerformed

    // Funciones
    private void habilitarCampos(boolean habilitar) {
        Component[] componentes = remp.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                componente.setEnabled(habilitar);
            }
        }
    }// Fin de la función

    private void habilitarCampos2(boolean habilitar) {
        Component[] componentes = remp2.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                componente.setEnabled(habilitar);
            }
        }
    }// Fin de la función

    private void habilitarGuardarCancelar(boolean habilitar) {
        bttnGuardar.setEnabled(habilitar);
        bttnCancelar.setEnabled(habilitar);
        lblGuardar.setEnabled(habilitar);
        lblCancelar.setEnabled(habilitar);
    }

    private void cargarDatosEmpleados() {
        // Obtener la lista de empleados desde el DAO
        List<Empleados> listaEmpleados = empleadosDAO.listar();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        // Limpiar el modelo de tabla existente
        modeloTabla.setRowCount(0); // Elimina todas las filas existentes
        // Iterar sobre la lista de empleados y agregar los datos al modelo
        for (Empleados emp : listaEmpleados) {
            modeloTabla.addRow(new Object[] {
                emp.getIdEmpleado(),
                emp.getTipo().getNombreTipo(),
                emp.getNombreEmp(),
                emp.getApellidosEmp(),
                emp.getCalle(),
                emp.getNumero(),
                emp.getColonia(),
                emp.getNss(),
                emp.getFechaDeContrato(),
                emp.getActivo() ? "Sí" : "No"
            });
        }
        
        // Establecer el modelo de la tabla
        jTable1.setModel(modeloTabla);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnBuscar;
    private javax.swing.JButton bttnCambiar;
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
    private javax.swing.JLabel lblInformacionEmpleado;
    private javax.swing.JLabel lblRegistrarEmpleado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormEmp;
    private javax.swing.JPanel pnlOpcionesEmpleados;
    private javax.swing.JPanel pnlVentanaEmp;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
