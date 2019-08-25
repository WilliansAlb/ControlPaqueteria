/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import java.util.Random;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author willians
 */
public class Controlador {
    Connection cn;
    String usuario = "";
    String puesto = "";
    
    public Controlador() {
        
        String user = "root";
        String password = "[Cristeptesico_65]";
        String url = "jdbc:mysql://localhost:3306/prueba1";
        try {
            cn = DriverManager.getConnection(url, user, password);
            //declaracion = cn.createStatement();
            //resultado = declaracion.executeQuery("SELECT * FROM Cliente");
        } catch (SQLException e) {
            System.out.println("Falló la conexión a la base de datos");
        }

    }

    public void agregarDatosPaquete(String idCreada, String peso1, String destinatario, String remitente, int ruta2) {
        try {
            PreparedStatement preparado = cn.prepareStatement("INSERT INTO paquete(Id_Paquete,Peso_Paquete,Destinatario,Remitente,PuntoControl,Priorizado,Ruta) VALUES(?,?,?,?,?,?,?)");
            preparado.setString(1, idCreada);
            preparado.setString(2, peso1);
            preparado.setString(3, destinatario);
            preparado.setString(4, remitente);
            preparado.setInt(5, 3);
            preparado.setBoolean(6, true);
            preparado.setInt(7, ruta2);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());

        }
    }
   
    public void agregarUsuario(String user, String pass, String nombre, String puesto){
        try {
            PreparedStatement preparado = cn.prepareStatement("INSERT INTO Usuarios(user,pass,puesto,nombre) VALUES(?,?,?,?)");
            preparado.setString(1, user);
            preparado.setString(2, pass);
            preparado.setString(3, puesto);
            preparado.setString(4, nombre);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());
        }
    }
    
    public void agregarRuta(int no_puntos, String destino, int cuota_destino, int cuota_priori, int tarifa_peso,boolean estado_ruta, int tarifa_global){
        try {
            PreparedStatement preparado = cn.prepareStatement("INSERT INTO Ruta(no_puntos,destino,cuota_destino,cuota_priori,tarifa_peso,estado_ruta,tarifa_global) VALUES(?,?,?,?,?,?,?)");
            preparado.setInt(1, no_puntos);
            preparado.setString(2, destino);
            preparado.setInt(3,cuota_destino);
            preparado.setInt(4,cuota_priori);
            preparado.setInt(5,tarifa_peso);
            preparado.setBoolean(6, true);
            preparado.setInt(7, tarifa_global);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());
        }
    }

    public void crearIDPaquete(String destinatario, String remitente, String destino1, int peso) {
        String idPos = "ABCDEFGHIJKLMNOPQRSTUWXYZ1234567890";
        String idCreada = "";
        String peso1 = "" + peso;
        boolean paso = false;
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Random aleatorio = new Random(System.currentTimeMillis());
            int numeroElegido = aleatorio.nextInt(idPos.length());
            idCreada += idPos.charAt(numeroElegido);
        }
        int identidadRuta = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT Destinatario FROM paquete WHERE Id_Paquete = ?");
            PreparedStatement preparada3 = cn.prepareStatement("SELECT Id_Ruta FROM Ruta WHERE Destino = '"+destino1+"'");
            preparada2.setString(1, idCreada);
            ResultSet resultado = preparada2.executeQuery();
            ResultSet resultado2 = preparada3.executeQuery();
            if (!resultado.next()) {
                paso = true;
            } else {
                System.out.print("Ya existe ese id");
            }
            while(resultado2.next())
            {
                identidadRuta = resultado2.getInt("Id_Ruta");
            }
        } catch (SQLException le) {
            System.out.print(le.getMessage());
        }

        if (paso) {
            agregarDatosPaquete(idCreada, peso1, destinatario, remitente,identidadRuta);
            String mensaje = "<html><body>Listo, el codigo de tu paquete es: <br>" + idCreada + "</body></html>";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            crearIDPaquete(destinatario, remitente, destino1, peso);
        }
    }
    
    public String crearIdPaquete(String destino1){
    String idPos = "ABCDEFGHIJKLMNOPQRSTUWXYZ1234567890";
        String idCreada = "";
        boolean paso = false;
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Random aleatorio = new Random(System.currentTimeMillis());
            int numeroElegido = aleatorio.nextInt(idPos.length());
            idCreada += idPos.charAt(numeroElegido);
        }
        int identidadRuta = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT Destinatario FROM paquete WHERE Id_Paquete = ?");
            PreparedStatement preparada3 = cn.prepareStatement("SELECT Id_Ruta FROM Ruta WHERE Destino = '"+destino1+"'");
            preparada2.setString(1, idCreada);
            ResultSet resultado = preparada2.executeQuery();
            ResultSet resultado2 = preparada3.executeQuery();
            if (!resultado.next()) {
                paso = true;
                return idCreada;
            } else {
                System.out.print("Ya existe ese id");
            }
            while(resultado2.next())
            {
                identidadRuta = resultado2.getInt("Id_Ruta");
            }
        } catch (SQLException le) {
            System.out.print(le.getMessage());
        }
        if (paso) {
            String mensaje = "<html><body>Listo, el codigo de tu paquete es: <br>" + idCreada + "</body></html>";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            crearIdPaquete(destino1);
        }
        return null;
    }
    
    public boolean identificar(String busqueda, String contra) {
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT pass, puesto FROM Usuarios WHERE user = ?");
            preparada2.setString(1, busqueda);
            ResultSet resultado = preparada2.executeQuery();
            System.out.print("entra acá");
            if (resultado.next()) {
                String contra_Hallada = resultado.getString("pass");
                if (contra_Hallada.equals(contra)) {
                    usuario = busqueda;
                    puesto = resultado.getString("puesto");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
                    return false;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public void eliminando(String sql){
        try {
            PreparedStatement preparado = cn.prepareStatement(sql);
            preparado.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiando(NuevoPaquete nuevoPaquete1){
        String sql = "SELECT Destino FROM Ruta";
       
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                String destino1 = rs.getString(1);
                nuevoPaquete1.getCiudadesText().addItem(destino1);
            }
        }
        catch(SQLException e){
        
        }
    }
    public void cambiandoDestino(ControlAdmin admin){
        String sql = "SELECT Destino FROM Ruta";
       
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                String destino1 = rs.getString(1);
                admin.getCombo_Destinos().addItem(destino1);
            }
        }
        catch(SQLException e){
        
        }
    }
    
    public int ruta(String destino){
        String sql = "SELECT codigo_ruta FROM Ruta WHERE destino = '"+destino+"'";
        int numero = 0; 
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                numero = rs.getInt("codigo_ruta");
            }
        }
        catch(SQLException e){
        
        }
        return numero;
    }
    public boolean verificarLimite(int i, ControlAdmin adm){
        String sql = "SELECT no_puntos FROM Ruta WHERE codigo_ruta = "+i;
        Statement st;
        Statement st2;
        int limite = 0;
        int existen = 0;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                limite = rs.getInt("no_puntos");
                
            }
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT COUNT(*) AS TOTAL FROM Puntos WHERE id_ruta = "+i);
            while (rs2.next())
            {
                existen = Integer.parseInt(rs2.getString("TOTAL"));
            }
            adm.setLimiteRuta(limite);
            return existen<=limite;
        }
        catch(SQLException e){
            System.out.print(e.getMessage());
        }
        return false;
    }

    public void buscandoPaquete(ControlarPaquete controlandoPaquete){
        String codigo = controlandoPaquete.getEntBusquedaPaquete().getText();
        String sql = "SELECT Ruta,PuntoControl FROM paquete WHERE Id_Paquete ='"+codigo+"'";
        int ruta1 = 0;
        Statement st;
        Statement st2;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                controlandoPaquete.setDondeEsta(rs.getInt("PuntoControl"));
                ruta1 = rs.getInt("Ruta");
            }
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT No_Punto FROM Ruta WHERE Id_Ruta = "+ruta1);
            while (rs2.next())
            {
                controlandoPaquete.setCuantosPuntos(rs2.getInt("No_Punto"));
            }
        }
        catch(SQLException e){
        
        }
    }
    
    public boolean existe_Usuario(String user){
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT nombre FROM Usuarios WHERE user = ?");
            preparada2.setString(1, user);
            ResultSet resultado = preparada2.executeQuery();
            if (!resultado.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Ese user le pertenece a "+ resultado.getString("nombre"));
                return false;
            }
        }catch (SQLException es){
            return false;
        }
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
