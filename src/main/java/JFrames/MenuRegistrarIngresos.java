package JFrames;

import RegistrarIngreso.GestorFinanzas;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa el menú para registrar ingresos.
 *
 * Esta clase extiende {@code javax.swing.JFrame} y proporciona una interfaz
 * gráfica para que los usuarios registren ingresos y manejen las entradas de
 * una base de datos.
 *
 * @author Rodney Piers Salazar Arapa
 */
public class MenuRegistrarIngresos extends javax.swing.JFrame {

    /**
     * Crea una nueva instancia de {@code MenuRegistrarIngresos}.
     *
     * Este constructor inicializa los componentes de la interfaz de usuario al
     * llamar a {@code initComponents()}.
     */
    public MenuRegistrarIngresos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngresos = new javax.swing.JTable();
        Agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Ingresos = new javax.swing.JButton();
        Retroceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        tablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Monto", "Categoria", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tablaIngresos);

        Agregar.setBackground(new java.awt.Color(102, 255, 204));
        Agregar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso4.png"))); // NOI18N

        Editar.setBackground(new java.awt.Color(153, 255, 153));
        Editar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.setToolTipText("");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(255, 204, 204));
        Eliminar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel3.setText("Menú de Ingreso");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Eliminar)
                                .addGap(46, 46, 46)
                                .addComponent(Agregar)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Editar)
                            .addComponent(Eliminar)
                            .addComponent(Agregar))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Administrador de Finanzas Personal");

        Ingresos.setBackground(new java.awt.Color(102, 255, 255));
        Ingresos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Ingresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso.png"))); // NOI18N
        Ingresos.setText("Ingresos");
        Ingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresosActionPerformed(evt);
            }
        });

        Retroceder.setBackground(new java.awt.Color(102, 255, 255));
        Retroceder.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Retroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha.png"))); // NOI18N
        Retroceder.setText("Retroceder");
        Retroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetrocederActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Retroceder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(Ingresos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Retroceder)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosActionPerformed
        /**
         * Maneja el evento de acción para cargar y mostrar la lista de ingresos
         * en la tabla {@code tablaIngresos}.
         *
         * Este método crea una instancia de {@code GestorFinanzas} para obtener
         * la lista de ingresos desde la base de datos y actualiza el modelo de
         * la tabla con los datos obtenidos.
         *
         * Se asegura de limpiar la tabla antes de cargar los nuevos datos para
         * evitar duplicados.
         *
         * @param evt El evento de acción que se produce al activar este método.
         */
        // Crear una instancia de GestorFinanzas
        GestorFinanzas gestor = new GestorFinanzas();

        // Obtener la lista de ingresos desde la base de datos
        List<Object[]> ingresos = gestor.obtenerIngresos();

        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaIngresos.getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        model.setRowCount(0);

        // Añadir los ingresos al modelo de la tabla
        for (Object[] ingreso : ingresos) {
            model.addRow(ingreso);
        } 
    }//GEN-LAST:event_IngresosActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        /**
         * Maneja el evento de acción para abrir el formulario de registro de
         * ingresos.
         *
         * Este método crea una instancia de {@code RegistrarIngreso} y hace
         * visible el formulario correspondiente para permitir al usuario
         * agregar nuevos ingresos.
         *
         * @param evt El evento de acción que se produce al activar este método.
         */
        // Crear una instancia del formulario secundario
        RegistrarIngreso EditarIngresos = new RegistrarIngreso();

        // Hacer visible el formulario secundario
        EditarIngresos.setVisible(true);
    }//GEN-LAST:event_AgregarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        /**
         * Maneja el evento de acción para editar un ingreso seleccionado en la
         * tabla.
         *
         * Este método obtiene la fila seleccionada en la tabla de ingresos,
         * pide al usuario nuevos valores para el monto, la categoría y la
         * fecha, y actualiza la tabla y la base de datos con los nuevos
         * valores. Si no hay una fila seleccionada, muestra un mensaje de
         * advertencia.
         *
         * @param evt El evento de acción que se produce al activar este método.
         */
        // Obtener la fila seleccionada
        int filaSeleccionada = tablaIngresos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) tablaIngresos.getModel();

            // Obtener los valores actuales
            Object idObj = model.getValueAt(filaSeleccionada, 0); // id
            Object montoObj = model.getValueAt(filaSeleccionada, 1); // monto
            Object categoriaObj = model.getValueAt(filaSeleccionada, 2); // categoría
            Object fechaObj = model.getValueAt(filaSeleccionada, 3); // fecha

            // Pedir nuevos valores al usuario
            String nuevoMontoStr = javax.swing.JOptionPane.showInputDialog(this, "Nuevo monto:", montoObj);
            String nuevaCategoria = javax.swing.JOptionPane.showInputDialog(this, "Nueva categoría:", categoriaObj);
            String nuevaFechaStr = javax.swing.JOptionPane.showInputDialog(this, "Nueva fecha (YYYY-MM-DD):", fechaObj.toString());

            // Validar que los valores no sean nulos
            if (nuevoMontoStr != null && nuevaCategoria != null && nuevaFechaStr != null) {
                try {
                    // Convertir los valores a los tipos correctos
                    double nuevoMonto = Double.parseDouble(nuevoMontoStr);
                    LocalDate nuevaFecha = LocalDate.parse(nuevaFechaStr);  // Convertir la fecha

                    // Actualizar los valores en la tabla localmente
                    model.setValueAt(nuevoMonto, filaSeleccionada, 1); // Actualizar monto en la tabla
                    model.setValueAt(nuevaCategoria, filaSeleccionada, 2); // Actualizar categoría en la tabla

                    // Convertir LocalDate a java.sql.Date
                    java.sql.Date sqlDate = java.sql.Date.valueOf(nuevaFecha);
                    model.setValueAt(sqlDate, filaSeleccionada, 3); // Actualizar fecha en la tabla

                    // Actualizar la base de datos
                    GestorFinanzas gestor = new GestorFinanzas();
                    gestor.actualizarIngreso((int) idObj, nuevoMonto, nuevaCategoria, nuevaFecha);

                    javax.swing.JOptionPane.showMessageDialog(this, "Ingreso actualizado correctamente.");

                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Formato de monto incorrecto.");
                } catch (DateTimeParseException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Usa YYYY-MM-DD.");
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una fila para editar.");
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void RetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetrocederActionPerformed
        /**
         * Maneja el evento de acción para volver al menú principal.
         *
         * Este método crea una instancia del formulario del menú principal y lo
         * hace visible. No se realizan otras operaciones ni se guardan datos
         * antes de cambiar de formulario.
         *
         * @param evt El evento de acción que se produce al activar este método.
         */
        // Crear una instancia del formulario secundario
        Menu IrMenu = new Menu();  //Se cambia el Menu

        // Hacer visible el formulario secundario
        IrMenu.setVisible(true);
    }//GEN-LAST:event_RetrocederActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        /**
         * Maneja el evento de acción para eliminar un ingreso de la tabla.
         *
         * Este método obtiene la fila seleccionada en la tabla de ingresos,
         * confirma la eliminación y, si se confirma, elimina el registro
         * correspondiente de la base de datos y de la tabla visual.
         *
         * Si no hay ninguna fila seleccionada, muestra un mensaje de
         * advertencia. En caso de error durante la eliminación, se muestra un
         * mensaje de error.
         *
         * @param evt El evento de acción que se produce al activar este método.
         */
        // Obtener la fila seleccionada
        int filaSeleccionada = tablaIngresos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) tablaIngresos.getModel();

            // Obtener el id del registro a eliminar (la primera columna)
            Object idObj = model.getValueAt(filaSeleccionada, 0);

            // Confirmar antes de eliminar
            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este ingreso?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                // Eliminar el registro de la base de datos
                try {
                    GestorFinanzas gestor = new GestorFinanzas();
                    gestor.eliminarIngreso((int) idObj); // Pasar el id al método eliminarIngreso

                    // Eliminar la fila de la tabla visual
                    model.removeRow(filaSeleccionada);

                    javax.swing.JOptionPane.showMessageDialog(this, "Ingreso eliminado correctamente.");
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el ingreso.");
                    e.printStackTrace();
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
        }
    }//GEN-LAST:event_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuRegistrarIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuRegistrarIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuRegistrarIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuRegistrarIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MenuRegistrarIngresos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Ingresos;
    private javax.swing.JButton Retroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIngresos;
    // End of variables declaration//GEN-END:variables
}
