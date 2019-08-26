/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willians
 */
public class Reportes {

    PantallaPaqueteria nueva;

    public Reportes(PantallaPaqueteria nueva) {
        this.nueva = nueva;
    }

    public void generarReporte() {
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reporteRuta" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE RUTA</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>CODIGO</strong></td>");
            escritura.println("<td><strong># DE PUNTOS</strong></td>");
            escritura.println("<td><strong>DESTINO</strong></td>");
            escritura.println("<td><strong>CUOTA DESTINO</strong></td>");
            escritura.println("<td><strong>CUOTA PRIORIDAD</strong></td>");
            escritura.println("<td><strong>TARIFA PESO</strong></td>");
            escritura.println("<td><strong>PAQUETES EN LA RUTA</strong></td>");
            escritura.println("<td><strong>PAQUETES EN LA RUTA</strong></td>");
            escritura.println("</tr>");
            String sql2 = "SELECT * FROM Ruta";
            Statement st;
            try {
                st = nueva.controladorDB.cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                while (rs.next()) {
                    int cod = rs.getInt("codigo_ruta");
                    int no_puntos = rs.getInt("no_puntos");
                    String destino = rs.getString("destino");
                    int cuota_destino = rs.getInt("cuota_destino");
                    int cuota_priori = rs.getInt("cuota_priori");
                    int tarifa_peso = rs.getInt("tarifa_peso");
                    int cuantosHay1 = nueva.controladorDB.paquetesEnRuta(cod,true);
                    int cuantosHay2 = nueva.controladorDB.paquetesEnRuta(cod,false);
                    //escritura.println("CODIGO RUTA: "+cod+" # DE PUNTOS: "+no_puntos+" DESTINO: "+destino+" CUOTA DESTINO: "+cuota_destino+
                    //" CUOTA PRIORIDAD: "+cuota_priori+" TARIFA PESO "+tarifa_peso+"<br>");
                    escritura.println("<tr><td>" + cod +
                            "</td><td>" + no_puntos + "</td><td>" + destino + "</td><td>" + cuota_destino + 
                            "</td><td>" + cuota_priori + "</td><td>" + tarifa_peso + "</td><td>" + cuantosHay1 + "</td><td>" + cuantosHay2 + "</td></tr>");
                }
            } catch (SQLException e) {
                System.out.print("problema" + e.getMessage());
            }
            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            JOptionPane.showMessageDialog(nueva,"Se ha creado el reporte, tiene nombre: "+ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void generarReporte(boolean paso) {
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String queEs;
            if (paso){
                queEs = "Activa";
            } else {
                queEs = "Inactiva";
            }
            String ruta = "reporteRuta"+queEs + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE RUTAS</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>CODIGO</strong></td>");
            escritura.println("<td><strong># DE PUNTOS</strong></td>");
            escritura.println("<td><strong>DESTINO</strong></td>");
            escritura.println("<td><strong>CUOTA DESTINO</strong></td>");
            escritura.println("<td><strong>CUOTA PRIORIDAD</strong></td>");
            escritura.println("<td><strong>TARIFA PESO</strong></td>");
            if (paso){
                escritura.println("<td><strong>PAQUETES EN LA RUTA</strong></td>");
            } else {
                escritura.println("<td><strong>PAQUETES FUERA DE LA RUTA</strong></td>");
            }
            
            escritura.println("</tr>");
            String sql2 = "SELECT * FROM Ruta";
            Statement st;
            try {
                st = nueva.controladorDB.cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                while (rs.next()) {
                    int cod = rs.getInt("codigo_ruta");
                    int no_puntos = rs.getInt("no_puntos");
                    String destino = rs.getString("destino");
                    int cuota_destino = rs.getInt("cuota_destino");
                    int cuota_priori = rs.getInt("cuota_priori");
                    int tarifa_peso = rs.getInt("tarifa_peso");
                    int cuantosHay1 = nueva.controladorDB.paquetesEnRuta(cod,paso);
                    escritura.println("<tr><td>" + cod +
                            "</td><td>" + no_puntos + "</td><td>" + destino + "</td><td>" + cuota_destino + 
                            "</td><td>" + cuota_priori + "</td><td>" + tarifa_peso + "</td><td>" + cuantosHay1 + "</td></tr>");
                }
            } catch (SQLException e) {
                System.out.print("problema" + e.getMessage());
            }
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            JOptionPane.showMessageDialog(nueva,"Se ha creado el reporte, tiene nombre: "+ruta);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("problema "+e.getMessage());
        }
    }
     public void generarReporteClientes(DefaultTableModel modelo1) {
         int cuantasVeces = modelo1.getRowCount();
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reporteCliente"+aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE CLIENTES</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>NIT</strong></td>");
            escritura.println("<td><strong>PAQUETE</strong></td>");
            escritura.println("<td><strong>NOMBRE</strong></td>");
            escritura.println("<td><strong>CIUDAD</strong></td>");
            escritura.println("<td><strong>INGRESO</strong></td>");
            escritura.println("<td><strong>COSTO</strong></td>");
            escritura.println("<td><strong>GANANCIA</strong></td>");
            escritura.println("</tr>");
            Object[] datos = new Object[7];
            String nit = "";
            String paquete = "";
            String nombre = "";
            String ciudad = "";
            String ingreso = "";
            String costo = "";
            String ganancia = "";
            for (int i = 0; i < cuantasVeces; i++){
                nit = modelo1.getValueAt(i, 0).toString();
                paquete = modelo1.getValueAt(i, 1).toString();
                nombre = modelo1.getValueAt(i, 2).toString();
                ciudad = modelo1.getValueAt(i, 3).toString();
                ingreso = modelo1.getValueAt(i, 4).toString();
                costo = modelo1.getValueAt(i, 5).toString();
                ganancia = modelo1.getValueAt(i, 6).toString();
                escritura.println("<tr><td>" + nit +
                            "</td><td>" + paquete + "</td><td>" + nombre + "</td><td>" + ciudad + 
                            "</td><td>" + ingreso + "</td><td>" + costo + "</td><td>" + ganancia + "</td></tr>");
                }
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            JOptionPane.showMessageDialog(nueva,"Se ha creado el reporte, tiene nombre: "+ruta);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("problema "+e.getMessage());
        }
    }

}
