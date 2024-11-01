package JFrames;

/**
 * Clase Menu representa la interfaz gráfica principal del sistema. Desde este
 * menú, el usuario puede acceder a diferentes funcionalidades como el registro
 * de ingresos, gastos, objetivos y reportes.
 *
 * @author Rodney Piers Salazar Arapa
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Constructor de la clase Menu que inicializa el menú principal de la aplicación.
     */
    public Menu() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Ingresos = new javax.swing.JButton();
        Gastos = new javax.swing.JButton();
        Objetivo = new javax.swing.JButton();
        Reportes = new javax.swing.JButton();
        CerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        Ingresos.setBackground(new java.awt.Color(204, 255, 204));
        Ingresos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Ingresos.setText("INGRESOS");
        Ingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresosActionPerformed(evt);
            }
        });

        Gastos.setBackground(new java.awt.Color(255, 153, 153));
        Gastos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Gastos.setText("GASTOS");
        Gastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GastosActionPerformed(evt);
            }
        });

        Objetivo.setBackground(new java.awt.Color(255, 255, 0));
        Objetivo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Objetivo.setText("OBJETIVO");
        Objetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjetivoActionPerformed(evt);
            }
        });

        Reportes.setBackground(new java.awt.Color(0, 255, 204));
        Reportes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Reportes.setText("REPORTES");
        Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesActionPerformed(evt);
            }
        });

        CerrarSesion.setBackground(new java.awt.Color(0, 102, 204));
        CerrarSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        CerrarSesion.setText("CERRAR SESION");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("ADMINISTRADOR DE FINANZAS PERSONAL");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso5.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/objetivo1.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gasto1.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(Ingresos)
                                        .addGap(90, 90, 90)
                                        .addComponent(Gastos)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Objetivo)
                                        .addGap(18, 18, 18)))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Reportes))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(CerrarSesion)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ingresos)
                    .addComponent(Gastos)
                    .addComponent(Objetivo)
                    .addComponent(Reportes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(CerrarSesion)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // Lógica para cerrar sesión. Se puede implementar la redirección al formulario de login.
         FormLogin IrLogin = new FormLogin(); // Se cambia el FormLogin
         IrLogin.setVisible(true);
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void IngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosActionPerformed
        /**
         * Acción ejecutada al presionar el botón "Ingresos". Abre el formulario
         * para gestionar y registrar ingresos.
         *
         * @param evt el evento de acción generado al presionar el botón
         */
// Crear una instancia del formulario secundario
        MenuRegistrarIngresos IrMenuRegistrarIngresos = new MenuRegistrarIngresos(); // Se cambia el FormLogin

        // Hacer visible el formulario secundario
        IrMenuRegistrarIngresos.setVisible(true);
    }//GEN-LAST:event_IngresosActionPerformed

    private void GastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GastosActionPerformed
        /**
         * Acción ejecutada al presionar el botón "Gastos". Abre el formulario
         * para gestionar y editar gastos.
         *
         * @param evt el evento de acción generado al presionar el botón
         */
         MenuGastos IrMenu = new MenuGastos();  //Se cambia el Menu
        // Hacer visible el formulario secundario
         IrMenu.setVisible(true);
    }//GEN-LAST:event_GastosActionPerformed

    private void ObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjetivoActionPerformed
        /**
         * Acción ejecutada al presionar el botón "Objetivo". Permite gestionar
         * y definir los objetivos financieros.
         *
         * @param evt el evento de acción generado al presionar el botón
         */
// TODO add your handling code here:
    }//GEN-LAST:event_ObjetivoActionPerformed

    private void ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesActionPerformed
        /**
         * Acción ejecutada al presionar el botón "Reportes". Permite acceder a
         * la generación y visualización de reportes.
         *
         * @param evt el evento de acción generado al presionar el botón
         */
// TODO add your handling code here:
    }//GEN-LAST:event_ReportesActionPerformed

    /**
     * Método principal que ejecuta el formulario de Menu.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton Gastos;
    private javax.swing.JButton Ingresos;
    private javax.swing.JButton Objetivo;
    private javax.swing.JButton Reportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
