package JFrames;

import RegistrarIngreso.GestorFinanzas;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
        txtFecha = new javax.swing.JTextField();
        RegistarIngresos = new javax.swing.JButton();
        VolverMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(categoria)
                        .addGap(48, 48, 48)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(RegistarIngresos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VolverMenu)
                .addGap(102, 102, 102))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
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
        /**
         * Acción ejecutada cuando se presiona el botón para registrar ingresos.
         *
         * Este método realiza las siguientes acciones:
         * <ul>
         * <li>Obtiene los valores de los campos de texto de la interfaz.</li>
         * <li>Valida que los campos no estén vacíos.</li>
         * <li>Convierte los valores ingresados a los tipos de datos
         * correspondientes (monto y fecha).</li>
         * <li>Registra el ingreso en la base de datos usando
         * {@code GestorFinanzas}.</li>
         * <li>Exporta los ingresos a un archivo Excel.</li>
         * <li>Muestra un mensaje de éxito al usuario.</li>
         * </ul>
         *
         * @param evt el evento de acción generado por el usuario al hacer clic
         * en el botón
         * @throws NumberFormatException si el formato del monto es incorrecto
         * @throws DateTimeParseException si el formato de la fecha es
         * incorrecto
         */
        // 1. Obtener los valores de los campos de texto
        String montoStr = txtMonto.getText();
        String categoria = txtCategoria.getText();
        String fechaStr = txtFecha.getText();

        // 2. Validar que los campos no estén vacíos
        if (montoStr.isEmpty() || categoria.isEmpty() || fechaStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        // 3. Convertir el texto a los tipos de datos correspondientes
        double monto;
        LocalDate fecha;
        try {
            monto = Double.parseDouble(montoStr);
            fecha = LocalDate.parse(fechaStr);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El formato de monto es incorrecto.");
            return;
        } catch (DateTimeParseException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El formato de fecha es incorrecto. Usa YYYY-MM-DD.");
            return;
        }

        // 4. Registrar el ingreso en la base de datos
        GestorFinanzas gestor = new GestorFinanzas();
        gestor.registrarIngreso(monto, categoria, fecha);

        // 5. Exportar ingresos a Excel
        gestor.exportarIngresos(); // Llamar a la exportación

        // 6. Mostrar un mensaje de éxito
        javax.swing.JOptionPane.showMessageDialog(this, "Ingreso registrado con éxito, exportado a Excel y exportado a una copia de seguridad.");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel monto;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
