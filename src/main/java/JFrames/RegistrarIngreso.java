package JFrames;

import ClaseDAOImpl.IngresoDAOImpl;
import Clases.Ingreso;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * La clase {@code RegistrarIngreso} representa el formulario para registrar un
 * nuevo ingreso financiero. Se encarga de obtener los datos del usuario,
 * validarlos, y registrarlos en la base de datos. También permite exportar los
 * ingresos a un archivo Excel.
 *
 * Esta clase extiende de {@code javax.swing.JFrame} para proporcionar una
 * interfaz gráfica de usuario (GUI).
 *
 * @author Rodney Piers Salazar Arapa
 */
public class RegistrarIngreso extends javax.swing.JFrame {
private static final Logger logger = Logger.getLogger(RegistrarIngreso.class.getName());
    /**
     * Constructor de la clase {@code RegistrarIngreso}. Inicializa los
     * componentes gráficos de la interfaz de registro de ingresos.
     */
    public RegistrarIngreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        monto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        categoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        fecha = new javax.swing.JLabel();
        RegistarIngresos = new javax.swing.JButton();
        VolverMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1Fecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setText("Registrar Ingresos");

        monto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        monto.setText("Ingrese Monto:");

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        categoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        categoria.setText("¿Que tipo de ingreso es?:");

        fecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        fecha.setText("¿Cuando lo recibiste?:");

        RegistarIngresos.setBackground(new java.awt.Color(153, 255, 153));
        RegistarIngresos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        RegistarIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        RegistarIngresos.setText("REGISTRAR");
        RegistarIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistarIngresosActionPerformed(evt);
            }
        });

        VolverMenu.setBackground(new java.awt.Color(255, 102, 102));
        VolverMenu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        VolverMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Regresar Registros.png"))); // NOI18N
        VolverMenu.setText("VOLVER");
        VolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMenuActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(fecha))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(monto)
                        .addGap(89, 89, 89)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(RegistarIngresos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VolverMenu)
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(categoria)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monto)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoria))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha)
                    .addComponent(jDateChooser1Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistarIngresos)
                    .addComponent(VolverMenu))
                .addGap(44, 44, 44)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistarIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistarIngresosActionPerformed
        try {
        // Obtener los datos del formulario
        double monto = Double.parseDouble(txtMonto.getText());
        String categoria = txtCategoria.getText();
        java.util.Date fecha = jDateChooser1Fecha.getDate();
        
        // Verificar si los campos no están vacíos
        if (txtMonto.getText().isEmpty() || categoria.isEmpty() || fecha == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            logger.warning("Intento de registro fallido: Campos vacíos.");
            return;
        }
        
        // Crear el objeto Ingreso
        Ingreso ingreso = new Ingreso();
        ingreso.setCantidad(monto);
        ingreso.setDescripcion(categoria); // Usamos la categoría como descripción
        ingreso.setFecha(new java.sql.Date(fecha.getTime())); // Convertimos la fecha a java.sql.Date
        
        // Registrar el ingreso
        IngresoDAOImpl ingresoDAO = new IngresoDAOImpl();
        ingresoDAO.agregarIngreso(ingreso);
        
        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Ingreso registrado exitosamente.");
        logger.info("Ingreso registrado exitosamente: " + ingreso.toString());
        
        // Limpiar los campos después de registrar el ingreso
        txtMonto.setText("");
        txtCategoria.setText("");
        jDateChooser1Fecha.setDate(null);
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El monto ingresado no es válido.");
        logger.severe("Error de formato en el monto: " + e.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al registrar el ingreso: " + e.getMessage());
        logger.severe("Error al registrar el ingreso en la base de datos: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado.");
        logger.severe("Error inesperado: " + e.getMessage());
    }
    }//GEN-LAST:event_RegistarIngresosActionPerformed

    private void VolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMenuActionPerformed
        /**
         * Acción ejecutada cuando se presiona el botón para volver al menú
         * principal.
         *
         * Este método realiza las siguientes acciones:
         * <ul>
         * <li>Crea una nueva instancia de {@code MenuRegistrarIngresos}.</li>
         * <li>Muestra el formulario del menú secundario.</li>
         * </ul>
         *
         * @param evt el evento de acción generado por el usuario al hacer clic
         * en el botón
         */
// Crear una instancia del formulario secundario
        MenuRegistrarIngresos VolverMenu = new MenuRegistrarIngresos();

        // Hacer visible el formulario secundario
        VolverMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverMenuActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegistarIngresos;
    private javax.swing.JButton VolverMenu;
    private javax.swing.JLabel categoria;
    private javax.swing.JLabel fecha;
    private com.toedter.calendar.JDateChooser jDateChooser1Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel monto;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
