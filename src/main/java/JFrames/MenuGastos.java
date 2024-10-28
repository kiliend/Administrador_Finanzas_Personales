package JFrames;

import EditarGasto.GastosConexionDB;
import RegistrarIngreso.GestorFinanzas;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * La clase {@code MenuGastos} es una interfaz gráfica que muestra y gestiona
 * los datos relacionados con los gastos. Permite la transferencia de datos
 * desde una base de datos de ingresos hacia una de gastos y los muestra en un
 * componente de tabla.
 * <p>
 * Esta clase utiliza la clase {@code ConexionDB} para la gestión de conexiones
 * a las bases de datos de ingresos y gastos, y SLF4J para el registro de logs.
 * </p>
 *
 * @author Rodney Piers Salazar Arapa
 *
 */
public class MenuGastos extends javax.swing.JFrame {

    private static final Logger logger = LoggerFactory.getLogger(MenuGastos.class);

    private GestorFinanzas gestorFinanzas; // Instancia de GestorFinanzas
    private DefaultTableModel tableModel; // Modelo de la tabla

    /**
     * Crea una instancia de {@code MenuGastos} y inicializa los componentes del
     * JFrame, así como el modelo de la tabla. También llama al método
     * {@link #transferirDatos()} para realizar la transferencia inicial de
     * datos de ingresos a gastos.
     */
    public MenuGastos() {
        initComponents();
        gestorFinanzas = new GestorFinanzas();
        tableModel = (DefaultTableModel) tablaGastos.getModel(); // Obtén el modelo de la tabla
        transferirDatos(); // Llama a transferirDatos al iniciar el JFrame
        logger.info("MenuGastos inicializado correctamente.");
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
    public void transferirDatos() {
        String sqlSelect = "SELECT id, monto, categoria, fecha FROM ingresos";
        String sqlInsert = "INSERT INTO gastos (id, monto, categoria, fecha, descripcion) VALUES (?, ?, ?, ?, ?)";

        try (Connection connIngresos = GastosConexionDB.getConnection(); Connection connGastos = GastosConexionDB.getConnectionGastos(); PreparedStatement pstmtSelect = connIngresos.prepareStatement(sqlSelect); ResultSet rs = pstmtSelect.executeQuery(); PreparedStatement pstmtInsert = connGastos.prepareStatement(sqlInsert)) {

            logger.info("Iniciando transferencia de datos de ingresos a gastos.");
            while (rs.next()) {
                // Verificar si el gasto ya existe para evitar duplicados
                if (!gastoExists(rs.getInt("id"))) {
                    pstmtInsert.setInt(1, rs.getInt("id"));
                    pstmtInsert.setDouble(2, rs.getDouble("monto"));
                    pstmtInsert.setString(3, rs.getString("categoria"));
                    pstmtInsert.setDate(4, rs.getDate("fecha"));
                    pstmtInsert.setString(5, ""); // Descripción vacía por ahora

                    pstmtInsert.executeUpdate();
                    logger.info("Datos transferidos para el ID: {}", rs.getInt("id"));
                } else {
                    logger.info("El gasto con ID {} ya existe en la tabla gastos.", rs.getInt("id"));
                }
            }

        } catch (SQLException e) {
            logger.error("Error al transferir datos: {}", e.getMessage(), e);
        }
    }

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
                "Id", "Monto", "Categoria", "Fecha", "Descripcion"
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Editar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(Editar)
                .addGap(41, 41, 41)
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
        cargarDatos(); // Cargar datos al presionar el botón Gastos
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
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        /**
         * Acción realizada al presionar el botón "Editar". Este método crea una
         * nueva instancia de {@code RegistrarGastos} y la hace visible.
         *
         * @param evt el evento de acción generado por el botón "Editar"
         */
        logger.info("Botón 'Editar' presionado.");
        RegistrarGastos IrMenu = new RegistrarGastos();  //Se cambia el Menu

        // Hacer visible el formulario secundario
        IrMenu.setVisible(true);

    }//GEN-LAST:event_EditarActionPerformed

    /**
     * Carga los datos de la tabla "gastos" de la base de datos y los muestra en
     * la tabla del componente de la interfaz. Limpia previamente el modelo de
     * la tabla para evitar duplicados.
     */
    private void cargarDatos() {
        String sql = "SELECT id, monto, categoria, fecha, descripcion FROM gastos"; // Asegúrate de que apunta a la tabla 'gastos'

        try (Connection conn = GastosConexionDB.getConnectionGastos(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            tableModel.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            logger.info("Cargando datos de la tabla gastos.");

            // Llenar la tabla con los datos obtenidos
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("id"), // ID
                    rs.getDouble("monto"), // Monto
                    rs.getString("categoria"), // Categoría
                    rs.getDate("fecha"), // Fecha
                    rs.getString("descripcion") // Descripción
                });
                logger.info("Dato agregado a la tabla: ID = {}, Monto = {}, Categoría = {}, Fecha = {}, Descripción = {}",
                        rs.getInt("id"), rs.getDouble("monto"), rs.getString("categoria"), rs.getDate("fecha"), rs.getString("descripcion"));
            }

        } catch (SQLException e) {
            logger.error("Error al cargar datos de la base de datos: {}", e.getMessage(), e);
        }
    }

    /**
     * Verifica si un gasto con el ID especificado ya existe en la tabla
     * "gastos".
     *
     * @param id el ID del gasto a verificar
     * @return {@code true} si el gasto existe, {@code false} en caso contrario
     */
    private boolean gastoExists(int id) {
        String sqlCheck = "SELECT COUNT(*) FROM gastos WHERE id = ?";
        try (Connection conn = GastosConexionDB.getConnectionGastos(); PreparedStatement pstmt = conn.prepareStatement(sqlCheck)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                logger.info("Verificación de existencia del gasto con ID: {}", id);
                return rs.getInt(1) > 0; // Retorna true si el ID existe
            }
        } catch (SQLException e) {
            logger.error("Error al verificar si el gasto existe: {}", e.getMessage(), e);
        }
        return false; // Retorna false si hubo un error o no existe
    }

    /**
     * Punto de entrada principal para la aplicación. Configura el aspecto de la
     * interfaz gráfica utilizando el tema Nimbus y crea una instancia del
     * formulario {@code MenuGastos}.
     *
     * @param args los argumentos de la línea de comandos
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
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton Editar;
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
