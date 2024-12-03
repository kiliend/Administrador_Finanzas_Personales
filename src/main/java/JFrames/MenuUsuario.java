package JFrames;

import Clases.RegistroUsuario;
import Clases.Usuario;
import Clases.UsuarioSesion;
import javax.swing.JOptionPane;
import Clases.CLogin;

/**
 *
 * @author Luan Condori
 */
public class MenuUsuario extends javax.swing.JFrame {

    /**
     * Creates new form MenuUsuario
     */
    public MenuUsuario() {
        initComponents();
         // Obtener el número de cuenta de la sesión y mostrarlo en el JLabel
        String numeroCuenta = UsuarioSesion.getNumeroCuenta();
        if (numeroCuenta != null) {
            NumeroTarjeta.setText("" + numeroCuenta);
        } else {
            NumeroTarjeta.setText("");
        }
        // Obtener el id desde la sesión
        int userId = UsuarioSesion.getUserId();
        
        // Llamar al método que obtiene los detalles del usuario
        CLogin.obtenerDetallesUsuario(userId);

        // Establecer los valores de los cuadros de texto
        txNombreEditar.setText(UsuarioSesion.getNombre());
        txDNIEditar.setText(UsuarioSesion.getDni());
        txEmailEditar.setText(UsuarioSesion.getCorreoElectronico());
        txTelefonoEditar.setText(UsuarioSesion.getTelefono());
    }
    /**
     * Método para mostrar el número de tarjeta en el JLabel.
     * 
     * @param numero Número de tarjeta a mostrar.
     */
    public void setNumeroTarjeta(String numero) {
        NumeroTarjeta.setText("" + numero);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NumeroTarjeta = new javax.swing.JLabel();
        btnEditarDatos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnRegistrarCuenta = new javax.swing.JButton();
        txNombreEditar = new javax.swing.JTextField();
        txEmailEditar = new javax.swing.JTextField();
        txDNIEditar = new javax.swing.JTextField();
        txTelefonoEditar = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("DATOS PERSONALES");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Email :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Cuenta  Bancaria:");

        NumeroTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnEditarDatos.setBackground(new java.awt.Color(204, 255, 204));
        btnEditarDatos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditarDatos.setText("Editar Datos");
        btnEditarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDatosActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("DNI:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Telefono :");

        jLabel13.setText("----------------------------------------------------------------");

        btnRegistrarCuenta.setBackground(new java.awt.Color(255, 255, 204));
        btnRegistrarCuenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso.png"))); // NOI18N
        btnRegistrarCuenta.setText("Registrar Cuenta Bancaria");
        btnRegistrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCuentaActionPerformed(evt);
            }
        });

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Regresar Registros.png"))); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txEmailEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(txNombreEditar)
                                    .addComponent(txDNIEditar)
                                    .addComponent(txTelefonoEditar)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(NumeroTarjeta))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEditarDatos)
                                .addGap(68, 68, 68)
                                .addComponent(Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarCuenta)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txNombreEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txEmailEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txDNIEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txTelefonoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NumeroTarjeta))
                .addGap(35, 35, 35)
                .addComponent(btnRegistrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDatosActionPerformed

        // Validar que los campos no estén vacíos
        if (txNombreEditar.getText().isEmpty() || txEmailEditar.getText().isEmpty() || txDNIEditar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
            return;
        }

        // Validar formato de correo electrónico
        String email1 = txEmailEditar.getText();
        if (!email1.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo electrónico válido");
            return;
        }

        // obtener los datos de los campos de texto
        String nombre = txNombreEditar.getText();
        String email = txEmailEditar.getText();
        String dni = txDNIEditar.getText();
        String telefono = txTelefonoEditar.getText();

        //obtener el id del usuario que inicio sesion
        int idUsuario = UsuarioSesion.getUserId();
        //comprobar que el id de usuario haya iniciado sesion
        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(this, "Error: No se ha iniciado sesión.");
            return;
        }

        // Crear una instancia de Usuario
        Usuario usuario = new Usuario(nombre, "", dni, telefono, email, "", "");
        usuario.setIdUsuario(idUsuario);

        RegistroUsuario registroUsuario = new RegistroUsuario();
        boolean actualizado = registroUsuario.editarUsuario(usuario);

        // Verifica si la actualización fue exitosa
        if (actualizado) {
            JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos.");
        }
    }//GEN-LAST:event_btnEditarDatosActionPerformed

    private void btnRegistrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCuentaActionPerformed

        // Redirigir a la siguiente pantalla
        // Crear instancia de la nueva pantalla (por ejemplo, FormPrincipal)
        RegistrarCuentaBancaria principal = new RegistrarCuentaBancaria();

        // Mostrar la nueva pantalla
        principal.setVisible(true);

        // Cerrar la pantalla de login actual
        this.dispose();
    }//GEN-LAST:event_btnRegistrarCuentaActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // Redirigir a la siguiente pantalla
        // Crear instancia de la nueva pantalla (por ejemplo, FormPrincipal)
        Menu principal = new Menu();

        // Mostrar la nueva pantalla
        principal.setVisible(true);

        // Cerrar la pantalla de login actual
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed


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
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel NumeroTarjeta;
    private javax.swing.JButton btnEditarDatos;
    private javax.swing.JButton btnRegistrarCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txDNIEditar;
    private javax.swing.JTextField txEmailEditar;
    private javax.swing.JTextField txNombreEditar;
    private javax.swing.JTextField txTelefonoEditar;
    // End of variables declaration//GEN-END:variables
}
