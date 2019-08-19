/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

/**
 *
 * @author willians
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PantallaPaqueteria nueva = new PantallaPaqueteria();
        Controlador nuevo = new Controlador();
        Login nueva = new Login(nuevo);
        nueva.setVisible(true);
    }
    
}
