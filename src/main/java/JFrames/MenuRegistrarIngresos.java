package JFrames;


import ClaseDAOImpl.IngresoDAOImpl;
import Clases.Ingreso;
import Clases.UsuarioSesion;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
      // Logger para la clase
    private static final Logger logger = Logger.getLogger(MenuRegistrarIngresos.class.getName());
    
    // Instancia del DAO para interactuar con la base de datos
    private IngresoDAOImpl ingresoDAO;

    /**
     * Crea una nueva instancia de {@code MenuRegistrarIngresos}.
     *
     * Este constructor inicializa los componentes de la interfaz de usuario al
     * llamar a {@code initComponents()}.
     */
    public MenuRegistrarIngresos() {
        initComponents();
        
        ingresoDAO = new IngresoDAOImpl(); // Inicializamos el DAO
        logger.info("Instancia de MenuRegistrarIngresos creada.");
        cargarIngresosEnTabla();
   
    }
    /**
     * Método para cargar los ingresos de un usuario en la tabla.
     * 
     * @param idUsuario El ID del usuario cuyos ingresos se desean mostrar.
     */
   
    // Obtén el ID del usuario desde UsuarioSesion
    private int obtenerIdUsuario() {
        return UsuarioSesion.getUserId();  // Aquí se usa UsuarioSesion para obtener el ID
    }

    private void cargarIngresosEnTabla() {
        int idUsuario = obtenerIdUsuario();  // Usamos el ID del usuario desde UsuarioSesion
        logger.info("Cargando ingresos para el usuario ID: " + idUsuario);
        try {
            // Obtener los ingresos del usuario desde la base de datos
            List<Ingreso> ingresos = ingresoDAO.obtenerIngresosPorUsuario(idUsuario);

            // Crear un modelo de tabla
            DefaultTableModel modelo = (DefaultTableModel) tlbIngresos.getModel();
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            // Agregar los datos de los ingresos en la tabla
            for (Ingreso ingreso : ingresos) {
                Object[] row = {
                    ingreso.getIdIngreso(),
                    ingreso.getCantidad(),
                    ingreso.getFecha(),
                    ingreso.getDescripcion()
                };
                modelo.addRow(row);
            }
            logger.info("Ingresos cargados exitosamente en la tabla.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener los ingresos para el usuario ID: " + idUsuario, e);
            JOptionPane.showMessageDialog(this, "Error al obtener los ingresos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarUltimoIngreso() {
        int idUsuario = obtenerIdUsuario();  // Usamos el ID del usuario desde UsuarioSesion
        logger.info("Cargando el último ingreso para el usuario ID: " + idUsuario);
        try {
            Ingreso ultimoIngreso = ingresoDAO.obtenerUltimoIngreso(idUsuario);
            if (ultimoIngreso != null) {
                txtUltimoIngreso.setText(String.valueOf(ultimoIngreso.getCantidad()));
                logger.info("Último ingreso cargado: " + ultimoIngreso.getCantidad());
            } else {
                txtUltimoIngreso.setText("N/A");
                logger.warning("No se encontró un último ingreso para el usuario ID: " + idUsuario);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el último ingreso para el usuario ID: " + idUsuario, e);
            JOptionPane.showMessageDialog(this, "Error al obtener el último ingreso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarIngresoMasAlto(String mes) {
        int idUsuario = obtenerIdUsuario();  // Usamos el ID del usuario desde UsuarioSesion
        logger.info("Cargando el ingreso más alto para el usuario ID: " + idUsuario + " en el mes: " + mes);
        try {
            Ingreso ingresoMasAlto = ingresoDAO.obtenerIngresoMasAltoDelMes(idUsuario, mes);
            if (ingresoMasAlto != null) {
                txtIngresoMayor.setText(String.valueOf(ingresoMasAlto.getCantidad()));
                logger.info("Ingreso más alto cargado: " + ingresoMasAlto.getCantidad());
            } else {
                txtIngresoMayor.setText("N/A");
                logger.warning("No se encontró un ingreso más alto para el usuario ID: " + idUsuario + " en el mes: " + mes);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el ingreso más alto para el usuario ID: " + idUsuario + " en el mes: " + mes, e);
            JOptionPane.showMessageDialog(this, "Error al obtener el ingreso más alto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTotalIngresosDelMes(String mes) {
        int idUsuario = obtenerIdUsuario();  // Usamos el ID del usuario desde UsuarioSesion
        logger.info("Cargando el total de ingresos para el usuario ID: " + idUsuario + " en el mes: " + mes);
        try {
            double totalIngresos = ingresoDAO.obtenerTotalIngresosDelMes(idUsuario, mes);
            txtIngresoMes.setText(String.valueOf(totalIngresos));
            logger.info("Total de ingresos cargado: " + totalIngresos);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el total de ingresos para el usuario ID: " + idUsuario + " en el mes: " + mes, e);
            JOptionPane.showMessageDialog(this, "Error al obtener el total de ingresos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbIngresos = new javax.swing.JTable();
        Agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUltimoIngreso = new javax.swing.JLabel();
        txtIngresoMayor = new javax.swing.JLabel();
        txtIngresoMes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Ingresos = new javax.swing.JButton();
        Retroceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        tlbIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Monto", "Fecha", "Descripcion"
            }
        ));
        tlbIngresos.setToolTipText("");
        jScrollPane1.setViewportView(tlbIngresos);

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

        txtUltimoIngreso.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtUltimoIngreso.setText("jLabel4");

        txtIngresoMayor.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIngresoMayor.setText("jLabel5");

        txtIngresoMes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIngresoMes.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUltimoIngreso)
                    .addComponent(jLabel2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Eliminar)))
                        .addGap(138, 138, 138))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(txtIngresoMayor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIngresoMes)
                        .addGap(126, 126, 126))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Editar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUltimoIngreso)
                    .addComponent(txtIngresoMayor)
                    .addComponent(txtIngresoMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Editar)
                    .addComponent(Eliminar)
                    .addComponent(Agregar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Retroceder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosActionPerformed
 
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
     * pide al usuario nuevos valores para el monto y la descripción, y 
     * actualiza la tabla y la base de datos con los nuevos valores. 
     * Si no hay una fila seleccionada, muestra un mensaje de advertencia.
     *
     * @param evt El evento de acción que se produce al activar este método.
     */
    
    // Obtener la fila seleccionada
    int selectedRow = tlbIngresos.getSelectedRow();
    
    if (selectedRow == -1) {
        // Si no hay ninguna fila seleccionada, mostrar mensaje de advertencia
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un ingreso para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Obtener el ID del ingreso seleccionado
    int idIngreso = (int) tlbIngresos.getValueAt(selectedRow, 0);  // Suponiendo que el ID de ingreso está en la primera columna

    // Obtener la descripción y la cantidad del ingreso
    String descripcionActual = (String) tlbIngresos.getValueAt(selectedRow, 3);  // Suponiendo que la descripción está en la cuarta columna
    double cantidadActual = (double) tlbIngresos.getValueAt(selectedRow, 1);  // Suponiendo que la cantidad está en la segunda columna

    // Mostrar ventana emergente para editar el monto
    String nuevoMontoStr = JOptionPane.showInputDialog(this, "Ingresa el nuevo monto para el ingreso:", cantidadActual);
    
    // Validar que el monto ingresado sea un número
    double nuevoMonto;
    try {
        nuevoMonto = Double.parseDouble(nuevoMontoStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El monto ingresado no es válido. Intenta nuevamente.", "Error de validación", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Mostrar ventana emergente para editar la descripción
    String nuevaDescripcion = JOptionPane.showInputDialog(this, "Ingresa la nueva descripción para el ingreso:", descripcionActual);
    
    // Validar que la descripción no esté vacía
    if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.", "Error de validación", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Confirmar que el usuario desea realizar la edición
    int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas editar este ingreso?", "Confirmación de edición", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Actualizar el ingreso en la base de datos utilizando el DAO
            ingresoDAO.actualizarIngreso(idIngreso, nuevoMonto, nuevaDescripcion);
            
            // Actualizar la tabla con los nuevos valores
            tlbIngresos.setValueAt(nuevoMonto, selectedRow, 1);  // Actualiza la cantidad en la tabla
            tlbIngresos.setValueAt(nuevaDescripcion, selectedRow, 3);  // Actualiza la descripción en la tabla
            
            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Ingreso actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            logger.info("Ingreso con ID " + idIngreso + " actualizado con éxito.");
        } catch (SQLException e) {
            // En caso de error, mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "Error al actualizar el ingreso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Error al actualizar el ingreso con ID " + idIngreso, e);
        }
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
        this.dispose();
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
    
    // Obtener la fila seleccionada de la tabla
    int selectedRow = tlbIngresos.getSelectedRow();
    
    if (selectedRow == -1) {
        // Si no hay ninguna fila seleccionada, mostrar mensaje de advertencia
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un ingreso para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Obtener el ID del ingreso seleccionado
    int idIngreso = (int) tlbIngresos.getValueAt(selectedRow, 0);  // Suponiendo que el ID de ingreso está en la primera columna

    // Obtener la fecha del ingreso seleccionado (en la columna correspondiente, por ejemplo, columna 2)
    LocalDate fechaIngreso = ((java.sql.Date) tlbIngresos.getValueAt(selectedRow, 2)).toLocalDate(); // Convertimos de java.sql.Date a LocalDate
    
    // Obtener la fecha actual
    LocalDate fechaActual = LocalDate.now();
    
    // Verificar si la fecha del ingreso es la misma que la fecha actual
    if (!fechaIngreso.isEqual(fechaActual)) {
        JOptionPane.showMessageDialog(this, "Solo se pueden eliminar ingresos del día de hoy.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Confirmar la eliminación
    int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este ingreso?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Eliminar el ingreso de la base de datos utilizando el DAO
            ingresoDAO.eliminarIngreso(idIngreso);
            
            // Eliminar la fila de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tlbIngresos.getModel();
            modelo.removeRow(selectedRow);
            
            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Ingreso eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            logger.info("Ingreso con ID " + idIngreso + " eliminado con éxito.");
        } catch (SQLException e) {
            // En caso de error, mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "Error al eliminar el ingreso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Error al eliminar el ingreso con ID " + idIngreso, e);
        }
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
    private javax.swing.JTable tlbIngresos;
    private javax.swing.JLabel txtIngresoMayor;
    private javax.swing.JLabel txtIngresoMes;
    private javax.swing.JLabel txtUltimoIngreso;
    // End of variables declaration//GEN-END:variables
}
