/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.proyectospand.Interfaces.Clientes;

import java.awt.Color;

/**
 *
 * @author omarr
 */
public class RegistrarClientesForm extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarClientesForm
     */
    public RegistrarClientesForm() {
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

        lblNombreCliente = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblApellidosCliente = new javax.swing.JLabel();
        txtApellidosCliente = new javax.swing.JTextField();
        lblCalleCliente = new javax.swing.JLabel();
        txtCalleCliente = new javax.swing.JTextField();
        lblNumeroCliente = new javax.swing.JLabel();
        txtNumeroCliente = new javax.swing.JTextField();
        lblColoniaCliente = new javax.swing.JLabel();
        txtColoniaCliente = new javax.swing.JTextField();
        lblTelefonoCliente = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();

        setBackground(new java.awt.Color(230, 230, 250));

        lblNombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreCliente.setText("Nombre del Cliente*");

        txtNombreCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreCliente.setText("Ingresa el nombre del cliente");
        txtNombreCliente.setEnabled(false);
        txtNombreCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreClienteFocusGained(evt);
            }
        });
        txtNombreCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNombreClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreClienteMousePressed(evt);
            }
        });

        lblApellidosCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApellidosCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblApellidosCliente.setText("Apellidos del Cliente*");

        txtApellidosCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidosCliente.setText("Ingresa los apellidos del cliente");
        txtApellidosCliente.setEnabled(false);
        txtApellidosCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidosClienteFocusGained(evt);
            }
        });
        txtApellidosCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtApellidosClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidosClienteMousePressed(evt);
            }
        });

        lblCalleCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCalleCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblCalleCliente.setText("Calle*");

        txtCalleCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtCalleCliente.setText("Ingresa la calle del cliente");
        txtCalleCliente.setEnabled(false);
        txtCalleCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCalleClienteFocusGained(evt);
            }
        });
        txtCalleCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCalleClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCalleClienteMousePressed(evt);
            }
        });

        lblNumeroCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumeroCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblNumeroCliente.setText("Número*");

        txtNumeroCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtNumeroCliente.setText("Ingresa el número del cliente");
        txtNumeroCliente.setEnabled(false);
        txtNumeroCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroClienteFocusGained(evt);
            }
        });
        txtNumeroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNumeroClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNumeroClienteMousePressed(evt);
            }
        });

        lblColoniaCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblColoniaCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblColoniaCliente.setText("Colonia*");

        txtColoniaCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtColoniaCliente.setText("Ingresa la colonia del cliente");
        txtColoniaCliente.setEnabled(false);
        txtColoniaCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtColoniaClienteFocusGained(evt);
            }
        });
        txtColoniaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtColoniaClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtColoniaClienteMousePressed(evt);
            }
        });

        lblTelefonoCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefonoCliente.setForeground(new java.awt.Color(102, 102, 102));
        lblTelefonoCliente.setText("Teléfono*");

        txtTelefonoCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefonoCliente.setText("Ingresa el teléfono del cliente");
        txtTelefonoCliente.setEnabled(false);
        txtTelefonoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoClienteFocusGained(evt);
            }
        });
        txtTelefonoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTelefonoClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoClienteMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreCliente)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidosCliente)
                    .addComponent(txtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCalleCliente)
                    .addComponent(txtCalleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroCliente)
                    .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColoniaCliente)
                    .addComponent(txtColoniaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefonoCliente)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblApellidosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCalleCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCalleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumeroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblColoniaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtColoniaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefonoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreClienteFocusGained
        if(txtNombreCliente.getText().equals("Ingresa el nombre del cliente")){
            txtNombreCliente.setText("");
            txtNombreCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreClienteFocusGained

    private void txtNombreClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreClienteMouseExited
        if (txtNombreCliente.getText().isEmpty()){
            txtNombreCliente.setText("Ingresa el nombre del cliente");
            txtNombreCliente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtNombreClienteMouseExited

    private void txtNombreClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreClienteMousePressed
        if(txtNombreCliente.getText().equals("Ingresa el nombre del cliente")){
            txtNombreCliente.setText("");
            txtNombreCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreClienteMousePressed

    private void txtApellidosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosClienteFocusGained
        if (txtApellidosCliente.getText().equals("Ingresa los apellidos del cliente")){ 
            txtApellidosCliente.setText("");
            txtApellidosCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtApellidosClienteFocusGained

    private void txtApellidosClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosClienteMouseExited
        if (txtApellidosCliente.getText().isEmpty()){ 
            txtApellidosCliente.setText("Ingresa los apellidos del cliente");
            txtApellidosCliente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtApellidosClienteMouseExited

    private void txtApellidosClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosClienteMousePressed
        if (txtApellidosCliente.getText().equals("Ingresa los apellidos del cliente")){ 
            txtApellidosCliente.setText("");
            txtApellidosCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtApellidosClienteMousePressed

    private void txtCalleClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalleClienteFocusGained
        if (txtCalleCliente.getText().equals("Ingresa la calle del cliente")){ 
            txtCalleCliente.setText("");
            txtCalleCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCalleClienteFocusGained

    private void txtCalleClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCalleClienteMouseExited
        if (txtCalleCliente.getText().isEmpty()){ 
            txtCalleCliente.setText("Ingresa la calle del cliente");
            txtCalleCliente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtCalleClienteMouseExited

    private void txtCalleClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCalleClienteMousePressed
        if (txtCalleCliente.getText().equals("Ingresa la calle del cliente")){ 
            txtCalleCliente.setText("");
            txtCalleCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCalleClienteMousePressed

    private void txtNumeroClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroClienteFocusGained
        if (txtNumeroCliente.getText().equals("Ingresa el número del cliente")){ 
            txtNumeroCliente.setText("");
            txtNumeroCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNumeroClienteFocusGained

    private void txtNumeroClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumeroClienteMouseExited
        if (txtNumeroCliente.getText().isEmpty()){ 
            txtNumeroCliente.setText("Ingresa el número del cliente");
            txtNumeroCliente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtNumeroClienteMouseExited

    private void txtNumeroClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumeroClienteMousePressed
        if (txtNumeroCliente.getText().equals("Ingresa el número del cliente")){ 
            txtNumeroCliente.setText("");
            txtNumeroCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNumeroClienteMousePressed

    private void txtColoniaClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtColoniaClienteFocusGained
        if (txtColoniaCliente.getText().equals("Ingresa la colonia del cliente")){ 
            txtColoniaCliente.setText("");
            txtColoniaCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtColoniaClienteFocusGained

    private void txtColoniaClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtColoniaClienteMouseExited
        if (txtColoniaCliente.getText().isEmpty()){ 
            txtColoniaCliente.setText("Ingresa la colonia del cliente");
            txtColoniaCliente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtColoniaClienteMouseExited

    private void txtColoniaClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtColoniaClienteMousePressed
        if (txtColoniaCliente.getText().equals("Ingresa la colonia del cliente")){ 
            txtColoniaCliente.setText("");
            txtColoniaCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtColoniaClienteMousePressed

    private void txtTelefonoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoClienteFocusGained
        if (txtTelefonoCliente.getText().equals("Ingresa el teléfono del cliente")){ 
            txtTelefonoCliente.setText("");
            txtTelefonoCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTelefonoClienteFocusGained

    private void txtTelefonoClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoClienteMouseExited
        if (txtTelefonoCliente.getText().isEmpty()){ 
            txtTelefonoCliente.setText("Ingresa el teléfono del cliente");
            txtTelefonoCliente.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtTelefonoClienteMouseExited

    private void txtTelefonoClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoClienteMousePressed
        if (txtTelefonoCliente.getText().equals("Ingresa el teléfono del cliente")){ 
            txtTelefonoCliente.setText("");
            txtTelefonoCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTelefonoClienteMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblApellidosCliente;
    private javax.swing.JLabel lblCalleCliente;
    private javax.swing.JLabel lblColoniaCliente;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNumeroCliente;
    private javax.swing.JLabel lblTelefonoCliente;
    private javax.swing.JTextField txtApellidosCliente;
    private javax.swing.JTextField txtCalleCliente;
    private javax.swing.JTextField txtColoniaCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNumeroCliente;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
