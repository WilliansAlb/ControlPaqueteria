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
    private final boolean [] tableColums = {false, false, true,true,true,false,false};
     
    @Override
    public final boolean isCellEditable(int row, int column) {
        return this.tableColums[column];
    }
}
