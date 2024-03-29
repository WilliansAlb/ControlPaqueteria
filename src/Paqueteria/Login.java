/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author willians
 */
public class Login extends javax.swing.JFrame {
    Controlador nuevo;
    /**
     * Creates new form Login
     */
    public Login(Controlador nuevo) {
        this.nuevo = nuevo;
        initComponents();
        setTitle("Paquetería");
        setLocationRelativeTo(null);   
        ImageIcon fot = new ImageIcon(getClass().getResource("/imagenes/fondoPaqueteria1.png"));
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        fondoLogin.setIcon(icono);
        
        ImageIcon foto = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
        Icon icono1 = new ImageIcon(foto.getImage().getScaledInstance(lblUser.getWidth(), lblUser.getHeight(), Image.SCALE_DEFAULT));
        lblUser.setIcon(icono1);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena2 = new javax.swing.JPasswordField();
        entradaUsuario = new javax.swing.JButton();
        fondoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 70, 70));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAQUETERIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 280, -1));

        jLabel2.setText("USUARIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 163, -1, -1));

        jLabel3.setText("CONTRASEÑA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 197, -1, 30));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 170, -1));
        getContentPane().add(txtContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 130, -1));

        entradaUsuario.setText("ENTRAR");
        entradaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(entradaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));
        getContentPane().add(fondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaUsuarioActionPerformed
        String contra1 = new String(txtContrasena2.getPassword());
        if (!contra1.isBlank() && !txtUsuario.getText().isBlank()) {
            if (nuevo.identificar(txtUsuario.getText(), contra1)) {
                PantallaPaqueteria nueva = new PantallaPaqueteria(nuevo);
                nueva.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_entradaUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entradaUsuario;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtContrasena2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
