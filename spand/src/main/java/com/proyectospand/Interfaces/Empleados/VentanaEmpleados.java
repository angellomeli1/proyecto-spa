    package com.proyectospand.Interfaces.Empleados;

    import java.awt.*;
import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.List;

    import javax.swing.JButton;
    import javax.swing.JComboBox;
    import javax.swing.JOptionPane;
    import javax.swing.JTextField;
    import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
    import javax.swing.event.ListSelectionListener;
    import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.proyectospand.ConexionDB.conexionDB;
    import com.proyectospand.Entidades.Empleados;
    import com.proyectospand.Entidades.TipoEmpleado;
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
        boolean modoBuscar = false;
        DefaultTableModel modeloTabla;
        EmpleadosDAO empleadosDAO = new EmpleadosDAO();
        private String nombreEmpleado;
        private String apellidosEmp;
        private String calle;
        private String numero;
        private String colonia;
        private String nss;
        private Date fechaContrato;
        private String clave;
        //Variables para la inserción, actualización y eliminación de empleados
        private boolean empleadoEstadoAE;
        //Guarda la id del empleado a actualizar
        private int empleadoAE;
        //fin variables para inserción, actualización y eliminación de empleados
        private Empleados empleadoE;
        public VentanaEmpleados(Empleados empleado) {
            initComponents();
            this.empleadoE = empleado;
            System.out.println("El empleado que esta manipulando el sistema es: " + empleadoE.getNombreEmp() + "Y es de tipo: " + empleadoE.getTipo().getNombreTipo());
            remp.setSize(338, 452);
            remp.setLocation(0, 0);
            pnlFormEmp.removeAll();
            pnlFormEmp.add(remp, BorderLayout.CENTER);
            pnlFormEmp.revalidate();
            pnlFormEmp.repaint();
            cargarDatosEmpleados();
            TableColumn columna = (TableColumn)jTable1.getColumnModel().getColumn(10);
            columna.setMinWidth(0);
            columna.setMaxWidth(0);
            columna.setWidth(0);
            columna.setPreferredWidth(0);
            columna.setResizable(false);
            jTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting()) {
                        if(!modoAgregar){
                            int selectedRow = jTable1.getSelectedRow();
                            if (selectedRow >= 0) {
                                // Extraer los datos de la fila seleccionada
                                empleadoAE = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
                                remp2.setTipo(jTable1.getValueAt(selectedRow, 1).toString());
                                remp.setTxtNombreEmp(jTable1.getValueAt(selectedRow, 2).toString());
                                remp.setTxtApellidosEmp(jTable1.getValueAt(selectedRow, 3).toString());
                                remp.setTxtCalleEmp(jTable1.getValueAt(selectedRow, 4).toString());
                                remp.setTxtNumeroEmp(jTable1.getValueAt(selectedRow, 5).toString());
                                remp.setTxtColoniaEmp(jTable1.getValueAt(selectedRow, 6).toString());
                                remp.setTxtNssEmp(jTable1.getValueAt(selectedRow, 7).toString());
                                remp2.setFechaContrato(jTable1.getValueAt(selectedRow, 8).toString());
                                String estado = jTable1.getValueAt(selectedRow, 9).toString();
                                empleadoEstadoAE = estado.equalsIgnoreCase("Sí") ? true : false;
                                activarBotonActDes();
                                if(!modoEditar){
                                    if(empleadoEstadoAE){
                                        lblActDes.setText("Desactivar");
                                    } else {
                                        lblActDes.setText("Activar");
                                    }
                                    lblActDes.revalidate();
                                    lblActDes.repaint();
                                }
                                remp2.setClave(jTable1.getValueAt(selectedRow, 10).toString());
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
            
                private void actualizarTabla() {
                    if(!txtBusqueda.getText().equals("INGRESA EL NOMBRE DEL EMPLEADO A BUSCAR")){
                        String textoBusqueda = txtBusqueda.getText().trim();
                        List<Empleados> empleados;
            
                        if (textoBusqueda.isEmpty()) {
                            empleados = empleadosDAO.listar(); // Método que lista todos los empleados
                        } else {
                            empleados = empleadosDAO.buscar(textoBusqueda);
                        }
                
                        // Actualiza el modelo de la tabla con los resultados
                        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                        modelo.setRowCount(0); // Limpiar la tabla
                
                        for (Empleados empleado : empleados) {
                            Object[] fila = new Object[]{
                                empleado.getIdEmpleado(),
                                empleado.getTipo().getNombreTipo(),
                                empleado.getNombreEmp(),
                                empleado.getApellidosEmp(),
                                empleado.getCalle(),
                                empleado.getNumero(),
                                empleado.getColonia(),
                                empleado.getNss(),
                                empleado.getFechaDeContrato(),
                                empleado.getActivo() ? "Activo" : "Inactivo"
                            };
                            modelo.addRow(fila);
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
        bttnActDes = new javax.swing.JButton();
        lblActDes = new javax.swing.JLabel();
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
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Empleado", "Tipo de Empleado", "Nombre", "Apellidos", "Calle", "Numero", "Colonia", "NSS", "Fecha de contrato", "Activo", "Clave"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        txtBusqueda.setText("INGRESA EL NOMBRE DEL EMPLEADO A BUSCAR");
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
            .addGroup(pnlVentanaEmpLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
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
            nombreEmpleado = remp.getNombreEmp();
            apellidosEmp = remp.getApellidosEmp();
            calle = remp.getCalleEmp();
            numero = remp.getNumeroEmp();
            colonia = remp.getColoniaEmp();
            nss = remp.getNSS();
            try{
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fechaContrato = formato.parse(remp2.getFechaContrato());
            } catch(Exception e){
                System.out.println(e);
            }
            clave = remp2.getClave();
            int idTipoEmpleado = remp2.getTipoEmpleado();
            TipoEmpleado tipo = obtenerTipoEmpleado(idTipoEmpleado);
            Empleados empleado = new Empleados();
            if(modoAgregar){
                empleado = new Empleados(0,nombreEmpleado,tipo,apellidosEmp,calle,numero,colonia,nss,fechaContrato,true,clave);
                if(empleadosDAO.insertar(empleado,empleadoE)){
                    JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente");
                    cargarDatosEmpleados();
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no agregado");
                }
            }
            if(modoEditar){
                empleado = new Empleados(empleadoAE,nombreEmpleado,tipo,apellidosEmp,calle,numero,colonia,nss,fechaContrato,empleadoEstadoAE,clave);
                if(empleadosDAO.actualizar(empleado,empleadoE)){
                    JOptionPane.showMessageDialog(null, "Empleado editado exitosamente");
                    cargarDatosEmpleados();
                } else {
                    JOptionPane.showMessageDialog(null, "pleado no editado");
                }
            }
        }//GEN-LAST:event_bttnGuardarActionPerformed

    private void txtBusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusquedaFocusGained
            txtBusqueda.setText("");
            txtBusqueda.setForeground(Color.black);
    }//GEN-LAST:event_txtBusquedaFocusGained

    private void txtBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaMouseExited
        if(txtBusqueda.getText().isEmpty()){
           txtBusqueda.setText("INGRESA EL NOMBRE DEL EMPLEADO A BUSCAR");
           txtBusqueda.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtBusquedaMouseExited

    private void bttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelarActionPerformed
        remp.limpiarCampos();
        remp2.limpiarCampos();
        modoAgregar = false;
        modoEditar = false;
        remp.habilitarCampos(false);
        remp2.habilitarComponentes(false);
        bttnBuscar.setEnabled(true);
        lblBuscar.setEnabled(true);
        bttnActDes.setEnabled(true);
        lblActDes.setEnabled(true);
        lblRegistrarEmpleado.setText("¡REGISTRA UN EMPLEADO!");
    }//GEN-LAST:event_bttnCancelarActionPerformed

    private void txtBusquedaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaMousePressed
        txtBusqueda.setText("");
        txtBusqueda.setForeground(Color.black);
    }//GEN-LAST:event_txtBusquedaMousePressed

    private void bttnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        if(modoBuscar){
            txtBusqueda.setEnabled(false);
            txtBusqueda.setFocusable(false);
            modoBuscar = false;

        }
        else {
            txtBusqueda.setEnabled(true);
            txtBusqueda.setFocusable(true);
            modoBuscar = true;
        }
    }

    private void bttnActDesActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(empleadoEstadoAE){
            if(empleadosDAO.desactivar(empleadoAE,empleadoE)){
                JOptionPane.showMessageDialog(null, "Empleado desactivado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al desactivar el empleado");
            }
        } else {
            if(empleadosDAO.activar(empleadoAE)){
                JOptionPane.showMessageDialog(null, "Empleado activado exitosamente");
                
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al activar el empleado");
            }
        }
        empleadoAE = 0;
        activarBotonActDes();
        cargarDatosEmpleados();
    }

        public TipoEmpleado obtenerTipoEmpleado(int idTipoEmpleado) {
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
        
            TipoEmpleado tipoEmpleado = null;
        
            try {
                conn = conexionDB.getIntance().getConnection();
        
                // Definir la consulta SQL
                String query = "SELECT * FROM TipoEmpleado WHERE idTipoEmpleado = ?";
                statement = conn.prepareStatement(query);
                // Establecer el valor del parámetro
                statement.setInt(1, idTipoEmpleado);
        
                // Ejecutar la consulta
                rs = statement.executeQuery();
        
                // Procesar el resultado
                if (rs.next()) {
                    int idTipo = rs.getInt("idTipoEmpleado");
                    String nombreTipo = rs.getString("nombreTipo");
                    double sueldo = rs.getDouble("sueldo");
        
                    // Crear el objeto TipoEmpleado con los datos obtenidos
                    tipoEmpleado = new TipoEmpleado(idTipo, nombreTipo, sueldo);
                }
        
            } catch (SQLException e) {
                e.printStackTrace(); // Cambié System.out.println por printStackTrace para un mejor diagnóstico de errores
            } finally {
                // Cerrar ResultSet, PreparedStatement y Connection en el bloque finally
                try {
                    if (rs != null) rs.close();
                    if (statement != null) statement.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        
            return tipoEmpleado;
        }

        private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bttnAgregarActionPerformed
            modoEditar = false;
            lblRegistrarEmpleado.setText("¡REGISTRA UN EMPLEADO!");
            if (modoAgregar) {
                remp.habilitarCampos(false);
                remp2.habilitarComponentes(false);
                modoAgregar = false;
                habilitarGuardarCancelar(false);
                bttnActDes.setEnabled(true);
                lblActDes.setEnabled(true);
                lblBuscar.setEnabled(true);
                bttnBuscar.setEnabled(true);
            } else {
                remp.limpiarCampos();
                remp2.limpiarCampos();
                remp.habilitarCampos(true);
                remp2.habilitarComponentes(true);
                modoAgregar = true;
                habilitarGuardarCancelar(true);
                bttnActDes.setEnabled(false);
                lblActDes.setEnabled(false);
                lblBuscar.setEnabled(false);
                bttnBuscar.setEnabled(false);
            }
        }// GEN-LAST:event_bttnAgregarActionPerformed

        private void bttnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bttnEditarActionPerformed
            modoAgregar = false;
            lblRegistrarEmpleado.setText("¡EDITA UN PROVEEDOR!");
            if (modoEditar) {
                remp.habilitarCampos(false);
                remp2.habilitarComponentes(true);
                modoEditar = false;
                habilitarGuardarCancelar(false);
                bttnActDes.setEnabled(true);
            } else {
                remp.habilitarCampos(true);
                remp2.habilitarComponentes(true);
                modoEditar = true;
                habilitarGuardarCancelar(true);
                bttnActDes.setEnabled(false);
            }
            // Una vez que la query sea exitosa y guarde los cambios, los campos se
            // deshabilitaran
        }// GEN-LAST:event_bttnEditarActionPerformed

        private void bttnCambiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bttnCambiarActionPerformed
            String text = bttnCambiar.getText();
            if ("Siguiente".equals(text)) {
                remp2.setSize(338, 452);
                remp2.setLocation(0, 0);
                pnlFormEmp.removeAll();
                pnlFormEmp.add(remp2, BorderLayout.CENTER);
                pnlFormEmp.revalidate();
                pnlFormEmp.repaint();
                bttnCambiar.setText("Anterior");
            } else if ("Anterior".equals(text)) {
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
                    emp.getActivo() ? "Sí" : "No",
                    emp.getContrasena()
                });
            }
            
            // Establecer el modelo de la tabla
            jTable1.setModel(modeloTabla);
        }

        public void activarBotonActDes(){
            if(empleadoAE == 0){
                bttnActDes.setEnabled(false);
            } else {
                bttnActDes.setEnabled(true);
            }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnActDes;
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnBuscar;
    private javax.swing.JButton bttnCambiar;
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
