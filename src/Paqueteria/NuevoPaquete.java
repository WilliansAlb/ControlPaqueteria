/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willians
 */
public class NuevoPaquete extends javax.swing.JInternalFrame {
    Controlador nuevo;
    boolean priorizado = false;
    DefaultTableModel modelo;
    /**
     * Creates new form NuevoPaquete
     * @param nuevo
     */
    public NuevoPaquete(Controlador nuevo) {
        initComponents();
        this.nuevo = nuevo;
        cambiarCiudadesText();
        componentesIniciales();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        destinoText = new javax.swing.JLabel();
        destinatarioTxt = new javax.swing.JLabel();
        pesoText = new javax.swing.JLabel();
        informacion = new javax.swing.JLabel();
        ciudadesText = new javax.swing.JComboBox<>();
        entDestinatario = new javax.swing.JTextField();
        ingresoEnvio = new javax.swing.JButton();
        slider_Peso = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        entRemitente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_Priorizado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaqueteNew = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_Cancelar = new javax.swing.JButton();
        btn_Generar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Nuevo Envio");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoPaqueteria.png"))); // NOI18N

        destinoText.setText("Destino:");

        destinatarioTxt.setText("Destinatario:");

        pesoText.setText("Peso paquete (libras):");

        informacion.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informacion.setText("Ingrese los datos del envio");

        ciudadesText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadesTextActionPerformed(evt);
            }
        });

        ingresoEnvio.setText("Ingresar");
        ingresoEnvio.setOpaque(true);
        ingresoEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoEnvioActionPerformed(evt);
            }
        });

        slider_Peso.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        slider_Peso.setMajorTickSpacing(5);
        slider_Peso.setMaximum(50);
        slider_Peso.setMinimum(1);
        slider_Peso.setMinorTickSpacing(1);
        slider_Peso.setPaintLabels(true);
        slider_Peso.setPaintTicks(true);
        slider_Peso.setSnapToTicks(true);
        slider_Peso.setToolTipText("");
        slider_Peso.setValue(1);
        slider_Peso.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        slider_Peso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        slider_Peso.setName("Peso");
        slider_Peso.setOpaque(true);
        slider_Peso.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                slider_PesoPropertyChange(evt);
            }
        });

        jLabel2.setText("Remitente:");

        jLabel3.setText("Priorizado:");

        btn_Priorizado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btn_Priorizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PriorizadoActionPerformed(evt);
            }
        });

        tablaPaqueteNew.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPaqueteNew);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tus paquetes:");

        btn_Cancelar.setText("Cancelar paquete");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_Generar.setText("Generar Factura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(informacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ingresoEnvio)
                .addGap(182, 182, 182))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(destinoText)
                        .addGap(18, 18, 18)
                        .addComponent(ciudadesText, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(destinatarioTxt)
                        .addGap(18, 18, 18)
                        .addComponent(entDestinatario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entRemitente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pesoText)
                            .addComponent(slider_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Priorizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Cancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Generar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudadesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoText))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinatarioTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(entRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesoText)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Priorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slider_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingresoEnvio)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Generar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void slider_PesoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_slider_PesoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_slider_PesoPropertyChange

    private void ingresoEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoEnvioActionPerformed
        if (!entDestinatario.getText().isBlank() && !entRemitente.getText().isBlank()) {
            
            String[] opciones = {"Confirmar","Cancelar"};
            int x = JOptionPane.showOptionDialog(null, "El costo de tu paquete es [cuota_Destino]+[cuota_Peso*peso]",
                "Confirmar ingreso de paquete",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            if (x==0){
                //nuevo.crearIDPaquete(entDestinatario.getText(), entRemitente.getText(), ciudadesText.getSelectedItem().toString(), jSlider1.getValue());
                actualizarTabla();
                entDestinatario.setText("");
                entRemitente.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No has llenado los campos");
        }
    }//GEN-LAST:event_ingresoEnvioActionPerformed

    private void ciudadesTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadesTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadesTextActionPerformed

    private void btn_PriorizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PriorizadoActionPerformed
        if (priorizado){
            btn_Priorizado.setText("No");
            priorizado = false;
        } else {
            btn_Priorizado.setText("Sí");
            priorizado = true;
        }
    }//GEN-LAST:event_btn_PriorizadoActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        int fila_Cancelar = tablaPaqueteNew.getSelectedRow();
        
        System.out.print(fila_Cancelar);
        modelo.removeRow(fila_Cancelar);
        tablaPaqueteNew.setModel(modelo);
        System.out.print(modelo.getRowCount());
    }//GEN-LAST:event_btn_CancelarActionPerformed

    public void actualizarTabla(){
        Object datos[] = new Object[7];
        datos[0] = nuevo.crearIdPaquete(ciudadesText.getSelectedItem().toString());
        datos[1] = ciudadesText.getSelectedItem().toString();
        datos[2] = entDestinatario.getText();
        datos[3] = entRemitente.getText();
        datos[4] = slider_Peso.getValue(); 
        datos[5] = 10; //acá debo de ver como meter la tarifa de destino y la del peso
        if (priorizado){
            datos[6] = "Sí";
        } else {
            datos[6] = "No";
        }
        
        modelo.addRow(datos);
        tablaPaqueteNew.setModel(modelo);
    }
    public void cambiarCiudadesText(){
        nuevo.cambiando(this);
    }

    public void componentesIniciales(){
        //modelo = new DefaultTableModel();
        modelo = new ModeloTabla();
        modelo.addColumn("Codigo");
        modelo.addColumn("Ruta");
        modelo.addColumn("Destinatario");
        modelo.addColumn("Remitente");
        modelo.addColumn("Peso");
        modelo.addColumn("Costo total");
        modelo.addColumn("Priorizado");
        tablaPaqueteNew.setModel(modelo);
        btn_Priorizado.setText("No");
        priorizado = false;
    }
    public JComboBox<String> getCiudadesText() {
        return ciudadesText;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Generar;
    private javax.swing.JButton btn_Priorizado;
    private javax.swing.JComboBox<String> ciudadesText;
    private javax.swing.JLabel destinatarioTxt;
    private javax.swing.JLabel destinoText;
    private javax.swing.JTextField entDestinatario;
    private javax.swing.JTextField entRemitente;
    private javax.swing.JLabel informacion;
    private javax.swing.JButton ingresoEnvio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pesoText;
    private javax.swing.JSlider slider_Peso;
    private javax.swing.JTable tablaPaqueteNew;
    // End of variables declaration//GEN-END:variables
}
