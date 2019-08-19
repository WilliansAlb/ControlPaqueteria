/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import javax.swing.JOptionPane;

/**
 *
 * @author willians
 */
public class NuevoPaquete extends javax.swing.JInternalFrame {
    Controlador nuevo;
    /**
     * Creates new form NuevoPaquete
     * @param nuevo
     */
    public NuevoPaquete(Controlador nuevo) {
        initComponents();
        this.nuevo = nuevo; 
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
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        entRemitente = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Nuevo Envio");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoPaqueteria.png"))); // NOI18N

        destinoText.setText("Destino:");

        destinatarioTxt.setText("Destinatario:");

        pesoText.setText("Peso paquete (libras):");

        informacion.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        informacion.setText("Ingrese los datos del envio");

        ciudadesText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ingresoEnvio.setText("Ingresar");
        ingresoEnvio.setOpaque(true);
        ingresoEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoEnvioActionPerformed(evt);
            }
        });

        jSlider1.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jSlider1.setMajorTickSpacing(5);
        jSlider1.setMaximum(50);
        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(1);
        jSlider1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.setName("Peso");
        jSlider1.setOpaque(true);
        jSlider1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSlider1PropertyChange(evt);
            }
        });

        jLabel2.setText("Remitente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(destinoText)
                                .addGap(18, 18, 18)
                                .addComponent(ciudadesText, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pesoText)
                                        .addGap(0, 219, Short.MAX_VALUE))
                                    .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(destinatarioTxt)
                                .addGap(18, 18, 18)
                                .addComponent(entDestinatario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entRemitente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(ingresoEnvio)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(informacion)
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudadesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoText))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinatarioTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(entRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pesoText)
                        .addGap(15, 15, 15)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addComponent(ingresoEnvio)
                .addContainerGap())
        );

        jSlider1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSlider1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jSlider1PropertyChange

    private void ingresoEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoEnvioActionPerformed
        if (!entDestinatario.getText().isBlank() && !entRemitente.getText().isBlank()) {
            nuevo.crearIDPaquete(entDestinatario.getText(), entRemitente.getText(), 2, jSlider1.getValue());
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No has llenado los campos");
        }
    }//GEN-LAST:event_ingresoEnvioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ciudadesText;
    private javax.swing.JLabel destinatarioTxt;
    private javax.swing.JLabel destinoText;
    private javax.swing.JTextField entDestinatario;
    private javax.swing.JTextField entRemitente;
    private javax.swing.JLabel informacion;
    private javax.swing.JButton ingresoEnvio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel pesoText;
    // End of variables declaration//GEN-END:variables
}