/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.proyectospand.Interfaces.Citas;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;

/**
 *
 * @author ING. Lomelí
 */
public class citasForm extends javax.swing.JPanel {

    /**
     * Creates new form citasForm
     */
    public citasForm() {
        initComponents();
        txtApellidosCliente.getText().isEmpty();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreCliente = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblApellidosCliente = new javax.swing.JLabel();
        txtApellidosCliente = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        lblCostoCita = new javax.swing.JLabel();
        txtCostoCita = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtNombreCliente5 = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        bttnSeleccionarFecha = new javax.swing.JButton();

        setBackground(new java.awt.Color(230, 230, 250));

        lblNombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreCliente.setText("Nombre");

        txtNombreCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreCliente.setText("Nombre del cliente");
        txtNombreCliente.setEnabled(false);

        lblApellidosCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApellidosCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblApellidosCliente.setText("Apellidos");

        txtApellidosCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidosCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidosCliente.setText("Apellidos del cliente");
        txtApellidosCliente.setEnabled(false);

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(102, 102, 102));
        lblTelefono.setText("Teléfono");

        txtTelefonoCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefonoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefonoCliente.setText("Teléfono del cliente");
        txtTelefonoCliente.setEnabled(false);

        lblNombreEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreEmpleado.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreEmpleado.setText("Nombre Empleado");

        txtNombreEmpleado.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreEmpleado.setText("Nombre del empleado");
        txtNombreEmpleado.setEnabled(false);

        lblCostoCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCostoCita.setForeground(new java.awt.Color(102, 102, 102));
        lblCostoCita.setText("Costo");

        txtCostoCita.setForeground(new java.awt.Color(153, 153, 153));
        txtCostoCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCostoCita.setText("Costo de la cita");
        txtCostoCita.setEnabled(false);

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        lblDescripcion.setText("Descripción");

        txtNombreCliente5.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreCliente5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreCliente5.setText("Breve descripción");
        txtNombreCliente5.setEnabled(false);

        txtFecha.setForeground(new java.awt.Color(153, 153, 153));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setText("AAAA/MM/DD");
        txtFecha.setEnabled(false);

        bttnSeleccionarFecha.setText("SELECCIONAR FECHA");
        bttnSeleccionarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSeleccionarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttnSeleccionarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreCliente)
                    .addComponent(lblApellidosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellidosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(lblCostoCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCostoCita, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreCliente5, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(txtFecha))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblNombreCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblApellidosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCostoCita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCostoCita, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnSeleccionarFecha)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnSeleccionarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSeleccionarFechaActionPerformed
        // Crear el calendario
        JCalendar calendario = new JCalendar();
        // Mostrar el calendario en un JOptionPane
        JOptionPane.showMessageDialog(null, calendario, "Selecciona una fecha", JOptionPane.PLAIN_MESSAGE);
        // Formato de la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Establecer la fecha seleccionada en el JTextField
        txtFecha.setText(sdf.format(calendario.getDate()));
    }//GEN-LAST:event_bttnSeleccionarFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnSeleccionarFecha;
    private javax.swing.JLabel lblApellidosCliente;
    private javax.swing.JLabel lblCostoCita;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtApellidosCliente;
    private javax.swing.JTextField txtCostoCita;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreCliente5;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
