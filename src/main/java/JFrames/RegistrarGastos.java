package JFrames;

import java.sql.SQLException;
import EditarGasto.GastosConexionDB;
import EditarGasto.ExportarGastos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.ResultSet;

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

    /**
     * Instancia para exportar los gastos a un archivo Excel.
     */
    private ExportarGastos excelExporter = new ExportarGastos();

    /**
     * Crea una nueva instancia de {@code RegistrarGastos} e inicializa los
     * componentes de la interfaz.
     */
    public RegistrarGastos() {
        initComponents();
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
        txtCategoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        RegistrarGasto = new javax.swing.JButton();
        RegresarMenu = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N

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

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("¿Cual es el ID?");

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
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                        .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.LEADING))))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
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
        /**
         * Acción realizada al presionar el botón "Registrar Gasto". Obtiene los
         * valores de los campos de texto y actualiza el gasto en la base de
         * datos. Realiza validaciones de entrada antes de ejecutar la
         * actualización.
         *
         * @param evt el evento de acción generado por el botón "Registrar
         * Gasto"
         */
// Obtener los valores de los campos de texto
        String idStr = txtId.getText();
        String categoria = txtCategoria.getText();
        String descripcion = txtDescripcion.getText();
        String fecha = txtFecha.getText();
        String montoStr = txtMonto.getText();

        // Validar que los campos no estén vacíos
        if (idStr.isEmpty() || categoria.isEmpty() || descripcion.isEmpty() || fecha.isEmpty() || montoStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        try {
            int id = Integer.parseInt(idStr); // Convertir el ID a entero
            double monto = Double.parseDouble(montoStr); // Convertir el monto a double

            // Validar el formato de la fecha
            if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
                javax.swing.JOptionPane.showMessageDialog(this, "El formato de la fecha debe ser YYYY-MM-DD.");
                return;
            }

            // Validar que el gasto con el ID dado existe
            if (!gastoExists(id)) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el gasto con ID " + id + ".");
                return;
            }

            // Consulta para actualizar el gasto en la base de datos
            String sqlUpdate = "UPDATE gastos SET monto = ?, categoria = ?, fecha = ?, descripcion = ? WHERE id = ?";

            try (Connection conn = GastosConexionDB.getConnectionGastos(); PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

                pstmt.setDouble(1, monto);
                pstmt.setString(2, categoria);
                pstmt.setDate(3, java.sql.Date.valueOf(fecha)); // Convertir la fecha a java.sql.Date
                pstmt.setString(4, descripcion);
                pstmt.setInt(5, id); // Usar el ID para la actualización

                int filasAfectadas = pstmt.executeUpdate(); // Ejecutar la consulta de actualización
                if (filasAfectadas > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Gasto actualizado exitosamente.");
                                    // Exportar los gastos a Excel
                ExportarGastos exportarGastos = new ExportarGastos();
                List<Object[]> listaGastos = obtenerGastos();
                exportarGastos.exportarGastosAExcel(listaGastos);
                    logger.info("Gasto actualizado exitosamente con ID: {}", id);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se pudo actualizar el gasto con ID " + id + ".");
                }

            } catch (SQLException e) {
                logger.error("Error al actualizar el gasto: {}", e.getMessage(), e);
                javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar el gasto: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El ID y el monto deben ser números válidos.");
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

    /**
     * Obtiene una lista de todos los gastos de la base de datos.
     *
     * @return una lista de arreglos de objetos, donde cada arreglo contiene los
     * datos de un gasto
     */
    private List<Object[]> obtenerGastos() {
        List<Object[]> gastos = new ArrayList<>();
        String sqlSelect = "SELECT id, monto, categoria, fecha, descripcion FROM gastos"; // Asegúrate de que el nombre de la tabla y las columnas son correctos.

        try (Connection conn = GastosConexionDB.getConnectionGastos(); PreparedStatement pstmt = conn.prepareStatement(sqlSelect); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                double monto = rs.getDouble("monto");
                String categoria = rs.getString("categoria");
                String fecha = rs.getString("fecha");
                String descripcion = rs.getString("descripcion");
                gastos.add(new Object[]{id, monto, categoria, fecha, descripcion});
            }
        } catch (SQLException e) {
            logger.error("Error al obtener los gastos: {}", e.getMessage(), e);
        }

        return gastos; // Retorna la lista de gastos.
    }

    /**
     * Verifica si un gasto con el ID especificado existe en la base de datos.
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
                return rs.getInt(1) > 0; // Retorna true si el ID existe
            }
        } catch (SQLException e) {
            logger.error("Error al verificar si el gasto existe: {}", e.getMessage(), e);
        }
        return false; // Retorna false si hubo un error o no existe
    }

    /**
     * Método principal que establece el estilo de la interfaz gráfica y muestra
     * el formulario de {@code RegistrarGastos}.
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
