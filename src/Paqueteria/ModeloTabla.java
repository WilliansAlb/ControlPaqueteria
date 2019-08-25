/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willians
 */
public class ModeloTabla extends DefaultTableModel {
    /**
     * Define la posibilidad de editar de una columna.
     */
    boolean[] tablaColumnas; 
    //private final boolean [] tableColums = {false, false, true,true,true,false,false};
    //private final boolean [] tableColums2 = {false, false, false};
    
    public ModeloTabla(int cual) {
        if (cual == 0) {
            tablaColumnas = new boolean[3];
            tablaColumnas[0] = false;
            tablaColumnas[1] = false;
            tablaColumnas[2] = false;
        } else {
            tablaColumnas = new boolean[7];
            tablaColumnas[0] = false;
            tablaColumnas[1] = false;
            tablaColumnas[2] = true;
            tablaColumnas[3] = true;
            tablaColumnas[4] = true;
            tablaColumnas[5] = false;
            tablaColumnas[6] = false;
        }
    }
    @Override
    public final boolean isCellEditable(int row, int column) {
        return this.tablaColumnas[column];
    }
}
