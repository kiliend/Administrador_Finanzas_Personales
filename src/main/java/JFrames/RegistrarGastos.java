package JFrames;

import ClaseDAOImpl.GastoDAOImpl;
import Clases.Gasto;
import Clases.UsuarioSesion;
import ConexionBD.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * La clase {@code RegistrarGastos} representa el formulario para registrar y
 * gestionar los gastos. Proporciona la funcionalidad de conexión con la base de
 * datos y permite exportar datos a Excel.
 *
 * @author Rodney Piers Salazar Arapa
 *
 */
public class RegistrarGastos extends javax.swing.JFrame {

    /**
     * Logger para registrar mensajes de error y depuración.
     */
    private static final Logger logger = LoggerFactory.getLogger(RegistrarGastos.class);

    public RegistrarGastos() {
        initComponents();
        cargarCategorias();
    }
        private void cargarCategorias() {
            // Crear una lista para almacenar las categorías
            List<String> categorias = new ArrayList<>();
            logger.info("Iniciando carga de categorías desde la base de datos...");

            // Realizar consulta a la base de datos para obtener las categorías
            try (Connection conexion = ConexionDB.getConexion()) {
                logger.info("Conexión establecida con la base de datos.");

                String sql = "SELECT nombre FROM categoria_gasto";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                logger.info("Ejecutando consulta: " + sql);

                // Llenar el ComboBox con las categorías
                while (rs.next()) {
                    String categoria = rs.getString("nombre");
                    categorias.add(categoria);
                    logger.debug("Categoría obtenida: " + categoria); // Log detallado por cada categoría
                }

                logger.info("Consulta ejecutada exitosamente. Se han obtenido " + categorias.size() + " categorías.");
            } catch (SQLException e) {
                logger.error("Error al cargar las categorías desde la base de datos", e);
            }

            // Verificar si se obtuvieron categorías y agregar al ComboBox
            if (!categorias.isEmpty()) {
                logger.info("Agregando categorías al ComboBox...");
                for (String categoria : categorias) {
                    jComboBoxCategoria_gasto.addItem(categoria);
                    logger.debug("Categoría agregada al ComboBox: " + categoria);
                }
            } else {
                logger.warn("No se encontraron categorías para agregar al ComboBox.");
            }

            logger.info("Carga de categorías finalizada.");
        }
        private void limpiarCampos() {
    txtDescripcion.setText("");  // Limpiar el campo de descripción
    txtMonto.setText("");  // Limpiar el campo de monto
    jComboBoxCategoria_gasto.setSelectedIndex(0);  // Restablecer el ComboBox a la primera opción
    jDateChooser1FECHA.setDate(null);  // Limpiar el selector de fecha
    logger.info("Campos limpiados exitosamente.");
}
        // Método para obtener la asignación de la categoría
private double obtenerAsignacionCategoria(int idCategoria) {
    double asignacion = 0;
    String sql = "SELECT asignacion FROM categoria_gasto WHERE id_categoria = ?";
    try (Connection conexion = ConexionDB.getConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, idCategoria);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            asignacion = rs.getDouble("asignacion");
        }
    } catch (SQLException e) {
        logger.error("Error al obtener la asignación de la categoría", e);
    }
    return asignacion;
}

    @SuppressWarnings("unchecked")
    // Otros métodos y lógica de la clase

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RegistrarGasto = new javax.swing.JButton();
        RegresarMenu = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jComboBoxCategoria_gasto = new javax.swing.JComboBox<>();
        jDateChooser1FECHA = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel2.setText("Nuevo Gasto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("¿Cuanto Gastamos?");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("¿Que Categoria es?");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("¿Cuando lo gastamos?");

        RegistrarGasto.setBackground(new java.awt.Color(153, 255, 153));
        RegistrarGasto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        RegistrarGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        RegistrarGasto.setText("Registrar");
        RegistrarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarGastoActionPerformed(evt);
            }
        });

        RegresarMenu.setBackground(new java.awt.Color(255, 102, 102));
        RegresarMenu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        RegresarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Regresar Registros.png"))); // NOI18N
        RegresarMenu.setText("Regresar");
        RegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarMenuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("¿En que Gastamos?");

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
                                .addGap(21, 21, 21)
                                .addComponent(RegistrarGasto)
                                .addGap(92, 92, 92)
                                .addComponent(RegresarMenu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(67, 67, 67)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxCategoria_gasto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1FECHA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxCategoria_gasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrarGasto)
                    .addComponent(RegresarMenu))
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 524, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarGastoActionPerformed
// Obtener los valores de los campos
logger.info("Iniciando el registro del gasto...");

