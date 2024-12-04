package JFrames;

import ClaseDAOImpl.GastoDAOImpl;  // Suponiendo que tienes un GastoDAOImpl
import Clases.Gasto;
import Clases.UsuarioSesion;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuGastos extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(MenuGastos.class.getName());
    private GastoDAOImpl gastoDAO;
    private Connection conexion;
    
    public MenuGastos() {
    initComponents();
    this.gastoDAO = new GastoDAOImpl();  // Crear la instancia del DAO de gastos
    cargarGastos();  // Cargar los gastos cuando inicie el formulario
}
    private void cargarGastos() {
    int userId = UsuarioSesion.getUserId(); // Obtener el ID del usuario desde la sesión
    if (userId != 0) {
        try {
            // Realiza una consulta para cargar los gastos del usuario
            List<Gasto> gastos = gastoDAO.obtenerGastosPorUsuario(userId);

            DefaultTableModel model = (DefaultTableModel) tablaGastos.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos datos

            for (Gasto gasto : gastos) {
                model.addRow(new Object[] {
                    gasto.getIdGasto(),
                    gasto.getDescripcion(),
                    gasto.getCantidad(),
                    gasto.getFecha(),
                    gasto.getIdCategoria()
                });
            }

            // Hacer la tabla editable si es necesario
            tablaGastos.setModel(model);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar los gastos: ", e);
            JOptionPane.showMessageDialog(this, "Error al cargar los gastos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Usuario no registrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    


    /**
     * Transfiere los datos desde la tabla de ingresos a la tabla de gastos.
     * Este método selecciona los datos de ingresos y los inserta en la tabla de
     * gastos si aún no existen para evitar duplicados.
     * <p>
     * En el proceso, realiza la conexión a ambas bases de datos y maneja
     * posibles excepciones de SQL.
     * </p>
     */


    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Gastos = new javax.swing.JButton();
        CerrarSesion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable();
        Editar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Administrador de Finanzas Personales");

        Gastos.setBackground(new java.awt.Color(102, 255, 255));
        Gastos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Gastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso.png"))); // NOI18N
        Gastos.setText("Gastos");
        Gastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GastosActionPerformed(evt);
            }
        });

        CerrarSesion.setBackground(new java.awt.Color(0, 102, 204));
        CerrarSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        CerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel3.setText("Menu De Gastos");

        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Gasto", "Descripcion", "Fecha", "Monto", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(tablaGastos);

        Editar.setBackground(new java.awt.Color(153, 255, 153));
        Editar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        Editar.setText("EDITAR");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gasto1.png"))); // NOI18N

        Agregar.setBackground(new java.awt.Color(102, 255, 204));
        Agregar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Agregar)
                        .addGap(77, 77, 77)
                        .addComponent(Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Eliminar)
                        .addGap(89, 89, 89))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Editar)
                    .addComponent(Eliminar)
                    .addComponent(Agregar))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Gastos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CerrarSesion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(Gastos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CerrarSesion)
                .addGap(177, 177, 177))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GastosActionPerformed
        /**
         * Acción realizada al presionar el botón "Gastos". Carga los datos en
         * la tabla correspondiente llamando al método {@link #cargarDatos()}.
         *
         * @param evt el evento de acción generado por el botón "Gastos"
         */
   cargarGastos();
    }//GEN-LAST:event_GastosActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed

        /**
         * Acción realizada al presionar el botón "Cerrar Sesión". Actualmente,
         * este método no implementa ninguna acción ya que el código para el
         * cambio de formulario está comentado.
         *
         * @param evt el evento de acción generado por el botón "Cerrar Sesión"
         */
        Menu IrMenu = new Menu();  //Se cambia el Menu
        // Hacer visible el formulario secundario
        IrMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
 int filaSeleccionada = tablaGastos.getSelectedRow();  // Obtener la fila seleccionada de la tabla
    if (filaSeleccionada == -1) {
        // Si no se seleccionó ninguna fila, mostrar un mensaje de advertencia
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un gasto para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtener el ID del gasto seleccionado
    int idGasto = (int) tablaGastos.getValueAt(filaSeleccionada, 0);
    String descripcion = (String) tablaGastos.getValueAt(filaSeleccionada, 1);
    double monto = (double) tablaGastos.getValueAt(filaSeleccionada, 2);

    // Crear un cuadro de diálogo para editar la descripción y monto
    JTextField txtDescripcion = new JTextField(descripcion);
    JTextField txtMonto = new JTextField(String.valueOf(monto));

    // Crear un panel para mostrar los campos de edición
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));  // Layout para el panel
    panel.add(new JLabel("Descripción:"));
    panel.add(txtDescripcion);
    panel.add(new JLabel("Monto:"));
    panel.add(txtMonto);

    // Mostrar una advertencia sobre la edición de la fecha
    JOptionPane.showMessageDialog(this, "Nota: No puede editar la fecha del gasto.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

    int opcion = JOptionPane.showConfirmDialog(this, panel, "Editar Gasto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (opcion == JOptionPane.OK_OPTION) {
        // Obtener los valores actualizados
        String nuevaDescripcion = txtDescripcion.getText();
        double nuevoMonto = Double.parseDouble(txtMonto.getText());

        // Crear un objeto Gasto con los nuevos datos
        Gasto gasto = new Gasto(idGasto, nuevoMonto, nuevaDescripcion, null, UsuarioSesion.getUserId(), 0);  // El ID del usuario se toma de la sesión

        try {
            // Llamar al método en el DAO para actualizar el gasto
            gastoDAO.actualizarGasto(gasto);
            // Actualizar la tabla para reflejar los cambios
            cargarGastos();  // Recargar los datos de la tabla
            JOptionPane.showMessageDialog(this, "Gasto actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el gasto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_EditarActionPerformed

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
        RegistrarGastos Registrar = new RegistrarGastos();
        Registrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int filaSeleccionada = tablaGastos.getSelectedRow();  // Obtener la fila seleccionada de la tabla
    
    if (filaSeleccionada == -1) {
        // Si no se seleccionó ninguna fila, mostrar un mensaje de advertencia
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un gasto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtener el ID del gasto seleccionado
    int idGasto = (int) tablaGastos.getValueAt(filaSeleccionada, 0);

    try {
        // Obtener la fecha del gasto desde la tabla (suponemos que la fecha está en la columna 3)
        Object fechaGastoObj = tablaGastos.getValueAt(filaSeleccionada, 3);  // Obtener el valor de la celda como Object

        if (fechaGastoObj instanceof java.sql.Date) {
            java.sql.Date fechaGastoSQL = (java.sql.Date) fechaGastoObj;  // Convertir a java.sql.Date
            LocalDate fechaGastoLocal = fechaGastoSQL.toLocalDate();  // Convertir la fecha a LocalDate

            // Verificar si la fecha del gasto es igual a la fecha de hoy
            if (!fechaGastoLocal.isEqual(LocalDate.now())) {
                // Si la fecha no es hoy, mostrar un mensaje de error
                JOptionPane.showMessageDialog(this, "Solo se pueden eliminar gastos del día de hoy.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Confirmar la eliminación
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este gasto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Llamar al método en el DAO para eliminar el gasto
                gastoDAO.eliminarGasto(idGasto);
                cargarGastos();  // Recargar los datos de la tabla después de eliminar el gasto
                JOptionPane.showMessageDialog(this, "Gasto eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: El valor de la fecha no es del tipo esperado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar el gasto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MenuGastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Gastos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaGastos;
    // End of variables declaration//GEN-END:variables
}
