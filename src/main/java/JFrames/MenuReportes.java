/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrames;

import javax.swing.*;
import Clases.ReporteService;

/**
 *
 * @author Luan Condori
 */
public class MenuReportes extends javax.swing.JFrame {
private String categoriaSeleccionada;
private String tiempoSeleccionado;
private String tipoArchivoSeleccionado;
private final ReporteService reporteService;
    /**
     * Creates new form MenuReportes
     */
    public MenuReportes() {
        
        initComponents();
        reporteService = new ReporteService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnIngresoReporte = new javax.swing.JButton();
        btnGastosReporte = new javax.swing.JButton();
        btnPresupuesto = new javax.swing.JButton();
        btnCerrarSesionPresupuesto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresoCategoria = new javax.swing.JButton();
        btnGastoCategoria = new javax.swing.JButton();
        btnPresupuestoCategoria = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDiaTiempo = new javax.swing.JButton();
        btnSemanaTiempo = new javax.swing.JButton();
        btnMesTiempo = new javax.swing.JButton();
        btnYearTiempo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnPdf = new javax.swing.JButton();
        btnCVS = new javax.swing.JButton();
        btnDescargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setText("Administrador de Finanzas Personales");

        btnIngresoReporte.setBackground(new java.awt.Color(102, 255, 255));
        btnIngresoReporte.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnIngresoReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso.png"))); // NOI18N
        btnIngresoReporte.setText("Ingresos");
        btnIngresoReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoReporteActionPerformed(evt);
            }
        });

        btnGastosReporte.setBackground(new java.awt.Color(102, 255, 255));
        btnGastosReporte.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnGastosReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/depreciacion.png"))); // NOI18N
        btnGastosReporte.setText("Gastos");

        btnPresupuesto.setBackground(new java.awt.Color(102, 255, 255));
        btnPresupuesto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grafico-circular.png"))); // NOI18N
        btnPresupuesto.setText("Presupuestos");

        btnCerrarSesionPresupuesto.setBackground(new java.awt.Color(0, 102, 204));
        btnCerrarSesionPresupuesto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnCerrarSesionPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesionPresupuesto.setText("Cerrar Sesión");
        btnCerrarSesionPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionPresupuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarSesionPresupuesto)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIngresoReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGastosReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPresupuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addComponent(btnIngresoReporte)
                .addGap(72, 72, 72)
                .addComponent(btnGastosReporte)
                .addGap(68, 68, 68)
                .addComponent(btnPresupuesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesionPresupuesto)
                .addGap(38, 38, 38))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel3.setText("Menú de Reportes");

        btnIngresoCategoria.setBackground(new java.awt.Color(153, 255, 153));
        btnIngresoCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnIngresoCategoria.setText("Ingreso");
        btnIngresoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoCategoriaActionPerformed(evt);
            }
        });

        btnGastoCategoria.setBackground(new java.awt.Color(255, 153, 153));
        btnGastoCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnGastoCategoria.setText("Gastos");
        btnGastoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastoCategoriaActionPerformed(evt);
            }
        });

        btnPresupuestoCategoria.setBackground(new java.awt.Color(51, 153, 255));
        btnPresupuestoCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnPresupuestoCategoria.setText("Presupuestos");
        btnPresupuestoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresupuestoCategoriaActionPerformed(evt);
            }
        });

        jLabel4.setText("---------------------------------------------------------------------------------");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Selecione la Categoria");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Selecione el rango de tiempo ");

        btnDiaTiempo.setBackground(new java.awt.Color(153, 255, 204));
        btnDiaTiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnDiaTiempo.setText("Dia");
        btnDiaTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaTiempoActionPerformed(evt);
            }
        });

        btnSemanaTiempo.setBackground(new java.awt.Color(204, 255, 102));
        btnSemanaTiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnSemanaTiempo.setText("Semana");
        btnSemanaTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemanaTiempoActionPerformed(evt);
            }
        });

        btnMesTiempo.setBackground(new java.awt.Color(255, 102, 0));
        btnMesTiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnMesTiempo.setText("Mes");
        btnMesTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesTiempoActionPerformed(evt);
            }
        });

        btnYearTiempo.setBackground(new java.awt.Color(255, 153, 153));
        btnYearTiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnYearTiempo.setText("Año");
        btnYearTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYearTiempoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Seleccione el tipo de archivo");

        jLabel8.setText("---------------------------------------------------------------------------------");

        btnPdf.setBackground(new java.awt.Color(102, 255, 153));
        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        btnCVS.setBackground(new java.awt.Color(102, 255, 153));
        btnCVS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/csv.png"))); // NOI18N
        btnCVS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCVSActionPerformed(evt);
            }
        });

        btnDescargar.setBackground(new java.awt.Color(0, 153, 153));
        btnDescargar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnDescargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adjunto-archivo.png"))); // NOI18N
        btnDescargar.setText("Descargar");
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDescargar)
                    .addComponent(jLabel2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(btnIngresoCategoria)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnGastoCategoria)
                                            .addGap(49, 49, 49)
                                            .addComponent(btnPresupuestoCategoria))
                                        .addComponent(jLabel4)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnDiaTiempo)
                                                .addGap(53, 53, 53)
                                                .addComponent(btnSemanaTiempo)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMesTiempo)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnYearTiempo))
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel8)))
                                .addContainerGap(60, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel7)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnPdf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCVS)
                        .addGap(129, 129, 129))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresoCategoria)
                    .addComponent(btnGastoCategoria)
                    .addComponent(btnPresupuestoCategoria))
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDiaTiempo)
                    .addComponent(btnSemanaTiempo)
                    .addComponent(btnMesTiempo)
                    .addComponent(btnYearTiempo))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(btnPdf))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnCVS)))
                        .addContainerGap(78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDescargar)
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoReporteActionPerformed
         categoriaSeleccionada = "ingreso";
    }//GEN-LAST:event_btnIngresoReporteActionPerformed

    private void btnCerrarSesionPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionPresupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarSesionPresupuestoActionPerformed

    private void btnIngresoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresoCategoriaActionPerformed

    private void btnDiaTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaTiempoActionPerformed
        tiempoSeleccionado = "dia";
    }//GEN-LAST:event_btnDiaTiempoActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        tipoArchivoSeleccionado = "PDF";
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnGastoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastoCategoriaActionPerformed
         categoriaSeleccionada = "gasto";

    }//GEN-LAST:event_btnGastoCategoriaActionPerformed

    private void btnPresupuestoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresupuestoCategoriaActionPerformed
        categoriaSeleccionada = "objetivo";
    }//GEN-LAST:event_btnPresupuestoCategoriaActionPerformed

    private void btnSemanaTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemanaTiempoActionPerformed
         tiempoSeleccionado = "semana";
    }//GEN-LAST:event_btnSemanaTiempoActionPerformed

    private void btnMesTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesTiempoActionPerformed
         tiempoSeleccionado = "mes";
    }//GEN-LAST:event_btnMesTiempoActionPerformed

    private void btnYearTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYearTiempoActionPerformed
        tiempoSeleccionado = "año";
    }//GEN-LAST:event_btnYearTiempoActionPerformed

    private void btnCVSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCVSActionPerformed
        tipoArchivoSeleccionado = "CSV";
    }//GEN-LAST:event_btnCVSActionPerformed

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
       // Validar si los parámetros seleccionados son correctos
    if (categoriaSeleccionada == null || categoriaSeleccionada.trim().isEmpty() ||
        tiempoSeleccionado == null || tiempoSeleccionado.trim().isEmpty() ||
        tipoArchivoSeleccionado == null || tipoArchivoSeleccionado.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione categoría, tiempo y tipo de archivo para el reporte.");
        return;
    }

    // Deshabilitar el botón para evitar clics múltiples durante la generación
    btnDescargar.setEnabled(false);

    try {
        // Generar el reporte según el tipo de archivo seleccionado
        switch (tipoArchivoSeleccionado) {
            case "PDF":
                reporteService.generarPDF(categoriaSeleccionada, tiempoSeleccionado);
                break;
            case "CSV":
                reporteService.generarCSV(categoriaSeleccionada, tiempoSeleccionado);
                break;
            default:
                throw new IllegalArgumentException("Tipo de archivo no soportado: " + tipoArchivoSeleccionado);
        }
        JOptionPane.showMessageDialog(this, "Reporte generado correctamente en formato " + tipoArchivoSeleccionado);
    } catch (Exception e) {
        e.printStackTrace();  // Esto es útil para depuración
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
    } finally {
        // Habilitar el botón de nuevo
        btnDescargar.setEnabled(true);
    }
    }//GEN-LAST:event_btnDescargarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCVS;
    private javax.swing.JButton btnCerrarSesionPresupuesto;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnDiaTiempo;
    private javax.swing.JButton btnGastoCategoria;
    private javax.swing.JButton btnGastosReporte;
    private javax.swing.JButton btnIngresoCategoria;
    private javax.swing.JButton btnIngresoReporte;
    private javax.swing.JButton btnMesTiempo;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnPresupuesto;
    private javax.swing.JButton btnPresupuestoCategoria;
    private javax.swing.JButton btnSemanaTiempo;
    private javax.swing.JButton btnYearTiempo;
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
    // End of variables declaration//GEN-END:variables
}