String descripcion = txtDescripcion.getText();
logger.debug("Descripción del gasto: " + descripcion); // Log detallado para la descripción

double monto;
try {
    monto = Double.parseDouble(txtMonto.getText());
    logger.debug("Monto ingresado: " + monto); // Log detallado para el monto
} catch (NumberFormatException e) {
    logger.error("Error al parsear el monto ingresado", e);
    JOptionPane.showMessageDialog(this, "El monto ingresado no es válido.");
    return;  // Detener la ejecución si el monto es inválido
}

int idCategoria = jComboBoxCategoria_gasto.getSelectedIndex() + 1;  // Obtener el ID de la categoría seleccionada
logger.debug("ID de la categoría seleccionada: " + idCategoria);

java.util.Date fecha = jDateChooser1FECHA.getDate();
logger.debug("Fecha seleccionada: " + fecha); // Log detallado para la fecha

// Obtener el ID del usuario desde UsuarioSesion
int idUsuario = UsuarioSesion.getUserId();
logger.debug("ID del usuario: " + idUsuario); // Log detallado para el ID del usuario

// Verificar si la fecha no es nula
if (fecha != null) {
    java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime()); // Convertir a java.sql.Date
    logger.debug("Fecha convertida a SQL: " + fechaSQL); // Log detallado para la fecha SQL

    // Verificar la asignación de la categoría
    double asignacionCategoria = obtenerAsignacionCategoria(idCategoria); // Método para obtener la asignación de la categoría

    // Validar si el monto ingresado excede la asignación de la categoría
    if (monto > asignacionCategoria) {
        JOptionPane.showMessageDialog(this, "El monto ingresado supera la asignación de la categoría.");
        logger.warn("Monto ingresado excede la asignación de la categoría: " + asignacionCategoria);
        return;  // Detener la ejecución si el monto es mayor que la asignación
    }

    // Crear el objeto Gasto
    Gasto gasto = new Gasto(0, monto, descripcion, fechaSQL, idUsuario, idCategoria);
    logger.info("Objeto Gasto creado: " + gasto); // Log detallado para el objeto Gasto

    // Llamar al método para registrar el gasto
    GastoDAOImpl gastoDAO = new GastoDAOImpl();
    try {
        logger.info("Intentando registrar el gasto en la base de datos...");
        gastoDAO.registrarGasto(gasto);
        logger.info("Gasto registrado exitosamente en la base de datos.");
        JOptionPane.showMessageDialog(this, "Gasto registrado exitosamente.");

        // Limpiar los campos después del registro
        limpiarCampos(); // Llamamos al método para limpiar los campos
    } catch (SQLException e) {
        logger.error("Error al registrar el gasto en la base de datos", e);
        JOptionPane.showMessageDialog(this, "Error al registrar el gasto.");
    }
} else {
    logger.warn("La fecha seleccionada es nula.");
    JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.");
}
    }//GEN-LAST:event_RegistrarGastoActionPerformed

    private void RegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarMenuActionPerformed

        /**
         * Acción realizada al presionar el botón "Regresar al Menú". Cierra la
         * ventana actual y abre la ventana de menú principal de gastos.
         *
         * @param evt el evento de acción generado por el botón "Regresar al
         * Menú"
         */
        this.dispose(); // Cerrar la ventana actual
        new MenuGastos().setVisible(true); // Abrir la ventana del menú principal de gastos
    }//GEN-LAST:event_RegresarMenuActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegistrarGastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegistrarGasto;
    private javax.swing.JButton RegresarMenu;
    private javax.swing.JComboBox<String> jComboBoxCategoria_gasto;
    private com.toedter.calendar.JDateChooser jDateChooser1FECHA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
