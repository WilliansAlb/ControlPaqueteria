/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author willians
 */
public class PantallaPaqueteria extends javax.swing.JFrame {
    Controlador controladorDB;
    public Image imagenFondo;
    public URL fondo1;
    public Controlador control1 = new Controlador();
    /**
     * Creates new form PantallaPaqueteria
     * @param controladorDB
     */
    public PantallaPaqueteria(Controlador controladorDB) {
        initComponents();
        setTitle("Paqueteria");
        setLocationRelativeTo(null);
        this.controladorDB = controladorDB;
        ImageIcon fot = new ImageIcon(getClass().getResource("/imagenes/fondoPaqueteria1.png"));
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        fondoLabel.setIcon(icono);
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

        escritorio = new javax.swing.JDesktopPane();
        fondoLabel = new javax.swing.JLabel();
        menuBarPaquetería = new javax.swing.JMenuBar();
        clientes = new javax.swing.JMenu();
        controlUsuarios = new javax.swing.JMenuItem();
        controlRutas = new javax.swing.JMenuItem();
        menuControlPuntos = new javax.swing.JMenuItem();
        paquetes = new javax.swing.JMenu();
        nuevoPaquete = new javax.swing.JMenuItem();
        controlarPaquete = new javax.swing.JMenuItem();
        entregaPaquete = new javax.swing.JMenuItem();
        rutas = new javax.swing.JMenu();
        nuevaRuta = new javax.swing.JMenuItem();
        modificacionRutas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paquetería");
        setFocusCycleRoot(false);
        setResizable(false);
        setSize(new java.awt.Dimension(625, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        escritorio.setOpaque(false);
        getContentPane().add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 620));
        getContentPane().add(fondoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 620));

        clientes.setText("Control");

        controlUsuarios.setText("Control de usuarios");
        controlUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlUsuariosActionPerformed(evt);
            }
        });
        clientes.add(controlUsuarios);

        controlRutas.setText("Control de Rutas");
        clientes.add(controlRutas);

        menuControlPuntos.setText("Control de Puntos");
        menuControlPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuControlPuntosActionPerformed(evt);
            }
        });
        clientes.add(menuControlPuntos);

        menuBarPaquetería.add(clientes);

        paquetes.setText("Paquetes");

        nuevoPaquete.setText("Nuevo Paquete");
        nuevoPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPaqueteActionPerformed(evt);
            }
        });
        paquetes.add(nuevoPaquete);

        controlarPaquete.setText("Rastrear Mi Paquete");
        controlarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarPaqueteActionPerformed(evt);
            }
        });
        paquetes.add(controlarPaquete);

        entregaPaquete.setText("Entrega de Paquete");
        entregaPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entregaPaqueteActionPerformed(evt);
            }
        });
        paquetes.add(entregaPaquete);

        menuBarPaquetería.add(paquetes);

        rutas.setText("Puntos de Control");

        nuevaRuta.setText("Control de paquetes");
        rutas.add(nuevaRuta);

        modificacionRutas.setText("Modificacion de valores");
        rutas.add(modificacionRutas);

        menuBarPaquetería.add(rutas);

        setJMenuBar(menuBarPaquetería);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPaqueteActionPerformed
        NuevoPaquete nuevo = new NuevoPaquete(controladorDB);
        this.escritorio.add(nuevo);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = nuevo.getSize();
        nuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        nuevo.show();
    }//GEN-LAST:event_nuevoPaqueteActionPerformed

    private void controlarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlarPaqueteActionPerformed
        ControlarPaquete nuevo = new ControlarPaquete(controladorDB);
        this.escritorio.add(nuevo);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = nuevo.getSize();
        nuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        nuevo.show();
    }//GEN-LAST:event_controlarPaqueteActionPerformed

    private void controlUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlUsuariosActionPerformed
        ControlAdmin control1 = new ControlAdmin(controladorDB,0);
        this.escritorio.add(control1);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = control1.getSize();
        control1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        control1.show();
    }//GEN-LAST:event_controlUsuariosActionPerformed

    private void entregaPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entregaPaqueteActionPerformed
        EntregaPaquete entregando = new EntregaPaquete();
        this.escritorio.add(entregando);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = entregando.getSize();
        entregando.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        entregando.show();
    }//GEN-LAST:event_entregaPaqueteActionPerformed

    private void menuControlPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuControlPuntosActionPerformed
        ControlAdmin control1 = new ControlAdmin(controladorDB,1);
        this.escritorio.add(control1);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = control1.getSize();
        control1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        control1.show();
    }//GEN-LAST:event_menuControlPuntosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu clientes;
    private javax.swing.JMenuItem controlRutas;
    private javax.swing.JMenuItem controlUsuarios;
    private javax.swing.JMenuItem controlarPaquete;
    private javax.swing.JMenuItem entregaPaquete;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel fondoLabel;
    private javax.swing.JMenuBar menuBarPaquetería;
    private javax.swing.JMenuItem menuControlPuntos;
    private javax.swing.JMenuItem modificacionRutas;
    private javax.swing.JMenuItem nuevaRuta;
    private javax.swing.JMenuItem nuevoPaquete;
    private javax.swing.JMenu paquetes;
    private javax.swing.JMenu rutas;
    // End of variables declaration//GEN-END:variables
}
