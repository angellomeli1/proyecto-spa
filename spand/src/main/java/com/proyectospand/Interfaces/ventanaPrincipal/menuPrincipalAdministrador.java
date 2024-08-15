
package com.proyectospand.Interfaces.ventanaPrincipal;
import com.proyectospand.Entidades.Empleados;
import com.proyectospand.Interfaces.confUI;
import com.proyectospand.Interfaces.Inventario.*;
import com.proyectospand.Interfaces.Proveedores.*;
public class menuPrincipalAdministrador extends javax.swing.JFrame {

    private Empleados empleado = new Empleados();
    private ventanaInventario inventario = new ventanaInventario();
    private VentanaProveedor proveedores = new VentanaProveedor();

    public menuPrincipalAdministrador(Empleados empleado) {
        this.empleado = empleado;
        initComponents();
        this.setLocationRelativeTo(null);
        confUI.applyCustomFont(16f, lblBienvenida);
        lblBienvenida.setText("BIENVENIDO: " + empleado.getNombreEmp() + " - Rol: " + empleado.getTipo().getNombreTipo());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlInterfaces = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bttnCitas = new javax.swing.JButton();
        bttnClientes = new javax.swing.JButton();
        bttnEmpleados = new javax.swing.JButton();
        bttnInventario = new javax.swing.JButton();
        bttnProveedores = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(230, 230, 250));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInterfaces.setPreferredSize(new java.awt.Dimension(1000, 0));

        javax.swing.GroupLayout pnlInterfacesLayout = new javax.swing.GroupLayout(pnlInterfaces);
        pnlInterfaces.setLayout(pnlInterfacesLayout);
        pnlInterfacesLayout.setHorizontalGroup(
            pnlInterfacesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        pnlInterfacesLayout.setVerticalGroup(
            pnlInterfacesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        pnlFondo.add(pnlInterfaces, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 1180, 610));

        jPanel2.setBackground(new java.awt.Color(230, 230, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.png"))); // NOI18N
        bttnCitas.setText("CITAS");
        bttnCitas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bttnCitas.setIconTextGap(0);
        bttnCitas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bttnCitas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bttnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCitasActionPerformed(evt);
            }
        });
        jPanel2.add(bttnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 159, 118, -1));

        bttnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.png"))); // NOI18N
        bttnClientes.setText("CLIENTES");
        bttnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bttnClientes.setIconTextGap(0);
        bttnClientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bttnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(bttnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, 118, -1));

        bttnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.png"))); // NOI18N
        bttnEmpleados.setText("EMPLEADOS");
        bttnEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bttnEmpleados.setIconTextGap(0);
        bttnEmpleados.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bttnEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(bttnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 483, 118, -1));

        bttnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.png"))); // NOI18N
        bttnInventario.setText("INVENTARIO");
        bttnInventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bttnInventario.setIconTextGap(0);
        bttnInventario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bttnInventario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bttnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnInventarioActionPerformed(evt);
            }
        });
        jPanel2.add(bttnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 267, 118, -1));

        bttnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.png"))); // NOI18N
        bttnProveedores.setText("PROVEEDORES");
        bttnProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bttnProveedores.setIconTextGap(0);
        bttnProveedores.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bttnProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bttnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnProveedoresActionPerformed(evt);
            }
        });
        jPanel2.add(bttnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 375, 118, -1));

        pnlFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 640));

        jPanel3.setBackground(new java.awt.Color(220, 220, 240));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(730, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pnlFondo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttnCitasActionPerformed

    private void bttnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnInventarioActionPerformed
        inventario.setSize(1180,610);
        inventario.setLocation(0, 0);
        pnlInterfaces.removeAll();
        pnlInterfaces.add(inventario);
        pnlInterfaces.revalidate();
        pnlInterfaces.repaint();
    }//GEN-LAST:event_bttnInventarioActionPerformed

    private void bttnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnProveedoresActionPerformed
        proveedores.setSize(1180,610);
        proveedores.setLocation(0, 0);
        pnlInterfaces.removeAll();
        pnlInterfaces.add(proveedores);
        pnlInterfaces.revalidate();
        pnlInterfaces.repaint();
    }//GEN-LAST:event_bttnProveedoresActionPerformed

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
            java.util.logging.Logger.getLogger(menuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados empleado = new Empleados(); // Crea o recibe el objeto Empleados
                new menuPrincipalAdministrador(empleado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnCitas;
    private javax.swing.JButton bttnClientes;
    private javax.swing.JButton bttnEmpleados;
    private javax.swing.JButton bttnInventario;
    private javax.swing.JButton bttnProveedores;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInterfaces;
    // End of variables declaration//GEN-END:variables
}
